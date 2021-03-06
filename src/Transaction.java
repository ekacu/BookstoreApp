import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    Date tanggalTransaksi;
    String kodeBuku;
    int qtyBuku, totalHarga,pendapatan=0;
    static ArrayList<Transaction> transactions = new ArrayList<>();

    public Transaction()
    {

    }

    public Transaction(Date tanggalTransaksi, String kodeBuku, int qtyBuku, int totalHarga)
    {
        this.tanggalTransaksi = tanggalTransaksi;
        this.kodeBuku = kodeBuku;
        this.qtyBuku = qtyBuku;
        this.totalHarga = totalHarga;
    }

    public int getPendapatan(){
        return pendapatan;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }
    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }
    public String getKodeBuku() {
        return kodeBuku;
    }
    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }
    public int getQtyBuku() {
        return qtyBuku;
    }
    public void setQtyBuku(int qtyBuku) {
        this.qtyBuku = qtyBuku;
    }
    public int getTotalHarga() {
        return totalHarga;
    }
    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public ArrayList<Transaction> getAllTransaction(){
        return transactions;
    }

    public void prosesTransaksi(MasterBooks mybooks, Date tanggaltrans, int qty){
        Scanner input = new Scanner(System.in);
        int total = mybooks.getPrice() * qty;
        System.out.print("Total Harga : Rp " + total);
        pendapatan += total;
        transactions.add(new Transaction(tanggaltrans,mybooks.kodeBuku, qty, total));
        mybooks.setQty(mybooks.getQty() - qty);
        System.out.println();
        System.out.println("Transaksi Berhasil!!!");
        System.out.println();
    }
}
