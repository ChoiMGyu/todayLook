package Yeungnam.YU.model;
//DTO(Data Transfer Object),VO : 웹 어플리케이션의 각 계층에 데이터를 교환하는 Model Object
//DTO가 VO를 포함하는 상위 개념

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@Data = @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode 포함하는 annotaion
//@RequiredArgsConstructor은 @NonNull에 대한 생성자를 생성
public class Member {
    
	private int id; //auto_increment primary key
	private String login_id; //아이디
	private String password; //패스워드
	private String email; //이메일 앞부분
	private String email_select; //이메일 뒷부분
	private String nickname; //닉네임
	private String department; //대학
	private String department_select; //학과
	private int gender; //성별
	private String memberPhone_sub; //전화번호 010
	private String memberPhone; //전화번호 뒤 8자리
	//CONCAT로 휴대전화번호 합치기
	
	public Member()
	{
		
	}
	
	public Member(String login_id, String password, String email, String email_select, String nickname,
			String department, String department_select, int gender, String memberPhone_sub, String memberPhone) {
		super();
		this.login_id = login_id;
		this.password = password;
		this.email = email;
		this.email_select = email_select;
		this.nickname = nickname;
		this.department = department;
		this.department_select = department_select;
		this.gender = gender;
		this.memberPhone_sub = memberPhone_sub;
		this.memberPhone = memberPhone;
	}

	public Member(String login_id, String password, String nickname)
	{
		this.login_id = login_id;
		this.password = password;
		this.nickname = nickname;
	}

}
