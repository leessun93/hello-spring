package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import javax.sound.midi.Sequence;
import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    //시퀀스값 = id 자동채번 seq
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        //시퀀스는 자동채번
        member.setId(++sequence);
        //해시맵의 seq , 받아온 member(이름)
        store.put(member.getId(), member);
        //이름 반환
        return member;
    }

    @Override
    public Optional<Member> findbyId(Long id) {
        //isnull과 같이 null벨류를 컨트롤하기위함
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findbyName(String name) {
        //이건 공부좀 해야겠다.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        //실무시에는 List를 많이 쓴다.
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        //위에 선언한 필드를 리프레쉬하는 코드
        store.clear();
    }
}
