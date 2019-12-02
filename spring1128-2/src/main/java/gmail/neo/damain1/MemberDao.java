package gmail.neo.damain1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.neo.damain.Member;

//등록된 패키지 안에 있으면 Bean을 자동으로 생성해주는 어노테이션
@Repository
public class MemberDao {
@Autowired
	private SqlSession sqlSession;

	//데이터를 삽입하는 메소드
	public int insert(Member member) {
		return sqlSession.insert("member.insert", member);
	}
	
	//데이터를 수정하는 메소드
	public int update(Member member) {
		return sqlSession.update("member.update", member);
	}
	
	//전체 데이터를 가져오는 메소드
	public List<Member> allMember() {
		return sqlSession.selectList("member.allmember");
	}
	
	
}
