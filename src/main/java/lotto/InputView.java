package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	int getPrice() {
		System.out.println("구입금액을 입력해 주세요.");
		int price = Integer.parseInt(Console.readLine());
		validatePrice(price);
		return price;
	}

	void validatePrice(int price) {

	}

	String getLottoNumber() {
		System.out.println("당첨 번호를 입력해 주세요.");
		String input = Console.readLine();
		validateLottoNumber(input);
		return input;
	}

	void validateLottoNumber(String input) {

	}

	int getBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		int bonusNumber = Integer.parseInt(Console.readLine());
		return bonusNumber;
	}
}
