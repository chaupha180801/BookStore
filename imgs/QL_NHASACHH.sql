--------------------tat ca du lieu-----------------
-------------------------------------------------
----------------BANG SACH-------------------------------
CREATE TABLE SACH
  (
    MaSach     VARCHAR2(20) NOT NULL PRIMARY KEY,
    TenSach    VARCHAR2(40) NOT NULL,
    NamXB      INT NOT NULL,
    GiaBia     INT NOT NULL,
    MaTL       VARCHAR2(20) NOT NULL,
    MaNXB      VARCHAR2(20) NOT NULL,
    MaTG       VARCHAR2(20) NOT NULL,
    SoLuongTon INT NOT NULL
  );

---------BANG TAC GIA---------------------------
CREATE TABLE TACGIA
  (
    MaTG   VARCHAR2(20) NOT NULL PRIMARY KEY,
    TenTG  VARCHAR2(40) NOT NULL,
    DiaChi VARCHAR2(40) NOT NULL,
    TieuSu VARCHAR2(400) NOT NULL,
    SDT    VARCHAR2(20) NOT NULL,
    Email  VARCHAR2(40) NOT NULL
  );
------------BANG NHA XUAT BAN -------------------
CREATE TABLE NHAXUATBAN
  (
    MaNXB     VARCHAR2(20) NOT NULL PRIMARY KEY,
    TenNXB    VARCHAR2(40) NOT NULL,
    DiaChi    VARCHAR2(40) NOT NULL,
    SDT       VARCHAR2(20) NOT NULL
  );
-----------BANG THE LOAI------------------------
CREATE TABLE THELOAI
  (
    MaTL     VARCHAR2(20) NOT NULL PRIMARY KEY,
    TenTL    VARCHAR2(40) NOT NULL,
    DienGiai VARCHAR2(200)NOT NULL
  );
 ----------BANG KHACH HANG--------------------------
CREATE TABLE KHACHHANG
  (
    MaKH   VARCHAR2(20) NOT NULL PRIMARY KEY,
    TenKH  VARCHAR2(40) NOT NULL,
    LoaiKH NUMBER(2,0) NOT NULL,
    DiaChi VARCHAR2(40) NOT NULL,
    SDT    VARCHAR2(20) NOT NULL,
    TongNo INT
  );
----------BANG NHAN VIEN ---------------------------
CREATE TABLE NHANVIEN
  (
    MaNV   VARCHAR2(20) NOT NULL PRIMARY KEY,
    TenNV  VARCHAR2(40) NOT NULL,
    ChucVu  NUMBER(2,0) NOT NULL,
    NgayLV DATE NOT NULL,
    DiaChi VARCHAR2(40) NOT NULL,
    SDT    VARCHAR2(20) NOT NULL,
    Luong  INT NOT NULL
  );
  
  
  ---------BANG TAI KHOAN --------------------------
CREATE TABLE TAIKHOAN
  (
    Username VARCHAR2(40) NOT NULL PRIMARY KEY,
    Password  VARCHAR2(40) NOT NULL,
    MaNV     VARCHAR2(20) NOT NULL
  );
----------BANG HOA DON ---------------------------
CREATE TABLE HOADON
  (
    MaHD      VARCHAR2(20) NOT NULL PRIMARY KEY,
    NgayHD    DATE NOT NULL,
    TongTienHoaDon INT NOT NULL,
    ThanhTien INT NOT NULL,
    SoTienThucTra INT NOT NULL,
    MaNV      VARCHAR2(20) NOT NULL,
    MaKH      VARCHAR2(20) NOT NULL,
    MaKM      VARCHAR2(20) NOT NULL
  );
  ----------BANG CHI TIET HOA DON ------------------
CREATE TABLE CHITIETHOADON
  (
    MaSach  VARCHAR2(20) NOT NULL,
    MaHD    VARCHAR2(20) NOT NULL,
    DonGia  INT NOT NULL,
    SoLuong INT NOT NULL
  );
  --------- BANG KHUYEN MAI ----------------------
   
CREATE TABLE KHUYENMAI
  (
    MaKM     VARCHAR2(20) NOT NULL PRIMARY KEY,
    TenKM    VARCHAR2(40) NOT NULL,
    MoTa     VARCHAR2(40) NOT NULL,
    NgayBD   DATE NOT NULL,
    NgayKT   DATE NOT NULL,
    TiLeGiamGia float
  );
  
  ---------BANG PHIEU THU TIEN----------------------
CREATE TABLE PHIEUTHUTIEN
  (
    MaPhieuThu  VARCHAR2(20) NOT NULL PRIMARY KEY,
    MaKH        VARCHAR2(20) NOT NULL,
    NgayThuTien DATE NOT NULL,
    SoTienThu   INT NOT NULL
  );
------BANG PHIEU NHAP SACH ---------------------
CREATE TABLE PHIEUNHAPSACH
  (
    MaPN     VARCHAR2(20) NOT NULL PRIMARY KEY,
    NgayNhap DATE NOT NULL
  );
-------BANG CHI TIET PHIEU NHAP--------------------
CREATE TABLE CHITIETPHIEUNHAP
  (
    MaSach      VARCHAR2(20) NOT NULL,
    MaPN        VARCHAR2(20) NOT NULL,
    SoLuongNhap INT NOT NULL,
    GiaNhapSach INT NOT NULL
  );
  --------BANG BAO CAO TON KHO-------------------------
CREATE TABLE BAOCAOTONKHO
  (
    MaTK    VARCHAR2(20) NOT NULL PRIMARY KEY,
    NgayBC DATE NOT NULL
  );
  -------BANG CHI TIET TON KHO ------------------------
CREATE TABLE CHITIETTONKHO
  (
    MaTK       VARCHAR2(20) NOT NULL,
    MaSach     VARCHAR2(20) NOT NULL,
    SoTD       INT NOT NULL,
    SoTC       INT NOT NULL
  );
-------BANG BAO CAO CONG NO-----------------------
CREATE TABLE BAOCAOCONGNO
  (
    MaCN    VARCHAR2(20) NOT NULL PRIMARY KEY,
    NgayLCN DATE NOT NULL
  );
  -------BANG CHI TIET CONG NO----------------------
CREATE TABLE CHITIETCONGNO
  (
    MaCN   VARCHAR2(20) NOT NULL,
    MaKH   VARCHAR2(20) NOT NULL,
    NoDau  INT NOT NULL,
    NoCuoi INT NOT NULL
  );
  -----BANG QUI DINH----------------------
CREATE TABLE QUIDINH
  (
    MaQD                       VARCHAR2(20) NOT NULL PRIMARY KEY,
    NgayCapNhat                DATE NOT NULL,
    SLSachTonToiThieuDeNhap    INT NOT NULL,
    SLSachNhapToiThieuDeNhap   INT NOT NULL,
    SoTienNoToiDa              INT NOT NULL,
    SLSachTonToiThieuSauKhiBan INT NOT NULL
  );
  -------------------RANG BUOC--------------------------
--------BANG SACH------------------------------------------
ALTER TABLE SACH ADD CONSTRAINT FK_THELOAI FOREIGN KEY (MaTL) REFERENCES THELOAI(MaTL);
ALTER TABLE SACH ADD CONSTRAINT FK_TACGIA FOREIGN KEY(MaTG) REFERENCES TACGIA(MaTG);
ALTER TABLE SACH ADD CONSTRAINT FK_NHAXUATBAN FOREIGN KEY(MaNXB) REFERENCES NHAXUATBAN(MaNXB);
-----BANG HOA DON-----------------
ALTER TABLE HOADON ADD CONSTRAINT FK_KHACHHANG FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MaKH);
ALTER TABLE HOADON ADD CONSTRAINT FK_NHANVIEN FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV);
ALTER TABLE HOADON ADD CONSTRAINT FK_KHUYENMAI FOREIGN KEY(MaKM) REFERENCES KHUYENMAI(MaKM);
------BANG CHI TIET HOA DON-----------------------------
ALTER TABLE CHITIETHOADON ADD CONSTRAINT FK_SACH1 FOREIGN KEY (MaSach) REFERENCES SACH(MaSach);
ALTER TABLE CHITIETHOADON ADD CONSTRAINT FK_HOADON FOREIGN KEY (MaHD) REFERENCES HOADON(MaHD);
ALTER TABLE CHITIETHOADON ADD CONSTRAINT PK_CTHD PRIMARY KEY(MaSach,MaHD);
------BANG TAI KHOAN ---------------------------
ALTER TABLE TAIKHOAN ADD CONSTRAINT FK_TK_NV FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV);
------BANG CHI TIET PHIEU NHAP -----------------------------------------
ALTER TABLE CHITIETPHIEUNHAP ADD CONSTRAINT FK_SACH2 FOREIGN KEY (MaSach) REFERENCES SACH(MaSach);
ALTER TABLE CHITIETPHIEUNHAP ADD CONSTRAINT FK_PHIEUNHAP FOREIGN KEY (MaPN) REFERENCES PHIEUNHAPSACH(MaPN);
ALTER TABLE CHITIETPHIEUNHAP ADD CONSTRAINT PK_CTPN_SACH PRIMARY KEY(MaSach,MaPN);
-------BANG CHI TIET TON KHO ----------------------------------------
ALTER TABLE CHITIETTONKHO ADD CONSTRAINT FK_SACH3 FOREIGN KEY (MaSach) REFERENCES SACH(MaSach);
ALTER TABLE CHITIETTONKHO ADD CONSTRAINT FK_BCTK FOREIGN KEY (MaTK) REFERENCES BAOCAOTONKHO(MaTK);
ALTER TABLE CHITIETTONKHO ADD CONSTRAINT PK_CTTK PRIMARY KEY (MaSach,MaTK);
------BANG CHI TIET CONG NO------------------------------------
ALTER TABLE CHITIETCONGNO ADD CONSTRAINT FK_KH FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MaKH);
ALTER TABLE CHITIETCONGNO ADD CONSTRAINT FK_CN FOREIGN KEY (MaCN) REFERENCES BAOCAOCONGNO(MaCN);
ALTER TABLE CHITIETCONGNO ADD CONSTRAINT PK_CTTK_CN PRIMARY KEY (MaKH,MaCN);
-----BANG PHIEU THU TIEN----------------------------------------
ALTER TABLE PHIEUTHUTIEN ADD CONSTRAINT FK_KHACHHANG1 FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MAKH);
-------------CAC SEQUENCE--------------------

------------------TAC GIA-------------
CREATE SEQUENCE auto_column_matg
 START WITH 1
 INCREMENT BY 1 
 MAXVALUE 999999
 NOCACHE
 NOORDER
 NOCYCLE;

CREATE OR REPLACE TRIGGER auto_matg
   BEFORE INSERT ON TACGIA
   FOR EACH ROW
  BEGIN  
    :new.MATG := 'TG' || substr('000000000000000' || TO_CHAR(auto_column_matg.nextval), -4);
  END;




--------------NHA XUAT BAN--------------
CREATE SEQUENCE auto_column_manxb
 START WITH 1
 INCREMENT BY 1 
 MAXVALUE 999999
 NOCACHE
 NOORDER
 NOCYCLE;

CREATE OR REPLACE TRIGGER auto_manxb
   BEFORE INSERT ON NHAXUATBAN
   FOR EACH ROW
  BEGIN  
    :new.MANXB := 'NXB' || substr('000000000000000' || TO_CHAR(auto_column_manxb.nextval), -4);
  END;
----------THE LOAI-------------
CREATE SEQUENCE auto_column_matl
 START WITH 1
 INCREMENT BY 1 
 MAXVALUE 999999
 NOCACHE
 NOORDER
 NOCYCLE;

CREATE OR REPLACE TRIGGER auto_matl
   BEFORE INSERT ON THELOAI
   FOR EACH ROW
  BEGIN  
    :new.MATL := 'TL' || substr('000000000000000' || TO_CHAR(auto_column_matl.nextval), -4);
  END;
----------SACH--------------
create SEQUENCE auto_column_masach
 START WITH 1
 INCREMENT BY 1 
 MAXVALUE 999999
 NOCACHE
 NOORDER
 NOCYCLE;

CREATE OR REPLACE TRIGGER auto_masach
   BEFORE INSERT ON SACH
   FOR EACH ROW
  BEGIN  
    :new.MASACH := 'S' || substr('000000000000000' || TO_CHAR(auto_column_masach.nextval), -4);
  END;
-----------NHAN VIEN-----------

CREATE SEQUENCE auto_column_manv
 START WITH 1
 INCREMENT BY 1 
 MAXVALUE 999999
 NOCACHE
 NOORDER
 NOCYCLE;

CREATE OR REPLACE TRIGGER auto_manv
   BEFORE INSERT ON NHANVIEN
   FOR EACH ROW
  BEGIN  
    :new.MANV := 'NV' || substr('000000000000000' || TO_CHAR(auto_column_manv.nextval), -4);
  END;
---------KHACH HANG----------
CREATE SEQUENCE auto_column_makh
 START WITH 1
 INCREMENT BY 1 
 MAXVALUE 999999
 NOCACHE
 NOORDER
 NOCYCLE;

CREATE OR REPLACE TRIGGER auto_makh
   BEFORE INSERT ON KHACHHANG
   FOR EACH ROW
  BEGIN  
    :new.MAKH := 'KH' || substr('000000000000000' || TO_CHAR(auto_column_makh.nextval), -4);
  END;
----------KHUYEN MAI-----------
CREATE SEQUENCE auto_column_makm
 START WITH 1
 INCREMENT BY 1 
 MAXVALUE 999999
 NOCACHE
 NOORDER
 NOCYCLE;

CREATE OR REPLACE TRIGGER auto_makm
   BEFORE INSERT ON KHUYENMAI
   FOR EACH ROW
  BEGIN  
    :new.MAKM := 'KM' || substr('000000000000000' || TO_CHAR(auto_column_makm.nextval), -4);
  END;
------------HOA DON--------------
CREATE SEQUENCE auto_column_mahd
 START WITH 1
 INCREMENT BY 1 
 MAXVALUE 999999
 NOCACHE
 NOORDER
 NOCYCLE;

CREATE OR REPLACE TRIGGER auto_mahd
   BEFORE INSERT ON HOADON
   FOR EACH ROW
  BEGIN  
    :new.MAHD := 'HD' || substr('000000000000000' || TO_CHAR(auto_column_mahd.nextval), -4);
  END;
---------PHIEUTHUTIEN---------
CREATE SEQUENCE auto_column_maptt
 START WITH 1
 INCREMENT BY 1 
 MAXVALUE 999999
 NOCACHE
 NOORDER
 NOCYCLE;

CREATE OR REPLACE TRIGGER auto_maptt
   BEFORE INSERT ON PHIEUTHUTIEN
   FOR EACH ROW
  BEGIN  
    :new.MAPHIEUTHU := 'PTT' || substr('000000000000000' || TO_CHAR(auto_column_maptt.nextval), -4);
  END;
-------------PHIEUNHAPSACH--------
CREATE SEQUENCE auto_column_mapns
 START WITH 1
 INCREMENT BY 1 
 MAXVALUE 999999
 NOCACHE
 NOORDER
 NOCYCLE;

CREATE OR REPLACE TRIGGER auto_mapns
   BEFORE INSERT ON PHIEUNHAPSACH
   FOR EACH ROW
  BEGIN  
    :new.MAPN := 'PNS' || substr('000000000000000' || TO_CHAR(auto_column_mapns.nextval), -4);
  END;
-----------BAOCAOCONGNO---------
CREATE SEQUENCE auto_column_macn
 START WITH 1
 INCREMENT BY 1 
 MAXVALUE 999999
 NOCACHE
 NOORDER
 NOCYCLE;

CREATE OR REPLACE TRIGGER auto_macn
   BEFORE INSERT ON BAOCAOCONGNO
   FOR EACH ROW
  BEGIN  
    :new.MACN := 'CN' || substr('000000000000000' || TO_CHAR(auto_column_macn.nextval), -4);
  END;
--------BAOCAOTONKHO------
CREATE SEQUENCE auto_column_matk
 START WITH 1
 INCREMENT BY 1 
 MAXVALUE 999999
 NOCACHE
 NOORDER
 NOCYCLE;

CREATE OR REPLACE TRIGGER auto_matk
   BEFORE INSERT ON BAOCAOTONKHO
   FOR EACH ROW
  BEGIN  
    :new.MATK := 'TK' || substr('000000000000000' || TO_CHAR(auto_column_matk.nextval), -4);
  END;



---------------------------------------------------------------------------------INSERT DATA---------------------------------------
----BANG THE LOAI-----

INSERT INTO THELOAI VALUES ('', 'Trinh tham','Tham hiem, kham pha')															;
INSERT INTO THELOAI VALUES ('', 'Kinh di','Truyen kinh di hay se khien ban ron ng?oi, am anh ban trong nhung giac mo')									;
INSERT INTO THELOAI VALUES ('', 'Huyen huyen','Duoc dat ten va phan loai dua theo he thong phan loai truyen chu cua Trung Quoc')							;
INSERT INTO THELOAI VALUES ('', 'Di gioi','Trong truyen co xuat hien nhung the gioi ky di, khac voi the gioi chung ta dang sinh song')							;
INSERT INTO THELOAI VALUES ('', 'Tu tien',' Mot nguoi binh thuong nhung lai gap vo van co duyen de buoc di tren con duong tu tien')							;
INSERT INTO THELOAI VALUES ('', 'Tho','Mot the loai van hoc')																;
INSERT INTO THELOAI VALUES ('', 'Xuyen khong','Nhan vat chinh bi dua den sinh song o mot khong gian hay mot khoang thoi gian khac')							;
INSERT INTO THELOAI VALUES ('', 'Trung sinh','Sinh vat song trong mot sinh vat khac')													;
INSERT INTO THELOAI VALUES ('', 'Sach giao khoa','Dung trong nha truong')														;
INSERT INTO THELOAI VALUES ('', 'Lang man','Danh cho nhung nguoi lang man')														;
INSERT INTO THELOAI VALUES ('', 'Hoc tro','Danh cho lua tuoi hoc tro')															;
INSERT INTO THELOAI VALUES ('', 'Thieu nhi','Danh cho lua tuoi thieu nhi')														;
INSERT INTO THELOAI VALUES ('', 'The thao','Cac thong tin ve the thao')															;
INSERT INTO THELOAI VALUES ('', 'Hu cau','Nhung cau chuyen khong co that')														;
INSERT INTO THELOAI VALUES ('', 'Truyen tranh, Comic, Manga','The loai danh cho thieu nhi')												;
INSERT INTO THELOAI VALUES ('', 'Game','Chien thuat trong cac tro choi')													        ;
INSERT INTO THELOAI VALUES ('', 'Ngon tinh','Truyen thuoc kieu lang man, ke ve nhung su kien vui buon trong tinh yeu cua nhan vat chinh')					        ;
INSERT INTO THELOAI VALUES ('', 'Doi thuong','Nhung cau truyen doi thuong')													        ;
INSERT INTO THELOAI VALUES ('', 'Gia tuong','Nhung cau truyen tuong tuong, khong co that')											        ;
INSERT INTO THELOAI VALUES ('', 'Tien hiep','Truyen tien hiep thuong ke ve qua trinh tu luyen va kham pha the gioi tu si than tien day bi an cua nhan vat chinh')		        ;
INSERT INTO THELOAI VALUES ('', 'Huyen ao','Co ve dep ki la va bi an, vua nhu thuc vua nhu hu, tao suc cuon hut manh me canh vat huyen ao qua man suong')			        ;
INSERT INTO THELOAI VALUES ('', 'Khoa hoc gia tuong','Khoa hoc vien tuong la mot the loai tieu thuyet hu cau mang cac yeu to khoa hoc')						;
INSERT INTO THELOAI VALUES ('', 'Ky ao','Ky ao la mot the loai van hoc nghe thuat trong do phep thuat va cac yeu to sieu nhien khac duoc su dung lam de tai, cot truyen hay boi canh');
INSERT INTO THELOAI VALUES ('', 'Su thi','Mot the loai van hoc')														        ;
INSERT INTO THELOAI VALUES ('', 'Sach hoc ngoai ngu','Sach ngon ngu n?oc ngoai')												        ;
INSERT INTO THELOAI VALUES ('', 'Tu dien','Tu dien tieng nuoc ngoai')														        ;
INSERT INTO THELOAI VALUES ('', 'Sach thuong thuc - Doi song','Noi ve doi song hang ngay')											        ;
INSERT INTO THELOAI VALUES ('', 'Sach van hoc - Truyen ngan','Van hoc theo cach noi chung nhat, la bat ky tac pham nao bang van ban')						        ;
INSERT INTO THELOAI VALUES ('', 'Nguoc','Mang y nghia nguoc')															        ;
INSERT INTO THELOAI VALUES ('', 'Sieu nang luc','Sieu nang luc hay sieu pham la mot thuat ngu van hoa dai chung danh cho nhung nhan vat hu cau co kha nang sieu nhien')		        ;
COMMIT; 



----BANG NHA XUAT BAN----
INSERT INTO NHAXUATBAN VALUES ('','Alphabooks','Viet Nam','0975234560')		  ;
INSERT INTO NHAXUATBAN VALUES ('','MCBOOKS','Viet Nam','0975234500')	   	  ;
INSERT INTO NHAXUATBAN VALUES ('','Nha Nam','Viet Nam','0975234460')		  ;
INSERT INTO NHAXUATBAN VALUES ('','Nha Xuat Ban Kim Dong','Viet Nam','0965234560');
INSERT INTO NHAXUATBAN VALUES ('','NXB Tre','Viet Nam','0235234541')		  ;
INSERT INTO NHAXUATBAN VALUES ('','Dinh Ti','Viet Nam','0974239520')		  ;
INSERT INTO NHAXUATBAN VALUES ('','Thai Ha','Viet Nam','0445234440')		  ;
INSERT INTO NHAXUATBAN VALUES ('','NXB Phu Nu Viet Nam','Viet Nam','0991234000')  ;
INSERT INTO NHAXUATBAN VALUES ('','FIRST NEWS','Viet Nam','0975777560')		  ;
INSERT INTO NHAXUATBAN VALUES ('','VanLangBooks','Viet Nam','02295234560')	  ;
INSERT INTO NHAXUATBAN VALUES ('','ABC','Viet Nam','0971234560')		  ;
INSERT INTO NHAXUATBAN VALUES ('','BIZBOOKS','Viet Nam','0267577560')		  ;
INSERT INTO NHAXUATBAN VALUES ('','1980 Books','Viet Nam','0966652560')		  ;
INSERT INTO NHAXUATBAN VALUES ('','NXB Tong Hop TP.HCM','Viet Nam','0543888560')  ;
INSERT INTO NHAXUATBAN VALUES ('','Bach Viet','Viet Nam','0935010102')		  ;
INSERT INTO NHAXUATBAN VALUES ('','NXB Giao Duc','Viet Nam','0335790860')	  ;
INSERT INTO NHAXUATBAN VALUES ('','NXB Lao Dong','Viet Nam','097876430')	  ;
INSERT INTO NHAXUATBAN VALUES ('','NXB DHQG Ha Noi','Viet Nam','0975447222')	  ;
INSERT INTO NHAXUATBAN VALUES ('','NXB DHQG TP. HCM','Viet Nam','0979987331')	  ;
COMMIT;






-------BANG TAC GIA---------------

INSERT INTO TACGIA VALUES ('', 'Nhieu tac gia','Nhieu dia chi','Nhieu tieu su','Khong ro','Nhieu email')				   ;
INSERT INTO TACGIA VALUES ('', 'Fred Vargas','America','Tot nghiep dai hoc tai My','0326164846','vargas@gmail.com')			   ;
INSERT INTO TACGIA VALUES ('', 'Darren Shan','America','Tot nghiep dai hoc tai My','0314494861','shan@gmail.com')			   ;
INSERT INTO TACGIA VALUES ('', 'Fresh Qua Qua','Trung Quoc','Tot nghiep dai hoc tai Trung Quoc','06484849451','quaqua@gmail.com')	   ;
INSERT INTO TACGIA VALUES ('', 'Thien Tam ','Trung Quoc','Tot nghiep dai hoc tai Trung Quoc','06481599451','thodau@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Dan Brown','America','Tot nghiep dai hoc tai My','011549499','brown@gmail.com') 			   ;
INSERT INTO TACGIA VALUES ('', 'Yukito Ayatsuji','Nhat ban','Tot nghiep ?ai hoc tai Nhat Ban','05161616','yukito@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Nguyen Nhat Anh','Viet Nam','Tot nghiep dai hoc tai viet Nam','016516189','nhatanh@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Nguyen Du','Viet Nam','Dai thi hao dan toc','Khong ro','Khong ro')					   ;
INSERT INTO TACGIA VALUES ('', 'Shinkai Makoto','Nhat Ban','Tot nghiep dai hoc tai Nhat Ban','0201616511','makoto@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Clive Staples Lewis','america','Tot nghiep dai hoc tai My','021651161','lewis@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Yem But Tieu Sinh','Trung Quoc','khong ro','Khong ro','Khong ro')				           ;
INSERT INTO TACGIA VALUES ('', 'Mamoru Hasoda','Nhat Ban','Tot nghiep dai hoc tai Nhat Ban','0206165116','hasoda@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Kobayashi Ritz','Nhat Ban','Tot nghiep dai hoc tai Nhat Ban','0454984151','ritz@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Yonezawa Honobu','Nhat Ban','Tot nghiep dai hoc tai Nhat Ban','09515115','honobu@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Kawahara Reki','Nhat Ban','Tot nghiep dai hoc tai Nhat Ban','07151166','reki@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Tanigawa Nagaru','Nhat Ban','Tot nghiep dai hoc tai Nhat Ban','056484913','nagaru@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Minh Nguyet Thinh Phong','Viet Nam','Tot nghiep dai hoc tai viet Nam','0616651649','thinhphong@gmail.com') ;
INSERT INTO TACGIA VALUES ('', ' Gia Tam','Trung Quoc','Tot nghiep dai hoc tai Trung Quoc','02651651616','tamthieu@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Mai Can Thai Thieu Binh','Trung Quoc','Tot nghiep dai hoc tai Trung Quoc','01155151','thieubinh@gmail.com');
INSERT INTO TACGIA VALUES ('', 'Fujiko F. Fujio','Nhat Ban','Cha de bo truyen Doraemon','Khong ro','Khong ro')				   ;
INSERT INTO TACGIA VALUES ('', 'Minh Nguyet','Viet Nam','Tot nghiep dai hoc tai Viet Nam','015616165','minhnguyet@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Conan Doyle','america','Tot nghiep dai hoc tai My','0156116584','doyle@gmail.com')			   ;
INSERT INTO TACGIA VALUES ('', 'Iwasaki Natsumi','Nhat Ban','Tot nghiep dai hoc tai Nhat Ban','0154865161','natsumi@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'Christine Ha','Viet Nam','Nguoi My goc Viet','061454511','hahaha@gmail.com')				   ;
INSERT INTO TACGIA VALUES ('', 'Huynh Hai Yen','Viet Nam','Tot nghiep dai hoc tai Viet Nam','0789455611','haiyen@gmail.com')		   ;
INSERT INTO TACGIA VALUES ('', 'J.R.R Tolkien','america','Tot nghiep dai hoc tai my','05164613165','tolkien@gmail.com')			   ;
INSERT INTO TACGIA VALUES ('', 'Tao Dinh','Trung Quoc','Tot nghiep dai hoc tai Trung Quoc','0265161','taodinh@gmail.com')		   ;
COMMIT;




-------BANG SACH--------------------


INSERT INTO SACH VALUES ('', 'Kinh van hoa - Tron bo', 2005   , 300000,'TL0015','NXB0001','TG0008',312 )		 ;
INSERT INTO SACH VALUES ('', 'Hoa thien cot - Tron bo',  2016  , 240000,'TL0020','NXB0002','TG0004', 282)	 ;
INSERT INTO SACH VALUES ('', 'Narnia - Tron bo',  1950  , 220000,'TL0008','NXB0015','TG0011', 141)		 ;
INSERT INTO SACH VALUES ('', 'Truyen Kieu',  1820  , 40000,'TL0006','NXB0004','TG0009', 147) 			 ;
INSERT INTO SACH VALUES ('', 'Another - Tron bo 2 tap',  2019  , 160000,'TL0015','NXB0005','TG0007', 290)	 ;
INSERT INTO SACH VALUES ('', '5 Centimet tren giay',  2007  , 50000,'TL0015','NXB0006','TG0010', 295)		 ;
INSERT INTO SACH VALUES ('', 'Hoa nguc',  2013  , 248000,'TL0015','NXB0001','TG0007', 148)			 ;
INSERT INTO SACH VALUES ('', 'Mat ma Da Vinci',  2003  , 222000,'TL0021','NXB0008','TG0006', 139)		 ;
INSERT INTO SACH VALUES ('', 'Bieu tuong that truyen',  2009  , 256000,'TL0015','NXB0009','TG0006', 296)		 ;
INSERT INTO SACH VALUES ('', 'Thien than va ac quy',  2000  , 212000,'TL0022','NXB0011','TG0006', 133)		 ;
INSERT INTO SACH VALUES ('', 'Phao dai so',  1998  ,204000,'TL0001','NXB0001','TG0006', 150)			 ;
INSERT INTO SACH VALUES ('', 'Sword Art Online: Aincrad - Tap 1',  2012  ,96000,'TL0016','NXB0001','TG0016', 146) ;
INSERT INTO SACH VALUES ('', 'Ma soi',  1973  ,98000,'TL0005','NXB0016','TG0002', 148)				 ;
INSERT INTO SACH VALUES ('', 'Daren Shan - Tron Bo',  2018  ,212000,'TL0021','NXB0012','TG0003', 150)		 ;
INSERT INTO SACH VALUES ('', 'Sherlock Holmes - Tron bo',  2018  , 270000,'TL0001','NXB0001','TG0024', 148)	 ;
INSERT INTO SACH VALUES ('', 'Bai hoc yeu cua tieu ma vuong',  2020  ,110000,'TL0017','NXB0001','TG0018', 150)    ;
INSERT INTO SACH VALUES ('', 'Dau pha thuong khung', 2020  , 420000,'TL0021','NXB0014','TG0005', 150)		 ;
INSERT INTO SACH VALUES ('', 'Dai chua te',  2013  ,450000,'TL0021','NXB0005','TG0005', 150)			 ;
INSERT INTO SACH VALUES ('', 'Dau la dai luc',  2008  ,210000,'TL0020','NXB0003','TG0019', 150)			 ;
INSERT INTO SACH VALUES ('', 'De ba',  1835  ,520000,'TL0004','NXB0001','TG0012', 149)				 ;
INSERT INTO SACH VALUES ('', 'Ve si than cap ',  1943  , 245000,'TL0015','NXB0001','TG0020', 150)		 ;
INSERT INTO SACH VALUES ('', 'Chu khung long cua Nobita',  2014  , 20000,'TL0015','NXB0001','TG0021', 150)        ;
INSERT INTO SACH VALUES ('', 'Doraemon: Vuong quoc tren may',  1992  , 20000,'TL0015','NXB0001','TG0021', 149)    ;
INSERT INTO SACH VALUES ('', 'Yeu cung',  2011  , 366000,'TL0027','NXB0001','TG0022', 150)			 ;
INSERT INTO SACH VALUES ('', 'Sword Art Online: Aincrad - Tap 2',  2010  , 96000,'TL0016','NXB0001','TG0016', 149);
INSERT INTO SACH VALUES ('', 'Bo sach giao khoa lop 9',  2020  ,106000,'TL0009','NXB0001','TG0001', 149)		 ;
INSERT INTO SACH VALUES ('', 'Bo vo bai tap lop 9',  2020  ,72000,'TL0004','NXB0001','TG0001', 149)		 ;	
INSERT INTO SACH VALUES ('', 'Co nang quan tri',  2019  ,92000,'TL0009','NXB0007','TG0025', 149)			 ;
INSERT INTO SACH VALUES ('', 'Nau an bang ca trai tim',  2020  ,82000,'TL0027','NXB0001','TG0026', 150)	 	 ;
INSERT INTO SACH VALUES ('', 'Oc dao mui huong',  2015  ,77000, 'TL0018','NXB0007','TG0027',150)			 ;
INSERT INTO SACH VALUES ('', 'Tai lieu luyen thi',  2020  ,50000,'TL0009','NXB0008','TG0028', 150)		 ;
INSERT INTO SACH VALUES ('', 'Doan ho nhan',  1954  ,180000,'TL0022','NXB0009','TG0021', 149)			 ;
INSERT INTO SACH VALUES ('', 'Hai toa thap',  2018  ,180000,'TL0003','NXB0001','TG0021', 149)			 ;
INSERT INTO SACH VALUES ('', 'Nha vua tro ve',  1855  ,180000, 'TL0015','NXB0001','TG0021',149)			 ;
INSERT INTO SACH VALUES ('', 'Anh chang Hobbit', 1937  ,165000,'TL0015','NXB0003','TG0021', 150)			 ;
INSERT INTO SACH VALUES ('', 'Khu vuon ngon tu',  2013  , 90000,'TL0010','NXB0001','TG0016', 148)		 ;
INSERT INTO SACH VALUES ('', 'Phieu luu vao xu quy',  1984  ,20000,'TL0015','NXB0001','TG0019', 149)		 ;
INSERT INTO SACH VALUES ('', 'Nghin le mot dem',  2016  ,20000,'TL0003','NXB0004','TG0013', 149)			 ;
INSERT INTO SACH VALUES ('', 'Nobita va nguoi khong lo xanh',  2008  ,20000,'TL0015','NXB0001','TG0013', 150)	 ;
INSERT INTO SACH VALUES ('', 'Cuoc dai thuy chien ',  2016  ,20000,'TL0015','NXB0001','TG0003', 149)		 ;
INSERT INTO SACH VALUES ('', 'Diem doi lua',  2020  , 240000, 'TL0022','NXB0001','TG0015',149)			 ;
INSERT INTO SACH VALUES ('', 'Dau la dai luc 2',  2020  ,225000, 'TL0020','NXB0001','TG0022',150)		 ;
INSERT INTO SACH VALUES ('', 'Yeu anh hon ca tu than',  2016  ,86000, 'TL0017','NXB0001','TG0012',149)		 ;
INSERT INTO SACH VALUES ('', 'Nhung dua con cua soi',  2015  ,108000, 'TL0015','NXB0001','TG0001',148)		 ;
INSERT INTO SACH VALUES ('', 'Sach day xep hinh',  2020  ,1000000,'TL0012','NXB0007','TG0003', 150)		 ;
COMMIT;

------BANG KHUYEN MAI--------------------

INSERT INTO KHUYENMAI values ('','Khuyen mai ngay le 30/4-1/5','Ngay le giai phong mien nam',TO_DATE('2021/04/30','yyyy/mm/dd'),TO_DATE('2021/05/01','yyyy/mm/dd'),0.15)     ;
INSERT INTO KHUYENMAI values ('','Khuyen mai ngay quoc te thieu nhi','Ngay le quoc te thieu nhi',TO_DATE('2021/06/01','yyyy/mm/dd'),TO_DATE('2021/06/02','yyyy/mm/dd'),0.2)  ;
INSERT INTO KHUYENMAI values ('','Cung em den truong','Chao don nam hoc moi',TO_DATE('2020/06/30','yyyy/mm/dd'),TO_DATE('2020/07/15','yyyy/mm/dd'),0.2)			     ;
INSERT INTO KHUYENMAI values ('','Tri an khach hang','Khuyen mai cho khach hang than thiet',TO_DATE('2020/07/15','yyyy/mm/dd'),TO_DATE('2020/07/30','yyyy/mm/dd'),0.15)	     ;
INSERT INTO KHUYENMAI values ('','Trung thu trao tay','Khuyen mai tet trung thu',TO_DATE('2020/07/30','yyyy/mm/dd'),TO_DATE('2020/08/30','yyyy/mm/dd'),0.1)		     ;
INSERT INTO KHUYENMAI values ('','Khuyen mai ngay quan doi nhan dan','Ngay le giai phong mien nam',TO_DATE('2020/12/22','yyyy/mm/dd'),TO_DATE('2020/12/31','yyyy/mm/dd'),0.1);
INSERT INTO KHUYENMAI values ('','Tet chon niem vui','Khuyen mai chao don tet duong lich',TO_DATE('2021/01/01','yyyy/mm/dd'),TO_DATE('2021/01/05','yyyy/mm/dd'),0.2)	     ;
INSERT INTO KHUYENMAI values ('','Le tinh yeu','Khuyen mai chao don ngay valentine',TO_DATE('2021/02/14','yyyy/mm/dd'),TO_DATE('2021/02/15','yyyy/mm/dd'),0.1)		     ;
INSERT INTO KHUYENMAI values ('','Quoc te phu nu','Khuyen mai chao don ngay 8/3',TO_DATE('2021/03/08','yyyy/mm/dd'),TO_DATE('2021/03/09','yyyy/mm/dd'),0.3)		     ;
INSERT INTO KHUYENMAI values ('','Ngay thanh lap doan','Khuyen mai ngay thanh lap doan 26/3',TO_DATE('2021/03/26','yyyy/mm/dd'),TO_DATE('2021/03/30','yyyy/mm/dd'),0.2)	     ;
COMMIT;


--------- BANG KHACH HANG-------


INSERT INTO KHACHHANG VALUES ('', 'Huynh Chi Phong', 0,'792/4 Duong Kha Van Can', '01238756',45000);
INSERT INTO KHACHHANG VALUES ('', 'Vo Hoai Nam',0, 'Lam Dong', '0151165191',20000)	       ;
INSERT INTO KHACHHANG VALUES ('', 'To Chinh Tin',1, 'Tien Giang', '0909936',34000)  	       ;
INSERT INTO KHACHHANG VALUES ('', 'Lanh Thua Phong', 0, 'Viet Nam', '01234678',0)	       ;
INSERT INTO KHACHHANG VALUES ('', 'Ly That Da', 2, 'Trung Quoc', '19816612',0)      	       ;
INSERT INTO KHACHHANG VALUES ('', 'Han Phong', 0, 'Nha Be', '191918483',0) 		       ;
INSERT INTO KHACHHANG VALUES ('', 'Du Chinh Phong',1, 'Da Lat', '15165194',0)                  ;
INSERT INTO KHACHHANG VALUES ('', 'Dieu Yen', 2, 'Lam Dong', '0119518',0)		       ;
INSERT INTO KHACHHANG VALUES ('', 'Tieu Viem',0, 'Dong Nai', '0569194',0) 		       ;
INSERT INTO KHACHHANG VALUES ('', 'Diep Pham',1, 'Quang Ngai', '018191879',0)		       ;
INSERT INTO KHACHHANG VALUES ('', 'Thao Thao',2, 'Xuan Loc, Dong Nai','0151989115',55000)      ;
INSERT INTO KHACHHANG VALUES ('', 'Chi Phong', 0,' Pham Van Dong', '012038756',28000)	       ;
INSERT INTO KHACHHANG VALUES ('', 'Hoai Nam',0, 'Long Khanh', '019819111',0)		       ;
INSERT INTO KHACHHANG VALUES ('', 'Chinh Tin',1, 'Hau Giang', '09079936',23000)		       ;
INSERT INTO KHACHHANG VALUES ('', 'Thua Phong', 0, 'Viet Nam', '012345678',20000)	       ;
INSERT INTO KHACHHANG VALUES ('', 'That Da', 2, 'Trung Quoc', '056199812',0)		       ;
INSERT INTO KHACHHANG VALUES ('', 'Phong', 0, 'Nha Be', '0605619843',0)			       ;
INSERT INTO KHACHHANG VALUES ('', 'Chinh Phong',1, 'Da Lat', '0158481984',0)		       ;
INSERT INTO KHACHHANG VALUES ('', 'Dieu Yen Yen', 2, 'Lam Dong', '011911518',0)		       ;
INSERT INTO KHACHHANG VALUES ('', 'Tieu Viem Viem',0, 'Dong Nai', '05619194',0)		       ;
INSERT INTO KHACHHANG VALUES ('', 'Diep Pham Van',1, 'Quang Ngai', '018198191879',0)	       ;
INSERT INTO KHACHHANG VALUES ('', 'Nguyen Thao Quyen',2, 'Xuan Loc, Dong Nai','0151989115',0)  ;
COMMIT;




----------BANG NHAN VIEN ---------------------------

INSERT INTO NHANVIEN VALUES ('','Thao Quyen',0,TO_DATE('2013/03/22','YYYY/MM/DD'),'Dong Nai','0118191981','1000000') ;
INSERT INTO NHANVIEN VALUES ('','Nhu Long',1,TO_DATE('2013/03/22','YYYY/MM/DD'),'Long An','06151981','10000000')     ;
INSERT INTO NHANVIEN VALUES ('','Chau Pha',1,TO_DATE('2014/02/22','YYYY/MM/DD'),'Quang Ngai','01117191','2000000')   ;
INSERT INTO NHANVIEN VALUES ('','Quoc Tin',2,TO_DATE('2015/03/22','YYYY/MM/DD'),'Dong Nai','0118161891','5000000')   ;
INSERT INTO NHANVIEN VALUES ('','Thanh Nhan',2,TO_DATE('2012/03/22','YYYY/MM/DD'),'TP.HCM','09185181','6000000')     ;
INSERT INTO NHANVIEN VALUES ('','Bich Cham',0,TO_DATE('2014/02/12','YYYY/MM/DD'),'Dong Nai','0151651981','4000000')  ;
INSERT INTO NHANVIEN VALUES ('','Xuan Dat',0,TO_DATE('2016/03/12','YYYY/MM/DD'),'Bien Hoa','01911965065','8000000')  ;
INSERT INTO NHANVIEN VALUES ('','Duy Phuc',0,TO_DATE('2018/03/03','YYYY/MM/DD'),'TP.HCM','01051561','4000000')	     ;
INSERT INTO NHANVIEN VALUES ('','Quoc Khanh',0,TO_DATE('2014/03/20','YYYY/MM/DD'),'Tien Giang','019819811','5000000');
INSERT INTO NHANVIEN VALUES ('','Thanh Dat',0,TO_DATE('2013/03/22','YYYY/MM/DD'),'Dong Nai','0119195611','4000000')  ;
INSERT INTO NHANVIEN VALUES ('','Xuan Phat',0,TO_DATE('2014/01/01','YYYY/MM/DD'),'Long Khanh','0551611919','9000000');
INSERT INTO NHANVIEN VALUES ('','Nghia',0,TO_DATE('2019/12/22','YYYY/MM/DD'),'Dong Nai','011819981','1000000')	     ;
COMMIT;

---------BANG TAI KHOAN --------------------------

INSERT INTO TAIKHOAN VALUES ('THAOQUYEN@gmail.com', 'LIULIU123','NV0001');
INSERT INTO TAIKHOAN VALUES ('NHULONG@gmail.com', 'LIULIU123@','NV0002') ;
INSERT INTO TAIKHOAN VALUES ('CHAUPHA@gmail.com', 'FGFDGRG','NV0003')    ;
INSERT INTO TAIKHOAN VALUES ('QUOCTIN@gmail.com', 'AFAFARF','NV0004')	 ;
INSERT INTO TAIKHOAN VALUES ('THANHNHAN@gmail.com', 'EGERGRAG','NV0005') ;
INSERT INTO TAIKHOAN VALUES ('BICHCHAM@gmail.com', 'GERGETBA','NV0006')  ;
INSERT INTO TAIKHOAN VALUES ('XUANDAT@gmail.com', 'AGETBAEB','NV0007')   ;
INSERT INTO TAIKHOAN VALUES ('DUYPHUC@gmail.com', 'AVETAETBA','NV0008')  ;
INSERT INTO TAIKHOAN VALUES ('QUOCKHANH@gmail.com', 'ABTABA','NV0009')   ;
INSERT INTO TAIKHOAN VALUES ('THANHDAT@gmail.com', 'ABRTBETAB','NV0010') ;
INSERT INTO TAIKHOAN VALUES ('XUANPHAT@gmail.com', 'ARVEABAE','NV0011')  ;
INSERT INTO TAIKHOAN VALUES ('NGHIA@gmail.com', 'WAERBG','NV0012')	 ;
COMMIT;

-------BANG BAO CAO CONG NO-----------------------
  
INSERT INTO BAOCAOCONGNO VALUES ('',TO_DATE('2021/03/30','YYYY/MM/DD'));
INSERT INTO BAOCAOCONGNO VALUES ('',TO_DATE('2021/04/30','YYYY/MM/DD'));
COMMIT;

  -------BANG CHI TIET CONG NO----------------------



INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0001', 75000,0)       ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0002' , 50000, 20000) ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0003' , 84000, 24000) ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0004' , 0, 0) 	;
INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0005' , 6000, 0)      ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0006' , 52000, 0)	    ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0007' , 0, 0)	    ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0008' , 0, 0)	    ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0009' , 6000, 0)      ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0010' , 0, 0)      ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0011' , 105000, 55000);
INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0012' , 78000, 28000) ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001', 'KH0013' , 0, 0) ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001', 'KH0014', 43000, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001','KH0015', 40800, 0)      ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001', 'KH0016', 0, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001', 'KH0017', 0, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001', 'KH0018',0, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001', 'KH0019', 0, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001', 'KH0020', 19600, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001', 'KH0021', 0, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0001', 'KH0022', 0, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0001', 75000,45000)       ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0002' , 50000, 20000) ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0003' , 84000, 34000) ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0004' , 0, 0) 	;
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0005' , 6000, 0)      ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0006' , 52000, 0)	    ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0007' , 0, 0)	    ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0008' , 0, 0)	    ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0009' , 6000, 0)      ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0010' , 0, 0)      ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0011' , 105000, 55000);
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0012' , 78000, 28000) ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002', 'KH0013' , 0, 0) ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002', 'KH0014', 43000, 23000)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002','KH0015', 40800, 20000)      ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002', 'KH0016', 0, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002', 'KH0017', 0, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002', 'KH0018',0, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002', 'KH0019', 0, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002', 'KH0020', 19600, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002', 'KH0021', 0, 0)     ;
INSERT INTO CHITIETCONGNO VALUES ('CN0002', 'KH0022', 0, 0)     ;
COMMIT;


  ---------BANG PHIEU THU TIEN----------------------

INSERT INTO PHIEUTHUTIEN VALUES ('','KH0001',TO_DATE('2021/03/22','YYYY/MM/DD'),75000);
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0002',TO_DATE('2021/03/22','YYYY/MM/DD'),30000);  
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0003',TO_DATE('2021/03/23','YYYY/MM/DD'),60000); 
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0005',TO_DATE('2021/03/24','YYYY/MM/DD'),6000) ;
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0006',TO_DATE('2021/03/24','YYYY/MM/DD'),52000);
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0009',TO_DATE('2021/03/25','YYYY/MM/DD'),6000) ; 
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0011',TO_DATE('2021/03/22','YYYY/MM/DD'),50000);
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0012',TO_DATE('2021/03/22','YYYY/MM/DD'),50000);  
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0014',TO_DATE('2021/03/23','YYYY/MM/DD'),43000); 
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0015',TO_DATE('2021/03/24','YYYY/MM/DD'),40800);
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0020',TO_DATE('2021/03/24','YYYY/MM/DD'),19600);
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0001',TO_DATE('2021/04/22','YYYY/MM/DD'),30000);
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0002',TO_DATE('2021/04/22','YYYY/MM/DD'),30000);  
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0003',TO_DATE('2021/04/23','YYYY/MM/DD'),50000); 
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0005',TO_DATE('2021/04/24','YYYY/MM/DD'),6000) ;
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0006',TO_DATE('2021/04/24','YYYY/MM/DD'),52000);
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0009',TO_DATE('2021/04/25','YYYY/MM/DD'),6000) ; 
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0011',TO_DATE('2021/04/22','YYYY/MM/DD'),50000);
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0012',TO_DATE('2021/04/22','YYYY/MM/DD'),50000);  
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0014',TO_DATE('2021/04/23','YYYY/MM/DD'),20000); 
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0015',TO_DATE('2021/04/24','YYYY/MM/DD'),20800);
INSERT INTO PHIEUTHUTIEN VALUES ('','KH0020',TO_DATE('2021/04/24','YYYY/MM/DD'),19600);
COMMIT;



------BANG PHIEU NHAP SACH ---------------------
 
INSERT INTO PHIEUNHAPSACH VALUES ('',TO_DATE('2021/02/11','YYYY/MM/DD'));
INSERT INTO PHIEUNHAPSACH VALUES ('',TO_DATE('2021/02/12','YYYY/MM/DD'));
INSERT INTO PHIEUNHAPSACH VALUES ('',TO_DATE('2021/02/13','YYYY/MM/DD'));
INSERT INTO PHIEUNHAPSACH VALUES ('',TO_DATE('2021/02/14','YYYY/MM/DD'));
INSERT INTO PHIEUNHAPSACH VALUES ('',TO_DATE('2021/02/15','YYYY/MM/DD'));
INSERT INTO PHIEUNHAPSACH VALUES ('',TO_DATE('2021/02/16','YYYY/MM/DD'));
INSERT INTO PHIEUNHAPSACH VALUES ('',TO_DATE('2021/02/17','YYYY/MM/DD'));
INSERT INTO PHIEUNHAPSACH VALUES ('',TO_DATE('2021/02/18','YYYY/MM/DD'));
INSERT INTO PHIEUNHAPSACH VALUES ('',TO_DATE('2021/02/19','YYYY/MM/DD'));
INSERT INTO PHIEUNHAPSACH VALUES ('',TO_DATE('2021/02/20','YYYY/MM/DD'));
INSERT INTO PHIEUNHAPSACH VALUES ('',TO_DATE('2021/02/21','YYYY/MM/DD'));
INSERT INTO PHIEUNHAPSACH VALUES ('',TO_DATE('2021/02/22','YYYY/MM/DD'));
COMMIT;



-------BANG CHI TIET PHIEU NHAP--------------------

INSERT INTO CHITIETPHIEUNHAP VALUES ('S0004','PNS0001', 150,30000) ;
INSERT INTO CHITIETPHIEUNHAP VALUES ('S0005','PNS0002', 150,140000);
INSERT INTO CHITIETPHIEUNHAP VALUES ('S0006','PNS0003', 150,40000) ;
INSERT INTO CHITIETPHIEUNHAP VALUES ('S0010','PNS0004', 150,200000);
INSERT INTO CHITIETPHIEUNHAP VALUES ('S0008','PNS0005', 150,200000);
INSERT INTO CHITIETPHIEUNHAP VALUES ('S0009','PNS0006', 150,20000) ;
INSERT INTO CHITIETPHIEUNHAP VALUES ('S0011','PNS0007', 150,190000);
INSERT INTO CHITIETPHIEUNHAP VALUES ('S0012','PNS0008', 150,80000) ;
INSERT INTO CHITIETPHIEUNHAP VALUES ('S0013','PNS0009', 150,70000) ;
INSERT INTO CHITIETPHIEUNHAP VALUES ('S0014','PNS0010', 150,200000);
INSERT INTO CHITIETPHIEUNHAP VALUES ('S0015','PNS0011', 150,200000);
INSERT INTO CHITIETPHIEUNHAP VALUES ('S0016','PNS0012', 150,90000) ;
COMMIT;


  --------BANG BAO CAO TON KHO-------------------------


INSERT INTO BAOCAOTONKHO VALUES ('',TO_DATE('2021/03/30','YYYY/MM/DD'));
INSERT INTO BAOCAOTONKHO VALUES ('',TO_DATE('2021/04/30','YYYY/MM/DD'));
COMMIT;



  -------BANG CHI TIET TON KHO ------------------------


INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0001',  342,327);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0002',  288,285);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0003',  147,144);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0004',  149,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0005',  294,292);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0006',  297,296);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0007',  148,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0008',  147,143);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0009',  300,298);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0010',  149,141);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0011',  342,342);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0012',  288,288);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0013',  147,147);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0014',  149,149);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0015',  294,294);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0016',  297,297);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0017',  148,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0018',  147,147);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0019',  300,300);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0020',  149,149);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0021',  342,327);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0022',  288,285);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0023',  147,144);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0024',  149,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0025',  294,292);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0026',  297,296);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0027',  148,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0028',  147,143);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0029',  300,298);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0030',  149,145);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0031',  342,342);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0032',  288,288);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0033',  147,147);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0034',  149,149);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0035',  294,294);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0036',  297,297);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0037',  148,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0038',  147,147);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0039',  300,300);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0040',  149,149);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0041',  297,297);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0042',  148,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0043',  147,147);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0044',  300,300);
INSERT INTO CHITIETTONKHO VALUES ('TK0001', 'S0045',  149,149);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0001',  327,312);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0002',  285,282);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0003',  144,141);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0004',  148,147);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0005',  292,290);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0006',  296,295);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0007',  148,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0008',  143,139);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0009',  298,296);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0010',  141,133);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0011',  342,342);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0012',  288,288);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0013',  147,147);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0014',  149,149);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0015',  294,294);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0016',  297,297);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0017',  148,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0018',  147,147);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0019',  300,300);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0020',  149,149);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0021',  342,327);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0022',  288,285);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0023',  147,144);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0024',  149,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0025',  294,292);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0026',  297,296);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0027',  148,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0028',  147,143);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0029',  300,298);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0030',  149,145);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0031',  342,342);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0032',  288,288);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0033',  147,147);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0034',  149,149);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0035',  294,294);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0036',  297,297);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0037',  148,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0038',  147,147);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0039',  300,300);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0040',  149,149);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0041',  297,297);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0042',  148,148);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0043',  147,147);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0044',  300,300);
INSERT INTO CHITIETTONKHO VALUES ('TK0002', 'S0045',  149,149);
COMMIT;







----------BANG HOA DON ---------------------------


INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/12','YYYY/MM/DD'), 1500000,1275000,1200000,'NV0001','KH0001','KM0001')  ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/12','YYYY/MM/DD'), 3000000, 2550000,2500000, 'NV0001','KH0002','KM0001');
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/12','YYYY/MM/DD'), 480000,384000,300000,'NV0002','KH0003','KM0002')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/12','YYYY/MM/DD'), 240000,192000,192000,'NV0002','KH0004','KM0002')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/12','YYYY/MM/DD'), 220000,176000,170000,'NV0003','KH0005','KM0010')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/13','YYYY/MM/DD'), 440000,352000,300000,'NV0003','KH0006','KM0010')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/13','YYYY/MM/DD'), 98000,78400,78400,'NV0004','KH0007','KM0003')        ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/13','YYYY/MM/DD'), 220000,176000,176000,'NV0004','KH0008','KM0003')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/13','YYYY/MM/DD'), 160000,136000,130000,'NV0005','KH0009','KM0004')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/13','YYYY/MM/DD'), 50000,42500,42500,'NV0005','KH0010','KM0004')        ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/14','YYYY/MM/DD'), 450000,405000,300000,'NV0006','KH0011','KM0005')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/14','YYYY/MM/DD'), 420000,378000,300000,'NV0006','KH0012','KM0005')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/14','YYYY/MM/DD'), 110000,99000,99000,'NV0007','KH0013','KM0005')      ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/14','YYYY/MM/DD'), 270000,243000,200000,'NV0007','KH0014','KM0005')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/14','YYYY/MM/DD'), 212000,190800,150000,'NV0008','KH0015','KM0005')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/15','YYYY/MM/DD'), 98000,88200,88200,'NV0008','KH0016','KM0006')        ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/15','YYYY/MM/DD'), 96000,76800,76800,'NV0009','KH0017','KM0007')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/15','YYYY/MM/DD'), 212000,190800,190800,'NV0009','KH0018','KM0008')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/15','YYYY/MM/DD'), 96000,76800,76800,'NV0010','KH0019','KM0010')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/03/15','YYYY/MM/DD'), 212000,169600,150000,'NV0011','KH0020','KM0010')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2020/03/15','YYYY/MM/DD'), 212000,169600,150000,'NV0011','KH0021','KM0010')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2020/03/16','YYYY/MM/DD'), 212000,169600,150000,'NV0011','KH0022','KM0010')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2020/03/16','YYYY/MM/DD'), 212000,169600,150000,'NV0011','KH0004','KM0010')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2020/03/16','YYYY/MM/DD'), 212000,169600,150000,'NV0011','KH0005','KM0010')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/12','YYYY/MM/DD'), 1500000,1275000,1200000,'NV0001','KH0001','KM0001')  ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/12','YYYY/MM/DD'), 3000000, 2550000,2500000, 'NV0001','KH0002','KM0001');
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/12','YYYY/MM/DD'), 480000,384000,300000,'NV0002','KH0003','KM0002')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/12','YYYY/MM/DD'), 240000,192000,192000,'NV0002','KH0004','KM0002')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/12','YYYY/MM/DD'), 220000,176000,170000,'NV0003','KH0005','KM0010')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/13','YYYY/MM/DD'), 440000,352000,300000,'NV0003','KH0006','KM0010')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/13','YYYY/MM/DD'), 98000,78400,78400,'NV0004','KH0007','KM0003')        ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/13','YYYY/MM/DD'), 220000,176000,176000,'NV0004','KH0008','KM0003')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/13','YYYY/MM/DD'), 160000,136000,130000,'NV0005','KH0009','KM0004')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/13','YYYY/MM/DD'), 50000,42500,42500,'NV0005','KH0010','KM0004')        ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/14','YYYY/MM/DD'), 450000,405000,300000,'NV0006','KH0011','KM0005')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/14','YYYY/MM/DD'), 420000,378000,300000,'NV0006','KH0012','KM0005')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/14','YYYY/MM/DD'), 110000,99000,99000,'NV0007','KH0013','KM0005')      ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/14','YYYY/MM/DD'), 270000,243000,200000,'NV0007','KH0014','KM0005')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/14','YYYY/MM/DD'), 212000,190800,150000,'NV0008','KH0015','KM0005')     ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/15','YYYY/MM/DD'), 98000,88200,88200,'NV0008','KH0016','KM0006')        ;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/15','YYYY/MM/DD'), 212000,169600,169600,'NV0009','KH0017','KM0007')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/15','YYYY/MM/DD'), 212000,190800,190800,'NV0009','KH0018','KM0008')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/15','YYYY/MM/DD'), 212000,169600,169600,'NV0010','KH0019','KM0010')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2021/04/15','YYYY/MM/DD'), 212000,169600,150000,'NV0011','KH0020','KM0010')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2020/04/15','YYYY/MM/DD'), 212000,169600,150000,'NV0011','KH0021','KM0010')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2020/04/16','YYYY/MM/DD'), 212000,169600,150000,'NV0011','KH0022','KM0010')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2020/04/16','YYYY/MM/DD'), 212000,169600,150000,'NV0011','KH0004','KM0010')	;
INSERT INTO HOADON VALUES ('', TO_DATE('2020/04/16','YYYY/MM/DD'), 212000,169600,150000,'NV0011','KH0005','KM0010')	;


COMMIT;



  ----------BANG CHI TIET HOA DON ------------------

INSERT INTO CHITIETHOADON VALUES ('S0001','HD0001', 300000, 5)  ;
INSERT INTO CHITIETHOADON VALUES ('S0001', 'HD0002', 300000, 10);
INSERT INTO CHITIETHOADON VALUES ('S0002', 'HD0003', 240000, 2) ;
INSERT INTO CHITIETHOADON VALUES ('S0002', 'HD0004', 240000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0003', 'HD0005', 220000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0003', 'HD0006', 220000, 2) ;
INSERT INTO CHITIETHOADON VALUES ('S0004', 'HD0007', 98000, 1)  ;
INSERT INTO CHITIETHOADON VALUES ('S0005', 'HD0008', 222000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0005', 'HD0009', 160000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0006', 'HD0010', 50000, 1)  ;
INSERT INTO CHITIETHOADON VALUES ('S0008', 'HD0011', 450000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0008', 'HD0012', 420000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0008', 'HD0013', 110000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0008', 'HD0014', 270000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0009', 'HD0015', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0009', 'HD0016', 98000, 1)  ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0017', 212000, 1)  ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0018', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0019', 212000, 1)  ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0020', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0021', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0022', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0023', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0024', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0001','HD0025', 300000, 5)  ;
INSERT INTO CHITIETHOADON VALUES ('S0001', 'HD0026', 300000, 10);
INSERT INTO CHITIETHOADON VALUES ('S0002', 'HD0027', 240000, 2) ;
INSERT INTO CHITIETHOADON VALUES ('S0002', 'HD0028', 240000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0003', 'HD0029', 220000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0003', 'HD0030', 220000, 2) ;
INSERT INTO CHITIETHOADON VALUES ('S0004', 'HD0031', 98000, 1)  ;
INSERT INTO CHITIETHOADON VALUES ('S0005', 'HD0032', 222000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0005', 'HD0033', 160000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0006', 'HD0034', 50000, 1)  ;
INSERT INTO CHITIETHOADON VALUES ('S0008', 'HD0035', 450000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0008', 'HD0036', 420000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0008', 'HD0037', 110000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0008', 'HD0038', 270000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0009', 'HD0039', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0009', 'HD0040', 98000, 1)  ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0041', 212000, 1)  ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0042', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0043', 212000, 1)  ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0044', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0045', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0046', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0047', 212000, 1) ;
INSERT INTO CHITIETHOADON VALUES ('S0010', 'HD0048', 212000, 1) ;
COMMIT;



  -----BANG QUI DINH----------------------
INSERT INTO QUIDINH VALUES ('1',TO_DATE('01/01/2021','DD/MM/YYYY'), 300, 150, 200000, 20);





































