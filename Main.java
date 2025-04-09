import java.util.ArrayList;
import java.util.Scanner;

public class RandevuSistemi {

    static class Randevu {
        String hastaAdi;
        String doktorAdi;
        String tarih;
        String saat;

        public Randevu(String hastaAdi, String doktorAdi, String tarih, String saat) {
            this.hastaAdi = hastaAdi;
            this.doktorAdi = doktorAdi;
            this.tarih = tarih;
            this.saat = saat;
        }

        @Override
        public String toString() {
            return "Hasta: " + hastaAdi + ", Doktor: " + doktorAdi +
                    ", Tarih: " + tarih + ", Saat: " + saat;
        }
    }

    static ArrayList<Randevu> randevuListesi = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n*** Randevu Sistemi ***");
            System.out.println("1. Randevu Ekle");
            System.out.println("2. Randevu Listele");
            System.out.println("3. Randevu Sil");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch(secim) {
                case 1:
                    randevuEkle();
                    break;
                case 2:
                    randevuListele();
                    break;
                case 3:
                    randevuSil();
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    static void randevuEkle() {
        System.out.println("\n*** Yeni Randevu ***");

        System.out.print("Hasta Adı: ");
        String hastaAdi = scanner.nextLine();

        System.out.print("Doktor Adı: ");
        String doktorAdi = scanner.nextLine();

        System.out.print("Tarih (GG/AA/YYYY): ");
        String tarih = scanner.nextLine();

        System.out.print("Saat: ");
        String saat = scanner.nextLine();

        Randevu yeniRandevu = new Randevu(hastaAdi, doktorAdi, tarih, saat);
        randevuListesi.add(yeniRandevu);

        System.out.println("Randevu başarıyla eklendi!");
    }

    static void randevuListele() {
        System.out.println("\n*** Randevu Listesi ***");

        if(randevuListesi.isEmpty()) {
            System.out.println("Henüz randevu bulunmamaktadır.");
            return;
        }

        for(int i = 0; i < randevuListesi.size(); i++) {
            System.out.println((i+1) + ". " + randevuListesi.get(i));
        }
    }

    static void randevuSil() {
        randevuListele();

        if(randevuListesi.isEmpty()) {
            return;
        }

        System.out.print("\nSilmek istediğiniz randevu numarası: ");
        int silinecekNo = scanner.nextInt();
        scanner.nextLine(); // Buffer temizleme

        if(silinecekNo < 1 || silinecekNo > randevuListesi.size()) {
            System.out.println("Geçersiz randevu numarası!");
            return;
        }

        Randevu silinen = randevuListesi.remove(silinecekNo-1);
        System.out.println("Şu randevu silindi: " + silinen);
    }
}