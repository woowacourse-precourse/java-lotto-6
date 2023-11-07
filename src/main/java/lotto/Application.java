package lotto;

import java.util.List;

import lotto.Lotto;

public class Application {
	public static void main(String[] args) {
		int user_input = Lotto.make_num();
		List<Integer>[] lotto = Lotto.make_lotto(user_input);

		int[] num = Lotto.get_num();
		int bonus = Lotto.get_bonus();

		int[] result = Lotto.compare_num(lotto, num);
		int[] boresult = Lotto.compare_bonus(lotto, bonus);

		int[] count = Lotto.make_result(result, boresult);
		Lotto.print_result(count);
		Lotto.print_percent(count, user_input);
	}
}
