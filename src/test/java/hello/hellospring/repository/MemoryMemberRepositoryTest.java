package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    //레파짓토리 그대로 가져온다
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //클리어 코드 생성 @AfterEach 만 생성하면 테스트코드 전체 실행시 각 함수 실행 후 초기화해준다.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    //테스트 꼭 붙인다.
    @Test
    public void save(){
        //맴버클래스 가져오기
        Member member = new Member();
        //임의의 이름 세팅
        member.setName("spring");

        //레파짓토리의 세이브
        repository.save(member);
        //레파짓토리의 파인드
        Member result = repository.findbyId(member.getId()).get();//옵셔널에서 데이터 꺼낼떄는 ,get()을 해주어야하다.

        //System.out.println("result =" + (result == member));
        //쥬피터
        Assertions.assertEquals(member, result);
        //어썰트J 요즘 요로케씀
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findbyName("spring1").get();

        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
