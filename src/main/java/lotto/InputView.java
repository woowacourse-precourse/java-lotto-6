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
				price = validatePriceIsNumber(input);
				validatePriceIsDivideBy1000(price);
				break;
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return price;
	}

	int validatePriceIsNumber(String input) {
		int price = 0;
		try {
			price = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력할 수 있습니다.");
		}
		return price;
	}

	void validatePriceIsDivideBy1000(int price) {
		if(price % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력해주세요.");
		}
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
