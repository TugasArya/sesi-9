import java.util.LinkedList;

public class DaftarBuku {
    // Use LinkedList to store the Buku objects
    private LinkedList<Buku> daftar;

    public DaftarBuku() {
        this.daftar = new LinkedList<>();
    }

    // a. Menambah buku (Add Book)
    public void tambahBuku(String kode, String judul, String penulis) {
        Buku bukuBaru = new Buku(kode, judul, penulis);
        daftar.add(bukuBaru);
        System.out.println("Buku berhasil ditambahkan: " + judul);
    }

    // b. Menghapus buku tertentu (Delete Book by Title)
    public boolean hapusBuku(String judul) {
        // Use a simple loop for deletion based on a property
        for (Buku buku : daftar) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                daftar.remove(buku);
                System.out.println("🗑 Buku berhasil dihapus: " + judul);
                return true;
            }
        }
        return false;
    }

    // c. Mencari buku berdasarkan judul (Search Book by Title)
    public Buku cariBuku(String judul) {
        for (Buku buku : daftar) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                return buku; // Return the found object
            }
        }
        return null; // Book not found
    }

    // d. Meng-update data buku (Update Book Data)
    public boolean updateBuku(String judulLama, String kodeBaru, String judulBaru, String penulisBaru) {
        Buku buku = cariBuku(judulLama);
        if (buku != null) {
            buku.setKode(kodeBaru);
            buku.setJudul(judulBaru);
            buku.setPenulis(penulisBaru);
            System.out.println("Data buku '" + judulLama + "' berhasil diupdate.");
            return true;
        }
        return false;
    }

    // e. Menampilkan seluruh buku secara berurutan (Display All Books)
    public void tampilkanSemuaBuku() {
        System.out.println("\n--- DAFTAR SELURUH BUKU (" + hitungTotalBuku() + " buku) ---");
        System.out.println("+------------+--------------------------------+----------------------+");
        System.out.println("| *KODE* | *JUDUL* | *PENULIS* |");
        System.out.println("+------------+--------------------------------+----------------------+");
        if (daftar.isEmpty()) {
            System.out.println("|               *** DAFTAR BUKU KOSONG *** |");
        } else {
            // Since LinkedList is naturally ordered, iterating will display them sequentially
            for (Buku buku : daftar) {
                System.out.println(buku.toString());
            }
        }
        System.out.println("+------------+--------------------------------+----------------------+");
    }

    // f. Menghitung jumlah total buku (Count Total Books)
    public int hitungTotalBuku() {
        return daftar.size(); // LinkedList.size() gives the current number of elements
    }
}
