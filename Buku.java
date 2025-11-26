public class Buku {
    private String kode;
    private String judul;
    private String penulis;

    // Constructor
    public Buku(String kode, String judul, String penulis) {
        this.kode = kode;
        this.judul = judul;
        this.penulis = penulis;
    }

    // Getters
    public String getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    // Setters (Needed for Update feature)
    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return String.format("| %-10s | %-30s | %-20s |", kode, judul, penulis);
    }
}
