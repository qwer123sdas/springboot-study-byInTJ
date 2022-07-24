package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    // private static : 클래스 레벨로 올라가서 1개만 존재하게 된

    // 유일하게 꺼내는 곳
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }
    private void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    public static void main(String[] args){
        SingletonService singletonService1 = new SingletonService();

    }
}
