package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// 4가지 기능 만들기
public interface MemberRepository {
    // 1. 회원이 저장소에 저장
    Member save(Member member);
    // 2. id로 리스트 가져오기
    Optional<Member> findById(Long id);
    // 3. 이름으로 리스트 가져오기
    Optional<Member> findByName(String name);
    // 4. 모든 회원 리스트 반환
    List<Member> findAll();

}
