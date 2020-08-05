import java.util.Scanner;
import java.util.ArrayList;

public class MasterBooks {
    String kodeBuku, judulBuku, pengarang, tahunTerbit, penerbit, kategori;
    int qty, price;
    ArrayList<MasterBooks> books;

    public MasterBooks()
    {
        books = new ArrayList<MasterBooks>();
    }

    public MasterBooks(String kodeBuku, String judulBuku, String pengarang, String penerbit, String tahunTerbit,
                       String kategori, int qty, int price)
    {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.kategori = kategori;
        this.qty = qty;
        this.price = price;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }
    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }
    public String getJudulBuku()
    {
        return judulBuku;
    }
    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }
    public String getPengarang()
    {
        return pengarang;
    }
    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }
    public String getPenerbit()
    {
        return penerbit;
    }
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
    public String getTahunTerbit()
    {
        return tahunTerbit;
    }
    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }
    public String getKategori()
    {
        return kategori;
    }
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    public int getQty()
    {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
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

        actionTambahBuku(kodeBuku,judulBuku,pengarang,penerbit,tahunTerbit,kategori,qty,price);
    }

    public void actionTambahBuku(String kodeBuku, String judulBuku, String pengarang, String penerbit, String tahunTerbit,
                                 String kategori, int qty, int price)
    {
        books.add(new MasterBooks(kodeBuku, judulBuku, pengarang, penerbit, tahunTerbit, kategori, qty, price));
        System.out.println("Berhasil Ditambahkan!!!");
    }

    public void tampilBuku()
    {
        System.out.println("Master Buku >> Daftar Buku");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("Kode Buku \t Judul Buku \t Pengarang \t\t\t\t Penerbit \t\t Tahun Terbit \t Kategori \t Stok \t Harga"));
        System.out.println("===============================================================================================================");
        for(MasterBooks mybooks:books)
        {
            System.out.println(mybooks.kodeBuku + "\t\t" + mybooks.judulBuku + "\t" + mybooks.pengarang + "\t" + mybooks.penerbit + "\t" +
                    mybooks.tahunTerbit + "\t\t\t" + mybooks.kategori + "\t\t" + mybooks.qty + "\t" + mybooks.price);
        }
        System.out.println();
    }

    public void ubahBuku(){
        Scanner input = new Scanner(System.in);
        boolean found = false;
        System.out.println("Master Buku >> Ubah Buku");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.print("Masukkan Kode Buku : ");
        String kode = input.nextLine();
        for(MasterBooks mybooks:books){
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
        System.out.println("Master Buku >> Hapus Buku");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.print("Masukkan Kode Buku : ");
        String kode = input.nextLine();
        for(MasterBooks mybooks:books){
            if(mybooks.kodeBuku.equals(kode) && !found){
                tampilBukuByKode(mybooks);
                actionHapusBuku(mybooks);
                found = true;
            }
        }
        if(!found){
            System.out.println("Kode Buku Tidak Ditemukan!!!");
        }
    }

    public void actionHapusBuku(MasterBooks mybooks){
        Scanner input = new Scanner(System.in);
        String choice;
        System.out.print("Apakah anda yakin ingin menghapus data buku ini? [Y/N] ");
        choice = input.next();

        if(choice.equals("Y") || choice.equals("y")){
            books.remove(mybooks);
            System.out.println("Data Berhasil Dihapus!!!");
        }
    }
}