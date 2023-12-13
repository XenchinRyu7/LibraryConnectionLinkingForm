untuk koneksi database gunakan 
KoneksiDatabase koneksi = new KoneksiDatabase("jdbc:mysql://localhost:3306/namadatabase");

// untuk mendapatkan query login dari admin/user
String sql = "SELECT admin.nama_admin, admin.password_admin FROM admin";
String[] data = koneksi.querySql(sql);
// contoh pengecekan data !user.equals(data[0]) || !pass.equals(data[1]

// untuk menampilkan form
Object field[] = {"NIM", "NAMA", "JENIS KELAMIN", "PRODI", "KELAS", "ANGKATAN", "NO HANDPHONE", "NO KARTU MAHASISWA" ,"ALAMAT"};
String queryTable = "SELECT mhs.nim, mhs.nama, mhs.jk, mhs.prodi, mhs.kelas, mhs.angkatan, mhs.no_hp, mhs.kartu_mahasiswa, mhs.alamat FROM mhs";
DataMahasiswa formData = new DataMahasiswa("jdbc:mysql://localhost:3306/namadatabase", field, queryTable);
formData.setVisible(true);
