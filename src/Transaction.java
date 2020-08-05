import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    Date tanggalTransaksi;
    String kodeBuku;
    int qtyBuku, totalHarga;
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

    public void prosesTransaksi(MasterBooks mybooks, Date tanggaltrans, int qty){
        Scanner input = new Scanner(System.in);
        System.out.print("Qty Buku : ");
        qtyBuku = input.nextInt();
        System.out.print("Total Harga : " + mybooks.getPrice() * qtyBuku);
        transactions.add(new Transaction(tanggalTransaksi,kodeBuku, qtyBuku, totalHarga));
        mybooks.setQty(mybooks.getQty() - qtyBuku);
        System.out.println("Transaksi Berhasil!!!");
    }
}
