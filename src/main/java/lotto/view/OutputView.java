package lotto.view;

import static lotto.constant.GameMessage.*;

import java.util.List;

import lotto.domain.Lotto;

public class OutputView {
	public static void printLottos(int amount, List<Lotto> lotts) {
		System.out.println(String.format(PRINT_LOTTO_AMOUNT, amount));

		for(Lotto lotto : lotts) {
			System.out.println(lotto.getNumbers());
		}
	}
}
