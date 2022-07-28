import java.util.Calendar;
import java.util.Scanner;


public class MainCafe {

    private static boolean session;
    private static boolean register = false;

    static void promo(){
        System.out.println("\nSekarang ada lagi promo 17 agustus nih kak!");
        System.out.println("jika tanggal lahir kaka 17 agustus/umur kaka 17 tahun bisa mendapatkan potongan harga ini loh kak,");
        System.out.println("tertarik? silahkan pilih salah-satu");
        System.out.println("1. Menyatakan benar bahwa saya lahir pada tanggal 17 Agustus [Lampirkan KTP]");
        System.out.println("2. Menyatakan benar bahwa saya berumur 17 Tahun");
        System.out.print("-> ");
    }

    static void tampilMenu(){
        System.out.println("\n=== Menu ====");
        if (register) {
            // registernya ilang klo sudah daftar
            System.out.println(" ");
        }else{
            System.out.println("1. Register");
        }
        if (session) {
            System.out.println("3. Minuman");
            System.out.println("5. Logout");
        } else {
            // System.out.println("Untuk masuk menu ini [Anda harus login terlebih dahulu]");
            System.out.println("2. Login");
        }
        System.out.println("0. Exit\n");
        System.out.println("=============");
        System.out.println("\nPilih menu");
        System.out.print("-> ");
    }

    public static void main(String[] args) {

        Person[] array = new Person[5];
        String nama, user, pass, conPass;
        int input, inputkopi, pesanan, promo, tahun_lahir, tahun_sekarang, umur;
        char confirm;
        Scanner inputan = new Scanner(System.in);
        // inisialsisasi kalendar
        Calendar kalender = Calendar.getInstance();
        tahun_sekarang = kalender.get(Calendar.YEAR);


        System.out.println("\n==! Selamat Datang di Angkringan Sekuy! !==");
        System.out.println("Tempatnya santuy dengan memesan aneka minuman mulai dari Kopi dan yang lainnya...\n" +
                "silahkan Register bagi yang belum mempunyai akun /atau " +
                "Login bagi yang sudah mempunyai akun, Selamat bersantuy ria :D");

        do {
            tampilMenu();
            input = inputan.nextInt();
            inputan.nextLine();

            switch (input) {
                case 1 -> {
                    if (!register){
                        System.out.print("Masukkan Nama Lengkap\t: ");
                        nama = inputan.nextLine();
                        System.out.print("Masukkan Username\t\t: ");
                        user = inputan.nextLine();
                        System.out.print("Masukkan Password\t\t: " );
                        pass = inputan.nextLine();
                        System.out.print("Masukkan Ulang Password\t: ");
                        conPass = inputan.nextLine();

                        if (!conPass.equals(pass)){
                            System.out.print("PIN TIDAK COCOK!");
                        }else{
                            System.out.println("\n--------------------");
                            System.out.println("Registrasi Berhasil");
                            System.out.println("--------------------\n");
                            register = true;

                            array[0] =new Person(nama, user, pass);
                        }
                    }else{
                        System.out.println("[Anda sudah mendaftar, Silahkan Login]");
                    }
                }
                case 2 -> {
                    System.out.print("Masukkan username\t\t: ");
                    user = inputan.nextLine();
                    System.out.print("Masukkan pin rekening\t: ");
                    pass = inputan.nextLine();

                    try {
                        if (user.equals(array[0].username) && pass.equals(array[0].password)){
                            register = true;
                            session = true;
                            System.out.println("\n[Login Berhasil]");
                        }else{
                            System.out.println("\n[Username atau password salah!]");
                        }

                    } catch (Exception e){
                        System.out.println("\n[something wrong in here]");
                    }
                }
                case 3 -> {
                    System.out.println("Pesan minuman apa nih...");
                    System.out.println("------------------------");
                    Minuman minuman = new Kopi();
                    Minuman minuman2 = new Kopi();
                    Minuman minuman3 = new Kopi();
                    Minuman minuman4 = new Kopi();
                    Minuman minuman5 = new Kopi();
                    minuman2 = new KopiArabica(minuman2);
                    minuman3 = new KopiLatte(minuman3);
                    minuman4 = new KopiCappucino(minuman4);
                    minuman5 = new KopiIced(minuman5);
                    System.out.println("\n1. " + minuman.getJenis_minuman() + " Rp." + minuman.harga());
                    System.out.println("2. " + minuman2.getJenis_minuman() + " Rp." + minuman2.harga());
                    System.out.println("3. " + minuman3.getJenis_minuman() + " Rp." + minuman3.harga());
                    System.out.println("4. "+ minuman4.getJenis_minuman() + " Rp." + minuman4.harga());
                    System.out.println("5. " + minuman5.getJenis_minuman() + " Rp." + minuman5.harga());
                    System.out.println("\nPilih menu");
                    System.out.print("-> ");
                    inputkopi = inputan.nextInt();
                    inputan.nextLine();
                    if (inputkopi == 1){
                        System.out.println("Hai, " + array[0].getNama());
                        System.out.println("Apakah benar anda memesan minuman ini? \n[" + minuman.getJenis_minuman() + "]");
                        System.out.println("ketik [y] jika benar, dan ketik [n] jika salah");
                        System.out.print("-> ");
                        confirm = inputan.next().charAt(0);

                        if (confirm == 'y'){
                            System.out.println("Mau pesan berapa?");
                            pesanan = inputan.nextInt();
                            inputan.nextLine();

                            promo();
                            promo = inputan.nextInt();
                            inputan.nextLine();
                            if (promo == 1){
                                System.out.println("Selamat anda mendapatkan potongan harga sebesar Rp. 10.000");
                            }else if(promo == 2){
                                System.out.print("Silahkan masukkan tahun lahir, untuk mengecek umur : ");
                                tahun_lahir = inputan.nextInt();
                                inputan.nextLine();

                                // rumus
                                umur = tahun_sekarang - tahun_lahir;

                                if (umur == 17){
                                    System.out.println("Umur anda "+umur+" tahun");
                                    System.out.println("Selamat anda mendapatkan potongan harga sebesar Rp.10.000");
                                }

                            }else{
                                System.out.println("\n[ Tidak Tersedia pilihan ]");
                            }

                            System.out.println("=| Pembelian |=");
                            System.out.println("\n[ "+minuman.getJenis_minuman() + pesanan + "x ]");
                            System.out.println("Total Harga\t: " + minuman.harga() * pesanan);

                            System.out.println("\n--------------------------------------------------");

                            System.out.println("Silahkan bisa membayar melalui kasir di Cafe sekuy!");
                            System.out.println("atau bisa lewat Atm Banking/Dana/OVO");

                            System.out.println("Terima kasih sudah memesan!");

                            System.out.println("--------------------------------------------------");


                        }else if(confirm == 'n'){
                            System.out.println("salah");
                        }else {
                            System.out.println("pilih [y] / [n]");
                        }

                    }else if (inputkopi == 2){
                        System.out.println("Hai, " + array[0].getNama());
                        System.out.println("Apakah benar anda memesan minuman ini? \n[" + minuman2.getJenis_minuman() + "]");
                        System.out.println("ketik [y] jika benar, dan ketik [n] jika salah");
                        System.out.print("-> ");
                        confirm = inputan.next().charAt(0);

                        if (confirm == 'y'){
                            System.out.println("Mau pesan berapa?");
                            pesanan = inputan.nextInt();
                            inputan.nextLine();

                            promo();
                            promo = inputan.nextInt();
                            inputan.nextLine();
                            if (promo == 1){
                                System.out.println("Selamat anda mendapatkan potongan harga sebesar Rp. 10.000");
                            }else if(promo == 2){
                                System.out.print("Silahkan masukkan tahun lahir, untuk mengecek umur : ");
                                tahun_lahir = inputan.nextInt();
                                inputan.nextLine();

                                // rumus
                                umur = tahun_sekarang - tahun_lahir;

                                if (umur == 17){
                                    System.out.println("Umur anda "+umur+" tahun");
                                    System.out.println("Selamat anda mendapatkan potongan harga sebesar Rp.10.000");
                                }

                            }else{
                                System.out.println("\n[ Tidak Tersedia pilihan ]");
                            }

                            System.out.println("=| Pembelian |=");
                            System.out.println("\n[ "+minuman2.getJenis_minuman() + pesanan + "x ]");
                            System.out.println("Total Harga\t: " + minuman2.harga() * pesanan);

                            System.out.println("\n--------------------------------------------------");

                            System.out.println("Silahkan bisa membayar melalui kasir di Cafe sekuy!");
                            System.out.println("atau bisa lewat Atm Banking/Dana/OVO");

                            System.out.println("Terima kasih sudah memesan!");

                            System.out.println("--------------------------------------------------");


                        }else if(confirm == 'n'){
                            System.out.println("salah");
                        }else {
                            System.out.println("pilih [y] / [n]");
                        }
                    }else if (inputkopi == 3){
                        System.out.println("Hai, " + array[0].getNama());
                        System.out.println("Apakah benar anda memesan minuman ini? \n[" + minuman3.getJenis_minuman() + "]");
                        System.out.println("ketik [y] jika benar, dan ketik [n] jika salah");
                        System.out.print("-> ");
                        confirm = inputan.next().charAt(0);

                        if (confirm == 'y'){
                            System.out.println("Mau pesan berapa?");
                            pesanan = inputan.nextInt();
                            inputan.nextLine();

                            promo();
                            promo = inputan.nextInt();
                            inputan.nextLine();
                            if (promo == 1){
                                System.out.println("Selamat anda mendapatkan potongan harga sebesar Rp. 10.000");
                            }else if(promo == 2){
                                System.out.print("Silahkan masukkan tahun lahir, untuk mengecek umur : ");
                                tahun_lahir = inputan.nextInt();
                                inputan.nextLine();

                                // rumus
                                umur = tahun_sekarang - tahun_lahir;

                                if (umur == 17){
                                    System.out.println("Umur anda "+umur+" tahun");
                                    System.out.println("Selamat anda mendapatkan potongan harga sebesar Rp.10.000");
                                }

                            }else{
                                System.out.println("\n[ Tidak Tersedia pilihan ]");
                            }

                            System.out.println("=| Pembelian |=");
                            System.out.println("\n[ "+minuman3.getJenis_minuman() + pesanan + "x ]");
                            System.out.println("Total Harga\t: " + minuman3.harga() * pesanan);

                            System.out.println("\n--------------------------------------------------");

                            System.out.println("Silahkan bisa membayar melalui kasir di Cafe sekuy!");
                            System.out.println("atau bisa lewat Atm Banking/Dana/OVO");

                            System.out.println("Terima kasih sudah memesan!");

                            System.out.println("--------------------------------------------------");


                        }else if(confirm == 'n'){
                            System.out.println("salah");
                        }else {
                            System.out.println("pilih [y] / [n]");
                        }
                    }else if (inputkopi == 4){
                        System.out.println("Hai, " + array[0].getNama());
                        System.out.println("Apakah benar anda memesan minuman ini? \n[" + minuman4.getJenis_minuman() + "]");
                        System.out.println("ketik [y] jika benar, dan ketik [n] jika salah");
                        System.out.print("-> ");
                        confirm = inputan.next().charAt(0);

                        if (confirm == 'y'){
                            System.out.println("Mau pesan berapa?");
                            pesanan = inputan.nextInt();
                            inputan.nextLine();

                            promo();
                            promo = inputan.nextInt();
                            inputan.nextLine();
                            if (promo == 1){
                                System.out.println("Selamat anda mendapatkan potongan harga sebesar Rp. 10.000");
                            }else if(promo == 2){
                                System.out.print("Silahkan masukkan tahun lahir, untuk mengecek umur : ");
                                tahun_lahir = inputan.nextInt();
                                inputan.nextLine();

                                // rumus
                                umur = tahun_sekarang - tahun_lahir;

                                if (umur == 17){
                                    System.out.println("Umur anda "+umur+" tahun");
                                    System.out.println("Selamat anda mendapatkan potongan harga sebesar Rp.10.000");
                                }

                            }else{
                                System.out.println("\n[ Tidak Tersedia pilihan ]");
                            }

                            System.out.println("=| Pembelian |=");
                            System.out.println("\n[ "+minuman4.getJenis_minuman() + pesanan + "x ]");
                            System.out.println("Total Harga\t: " + minuman4.harga() * pesanan);

                            System.out.println("\n--------------------------------------------------");

                            System.out.println("Silahkan bisa membayar melalui kasir di Cafe sekuy!");
                            System.out.println("atau bisa lewat Atm Banking/Dana/OVO");

                            System.out.println("Terima kasih sudah memesan!");

                            System.out.println("--------------------------------------------------");


                        }else if(confirm == 'n'){
                            System.out.println("salah");
                        }else {
                            System.out.println("pilih [y] / [n]");
                        }
                    }else if (inputkopi == 5){
                        System.out.println("Hai, " + array[0].getNama());
                        System.out.println("Apakah benar anda memesan minuman ini? \n[" + minuman5.getJenis_minuman() + "]");
                        System.out.println("ketik [y] jika benar, dan ketik [n] jika salah");
                        System.out.print("-> ");
                        confirm = inputan.next().charAt(0);

                        if (confirm == 'y'){
                            System.out.println("Mau pesan berapa?");
                            pesanan = inputan.nextInt();
                            inputan.nextLine();

                            promo();
                            promo = inputan.nextInt();
                            inputan.nextLine();
                            if (promo == 1){
                                System.out.println("Selamat anda mendapatkan potongan harga sebesar Rp. 10.000");
                            }else if(promo == 2){
                                System.out.print("Silahkan masukkan tahun lahir, untuk mengecek umur : ");
                                tahun_lahir = inputan.nextInt();
                                inputan.nextLine();

                                // rumus
                                umur = tahun_sekarang - tahun_lahir;

                                if (umur == 17){
                                    System.out.println("Umur anda "+umur+" tahun");
                                    System.out.println("Selamat anda mendapatkan potongan harga sebesar Rp.10.000");
                                }

                            }else{
                                System.out.println("\n[ Tidak Tersedia pilihan ]");
                            }

                            System.out.println("=| Pembelian |=");
                            System.out.println("\n[ "+minuman5.getJenis_minuman() + pesanan + "x ]");
                            System.out.println("Total Harga\t: " + minuman5.harga() * pesanan);

                            System.out.println("\n--------------------------------------------------");

                            System.out.println("Silahkan bisa membayar melalui kasir di Cafe sekuy!");
                            System.out.println("atau bisa lewat Atm Banking/Dana/OVO");

                            System.out.println("Terima kasih sudah memesan!");

                            System.out.println("--------------------------------------------------");


                        }else if(confirm == 'n'){
                            System.out.println("salah");
                        }else {
                            System.out.println("pilih [y] / [n]");
                        }
                    }

                }
                case 5 -> {
                    register = false;
                    session = false;
                    System.out.println("\n [ Logout Berhasil! ]");
                }
                case 0 -> {
                    System.exit(0);
                }
            }
        }while (true);

    }
}