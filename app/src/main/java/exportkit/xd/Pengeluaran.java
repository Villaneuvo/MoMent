package exportkit.xd;

public class Pengeluaran {
    private String nama_barang, keterangan, jenis, tanggal, nominal;
    int id;

    public Pengeluaran(){

    }

    public Pengeluaran(String nominal, String nama_barang, String keterangan, String jenis, String tanggal) {
        this.nama_barang = nama_barang;
        this.keterangan = keterangan;
        this.jenis = jenis;
        this.tanggal = tanggal;
        this.nominal = nominal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
}
