package penumpangreguler;

import java.util.Scanner;

/**
 *
 * @author Kato
 */

abstract class penumpang{
    protected String nama;
    protected String notiket;
    
    public penumpang(String nama, String notiket){
        this.nama = nama;
        this.notiket = notiket;
    }
    public abstract double hitunghargatiket();
    
    public void tampilkandata(){
        System.out.println("Nama        : " + nama);
        System.out.println("No Tiket    : " + notiket);
        System.out.println("Harga Tiket : " + hitunghargatiket());
    }
    public void tampilkandata(String jenis){
        tampilkandata();
        System.out.println("Jenis       : " + jenis);
    }
}
class penumpangreguler extends penumpang{
    public penumpangreguler(String nama, String notiket){
        super(nama, notiket);
    }
    
    @Override
    public double hitunghargatiket(){
        return 75000;
    }
}
class penumpangvip extends penumpang{
    public penumpangvip(String nama, String notiket){
        super(nama, notiket);
    }
    
    @Override
    public double hitunghargatiket(){
        return 125000;
    }
}
class inputpenumpang{
    protected Scanner kato = new Scanner(System.in);
}
public class Main extends inputpenumpang{
    public static void main(String[] args) {
        Main m = new Main();
        
        System.out.print("Masukkan jumlah penumpang: ");
        int jumlah = m.kato.nextInt();
        m.kato.nextLine();
        
        for (int i = 1; i <= jumlah; i++) {
            System.out.println("\nPenumpang ke" + i);
        
            System.out.print("Masukkan Nama Penumpang: ");
            String nama = m.kato.nextLine();
        
            System.out.print("Masukkan No Tiket: ");
            String notiket = m.kato.nextLine();
        
            System.out.print("Jenis Penumpang (1: Reguler, 2: VIP): ");
            int pilih = m.kato.nextInt();
            m.kato.nextLine();
        
            penumpang p;
        
            if(pilih == 1){
                p = new penumpangreguler(nama, notiket);
                p.tampilkandata("Reguler");
            }else if((pilih == 2)){
             p = new penumpangvip(nama, notiket);
                p.tampilkandata("VIP");
            }else{
                System.out.println("Mohon masukkan pilihan yang tertera");
            }
        }
    }
}

