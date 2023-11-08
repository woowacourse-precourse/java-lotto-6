package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.Application;
import lotto.object.Lotto;

public class PlayerInput {
	public static void numberCheck(String inputNumber) {
		List<Integer> numbers = new ArrayList<Integer>();
		String[] splitInputNumber = inputNumber.split(",");

		try {
			for (int i = 0; i < splitInputNumber.length; i++) {
				int eachNumber = Integer.parseInt(splitInputNumber[i]);
				numbers.add(eachNumber);
			}
			Lotto playerLotto = new Lotto(numbers);
			Application.playerLotto = playerLotto;
		} catch (IllegalArgumentException e) {
			LottoStart.inputNumber();
		}
	}

	public static void bonusNumberCheck(int bonusLotto) {
		try {
			if (bonusLotto < 1 || bonusLotto > 45) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] 1부터 45 사이의 숫자 하나만 입력해 주세요.");
			LottoStart.inputBonusNumber();
		}
	}
}
