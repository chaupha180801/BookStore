/*
QUANLY: select, update, insert, delete --> khuyenmai, baocaocongno, chitietcongno
        select --> all
NHANVIENBANHANG: select --> tacgia, theloai, khachhang, nxb, sach, khuyenmai, phieuthutien, hoadon, chitiethoadon
          update, insert --> khachhang, phieuthutien, hoadon, chitiethoadon
NHANVIENKHO: select, update, insert, delete --> tacgia, theloai, nxb, sach, phieunhapsach, baocaotonkho, baocaocongno
*/

CREATE ROLE bookstore_sale_staff_role;
CREATE ROLE bookstore_stock_staff_role;
CREATE ROLE bookstore_manager_role;

CREATE USER bookstore_sale_staff IDENTIFIED BY qlns;
CREATE USER bookstore_stock_staff IDENTIFIED BY qlns;
CREATE USER bookstore_manager IDENTIFIED BY qlns;

GRANT CREATE SESSION TO bookstore_sale_staff;
GRANT CREATE SESSION TO bookstore_stock_staff;
GRANT CREATE SESSION TO bookstore_manager;

GRANT EXECUTE ANY PROCEDURE TO bookstore_sale_staff;
GRANT EXECUTE ANY PROCEDURE TO bookstore_stock_staff;
GRANT EXECUTE ANY PROCEDURE TO bookstore_manager;

GRANT EXECUTE ON SYS.DBMS_LOCK to bookstore_sale_staff;
GRANT EXECUTE ON SYS.DBMS_LOCK to bookstore_stock_staff;
GRANT EXECUTE ON SYS.DBMS_LOCK to bookstore_manager;

/* GRANT PRIVILEGES TO bookstore_sale_staff */
GRANT SELECT, UPDATE, INSERT ON khachhang TO bookstore_sale_staff_role;
GRANT SELECT, UPDATE, INSERT ON phieuthutien TO bookstore_sale_staff_role;
GRANT SELECT, UPDATE, INSERT ON hoadon TO bookstore_sale_staff_role;
GRANT SELECT, UPDATE, INSERT ON chitiethoadon TO bookstore_sale_staff_role;
GRANT DELETE ON khachhang TO bookstore_sale_staff_role;
GRANT DELETE ON phieuthutien TO bookstore_sale_staff_role;
GRANT DELETE ON hoadon TO bookstore_sale_staff_role;
GRANT DELETE ON chitiethoadon TO bookstore_sale_staff_role;

GRANT SELECT ON tacgia TO bookstore_sale_staff_role;
GRANT SELECT ON theloai TO bookstore_sale_staff_role;
GRANT SELECT ON nhaxuatban TO bookstore_sale_staff_role;
GRANT SELECT ON sach TO bookstore_sale_staff_role;
GRANT SELECT ON khuyenmai TO bookstore_sale_staff_role;


GRANT bookstore_sale_staff_role TO bookstore_sale_staff;

/* GRANT PRIVILEGES TO bookstore_stock_staff */
GRANT SELECT, UPDATE, INSERT, DELETE ON tacgia TO bookstore_stock_staff_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON nhaxuatban TO bookstore_stock_staff_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON theloai TO bookstore_stock_staff_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON sach TO bookstore_stock_staff_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON phieunhapsach TO bookstore_stock_staff_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON chitietphieunhap TO bookstore_stock_staff_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON baocaocongno TO bookstore_stock_staff_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON chitietcongno TO bookstore_stock_staff_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON baocaotonkho TO bookstore_stock_staff_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON chitiettonkho TO bookstore_stock_staff_role;

GRANT SELECT ON khachhang TO bookstore_stock_staff_role;
GRANT SELECT ON phieuthutien TO bookstore_stock_staff_role;
GRANT SELECT ON hoadon TO bookstore_stock_staff_role;
GRANT SELECT ON khuyenmai TO bookstore_stock_staff_role;

GRANT bookstore_stock_staff_role TO bookstore_stock_staff;
/* GRANT PRIVILEGES TO bookstore_stock_admin */
GRANT SELECT, UPDATE, INSERT,DELETE ON khachhang TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT,DELETE ON phieuthutien TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON hoadon TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT,DELETE ON chitiethoadon TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON tacgia TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON nhaxuatban TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON theloai TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON sach TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON phieunhapsach TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON chitietphieunhap TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON baocaocongno TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON chitietcongno TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON baocaotonkho TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON chitiettonkho TO bookstore_manager_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON nhanvien TO bookstore_manager_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON khuyenmai TO bookstore_manager_role;

GRANT bookstore_manager_role TO bookstore_manager;
