package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements  MemberService{
    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class)처럼 자동으로 주입해줌.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // 이를 통해 추상화에만 의존하게 된다.(= DIP를 지키게 됨)
    // 이를 생성자 주입이라고 한다.


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
