import java.util.ArrayList;

public class MasterBooks {
    String kodeBuku, judulBuku, pengarang, tahunTerbit, penerbit, kategori;
    int qty, price;
    static ArrayList<MasterBooks> books = new ArrayList<>();

    public MasterBooks()
    {

    }

    public ArrayList<MasterBooks> getAllBooks(){
        return books;
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

    public void actionTambahBuku(String kodeBuku, String judulBuku, String pengarang, String penerbit, String tahunTerbit,
                                 String kategori, int qty, int price)
    {
        books.add(new MasterBooks(kodeBuku, judulBuku, pengarang, penerbit, tahunTerbit, kategori, qty, price));
        System.out.println("Berhasil Ditambahkan!!!");
    }
}
