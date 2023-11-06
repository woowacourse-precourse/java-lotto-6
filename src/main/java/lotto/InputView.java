package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	int getPrice() {
		int price = 0;
		while(true) {
			try {
				System.out.println("구입금액을 입력해 주세요.");
				String input = Console.readLine();
				price = validatePrice(input);
				break;
			} catch(IllegalArgumentException e) {
				System.out.println("[ERROR] 구입금액은 숫자만 입력 해주시기 바랍니다.");
			}
		}
		return price;
	}

	int validatePrice(String input) {
		int price = Integer.parseInt(input);
		return price;
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
