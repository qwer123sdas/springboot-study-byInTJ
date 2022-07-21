package hello.core.member;

public class MemberServiceImpl implements  MemberService{
    private final MemberRepository memberRepository;

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
}
