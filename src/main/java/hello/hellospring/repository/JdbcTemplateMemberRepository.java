package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository {
/*
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateMemberRepository(Datasource datasource){
        this.jdbcTemplate = new JdbcTemplate();
    }*/

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findbyId(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findbyName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }
}
