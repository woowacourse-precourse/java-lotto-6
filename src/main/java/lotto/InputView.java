package lotto;

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
}
