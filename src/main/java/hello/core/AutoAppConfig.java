package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member", // 해당 패키지 위치부터 스캔하도록 설정
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // AppConfig.class는 수동으로 스프링 빈을 등록하여 충돌이 일어나므로(+TesfConfig들도) 제외 시키기
        // 그래서 필터에서 Configuration어노테이션이 붙은 것들은 미리 제외 시킨다.(지금까지 공부한 코드들을 다 지울 순 없어서 이렇게 제외시킴)
) // @Component 어노테이션이 붙은 스프링을 빈들을 자동으로 찾아서 컨테이너에 등록해음
public class AutoAppConfig {

}
