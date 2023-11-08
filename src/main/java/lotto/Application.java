package lotto;

import java.util.List;


public class Application {
	public static void main(String[] args) {
		int user_input = 0;
		while(user_input == 0) {
			user_input = Lotto.make_num();
		}
		
		List<Integer>[] lotto = null;
		while(lotto == null) {
			lotto = Lotto.make_lotto(user_input);
		}
		
		int[] num = null;
		while(num == null) {
			num = Lotto.get_num();
		}
		
		int bonus = Lotto.get_bonus();

		int[] result = Lotto.compare_num(lotto, num);
		int[] boresult = Lotto.compare_bonus(lotto, bonus);

		int[] count = Lotto.make_result(result, boresult);
		Lotto.print_result(count);
		Lotto.print_percent(count, user_input);
	}
}
