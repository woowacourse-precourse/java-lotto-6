package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchase {
	private String amout;
	private int number;

	public int purchase() {
		System.out.println("구매금액을 입력해 주세요.");
		amout = Console.readLine();
		return Integer.parseInt(amout);
	}

	public int numberaCount() {
		number = purchase() / 1000;
		return number;

	}
	
	public void printButLotto() {
		
		System.out.println(numberaCount() + "개를 구매했습니다.");
}
}
