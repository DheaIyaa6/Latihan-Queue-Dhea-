
package Queue;
import java.util.Scanner;
class simpul{
    String barang;
    int harga;
    simpul prev, next;
    simpul(String b, int h){ barang = b; harga = h; }
}
class queue{
    simpul front,rear;
    queue(){ front=rear=null; }
    void enqueue(simpul baru){
        if(rear==null){
            front=rear=baru;
        }
        else{
            rear.prev=baru;
            baru.next=rear;
            rear=baru;
        }
        System.out.println("enqueue sukses..");
    }
    simpul dequeue(){
        simpul t=null;
        if(front==null){
            System.out.println("queue kosong!");
        }
        else if(front.prev==null){
            t=front;
            front=rear=null;
        }
        else{
            t=front;
            simpul temp=front.prev;
            front.prev=null;
            temp.next=null;
            front=temp;
            System.out.println("dequeue sukses...");
        }
        return t;
    }
    
    
    void view(){
        System.out.println("Isi queue: ");
        for(simpul t=rear; t!=null; t=t.next){
            System.out.print(t.barang+" ["+t.harga+"] ");
        }
        System.out.println("");
    }
    
}


public class appQueue {
    public static void main(String[] args) {
        simpul s = new simpul("Sepatu",200000);
        queue q = new queue();
        q.enqueue(s); q.view();
        Scanner sc = new Scanner(System.in);
        int pilih=0;
        int pemasukan=0;
        do{
            System.out.println("Antrian Pembelian: ");
            System.out.println("1.enqueue\n2.dequeue");
            System.out.println("3.view\n4.exit");
            System.out.print("Pilih = ");
            pilih=sc.nextInt();
            switch(pilih){
                case 1:
                    System.out.println("Daftar barang");
                    System.out.println("1.Sepatu\n2.Tas");
                    System.out.println("3.Sendal");
                    System.out.print("Pilih = ");
                    int pilih2=sc.nextInt();
                    switch(pilih2){
                        case 1:
                            s = new simpul("Sepatu",200000);
                            break;
                        case 2:
                            s = new simpul("Tas",150000);
                            break;
                        case 3:
                            s = new simpul("Sandal",100000);
                    }
                    q.enqueue(s);
                    break;
                case 2:
                    simpul t=q.dequeue();
                    if(t!=null){
                        System.out.println("Check out "+t.barang);
                        //hitung pemasukan
                        pemasukan=pemasukan+t.harga;
                        System.out.println("Total pemasukan: "+pemasukan);
                    }
                        else System.out.println("queue kosong!");
                    break;
                case 3:
                    q.view();
                     int total=0;
                    for(simpul temp=q.front; temp!=null; temp=temp.prev){
                        total=total+temp.harga; 
                    }
                    System.out.println("Total transaksi = "+total);
                    break;
                case 4:
                    System.out.print("Thanks..");
            }
            
        }while(pilih!=4);
        
    }
}
