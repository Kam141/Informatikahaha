package SisUtama;

import java.util.Random;
import java.util.Scanner;

public class SisUtama2 {
    static Random token = new Random();
    static Scanner sc1 = new Scanner(System.in);
    static Scanner input1 = new Scanner(System.in);

    // Kebutuhan Sistem Bank
    static int saldo[] = { 500000, 300000, 400000 };
    static int login = 0;
    static int setor, tarik;
    static int randomToken = 0;
    static String rekTujuan = " ";
    static int trf = 0;
    static String kodeBank;
    static int pilihBank;
    
    // Kode untuk transfer % tagihan topup
    static String kodeTfBank[] = { "002", "009", "451", "008", "114", "601", "622" };
    static String kodeNohp[] = { "08" };
    static String[] kodeTopUp = { "09110", "70001", "39358", "89308", "89508" };
    static String[] noRekUser = { "121212121212", "232323232323", "343434343434" };
    static int [] digitBank = {15,10,10,13,10,10,16,12};
    // Tagihan Listrik
    static int kWH, daya, biaya, total = 0;
    static int admin = 2000;
    // Akun
    static String[][] userID = {
            { "Budi", "1122" },
            { "Siti", "2233" },
            { "Yudo", "3344" }
    };

    /**
     * @param args
     */
    public static void main(String[] args) {

        int transaksi = 01;
        System.out.println("=============================================");
        System.out.println("|   Pilih Bahasa yang ingin anda gunakan    |");
        System.out.println("|           (select a language)             |");
        System.out.println("|___________________________________________|");
        System.out.println("| 1. Indonesia                              |");
        System.out.println("| 2. Inggris                                |");
        System.out.println("|___________________________________________|");
        System.out.println();
        System.out.print(">>> Pilih :");
        int pilihBahasa = sc1.nextInt();

        if (pilihBahasa == 1) {

            int ulangAwal = 0;
            while (ulangAwal == 0) {
                System.out.println("======================================");
                System.out.println("|            SELAMAT DATANG          |");
                System.out.println("======================================");
                System.out.println("|\t1. Login                     |");
                System.out.println("|\t2. Daftar                    |");
                System.out.println("|\t3. Keluar                    |");
                System.out.println("|____________________________________|");
                System.out.println();
                System.out.print(">>> Pilih : ");
                char awal = sc1.next().charAt(0);

                if (awal == '1') {
                    login = -1;
                } else if (awal == '2') {
                    System.out.println("-----------------------------------------");
                    System.out.printf("| Masukkan Nama Anda : ");
                    String nama = input1.nextLine();
                    System.out.print("| Masukkan PIN       : ");
                    String pinDaftar = input1.nextLine();
                    System.out.println("-----------------------------------------");

                    String newUser[][] = new String[userID.length + 1][userID[0].length];
                    int newSaldo[] = new int[saldo.length + 1];
    
                    for (int i = 0; i < userID.length; i++) {
                        for (int j = 0; j < userID[i].length; j++) {
                            newUser[i][j] = userID[i][j];
                        }
                        newSaldo[i] = saldo[i];
                    }

                    newUser[userID.length][0] = nama;
                    newUser[userID.length][1] = pinDaftar;
    
                    userID = newUser;
                    saldo = newSaldo;

                    System.out.println("=====================================");
                    System.out.println("|     Pendaftaran Anda Berhasil     |");
                    System.out.println("=====================================");

                } else {
                    ulangAwal = 1;
                }

                int cobaLogin = 0;
                int cobaan = 0;

                // login
                while (login == -1) {
                    while (cobaLogin == 0) {
                        if (cobaan < 3) {

                            System.out.println();
                            System.out.println("---------------------------------------");
                            System.out.print("| Masukkan ID Pengguna  :  ");
                            String username = input1.nextLine();

                            System.out.print("| Masukkan PIN Pengguna : ");
                            String pin = input1.nextLine();
                            System.out.println("----------------------------------------");
                            System.out.println("\033[H\033[2J");

                            int indexBaris = -1;
                            int indexKolom = -1;

                            for (int i = 0; i < userID.length; i++) {
                                for (int j = 0; j < userID[i].length; j++) {
                                    if (userID[i][j].equals(username)) {
                                        indexBaris = i;
                                        indexKolom = j;
                                        break;
                                    }
                                }
                            }

                            if (indexBaris != -1 && indexKolom != -1) {
                                if (userID[indexBaris][indexKolom + 1].equals(pin)) {
                                    System.out.println();
                                    System.out.println("=======================================");
                                    System.out.println("|             Login Anda              |");
                                    System.out.println("|              Berhasil               |");
                                    System.out.println("=======================================");
                                    login = indexBaris;
                                } else {
                                    System.out.println();
                                    System.out.println("=====================================");
                                    System.out.println("|          Pin Anda Salah :(        |");
                                    System.out.println("=====================================");
                                    cobaan++;
                                }
                            } else {
                                    System.out.println();
                                    System.out.println("=====================================");
                                    System.out.println("|      Username Anda Salah :(       |");
                                    System.out.println("=====================================");
                                cobaan++;
                            }
                            // menu
                            if (login != -1) {
                                int ulangMenu = 2;
                                while (ulangMenu == 2) {

                                    System.out.println("");
                                    System.out.println("================================================");
                                    System.out.println("|                   Pilih menu                 |");
                                    System.out.println("================================================");
                                    System.out.println("|  1. Setor Tunai                              |");
                                    System.out.println("|  2. Tarik Tunai                              |");
                                    System.out.println("|  3. Transfer                                 |");
                                    System.out.println("|  4. Pembayaran Tagihan                       |");
                                    System.out.println("|  5. Cek Saldo                                |");
                                    System.out.println("|  6. Ubah PIN                                 |");
                                    System.out.println("|  7. Mutasi Rekening                          |");
                                    System.out.println("|  8. Logout                                   |");
                                    System.out.println("================================================");
                                    System.out.println();

                                    System.out.print(">>> Pilih : ");
                                    int pilih = sc1.nextInt();
                                    // setor tunai
                                    if (pilih == 1) {
                                        System.out.println("");
                                        tabelSapaan(username);
                                        System.out.print("| Masukkan Nominal Setor : ");
                                        int setor = sc1.nextInt();
                                        System.out.println("|______________________________________|");

                                        saldo[login] += setor;

                                        strukSetorTunai(username, saldo, setor);

                                        System.out.println("Apakah anda ingin lanjut? (y/n): ");
                                        char lanjut = sc1.next().charAt(0);
                                        if (lanjut != 'y') {
                                            ulangMenu = 1;
                                            ucapan(username);
                                        }
                                        // Tarik tunai
                                    } else if (pilih == 2) {
                                        System.out.println("");
                                        tabelSapaan(username);
                                        System.out.print("| Masukkan Nominal Tarik : ");
                                        int tarik = sc1.nextInt();
                                        System.out.println("|______________________________________|");

                                        if (saldo[login] > tarik) {
                                            saldo[login] -= tarik;

                                            strukTarikTunai(username, saldo, tarik);

                                        } else {
                                            System.out.println("Saldo Tidak Mencukupi");
                                        }
                                        // struk

                                        System.out.println("Apakah anda ingin lanjut? (y/n): ");
                                        char lanjut = sc1.next().charAt(0);
                                        if (lanjut != 'y') {
                                            ulangMenu = 1;
                                            ucapan(username);
                                        }
                                        // transfer
                                    } else if (pilih == 3) {

                                        System.out.println("");
                                        System.out.println("==========================================");
                                        System.out.println("|               Transfer                 |");
                                        System.out.println("==========================================");
                                        System.out.println("|        Pilih Bank Tujuan Anda          |");
                                        System.out.println("|________________________________________|");
                                        System.out.println("|  1. Bank BRI     (002)                 |");
                                        System.out.println("|  2. Bank BNI     (009)                 |");
                                        System.out.println("|  3. Bank BSI     (451)                 |");
                                        System.out.println("|  4. Bank Mandiri (008)                 |");
                                        System.out.println("|  5. Bank Jatim   (114)                 |");
                                        System.out.println("|  6. Bank BCA     (601)                 |");
                                        System.out.println("|  7. Bank BTN     (622)                 |");
                                        System.out.println("|  8. Transfer Antar Pengguna            |");
                                        System.out.println("==========================================");

                                        System.out.print(">>> Pilih : ");
                                        pilihBank = sc1.nextInt();

                                        if (pilihBank == 1) {
                                            int noBank = -2;
                                            while (noBank == -2) {
                                                System.out.println("");
                                                System.out.println("=============================================================");
                                                System.out.println("|                            Bank BRI                       |");
                                                System.out.println("=============================================================");
                                                System.out.println("|              Gunakan Kode Bank Di 3 Angka Awal            |");
                                                System.out.println("|___________________________________________________________|");
                                                System.out.print("| Masukkan Nomor Rekening Tujuan (15 Digit) : ");
                                                rekTujuan = input1.nextLine();
                                                System.out.println("|___________________________________________________________|");

                                                bank(kodeBank, pilihBank, noBank, trf, digitBank);

                                            }
                                            perulnaganDanUcapan(ulangMenu, username, noBank);

                                        } else if (pilihBank == 2) {
                                            int noBank = -2;
                                            while (noBank == -2) {
                                                System.out.println("");
                                                System.out.println("=============================================================");
                                                System.out.println("|                            Bank BNI                       |");
                                                System.out.println("=============================================================");
                                                System.out.println("|              Gunakan Kode Bank Di 3 Angka Awal            |");
                                                System.out.println("|___________________________________________________________|");
                                                System.out.print("| Masukkan Nomor Rekening Tujuan (10 Digit) : ");
                                                rekTujuan = input1.nextLine();
                                                System.out.println("|___________________________________________________________|");

                                                bank(kodeBank, pilihBank, noBank, trf, digitBank);
                                            }

                                            perulnaganDanUcapan(ulangMenu, username,noBank);

                                        } else if (pilihBank == 3) {
                                            int noBank = -2;
                                            while (noBank == -2) {
                                                System.out.println("");
                                                System.out.println("=============================================================");
                                                System.out.println("|                            Bank BSI                       |");
                                                System.out.println("=============================================================");
                                                System.out.println("|              Gunakan Kode Bank Di 3 Angka Awal            |");
                                                System.out.println("|___________________________________________________________|");
                                                System.out.print("| Masukkan Nomor Rekening Tujuan (10 Digit) : ");
                                                rekTujuan = input1.nextLine();
                                                System.out.println("|___________________________________________________________|");

                                                bank(kodeBank, pilihBank, noBank, trf, digitBank);
                                            }

                                           perulnaganDanUcapan(ulangMenu, username, noBank);


                                        } else if (pilihBank == 4) {
                                            int noBank = -2;
                                            while (noBank == -2) {
                                                System.out.println("");
                                                System.out.println("=============================================================");
                                                System.out.println("|                          Bank Mandiri                     |");
                                                System.out.println("=============================================================");
                                                System.out.println("|              Gunakan Kode Bank Di 3 Angka Awal            |");
                                                System.out.println("|___________________________________________________________|");
                                                System.out.print("| Masukkan Nomor Rekening Tujuan (13 Digit) : ");
                                                rekTujuan = input1.nextLine();
                                                System.out.println("|___________________________________________________________|");

                                                bank(kodeBank, pilihBank, noBank, trf, digitBank);
                                            }

                                           perulnaganDanUcapan(ulangMenu, username, noBank);

                                        } else if (pilihBank == 5) {
                                            int noBank = -2;
                                            while (noBank == -2) {
                                                System.out.println("");
                                                System.out.println("=============================================================");
                                                System.out.println("|                        Bank Bank Jatim                    |");
                                                System.out.println("=============================================================");
                                                System.out.println("|              Gunakan Kode Bank Di 3 Angka Awal            |");
                                                System.out.println("|___________________________________________________________|");
                                                System.out.print("| Masukkan Nomor Rekening Tujuan (10 Digit) : ");
                                                rekTujuan = input1.nextLine();
                                                System.out.println("|___________________________________________________________|");

                                                bank(kodeBank, pilihBank, noBank, trf, digitBank);
                                            }

                                            perulnaganDanUcapan(ulangMenu, username, noBank);

                                        } else if (pilihBank == 6) {
                                            int noBank = -2;
                                            while (noBank == -2) {
                                                    System.out.println("");
                                                System.out.println("=============================================================");
                                                System.out.println("|                            Bank BCA                       |");
                                                System.out.println("=============================================================");
                                                System.out.println("|              Gunakan Kode Bank Di 3 Angka Awal            |");
                                                System.out.println("|___________________________________________________________|");
                                                System.out.print("| Masukkan Nomor Rekening Tujuan (10 Digit) : ");
                                                rekTujuan = input1.nextLine();
                                                System.out.println("|___________________________________________________________|");

                                                bank(kodeBank, pilihBank, noBank, trf, digitBank);
                                            }
                                            perulnaganDanUcapan(ulangMenu, username, noBank);

                                        } else if (pilihBank == 7) {
                                            int noBank = -2;
                                            while (noBank == -2) {
                                                System.out.println("");
                                                System.out.println("=============================================================");
                                                System.out.println("|                            Bank BTN                       |");
                                                System.out.println("=============================================================");
                                                System.out.println("|              Gunakan Kode Bank Di 3 Angka Awal            |");
                                                System.out.println("|___________________________________________________________|");
                                                System.out.print("| Masukkan Nomor Rekening Tujuan (16 Digit) : ");
                                                rekTujuan = input1.nextLine();
                                                System.out.println("|___________________________________________________________|");

                                                bank(pin, pilihBahasa, noBank, transaksi, digitBank);
                                            }
                                           perulnaganDanUcapan(ulangMenu, username, noBank);

                                        } else if (pilihBank == 8) {
                                            int noBank = -2;
                                            while (noBank == -2) {
                                                System.out.println("");
                                                System.out.println("=============================================================");
                                                System.out.println("|                        Sesama Rekening                    |");
                                                System.out.println("=============================================================");
                                                System.out.print("| Masukkan Nomor Rekening Tujuan (12 Digit) : ");
                                                rekTujuan = input1.nextLine();
                                                System.out.println("|___________________________________________________________|");

                                                bank(kodeBank, pilihBank, noBank, trf, digitBank);
                                            }
                                            perulnaganDanUcapan(ulangMenu, username, noBank);
                                        }
                                        // pembayaran tagihan
                                    } else if (pilih == 4) {
                                        System.out.println("\tPembayaran Tagihan");
                                        System.out.println("1. Pembayaran Listrik");
                                        System.out.println("2. Pembayaran PDAM");
                                        System.out.println("3. Pembelian Pulsa");
                                        System.out.println("4. Top up");
                                        System.out.println();

                                        System.out.print("Pilih Pembayaran : ");
                                        char pilihTagihan = sc1.next().charAt(0);

                                        // pembayaran listrik
                                        if (pilihTagihan == '1') {

                                            // Random untuk token

                                            System.out.print("Masukkan NO Meter (11 Nomor) : ");
                                            String cekNomor = input1.next();

                                            int tandaLstrk = -3;
                                            while (tandaLstrk == -3) {

                                                if (cekNomor.length() == 11) {
                                                    System.out.println("No Meter Valid");
                                                    tandaLstrk = 3;
                                                } else {
                                                    System.out.println("No Meter Tidak Valid");
                                                }
                                            }

                                            System.out.print("Masukkan Daya Listrik Rumah Anda (450/900/1300/2500) : ");
                                            daya = sc1.nextInt();

                                            System.out.print("Masukkan Nominal Pembelian       : ");
                                            biaya = sc1.nextInt();

                                            if (saldo[login] > biaya) {
                                                total = biaya + admin;
                                                saldo[login] -= total;

                                                if (daya == 900) {
                                                    kWH = biaya / 1352;

                                                    tagihanListrik(cekNomor, username, randomToken);

                                                } else if (daya == 1300) {
                                                    kWH = biaya / 1444;

                                                    tagihanListrik(cekNomor, username, randomToken);

                                                } else if (daya == 450) {
                                                    kWH = biaya / 1250;

                                                    tagihanListrik(cekNomor, username, randomToken);

                                                } else if (daya == 2500) {
                                                    kWH = biaya / 2200;

                                                    tagihanListrik(cekNomor, username, randomToken);

                                                } else {
                                                    System.out.println("Layanan Tidak Tersedia");
                                                }

                                                System.out.println("");
                                                System.out.println("Sisa Saldo   : " + saldo[login]);
                                                System.out.println("");
                                            } else {
                                                System.out.println("Saldo Tidak Mencukup");
                                            }

                                            System.out.println("Apakah Anda Ingin Lanjut? (y/n) : ");
                                            char hentiTagih = sc1.next().charAt(0);

                                            if (hentiTagih != 'y') {
                                                ulangMenu = 1;
                                                ulangAwal = 1;
                                                login = 1;
                                                System.out.println("Terima Kasih");

                                                // Pembayaran PDAM
                                            }
                                        } else if (pilihTagihan == '2') {

                                            System.out.println("Maaf Masih Fitur Masih Dalam Perbaikan");

                                        } else if (pilihTagihan == '3') {

                                            System.out.println("Pastikan Nomor Sesuai Dengan Kode Operator");
                                            System.out.print("Masukkan Nomor Telefon Anda : ");
                                            String noTelf = input1.nextLine();

                                            String kodeOperator = noTelf.substring(0, 3);
                                            noTelf = noTelf.substring(3);

                                            int beliPulsa;
                                            int totalPulsa = 0;
                                            String namaOperator;
                                            int ulangPulsa = 0;
                                            while (ulangPulsa == 0) {
                                                if (kodeOperator.equals("081")) {
                                                    namaOperator = "TELKOMSEL";
                                                    System.out.print("Masukkan Nominal Pembelian : ");
                                                    beliPulsa = sc1.nextInt();

                                                    if (saldo[login] > beliPulsa) {
                                                        totalPulsa = beliPulsa + 2000;
                                                        saldo[login] -= totalPulsa;
                                                        System.out
                                                                .println("Nominal Yang Harus Dibayar : " + totalPulsa);
                                                        System.out.println(
                                                                "Pembelian Pulsa " + namaOperator + " Sejumlah "
                                                                        + beliPulsa + " Berhasil");
                                                        System.out.println("Sisa saldo : " + saldo[login]);
                                                        System.out.println("");
                                                    } else {
                                                        System.out.println("Saldo Tidak Mencukupi");
                                                    }
                                                    System.out.print("Apakah Anda Ingin Lanjut? (y/n): ");
                                                    char hentiPulsa = sc1.next().charAt(0);
                                                    if (hentiPulsa != 'y') {
                                                        ulangPulsa = 1;
                                                        ulangMenu = 1;
                                                        ulangAwal = 1;
                                                        login = 1;
                                                        System.out.println("Terima Kasih");
                                                    }
                                                    ulangPulsa = 1;

                                                } else if (kodeOperator.equals("082")) {
                                                    namaOperator = "INDOSAT OOREDOO";
                                                    System.out.print("Masukkan Nominal Pembelian : ");
                                                    beliPulsa = sc1.nextInt();

                                                    if (saldo[login] > beliPulsa) {
                                                        totalPulsa = beliPulsa + 2000;
                                                        saldo[login] -= totalPulsa;
                                                        System.out
                                                                .println("Nominal Yang Harus Dibayar : " + totalPulsa);
                                                        System.out.println(
                                                                "Pembelian Pulsa " + namaOperator + " Sejumlah "
                                                                        + beliPulsa + " Berhasil");
                                                        System.out.println("Sisa saldo : " + saldo[login]);
                                                        System.out.println("");
                                                    } else {
                                                        System.out.println("Saldo Tidak Mencukupi");
                                                    }
                                                    System.out.print("Apakah Anda Ingin Lanjut? (y/n): ");
                                                    char hentiPulsa = sc1.next().charAt(0);
                                                    if (hentiPulsa != 'y') {
                                                        ulangPulsa = 1;
                                                        ulangMenu = 1;
                                                        ulangAwal = 1;
                                                        login = 1;
                                                        System.out.println("Terima Kasih");
                                                    }
                                                    ulangPulsa = 1;
                                                } else if (kodeOperator.equals("083")) {
                                                    namaOperator = "TRI(3)";
                                                    System.out.print("Masukkan Nominal Pembelian : ");
                                                    beliPulsa = sc1.nextInt();

                                                    if (saldo[login] > beliPulsa) {
                                                        totalPulsa = beliPulsa + 2000;
                                                        saldo[login] -= totalPulsa;
                                                        System.out
                                                                .println("Nominal Yang Harus Dibayar : " + totalPulsa);
                                                        System.out.println(
                                                                "Pembelian Pulsa " + namaOperator + " Sejumlah "
                                                                        + beliPulsa + " Berhasil");
                                                        System.out.println("Sisa saldo : " + saldo[login]);
                                                        System.out.println("");
                                                    } else {
                                                        System.out.println("Saldo Tidak Mencukupi");
                                                    }
                                                    System.out.print("Apakah Anda Ingin Lanjut? (y/n): ");
                                                    char hentiPulsa = sc1.next().charAt(0);
                                                    if (hentiPulsa != 'y') {
                                                        ulangPulsa = 1;
                                                        ulangMenu = 1;
                                                        ulangAwal = 1;
                                                        login = 1;
                                                        System.out.println("Terima Kasih");
                                                    }
                                                    ulangPulsa = 1;
                                                } else if (kodeOperator.equals("084")) {
                                                    namaOperator = "XL AXIATA";
                                                    System.out.print("Masukkan Nominal Pembelian : ");
                                                    beliPulsa = sc1.nextInt();

                                                    if (saldo[login] > beliPulsa) {
                                                        totalPulsa = beliPulsa + 2000;
                                                        saldo[login] -= totalPulsa;
                                                        System.out
                                                                .println("Nominal Yang Harus Dibayar : " + totalPulsa);
                                                        System.out.println("Pembelian Pulsa " + namaOperator
                                                                + " Sejumlah " + beliPulsa + " Berhasil");
                                                        System.out.println("Sisa saldo : " + saldo[login]);
                                                        System.out.println("");
                                                    } else {
                                                        System.out.println("Saldo Tidak Mencukupi");
                                                    }
                                                    System.out.print("Apakah Anda Ingin Lanjut? (y/n): ");
                                                    char hentiPulsa = sc1.next().charAt(0);
                                                    if (hentiPulsa != 'y') {
                                                        ulangPulsa = 1;
                                                        ulangMenu = 1;
                                                        System.out.println("Terima Kasih");
                                                    }
                                                    ulangPulsa = 1;
                                                } else if (kodeOperator.equals("085")) {
                                                    namaOperator = "SMARTFREN";
                                                    System.out.print("Masukkan Nominal Pembelian : ");
                                                    beliPulsa = sc1.nextInt();

                                                    if (saldo[total] > beliPulsa) {
                                                        totalPulsa = beliPulsa + 2000;
                                                        saldo[login] -= totalPulsa;
                                                        System.out
                                                                .println("Nominal Yang Harus Dibayar : " + totalPulsa);
                                                        System.out.println(
                                                                "Pembelian Pulsa " + namaOperator + " Sejumlah "
                                                                        + beliPulsa + " Berhasil");
                                                        System.out.println("Sisa saldo : " + saldo[login]);
                                                        System.out.println("");
                                                    } else {
                                                        System.out.println("Saldo Tidak Mencukupi");
                                                    }
                                                    System.out.print("Apakah Anda Ingin Lanjut? (y/n): ");
                                                    char hentiPulsa = sc1.next().charAt(0);
                                                    if (hentiPulsa != 'y') {
                                                        ulangPulsa = 1;
                                                        ulangMenu = 1;
                                                        System.out.println("Terima Kasih");
                                                    }
                                                    ulangPulsa = 1;
                                                } else {
                                                    System.out.println("Maaf Kode Operator Tidak Tersedia");
                                                    break;
                                                }
                                            }

                                        } else if (pilihTagihan == '4') {

                                            System.out.println();
                                            System.out.println("==================================");
                                            System.out.println("       PILIH MENU TOP UP          ");
                                            System.out.println("==================================");
                                            System.out.println("| 1. Link aja                     |");
                                            System.out.println("| 2. GoPay                        |");
                                            System.out.println("| 3. OVO                          |");
                                            System.out.println("| 4. Shoppe pay                   |");
                                            System.out.println("| 5. Dana                         |");
                                            System.out.println("==================================");
                                            System.out.print("Pilih TOP UP yang ingin anda lakukan: ");
                                            char topUp = sc1.next().charAt(0);
                                            int biayaTopup;

                                            if (topUp == '1') {
                                                int ulangTopUp = -4;
                                                while (ulangTopUp == -4) {

                                                    System.out.println("\tTop Up LinkAja");
                                                    System.out.print("Masukkan Kode Perusahaan LinkAja : ");
                                                    String perusahaan = input1.nextLine();
                                                    System.out.print(
                                                            "Masukkan No Hp Yang Terdaftar di LinkAja (12 Digit) : ");
                                                    String noTopup = input1.nextLine();

                                                    if (perusahaan.equals(kodeTopUp[0])) {
                                                        if (noTopup.length() == 12) {

                                                            String kodeHp = noTopup.substring(0, 2);

                                                            boolean noValid = false;
                                                            for (int i = 0; i < kodeNohp.length; i++) {
                                                                if (kodeHp.equals(kodeNohp[0])) {
                                                                    noValid = true;
                                                                    break;
                                                                }
                                                            }
                                                            if (noValid) {
                                                                System.out.println("Nomor Valid");
                                                                ulangTopUp = 4;
                                                            } else {
                                                                System.out.println("Kode Nomor Tidak Valid");
                                                            }
                                                        } else {
                                                            System.out.println("Nomor Tidak Valid");
                                                        }
                                                    } else {
                                                        System.out.println("Kode Perusahaan Salah");
                                                    }
                                                }

                                                System.out.print("Masukkan Nominal Top Up : ");
                                                biayaTopup = sc1.nextInt();

                                                if (saldo[login] > biayaTopup) {
                                                    saldo[login] -= biayaTopup;
                                                    System.out.println("Nominal Top Up " + biayaTopup
                                                            + " Berhasil Terkirim Ke Akun Anda");
                                                    System.out.println("Sisa saldo \t : " + saldo[login]);
                                                } else {
                                                    System.out.println("Saldo Tidak Mencukupi");
                                                }

                                                System.out.println("Apakah Anda Ingin lanjut? (y/n)");
                                                char hentiTopUp = sc1.next().charAt(0);
                                                if (hentiTopUp != 'y') {
                                                    ulangMenu = 1;
                                                    System.out.println("Terima Kasih");
                                                }

                                            } else if (topUp == '2') {
                                                int ulangTopUp = -4;
                                                while (ulangTopUp == -4) {

                                                    System.out.println("\tTop Up GoPay");
                                                    System.out.print("Masukkan Kode Perusahaan GoPay : ");
                                                    String perusahaan = input1.nextLine();
                                                    System.out.print(
                                                            "Masukkan No Hp Yang Terdaftar di LinkAja (12 Digit) : ");
                                                    String noTopup = input1.nextLine();

                                                    if (perusahaan.equals(kodeTopUp[1])) {
                                                        if (noTopup.length() == 12) {

                                                            String kodeHp = noTopup.substring(0, 2);

                                                            boolean noValid = false;
                                                            for (int i = 0; i < kodeNohp.length; i++) {
                                                                if (kodeHp.equals(kodeNohp[0])) {
                                                                    noValid = true;
                                                                    break;
                                                                }
                                                            }
                                                            if (noValid) {
                                                                System.out.println("Nomor Valid");
                                                                ulangTopUp = 4;
                                                            } else {
                                                                System.out.println("Kode Nomor Tidak Valid");
                                                            }
                                                        } else {
                                                            System.out.println("Nomor Tidak Valid");
                                                        }
                                                    } else {
                                                        System.out.println("Kode Perusahaan Salah");
                                                    }
                                                }

                                                System.out.print("Masukkan Nominal Top Up : ");
                                                biayaTopup = sc1.nextInt();

                                                if (saldo[login] > biayaTopup) {
                                                    saldo[login] -= biayaTopup;
                                                    System.out.println("Nominal Top Up " + biayaTopup
                                                            + " Berhasil Terkirim Ke Akun Anda");
                                                    System.out.println("Sisa saldo \t : " + saldo[login]);
                                                } else {
                                                    System.out.println("Saldo Tidak Mencukupi");
                                                }
                                                System.out.println("Apakah Anda Ingin lanjut? (y/n)");
                                                char hentiTopUp = sc1.next().charAt(0);
                                                if (hentiTopUp != 'y') {
                                                    ulangMenu = 1;
                                                    System.out.println("Terima Kasih");
                                                }

                                            } else if (topUp == '3') {
                                                int ulangTopUp = -4;
                                                while (ulangTopUp == -4) {

                                                    System.out.println("\tTop Up OVO");
                                                    System.out.print("Masukkan Kode Perusahaan OVO : ");
                                                    String perusahaan = input1.nextLine();
                                                    System.out.print(
                                                            "Masukkan No Hp Yang Terdaftar di LinkAja (12 Digit) : ");
                                                    String noTopup = input1.nextLine();

                                                    if (perusahaan.equals(kodeTopUp[2])) {
                                                        if (noTopup.length() == 12) {

                                                            String kodeHp = noTopup.substring(0, 2);

                                                            boolean noValid = false;
                                                            for (int i = 0; i < kodeNohp.length; i++) {
                                                                if (kodeHp.equals(kodeNohp[0])) {
                                                                    noValid = true;
                                                                    break;
                                                                }
                                                            }
                                                            if (noValid) {
                                                                System.out.println("Nomor Valid");
                                                                ulangTopUp = 4;
                                                            } else {
                                                                System.out.println("Kode Nomor Tidak Valid");
                                                            }
                                                        } else {
                                                            System.out.println("Nomor Tidak Valid");
                                                        }
                                                    } else {
                                                        System.out.println("Kode Perusahaan Salah");
                                                    }
                                                }

                                                System.out.print("Masukkan Nominal Top Up : ");
                                                biayaTopup = sc1.nextInt();

                                                if (saldo[login] > biayaTopup) {
                                                    saldo[login] -= biayaTopup;
                                                    System.out.println(
                                                            "Nominal Top Up " + biayaTopup
                                                                    + " Berhasil Terkirim Ke Akun Anda");
                                                    System.out.println("Sisa saldo \t : " + saldo[login]);
                                                } else {
                                                    System.out.println("Saldo Tidak Mencukupi");
                                                }

                                                System.out.println("Apakah Anda Ingin lanjut? (y/n)");
                                                char hentiTopUp = sc1.next().charAt(0);
                                                if (hentiTopUp != 'y') {
                                                    ulangMenu = 1;
                                                    System.out.println("Terima Kasih");
                                                }

                                            } else if (topUp == '4') {
                                                int ulangTopUp = -4;
                                                while (ulangTopUp == -4) {

                                                    System.out.println("\tTop Up ShopeePay");
                                                    System.out.print("Masukkan Kode Perusahaan ShopeePay : ");
                                                    String perusahaan = input1.nextLine();
                                                    System.out.print(
                                                            "Masukkan No Hp Yang Terdaftar di LinkAja (12 Digit) : ");
                                                    String noTopup = input1.nextLine();

                                                    if (perusahaan.equals(kodeTopUp[3])) {
                                                        if (noTopup.length() == 12) {

                                                            String kodeHp = noTopup.substring(0, 2);

                                                            boolean noValid = false;
                                                            for (int i = 0; i < kodeNohp.length; i++) {
                                                                if (kodeHp.equals(kodeNohp[0])) {
                                                                    noValid = true;
                                                                    break;
                                                                }
                                                            }
                                                            if (noValid) {
                                                                System.out.println("Nomor Valid");
                                                                ulangTopUp = 4;
                                                            } else {
                                                                System.out.println("Kode Nomor Tidak Valid");
                                                            }
                                                        } else {
                                                            System.out.println("Nomor Tidak Valid");
                                                        }
                                                    } else {
                                                        System.out.println("Kode Perusahaan Salah");
                                                    }
                                                }

                                                System.out.print("Masukkan Nominal Top Up : ");
                                                biayaTopup = sc1.nextInt();

                                                if (saldo[login] > biayaTopup) {
                                                    saldo[login] -= biayaTopup;
                                                    System.out.println(
                                                            "Nominal Top Up " + biayaTopup
                                                                    + " Berhasil Terkirim Ke Akun Anda");
                                                    System.out.println("Sisa saldo \t : " + saldo[login]);
                                                } else {
                                                    System.out.println("Saldo Tidak Mencukupi");
                                                }

                                                System.out.println("Apakah Anda Ingin lanjut? (y/n)");
                                                char hentiTopUp = sc1.next().charAt(0);
                                                if (hentiTopUp != 'y') {
                                                    ulangMenu = 1;
                                                    System.out.println("Terima Kasih");
                                                }

                                            } else if (topUp == '5') {
                                                int ulangTopUp = -4;
                                                while (ulangTopUp == -4) {

                                                    System.out.println("\tTop Up Dana");
                                                    System.out.print("Masukkan Kode Perusahaan Dana : ");
                                                    String perusahaan = input1.nextLine();
                                                    System.out.print(
                                                            "Masukkan No Hp Yang Terdaftar di LinkAja (12 Digit) : ");
                                                    String noTopup = input1.nextLine();

                                                    if (perusahaan.equals(kodeTopUp[4])) {
                                                        if (noTopup.length() == 12) {

                                                            String kodeHp = noTopup.substring(0, 2);

                                                            boolean noValid = false;
                                                            for (int i = 0; i < kodeNohp.length; i++) {
                                                                if (kodeHp.equals(kodeNohp[0])) {
                                                                    noValid = true;
                                                                    break;
                                                                }
                                                            }
                                                            if (noValid) {
                                                                System.out.println("Nomor Valid");
                                                                ulangTopUp = 4;
                                                            } else {
                                                                System.out.println("Kode Nomor Tidak Valid");
                                                            }
                                                        } else {
                                                            System.out.println("Nomor Tidak Valid");
                                                        }
                                                    } else {
                                                        System.out.println("Kode Perusahaan Salah");
                                                    }
                                                }

                                                System.out.print("Masukkan Nominal Top Up : ");
                                                biayaTopup = sc1.nextInt();

                                                if (saldo[login] > biayaTopup) {
                                                    saldo[login] -= biayaTopup;
                                                    System.out.println(
                                                            "Nominal Top Up " + biayaTopup
                                                                    + " Berhasil Terkirim Ke Akun Anda");
                                                    System.out.println("Sisa saldo \t : " + saldo[login]);
                                                } else {
                                                    System.out.println("Saldo Tidak Mencukupi");
                                                }

                                                System.out.println("Apakah Anda Ingin lanjut? (y/n)");
                                                char hentiTopUp = sc1.next().charAt(0);
                                                if (hentiTopUp != 'y') {
                                                    ulangMenu = 1;
                                                    System.out.println("Terima Kasih");
                                                }

                                            }
                                        }
                                    } else if (pilih == 5) {
                                        System.out.println(" Saldo anda sekarang adalah: " + saldo[login]);
                                        System.out.print("Apakah Anda Ingin Lanjut? (y/n): ");
                                        char hentiSaldo = sc1.next().charAt(0);
                                        if (hentiSaldo != 'y') {
                                            ulangMenu = 1;
                                            System.out.println("Terima Kasih");
                                        }

                                    } else if (pilih == 6) {
                                        System.out.print("Masukkan PIN Lama : ");
                                        String pinLama = input1.nextLine();

                                        if (pinLama.equals(userID[indexBaris][indexKolom + 1])) {
                                            System.out.print("Masukkan PIN Baru : ");
                                            String pinBaru = input1.nextLine();

                                            userID[indexBaris][indexKolom + 1] = pinBaru;
                                            System.out.println("PIN Berhasil Diubah");
                                        } else {
                                            System.out.println("PIN Lama Salah");
                                        }

                                        System.out.print("Apakah Anda Ingin Lanjut? (y/n): ");
                                        char hentiPin = sc1.next().charAt(0);
                                        if (hentiPin != 'y') {
                                            ulangMenu = 1;
                                            System.out.println("Terima Kasih");
                                        }

                                    } else if (pilih == 7) {
                                        System.out.println("bb");
                                        strukSetorTunai(username, saldo, setor);
                                        strukTarikTunai(username, saldo, tarik);

                                    } else {

                                        System.out.println("\t^^^ Terima Kasih Sudah Menggunakan Layanan Kami ^^^");
                                        ulangMenu = 1;
                                        ulangAwal = 0;
                                        login = 1;
                                        cobaLogin = 1;

                                    }
                                }

                            }
                        } else {
                            System.out.println("Anda Sudah Melebihi Batas Percobaan Login Silahkan Coba Lagi Nanti");
                            login = 1;
                            ulangAwal = 1;
                            break;
                        }
                    }
                }
            }
        } else if (pilihBahasa == 2) {

        } else {
            System.out.println("=======================+++=====================");
            System.out.println("|   Bahasa yang anda pilih tidak disediakan   |");
            System.out.println("| (The language you selected is not provided) |");
            System.out.println("=======================+++=====================");
            System.out.println("|  Apakah anda ingin melanjutkan transaksi?   |");
            System.out.println("|  Do you want to continue the transaction?   |");
            System.out.println("|          masukkan/insert (y/n)              |");
            System.out.println("===============================================");
            int lanjutTransaksi = sc1.nextInt();
            if (lanjutTransaksi == 1) {
                transaksi = 01;
            } else {
                System.out.println("+==========================================+");
                System.out.println("|               TERIMAKASIH                |");
                System.out.println("|                 THANKYOU                 |");
                System.out.println("+==========================================+");
            }
        }
    }

    public static void strukSetorTunai(String username, int saldo[], int setor) {
        System.out.println("");
        System.out.println("\tStruk Setoran");
        System.out.println("Nama\t\t : " + username);
        System.out.println("Setoran\t\t : " + setor);
        System.out.println("Jumlah saldo\t : " + saldo[login]);
        System.out.println("");
    }

    public static void strukTarikTunai(String username, int saldo[], int tarik) {
        System.out.println("");
        System.out.println("\tStruk Penarikan");
        System.out.println("Nama\t\t : " + username);
        System.out.println("Penarikan\t : " + tarik);
        System.out.println("Sisa saldo\t : " + saldo[login]);
        System.out.println("");
    }

    public static void tagihanListrik(String cekNomor, String username, int randomToken) {
        System.out.println("NO Meter     : " + cekNomor);
        System.out.println("Nama         : " + username);
        System.out.println("Daya         : " + daya);
        System.out.println("KWH          : " + kWH);
        System.out.println("Nominal      : " + biaya);
        System.out.println("Biaya Admin  : " + admin);
        System.out.println("Total Bayar  : " + total);
        System.out.print("Token        : ");

        for (int i = 0; i < 20; i++) {
            randomToken = token.nextInt(10);
            System.out.print(randomToken);

            if ((i + 1) % 4 == 0) {
                System.out.print(" ");
            }
        }
    }

    public static void strukTransfer(String rekTujuan2, int trf, int saldo[]) {
        System.out.println();
        System.out.println("             STRUK TRANSFER            ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("| Nomer Rekening   : %-22s |", rekTujuan2 );
        System.out.printf("\n| Nominal Transfer : %-22d |", trf);
        System.out.printf("\n| Sisa saldo anda  : %-22d |", saldo[login]);
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++");
    }

    public static void ucapan(String username) {
        System.out.println("===============================================");
        System.out.println("|            \tTerima Kasih " + username + "             |");
        System.out.println("|          Telah Melakukan Transaksi          |");
        System.out.println("===============================================");
    }

    public static void tabelSapaan(String username) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("|             Hallo " + username + "               |");
        System.out.println("|            SELAMAT DATANG            |");
        System.out.println("|++++++++++++++++++++++++++++++++++++++|");
    }

    public static void bank(String kodeBank, int pilihBank, int noBank, int trf, int[] digitBank) {

        if (rekTujuan.length() == digitBank[pilihBank-1]) {
        kodeBank = rekTujuan.substring(0, 3);

        boolean valid = false;
        for (int j = 0; j < kodeTfBank.length; j++) {
            if (kodeBank.equals(kodeTfBank[pilihBank-1])) {
                valid = true;
                break;
            }
        }
            if (valid) {
                System.out.println("Nomor Valid");
                noBank = 2;
            } else {
                System.out.println("Kode Bank Tidak Valid");
            }
        } else {
            System.out.println("Nomor Tidak Valid");
        }
    }
    
    public static void perulnaganDanUcapan(int ulangMenu, String username, int noBank) {
        
        noBank=2;
        System.out.print("Masukkan Nominal Transfer : ");
        trf = sc1.nextInt();
    
        if (saldo[login] > trf) {
            saldo[login] -= trf;
            System.out.println("Tranfer Sejumlah " + trf + " Berhasil");
            System.out.println("Sisa Saldo \t : " + saldo[login]);
            strukTransfer(rekTujuan, trf, saldo);
        } else {
        System.out.println("Saldo Tidak Mencukupi");
        }
        System.out.println("Apakah Anda Ingin Lanjut? (y/n): ");
        char hentiTf = sc1.next().charAt(0);

        if (hentiTf != 'y') {
            ulangMenu = 1;
            ucapan(username);
        }
    }
                                        
}
