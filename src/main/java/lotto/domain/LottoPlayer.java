package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Application;

public class LottoPlayer {
	private static final int lottoPrice = 1000;
	public static void buyLotto() {
		System.out.println("구입 금액을 입력해 주세요.");
		String money = Console.readLine();
		Application.purchaseAmount = Integer.parseInt(money);
		lottoTicket(Application.purchaseAmount); // 티켓 구매 장 수 출력 함수 호출
	}
	
	public static void lottoTicket(int purchaseAmount) {
		Application.ticketNumber = purchaseAmount / lottoPrice;
		System.out.println(Application.ticketNumber + "개를 구매했습니다.");
	}
	
	public static void inputNumber() {
		System.out.println("당첨 번호를 입력해 주세요.(쉼표(,)로 구분하여 입력)");
		String inputNumber = Console.readLine();
		String[] splitInputNumber = inputNumber.split(","); 
		for (int i = 0; i < splitInputNumber.length; i++) {
			int eachNumber = Integer.parseInt(splitInputNumber[i]);
			Application.playerNumber.add(eachNumber);
		}
		System.out.println("보너스 번호를 입력해 주세요.");
		Application.playerBonusNumber = Integer.parseInt(Console.readLine());
	}
	
}
