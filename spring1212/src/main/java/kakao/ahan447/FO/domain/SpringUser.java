package kakao.ahan447.FO.domain;


import lombok.Data;

@Data
public class SpringUser {
	private String email;
	private String pw;
	private String name;
	private String nickname;
	private String image;
	private String phone;
	private String hobby;
}