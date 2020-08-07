import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.LoggingPermission;
import com.github.mrebhan.crogamp.cli.TableList;
import java.util.ArrayList;

public class MainClass {
    MasterBooks mb = new MasterBooks();
    Transaction tr = new Transaction();
    Category ct = new Category();

    public static void main(String[] args){
        MainClass mc = new MainClass();
        Scanner input = new Scanner(System.in);

        int choice = 0;
        while (true){
            System.out.println("============================================================================================================");
            System.out.println("BOOKSTORE APPLICATION");
            System.out.println("============================================================================================================");
            System.out.println("1. Master Data Kategori");
            System.out.println("2. Master Data Buku");
            System.out.println("3. Transaksi");
            System.out.println("4. Keluar");
            System.out.print("Masukkan Pilihan Anda : ");

            choice = input.nextInt();
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            switch (choice) {
                case 1:
                    mc.menuMasterKategori();
                    break;
                case 2:
                    mc.menuMasterBuku();
                    break;
                case 3:
                    mc.menuTransaksi();
                    break;
                case 4:
                    System.out.println("Terimakasih . . . . . . . . . . . . . . . . .");
                    System.exit(0); break;
                default:
                    System.out.println("Pilihan menu tidak tersedia! Silahkan ulangi lagi!");
                    break;
            }

        }
    }

    public void menuMasterKategori(){
        Scanner scan = new Scanner(System.in);
        String option;
        System.out.println("==================================================================================================================");
        System.out.println("Pilih Menu Kategori : ");
        System.out.println("1. Tambah Kategori");
        System.out.println("2. Tampil Kategori");
        System.out.println("3. Ubah Kategori");
        System.out.println("4. Hapus Kategori");
        System.out.println("5. Kembali ke menu utama");
        System.out.print("Masukkan Pilihan Anda : ");
        option = scan.nextLine();
        switch (option){
            case "1":
                tambahKategori();
                menuMasterKategori();
                break;
            case "2":
                tampilKategori();
                menuMasterKategori();
                break;
            case "3":
                ubahKategori();
                menuMasterKategori();
                break;
            case "4":
                hapusKategori();
                menuMasterKategori();
                break;
            case "5":
                break;
            default:
                System.out.println("Opsi tidak tersedia");
                break;
        }
    }

    public void menuMasterBuku(){
        Scanner scan = new Scanner(System.in);
        String option;
        System.out.println("==================================================================================================================");
        System.out.println("Pilih Menu Buku : ");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Tampil Buku");
        System.out.println("3. Ubah Buku");
        System.out.println("4. Hapus Buku");
        System.out.println("5. Kembali ke menu utama");
        System.out.print("Masukkan Pilihan Anda : ");
        option = scan.nextLine();
        switch (option){
            case "1":
                tambahBuku();
                menuMasterBuku();
                break;
            case "2":
                tampilBuku();
                menuMasterBuku();
                break;
            case "3":
                ubahBuku();
                menuMasterBuku();
                break;
            case "4":
                hapusBuku();
                menuMasterBuku();
                break;
            case "5":
                break;
            default:
                System.out.println("Opsi tidak tersedia");
                break;
        }
    }

    public void menuTransaksi(){
        Scanner scan = new Scanner(System.in);
        String option;
        System.out.println("==================================================================================================================");
        System.out.println("Pilih Menu Transaksi : ");
        System.out.println("1. Penjualan Buku");
        System.out.println("2. Riwayat Transaksi");
        System.out.println("3. Kembali ke menu utama");
        System.out.print("Masukkan Pilihan Anda : ");
        option = scan.nextLine();
        switch (option){
            case "1":
                Transaksi();
                menuTransaksi();
                break;
            case "2":
                tampilTransaksi();
                menuTransaksi();
                break;
            case "3":
                break;
            default:
                System.out.println("Opsi tidak tersedia");
                break;
        }

    }


    public void tambahBuku(){
        Scanner input = new Scanner(System.in);
        String kodeBuku, judulBuku, pengarang, tahunTerbit, penerbit, kategori;
        int qty, price;

        System.out.println("Master Buku >> Tambah Buku");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.print("Kode Buku : ");
        kodeBuku = input.nextLine();
        System.out.print("Judul Buku : ");
        judulBuku = input.nextLine();
        System.out.print("Pengarang : ");
        pengarang = input.nextLine();
        System.out.print("Penerbit : ");
        penerbit = input.nextLine();
        System.out.print("Tahun Terbit : ");
        tahunTerbit = input.nextLine();
        System.out.print("Kategori : ");
        kategori = input.nextLine();
        System.out.print("Stok : ");
        qty = input.nextInt();
        System.out.print("Harga : ");
        price = input.nextInt();

        mb.actionTambahBuku(kodeBuku,judulBuku,pengarang,penerbit,tahunTerbit,kategori,qty,price);
    }

    public void tampilBuku()
    {
        System.out.println("Master Buku >> Daftar Buku");
        TableList tl = new TableList(8, "Kode Buku","Judul Buku","Pengarang","Penerbit","Tahun Terbit","Kategori","Stok","Harga").sortBy(0).withUnicode(true);
        ArrayList<MasterBooks> mstbook = mb.getAllBooks();
        mstbook.forEach(element -> tl.addRow(String.valueOf(element.kodeBuku), String.valueOf(element.judulBuku), String.valueOf(element.pengarang),
                String.valueOf(element.penerbit), String.valueOf(element.tahunTerbit), String.valueOf(getJudulBukuTrans(element.kodeBuku)),
                String.valueOf(element.qty), String.valueOf(element.price)));
        tl.print();
        System.out.println();
    }

    public String getKategoriBuku(String kodeKategori){
        String output = "";
        for(Category mycategories:ct.getAllCategories())
        {
            if(kodeKategori.equals(mycategories.kodeCategory)){
                output = mycategories.getDeskripsi();
                break;
            }
            else{
                output = kodeKategori;
                continue;
            }
        }
        return output;
    }

    public void ubahBuku(){
        Scanner input = new Scanner(System.in);
        boolean found = false;
        System.out.println("Master Buku >> Ubah Buku");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.print("Masukkan Kode Buku : ");
        String kode = input.nextLine();
        for(MasterBooks mybooks:mb.getAllBooks()){
            if(mybooks.kodeBuku.equals(kode) && !found){
                tampilBukuByKode(mybooks);
                actionUbahBuku(mybooks);
                tampilBukuByKode(mybooks);
                found = true;
            }
        }
        if(!found){
            System.out.println("Kode Buku Tidak Ditemukan!!!");
        }
    }

    public void tampilBukuByKode(MasterBooks mybooks){
        System.out.println("=====Data Buku=====");
        System.out.println("Judul Buku = " + mybooks.judulBuku);
        System.out.println("Pengarang = " + mybooks.pengarang);
        System.out.println("Penerbit = " + mybooks.penerbit);
        System.out.println("Tahun Terbit = " + mybooks.tahunTerbit);
        System.out.println("Kategori = " + mybooks.kategori);
        System.out.println("Stok = " + mybooks.qty);
        System.out.println("Harga = " + mybooks.price);
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }

    public void actionUbahBuku(MasterBooks mybooks){
        Scanner scan = new Scanner(System.in);
        String judulBaru, pengarangBaru, tahunTerbitBaru, penerbitBaru, kategoriBaru, option;
        int stokBaru, hargaBaru;

        System.out.println("Pilih Data Perubahan Buku : ");
        System.out.println("1. Ubah Judul Buku");
        System.out.println("2. Ubah Pengarang");
        System.out.println("3. Ubah Penerbit");
        System.out.println("4. Ubah Tahun Terbit");
        System.out.println("5. Ubah Kategori");
        System.out.println("6. Ubah Stok");
        System.out.println("7. Ubah Harga");
        System.out.print("Masukkan Pilihan Anda : ");
        option = scan.nextLine();
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        switch (option){
            case "1":
                System.out.print("Judul Buku : ");
                judulBaru = scan.nextLine();
                mybooks.setJudulBuku(judulBaru);
                System.out.println("Judul Berhasil Diubah!!!");
                break;
            case "2":
                System.out.print("Pengarang : ");
                pengarangBaru = scan.nextLine();
                mybooks.setPengarang(pengarangBaru);
                System.out.println("Pengarang Berhasil Diubah!!!");
                break;
            case "3":
                System.out.print("Penerbit : ");
                penerbitBaru = scan.nextLine();
                mybooks.setPenerbit(penerbitBaru);
                System.out.println("Penerbit Berhasil Diubah!!!");
                break;
            case "4":
                System.out.print("Tahun Terbit : ");
                tahunTerbitBaru = scan.nextLine();
                mybooks.setTahunTerbit(tahunTerbitBaru);
                System.out.println("Tahun Terbit Berhasil Diubah!!!");
                break;
            case "5":
                System.out.print("Kategori : ");
                kategoriBaru = scan.nextLine();
                mybooks.setKategori(kategoriBaru);
                System.out.println("Kategori Berhasil Diubah!!!");
                break;
            case "6":
                System.out.print("Stok : ");
                stokBaru = scan.nextInt();
                mybooks.setQty(stokBaru);
                System.out.println("Stok Berhasil Diubah!!!");
                break;
            case "7":
                System.out.print("Harga : ");
                hargaBaru = scan.nextInt();
                mybooks.setPrice(hargaBaru);
                System.out.println("Harga Berhasil Diubah!!!");
                break;
            default:
                System.out.println("Pilihan menu tidak tersedia! Silahkan ulangi lagi!");
                break;
        }
    }

    public void hapusBuku(){
        Scanner input = new Scanner(System.in);
        boolean found = false;
        String choice;
        System.out.println("Master Buku >> Hapus Buku");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.print("Masukkan Kode Buku : ");
        String kode = input.nextLine();

        for(Iterator<MasterBooks> masterBooksIterator = mb.getAllBooks().iterator(); masterBooksIterator.hasNext();){
            MasterBooks mstbook = masterBooksIterator.next();
            if(mstbook.getKodeBuku().equals(kode)){
                System.out.print("Apakah anda yakin ingin menghapus data kategori ini? [Y/N] ");
                choice = input.next();
                if(choice.equals("Y") || choice.equals("y")){
                    masterBooksIterator.remove();
                    System.out.println("Data Berhasil Dihapus!!!");
                }
                found = true;
            }
        }
        if(!found){
            System.out.println("Kode Buku Tidak Ditemukan!!!");
        }
        menuMasterKategori();
    }

    public void Transaksi(){
        System.out.println("Transaksi >> Penjualan Buku");
        Scanner input = new Scanner(System.in);
        boolean found = false;
        Date tanggalTransaksi = new Date();
        System.out.println("Tanggal Transaksi : " +tanggalTransaksi);
        System.out.print("Kode Buku : ");
        String kode = input.nextLine();

        for(MasterBooks mybooks:mb.getAllBooks()){
            if(mybooks.kodeBuku.equals(kode) && !found){
                tampilBukuByKode(mybooks);
                System.out.print("Qty Buku : ");
                int qtyBuku = input.nextInt();
                tr.prosesTransaksi(mybooks, tanggalTransaksi, qtyBuku);
                found = true;
            }
        }
        if(!found){
            System.out.println("Kode Buku Tidak Ditemukan!!!");
        }

    }

    public void tampilTransaksi(){
        TableList tl = new TableList(4, "Tgl. Transaksi", "Kode Buku","Qty","Total Harga").sortBy(0).withUnicode(true);

        ArrayList<Transaction> transaksi = tr.getAllTransaction();
        transaksi.forEach(element -> tl.addRow(String.valueOf(element.tanggalTransaksi), getJudulBukuTrans(element.kodeBuku), String.valueOf(element.qtyBuku), String.valueOf(element.totalHarga)));
        tl.print();
        System.out.println("Total Pendapatan : Rp " + tr.getPendapatan());
        System.out.println();
    }

    public String getJudulBukuTrans(String kodeBukuTrans){
        String output = "";
        for(MasterBooks mybooks:mb.getAllBooks())
        {
            if(kodeBukuTrans.equals(mybooks.kodeBuku)){
                output = mybooks.getJudulBuku();
                break;
            }
            else{
                output = kodeBukuTrans;
                continue;
            }
        }
        return output;
    }

    public void tambahKategori(){
        Scanner input = new Scanner(System.in);

        System.out.println("Master Kategori >> Tambah Kategori");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.print("Kode Kategori : ");
        String kodeCategory = input.nextLine();
        System.out.print("Deskripsi : ");
        String deskripsi = input.nextLine();

        ct.actionTambahKategori(kodeCategory,deskripsi);
    }

    public void tampilKategori()
    {
        System.out.println("Master Kategori >> Daftar Kategori");
        TableList tl = new TableList(2, "Kode Kategori", "Deskripsi").sortBy(0).withUnicode(true);
        ArrayList<Category> cat = ct.getAllCategories();
        cat.forEach(element -> tl.addRow(String.valueOf(element.kodeCategory),String.valueOf(element.deskripsi)));
        tl.print();
        System.out.println();
    }

    public void ubahKategori(){
        Scanner input = new Scanner(System.in);
        boolean found = false;
        System.out.println("Master Kategori >> Ubah Kategori");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.print("Masukkan Kode Kategori : ");
        String kode = input.nextLine();
        for(Category mycategories:ct.getAllCategories()){
            if(mycategories.kodeCategory.equals(kode) && !found){
                tampilKategoriByKode(mycategories);
                actionUbahKategori(mycategories);
                tampilKategoriByKode(mycategories);
                found = true;
            }
        }
        if(!found){
            System.out.println("Kode Buku Tidak Ditemukan!!!");
        }
        menuMasterKategori();
    }

    public void tampilKategoriByKode(Category mycategories){
        System.out.println("=====Data Kategori=====");
        System.out.println("Kode Kategori = " + mycategories.kodeCategory);
        System.out.println("Deskripsi = " + mycategories.deskripsi);
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }

    public void actionUbahKategori(Category mycategories){
        Scanner scan = new Scanner(System.in);
        String deskripsiBaru;

        System.out.print("Deskripsi : ");
        deskripsiBaru = scan.nextLine();
        mycategories.setDeskripsi(deskripsiBaru);
        System.out.println("Deskripsi Berhasil Diubah!!!");
        menuMasterKategori();
    }

    public void hapusKategori(){
        Scanner input = new Scanner(System.in);
        String choice;
        boolean found = false;
        System.out.println("Master Kategori >> Hapus Kategori");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.print("Masukkan Kode Kategori : ");
        String kode = input.nextLine();

        for(Iterator<Category> categoryIterator = ct.getAllCategories().iterator(); categoryIterator.hasNext();){
            Category cat = categoryIterator.next();
            if(cat.kodeCategory.equals(kode)){
                System.out.print("Apakah anda yakin ingin menghapus data kategori ini? [Y/N] ");
                choice = input.next();
                if(choice.equals("Y") || choice.equals("y")){
                    categoryIterator.remove();
                    System.out.println("Data Berhasil Dihapus!!!");
                }
                found = true;
            }
        }
        if(!found){
            System.out.println("Kode Buku Tidak Ditemukan!!!");
        }
        menuMasterKategori();
    }
}