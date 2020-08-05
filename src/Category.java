import java.util.Scanner;
import java.util.ArrayList;

public class Category {
    String kodeCategory, deskripsi;
    static ArrayList<Category> categories = new ArrayList<>();

    public Category()
    {

    }

    public Category(String kodeCategory, String deskripsi)
    {
        this.kodeCategory = kodeCategory;
        this.deskripsi = deskripsi;
    }

    public ArrayList<Category> getAllCategories(){
        return categories;
    }

    public String getKodeCategory() {
        return kodeCategory;
    }
    public void setKodeCategory(String kodeCategory) {
        this.kodeCategory = kodeCategory;
    }
    public String getDeskripsi()
    {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void actionTambahKategori(String kodeCategory,String deskripsi)
    {
        categories.add(new Category(kodeCategory,deskripsi));
        System.out.println("Berhasil Ditambahkan!!!");
    }
}
