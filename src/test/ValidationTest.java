package test;
import validation.Validation;;
public class ValidationTest {

	public static void main(String[] args) {

		System.out.println(Validation.MatchStuNo("13030990011"));
		System.out.println(Validation.MatchPassword("sadfasdfsa345"));
		System.out.println(Validation.MatchName("圣斗士"));
		System.out.println(Validation.MatchEmail("13030990011@qq.com"));
		System.out.println(Validation.MatchPhone("18826542654"));
		System.out.println(Validation.MatchBirthday("2013-02-29"));
		System.out.println(Validation.MatchSex("0"));
		System.out.println(Validation.MatchJob("5"));
	}

}
