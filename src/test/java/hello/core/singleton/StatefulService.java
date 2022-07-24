package hello.core.singleton;

public class StatefulService {
    // private int price; // 상태를 유지하는 필드

    public int  order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        // this.price = price; // 여기가문제
        
        // 그래서 지역변수로 해결(지역변수는 공유되지 않으므로)
        return price;
    }

/*    public int getPrice(){
        return price;
    }*/
}
