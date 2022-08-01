package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void creatOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void fieldInjectionTest(){
        // 이렇게 유연하게 대처 가능
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        // 하지만 필드 주입이면
        //  OrderServiceImpl orderService = new OrderServiceImpl(); 이기 때문에, 유연하게 대처 불가능
        // 또한 스프링 빈에서 돌리는 게 아니기 때문에 널포인트익셉션이 발생하게 된다.
        // 그래서 결국 setter을 따로 만들어줘서 해결할 수 있다. 즉 필드 주입은 setter을 만들어 줘야하므로 불편
        
        orderService.createOrder(1L, "itemA", 10000);
    }
}
