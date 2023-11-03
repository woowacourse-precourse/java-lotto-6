package lotto;

import camp.nextstep.edu.missionutils.*;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현

		// 로또 구입 금액을 입력받는 기능
		while (true) {
			System.out.println("구입금액을 입력해 주세요.");
			String input = Console.readLine();
			try {
				int price = Integer.parseInt(input);
				check1000Unit(price);
				break;

			} catch (NumberFormatException e) {
				System.out.println("[ERROR] 숫자를 입력해 주세요.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	// 1000원으로 나누어 떨어지는지 확인하는 메소드
	private static void check1000Unit(int price) {
		if ((price % 1000) != 0) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야합니다.");
		}
	}

}
