package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {
    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url );
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url){
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect(){
        System.out.println("connect : " + url);
    }
    public void call(String message){
        System.out.println("call : " + url + "message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println("close " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 프로퍼티의 설정이 끝나면 = 의존관계 주입이 끝나면 설정해 주겠따.
        // 싱글톤 빈이기 때문에 스프링 컨테이너에 올라올 때 생성이 되고, 의존관계 주입이 되면 호출이 됨
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }

    @Override
    public void destroy() throws Exception {
        // 스프링 빈이 종료될 때 호출 됨
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
