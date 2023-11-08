package lottoBuy;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchase {
	private String amout;
	private int number;
	private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
	private static final String OUPUT_LOTTO_BYE = "개를 구매했습니다.";
	private static final int LOTTO_MIN_AMOUNT = 1000;

	public int purchase() {
		System.out.println(INPUT_LOTTO_AMOUNT);
		amout = Console.readLine();
		return Integer.parseInt(amout);
	}

	public void numberaCount() {
		number = purchase() / LOTTO_MIN_AMOUNT;

	}

	public int getNumber() {
		return number;
	}
	
	public int lottoMinAmout() {
		return LOTTO_MIN_AMOUNT;
	}

	public void printButLotto() {
		
		System.out.println();
		System.out.println(getNumber() + OUPUT_LOTTO_BYE);

	}
}
