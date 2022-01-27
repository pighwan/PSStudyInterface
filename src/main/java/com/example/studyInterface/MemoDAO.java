package com.example.studyInterface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
// import org.springframework.stereotype.Repository;

// @Repository root.context에 <mybatis-spring:scan base-package="com.example.studyInterface" /> 요거 해줘서 굳이 안해도됨
public interface MemoDAO {
	
	@Select("select * from memo order by idx desc")
	List<MemoDTO> list(); // 일케 하면 xml 파일을 따로 작성할 필요가 엄슴! 인터페이스로 선언
	
	@Insert("insert into memo (idx, writer, memo) values ((select nvl(max(idx)+1, 1) from memo), #{writer}, #{memo}")
	public void insert(@Param("writer") String writer, @Param("memo") String memo); // MyBatis랑 연결할때는 @Param이라는 어노테이션 사용
	
	@Select("select * from memo where idx = #{idx}")
	public MemoDTO view(@Param("idx") int idx);
	
	@Update("update memo set writer = #{writer}, memo = #{memo} where idx = #{idx}")
	public void update(MemoDTO dto);
	
	@Delete("delete from memo where idx = #{idx}")
	void delete(@Param("idx") int idx);
	
	
} // interface
