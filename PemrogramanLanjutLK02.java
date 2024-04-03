import java.util.Scanner;

class penumpang {
    private String nama;

    public penumpang(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
}

class Driver {
    public String no_sim;

    Driver() {
    }
}

class Kendaraan {
    public String merk;
    public String warna;
    public String platNomor;
    public int jumlahPenumpang;
    public int maxPenumpang;
    public Driver driver;

    

    public Kendaraan(String pn, String m, int max) {
        this.merk = m;
        this.platNomor = pn;
        this.jumlahPenumpang = 0;
        this.maxPenumpang = max;

        System.out.println("Kendaraan dengan plat nomor : " + this.platNomor);
        cekPenumpang();
    }

    public void cekPenumpang() {
        System.out.println("Penumpang saat ini: " + this.jumlahPenumpang);
    }

    public void penumpangNaik(int naik) {
        System.out.println("Ada penumpang yang ingin naik: " + naik);
        int current = this.jumlahPenumpang;
        if (current + naik > this.maxPenumpang) {
            System.out.println("Maaf, penumpang melebihi kapasitas.");
        } else {
            this.jumlahPenumpang += naik;
            System.out.println("Penumpang berhasil naik.");
        }
        cekPenumpang();
    }

    public void penumpangTurun(int turun) {
        System.out.println("Ada penumpang yang ingin turun: " + turun);
        int current = this.jumlahPenumpang;
        if (current - turun < 0) {
            System.out.println("Maaf, penumpang ghoib yang turun.");
        } else {
            this.jumlahPenumpang -= turun;
            System.out.println("Penumpang berhasil turun.");
        }
        cekPenumpang();
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void maju() {
        System.out.println(this.merk + " " + this.platNomor + " Maju");
    }

    public void mundur() {
        System.out.println(this.merk + " " + this.platNomor + " Mundur");
    }

    public void belok() {
        System.out.println(this.merk + " " + this.platNomor + " Belok");
    }

    public void berhenti() {
        System.out.println(this.merk + " " + this.platNomor + " Berhenti");
    }

    
    public void toiletDipakai() {
        System.out.println("Toilet dipakai.");
    }

    
    public void toiletKosong() {
        System.out.println("Toilet kosong.");
    }

    
    public void cekToilet() {
        System.out.println("Toilet dalam keadaan baik.");
    }
}

class Truk extends Kendaraan {
    int kapasitasMuatan;

    public Truk(String pn, String m, int max) {
        super(pn, m, max);
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitasMuatan = kapasitas;
    }

    public void muatBarang(int berat, int kapasitasMuatan) {
        System.out.println("Muatan yang ingin dinaikan: " + berat + " kg");
        if (berat <= kapasitasMuatan) {
            System.out.println("Barang berhasil dimuat ke dalam truk.");
        } else {
            System.out.println("Kapasitas muatan truk tidak mencukupi. Silahkan turunkan muatan terlebih dahulu");
        }
    }
}

public class PemrogramanLanjutLK02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;
        int pilihanBus = 0;
        Kendaraan b1 = new Kendaraan("L 1234 OO", "Toyota", 20); 

        while (pilihan != 4) {
            System.out.println("Menu:");
            System.out.println("1. Naik");
            System.out.println("2. Turun");
            System.out.println("3. Cek Penumpang");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu (masukkan angka): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Masukkan jumlah penumpang yang ingin naik:");
                    int naik = scanner.nextInt();
                    b1.penumpangNaik(naik);
                    break;
                case 2:
                    System.out.println("Masukkan jumlah penumpang yang ingin turun:");
                    int turun = scanner.nextInt();
                    b1.penumpangTurun(turun);
                    break;
                case 3:
                    b1.cekPenumpang();
                    break;
                case 4:
                    System.out.println("Terima kasih. Program berhenti.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
            }
        }

        while (pilihanBus != 4) {
            System.out.println("1. Gunakan Toilet");
            System.out.println("2. Keluar Toilet");
            System.out.println("3. Cek Toilet");
            System.out.println("4. Keluar menu");
            System.out.print("Pilih menu (masukkan angka): ");
            pilihanBus = scanner.nextInt();

            switch (pilihanBus) {
                case 1:
                    b1.toiletDipakai();
                    break;
                case 2:
                    System.out.println("Keluar dari toilet");
                    b1.toiletKosong();
                    break;
                case 3:
                    b1.cekToilet();
                    break;
                case 4:
                    System.out.println("Terima kasih. Lanjutannya");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
            }
        }

        scanner.close();
    }
}