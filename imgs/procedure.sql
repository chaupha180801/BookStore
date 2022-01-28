set serveroutput on;
create or replace procedure Them_HD(v_manv in varchar2, v_makh in varchar2,
                          v_ngayhd in date)
is
  sohd HOADON.mahd%type;
  dem int;
  v_sotienthuctra hoadon.sotienthuctra%type;
  tien_no KHACHHANG.makh%type;
  v_loaikh KHACHHANG.makh%type;
  
  v_ngaybd KHUYENMAI.ngaybd%type;
  v_ngaykt KHUYENMAI.ngaykt%type;
  v_makm  KHUYENMAI.makm%type;
  v_tilekm KHUYENMAI.tilekm%type;
  
  v_tonghd HOADON.tonghd%type;
  v_thanhtien HOADON.thanhtien%type;
  hd_makm  KHUYENMAI.makm%type;
  hd_tilekm KHUYENMAI.tilekm%type;
  
  cursor kt_dk_km is select makm, ngaybd, ngaykt, tilekm 
                     from  KHUYENMAI;
 begin
 
  select tongno,loaikh into tien_no,v_loaikh
  from khachhang
  where makh = v_makh;
  
  if(tien_no > 200000) then
      RAISE_APPLICATION_ERROR(-20000, 'Khong the lap hoa don');   
  else
    begin
      open kt_dk_km;
      loop      
        fetch kt_dk_km into v_makm, v_ngaybd, v_ngaykt, v_tilekm;
        exit when(kt_dk_km %notfound);
        if( v_ngayhd >= v_ngaybd and v_ngayhd <= v_ngaykt) then
            hd_makm := v_makm;
            hd_tilekm := v_tilekm;
        end if;
      end loop;
      close kt_dk_km;
    end;
    end if;
  v_tonghd := 0;
  v_sotienthuctra := 0;
  v_thanhtien := 0;
  insert into hoadon(mahd, ngayhd, thanhtien, sotienthuctra, manv, makh, makm, tonghd)
  values (sohd, v_ngayhd, v_thanhtien,v_sotienthuctra, v_manv, v_makh,hd_makm, v_tonghd);
      
  select count(*) into dem
  from hoadon
  where mahd = sohd;
      
  if(dem > 0) then
    begin
      DBMS_OUTPUT.PUT_LINE('Thuc hien thanh cong.');
    end;
  end if;
end;
select * from hoadon;
delete  from hoadon;
exec Them_HD('NV0001','KH0003',TO_DATE('2020/06/30','YYYY/MM/DD'));
INSERT INTO HOADON VALUES ('', TO_DATE('2020/06/30','YYYY/MM/DD'), 1500000,1275000,1200000,'NV0001','KH0001','KM0001')  ;
set serveroutput on;
create or replace procedure Them_CTHD(sohd varchar2, v_masach varchar2,
                                      v_soluong int, gia int)
is 
  kt int;
  v_soluongton SACH.soluongton%type;
  v_tonghd HOADON.tonghd%type;
  
begin
  select soluongton into v_soluongton
  from sach
  where masach = v_masach;
  
  if(v_soluongton < v_soluong) then 
    RAISE_APPLICATION_ERROR(-20000, 'So luong ton cua sach khong du de dap ung');
  end if;
  
  insert into CHITIETHOADON(masach, mahd, soluong, dongia)
  values (v_masach, sohd, v_soluong, gia);
  
  select count(*) into kt
  from CHITIETHOADON 
  where mahd = sohd and masach = v_masach; 
  
  if(kt > 0) then
      DBMS_OUTPUT.PUT_LINE('Thuc hien thanh cong.');
  end if;
end;
exec Them_cthd('HD0002','S0001',5,300000);
exec Them_cthd('HD0002','S0002', 4,240000);

create or replace procedure sum_cost(sohd IN HOADON.MaHD%type)
is
  v_tonghd HOADON.TONGHD%type;
  v_makm   KHUYENMAI.MAKM%type;
  v_tilekm KHUYENMAI.TILEKM%type;
  v_thanhtien HOADON.thanhtien%type;
begin
  set transaction isolation level serializable; 
  select sum(soluong*dongia) into v_tonghd
  from CHITIETHOADON
  where mahd = sohd;
  
  update HOADON
  set tonghd = v_tonghd
  where mahd = sohd;
  
  select hd.makm, km.tilekm into v_makm,v_tilekm
  from HOADON hd inner join KHUYENMAI km on hd.makm = km.makm and hd.mahd = sohd;
  
  if(v_makm is null) then
      update HOADON
      set thanhtien = v_tonghd
      where mahd = sohd;
  else 
      update HOADON
      set thanhtien = v_tonghd - v_tonghd * v_tilekm
      where mahd = sohd;
  end if;
  commit;
end;
exec sum_cost('HD0002');
---------------------------
create or replace procedure Them_tienthattra(sohd in hoadon.mahd%type, v_sotienthuctra in int)
is 
  v_thanhtien Hoadon.thanhtien %type;
  v_tongno KhachHang.tongno%type;
  v_makh Khachhang.makh%type;
  
begin
   select thanhtien, makh  into v_thanhtien, v_makh
   from hoadon
   where mahd = sohd;
   
   if(v_sotienthuctra < v_thanhtien *0.75) then
      RAISE_APPLICATION_ERROR(-20000, 'So tien thuc tra phai lon hon hoac bang 75% thanh tien');
   end if;
   
   update hoadon
   set sotienthuctra = v_sotienthuctra
   where mahd = sohd;
   select tongno into v_tongno
   from khachhang 
   where makh = v_makh;
   
   update khachhang 
   set tongno = v_tongno + (v_thanhtien - v_sotienthuctra)
   where makh = v_makh;
end;
select * from hoadon;
   exec Them_tienthattra('HD0002', 1477000); 

select * from khachhang;
-------------------------------------------------------------------------
set serveroutput on;
create or replace trigger update_thanhtien
before insert or update on CHITIETHOADON
for each row
declare
  v_tongtl HOADON.tonghd%type;
  v_tonghd HOADON.tonghd%type;
  v_makm   KHUYENMAI.MAKM%type;
  v_tilekm KHUYENMAI.TILEKM%type;
  v_thanhtien HOADON.thanhtien%type;
begin
  v_tongtl := 0;
  select tonghd, thanhtien,makm into v_tonghd, v_thanhtien, v_makm
  from hoadon
  where mahd = :new.mahd;
  
  select tilekm into v_tilekm
  from khuyenmai
  where makm = v_makm;
  
  if (INSERTING) then
     v_tongtl := (:new.SOLUONG * :new.DONGIA);
    UPDATE hoadon
    SET tonghd = v_tonghd + v_tongtl
    WHERE MAHD =:new.MAHD;

    if(v_makm is null) then
      update HOADON
      set thanhtien = v_thanhtien + v_tongtl
      where mahd = :new.mahd;
    else 
      update HOADON
      set thanhtien = v_thanhtien + v_tongtl*(1- v_tilekm) 
      where mahd = :new.mahd;
    end if;  
  end if ;
  if (UPDATING) then
      if (:new.SOLUONG > :old.SOLUONG) then
        v_tongtl := (:new.SOLUONG - :old.SOLUONG)*:old.DONGIA;
        UPDATE HOADON
        SET tonghd = v_tonghd + v_tongtl
        WHERE :old.MAHD =:new.MAHD;
        if(v_makm is null) then
          update HOADON
          set thanhtien = v_thanhtien + v_tongtl
          where :old.mahd = :new.mahd;
        else 
          update HOADON
          set thanhtien = v_thanhtien + v_tongtl*(1- v_tilekm) 
          where :old.mahd = :new.mahd;
        end if;    
      else
        v_tongtl :=  (:old.SOLUONG - :new.SOLUONG)*:old.DONGIA;
        UPDATE HOADON
        SET tonghd = v_tonghd - v_tongtl
        WHERE :old.MAHD =:new.MAHD;
        if(v_makm is null) then
          update HOADON
          set thanhtien = v_thanhtien + v_tonghd
          where :old.mahd = :new.mahd;
        else 
          update HOADON
          set thanhtien = v_thanhtien - v_tongtl*(1- v_tilekm) 
          where :old.mahd = :new.mahd;
        end if;
    end if; 
  end if;
end;
---------------
set serveroutput on;
create or replace trigger delete_thanhtien
before delete on CHITIETHOADON
for each row
declare
  v_tongtl HOADON.tonghd%type;
  v_tonghd HOADON.tonghd%type;
  v_makm   KHUYENMAI.MAKM%type;
  v_tilekm KHUYENMAI.TILEKM%type;
  v_thanhtien HOADON.thanhtien%type;
begin
  v_tongtl := 0;
  select tonghd, thanhtien,makm into v_tonghd, v_thanhtien, v_makm
  from hoadon
  where mahd = :old.mahd;
  
  select tilekm into v_tilekm
  from khuyenmai
  where makm = v_makm;
  v_tongtl := (:old.soluong * :old.dongia);
  update hoadon
  set tonghd = v_tonghd - v_tongtl
  where mahd = :old.mahd;
  
  update hoadon
  set thanhtien = v_thanhtien - v_tongtl *(1 - v_tilekm)
  where mahd = :old.mahd;
end;
  
-----------------------------------------------
select * from hoadon;
select * from chitiethoadon;
select * from sach;
delete from chitiethoadon;
delete from hoadon;
exec Them_HD('NV0001','KH0003',TO_DATE('2020/06/30','YYYY/MM/DD'));
exec Them_cthd('HD0009','S0004',5,40000);
exec Them_cthd('HD0009','S0002', 4,240000);
delete from chitiethoadon where mahd = 'HD0009' and masach = 'S0004';
update chitiethoadon
set soluong = 5
where mahd = 'HD0009' and masach = 'S0004';
exec Them_tienthattra('HD0009', 760000);
select * from khachhang;
----------------------------------------------
set SERVEROUTPUT ON;
create or replace trigger update_tongno
before insert or update on hoadon
for each row
declare
 v_thanhtien hoadon.thanhtien%type;
 v_sotienthuctra hoadon.sotienthuctra%type;
 v_tongno khachhang.tongno%type;
 v_tongnoht khachhang.tongno%type;
begin
  v_tongnoht := 0;
  select thanhtien, sotienthuctra into v_thanhtien, v_sotienthuctra
  from hoadon
  where mahd = :new.mahd;
  select tongno into v_tongno
  from khachhang
  where makh = :new.makh; 
  
  if(inserting) then 
    v_tongnoht := :new.thanhtien - :new.sotienthuctra;
    update khachhang 
    set tongno = tongno + v_tongnoht
    where makh = :new.makh;
  end if;
  if(updating) then
    select tongno into v_tongno
    from khachhang
    where makh = :new.makh;
    if(:new.sotienthuctra > :old.sotienthuctra) then
      v_tongnoht := v_thanhtien - (:new.sotienthuctra - :old.sotienthuctra);
      update khachhang
      set tongno = tongno - v_tongnoht
      where :old.makh = :new.makh;
    else
      v_tongnoht := v_thanhtien - (:old.sotienthuctra - :new.sotienthuctra);
      update khachhang
      set tongno = tongno + v_tongnoht
      where :old.makh = :new.makh;
    end if;
  end if;
end;
drop trigger update_tongno;
 exec Them_tienthattra('HD0009', 770000);
update hoadon
set sotienthuctra = 770000
where mahd = 'HD0009' and makh = 'KH0003';
select * from hoadon;
-------------------------
create or replace  procedure update_tongno(sohd in varchar2, v_sotienthuctra in int)
is
  v_thanhtien hoadon.thanhtien%type;
  v_sotienthuctraht hoadon.sotienthuctra%type;
  v_tongno khachhang.tongno%type;
  v_tongnoht khachhang.tongno%type;
  v_makh khachhang.makh%type;
begin
  select thanhtien, sotienthuctra,makh into v_thanhtien, v_sotienthuctraht, v_makh
  from hoadon
  where mahd = sohd;
  update hoadon
  set sotienthuctra = v_sotienthuctra
  where mahd = sohd;
   if(v_sotienthuctra > v_sotienthuctraht) then

      update khachhang
      set tongno = tongno - (v_sotienthuctra - v_sotienthuctraht)
      where makh = v_makh;
    else
      update khachhang
      set tongno = tongno +  (v_sotienthuctraht - v_sotienthuctra)
      where makh = v_makh;
    end if;
end;
 exec update_tongno('HD0009', 760000);
 select * from hoadon;
 select * from khachhang;