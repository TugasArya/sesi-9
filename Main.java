import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DaftarBuku sistem = new DaftarBuku();
        int pilihan;

        // Add some initial data for testing
        sistem.tambahBuku("K001", "Dasar-Dasar Java", "Arya");
        sistem.tambahBuku("K002", "Struktur Data dengan C++", "Nurman");
        sistem.tambahBuku("K003", "Algoritma dan Pemrograman", "Rizal");

        do {
            System.out.println("\n=============================================");
            System.out.println("    MINI SISTEM DAFTAR BUKU PERPUSTAKAAN");
            System.out.println("=============================================");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku Berdasarkan Judul");
            System.out.println("3. Cari Buku Berdasarkan Judul");
            System.out.println("4. Update Data Buku");
            System.out.println("5. Tampilkan Semua Buku");
            System.out.println("6. Hitung Total Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi (0-6): ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                pilihan = -1; // Invalid input
            }

            switch (pilihan) {
                case 1: // Tambah Buku
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = scanner.nextLine();
                    System.out.print("Masukkan Judul Buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis Buku: ");
                    String penulis = scanner.nextLine();
                    sistem.tambahBuku(kode, judul, penulis);
                    break;

                case 2: // Hapus Buku
                    System.out.print("Masukkan Judul Buku yang akan dihapus: ");
                    String judulHapus = scanner.nextLine();
                    if (!sistem.hapusBuku(judulHapus)) {
                        System.out.println("Gagal menghapus. Buku dengan judul '" + judulHapus + "' tidak ditemukan.");
                    }
                    break;

                case 3: // Cari Buku
                    System.out.print("Masukkan Judul Buku yang dicari: ");
                    String judulCari = scanner.nextLine();
                    Buku bukuDitemukan = sistem.cariBuku(judulCari);
                    if (bukuDitemukan != null) {
                        System.out.println("\n** Buku Ditemukan **");
                        System.out.println("Kode: " + bukuDitemukan.getKode());
                        System.out.println("Judul: " + bukuDitemukan.getJudul());
                        System.out.println("Penulis: " + bukuDitemukan.getPenulis());
                    } else {
                        System.out.println("Buku dengan judul '" + judulCari + "' tidak ditemukan.");
                    }
                    break;

                case 4: // Update Buku
                    System.out.print("Masukkan Judul Buku LAMA yang akan diupdate: ");
                    String judulLama = scanner.nextLine();
                    if (sistem.cariBuku(judulLama) == null) {
                        System.out.println("Gagal update. Buku dengan judul '" + judulLama + "' tidak ditemukan.");
                        break;
                    }
                    System.out.println("\nMasukkan DATA BARU:");
                    System.out.print("Masukkan Kode Buku Baru: ");
                    String kodeBaru = scanner.nextLine();
                    System.out.print("Masukkan Judul Buku Baru: ");
                    String judulBaru = scanner.nextLine();
                    System.out.print("Masukkan Penulis Buku Baru: ");
                    String penulisBaru = scanner.nextLine();
                    sistem.updateBuku(judulLama, kodeBaru, judulBaru, penulisBaru);
                    break;

                case 5: // Tampilkan Semua
                    sistem.tampilkanSemuaBuku();
                    break;

                case 6: // Hitung Total
                    System.out.println("Total buku saat ini: " + sistem.hitungTotalBuku() + " buku.");
                    break;

                case 0: // Keluar
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
