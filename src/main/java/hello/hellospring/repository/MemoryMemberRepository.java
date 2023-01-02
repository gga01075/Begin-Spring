package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

// 실질적인 사용될 기능의 코딩 영역
public class MemoryMemberRepository implements  MemberRepository{
    // key : 회원의 id, value: Member
    private static Map<Long, Member> store = new HashMap<>();
    // key값 생성해주는 애 0,1,2....
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
      member.setId(++sequence);
      store.put(member.getId(), member);
      return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
