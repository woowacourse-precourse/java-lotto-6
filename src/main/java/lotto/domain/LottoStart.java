package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Application;

public class LottoStart {
	public static void startGame() {
		buyLotto();
    	inputNumber();
    	inputBonusNumber();
    	resultPrint();
	}
	
	public static void buyLotto() {
		System.out.println("구입 금액을 입력해 주세요.");
		String money = Console.readLine();
		LottoUtil.moneyCheck(money);
	}
	
	public static void inputNumber() {
		System.out.println("당첨 번호를 입력해 주세요.(쉼표(,)로 구분하여 입력)");
		String inputNumber = Console.readLine();
		LottoUtil.numberCheck(inputNumber);
	}
	
	public static void inputBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		Application.bonusNumber = Integer.parseInt(Console.readLine());
		LottoUtil.bonusNumberCheck(Application.bonusNumber);
	}
	
	public static void resultPrint() {
		LottoResult.lottoCompare(Application.lottoList);
		LottoResult.earningRateCaculator();
		LottoResult.resultContents();
	}
}
