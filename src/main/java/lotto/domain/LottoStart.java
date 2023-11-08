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
		LottoGenerate.moneyCheck(money);
	}

	public static void inputNumber() {
		System.out.println("당첨 번호를 입력해 주세요.(쉼표(,)로 구분하여 입력)");
		String inputNumber = Console.readLine();
		PlayerInput.numberCheck(inputNumber);
	}

	public static void inputBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		Application.bonusLotto = Integer.parseInt(Console.readLine());
		PlayerInput.bonusNumberCheck(Application.bonusLotto);
	}

	public static void resultPrint() {
		LottoResult.lottoCompare();
		LottoResult.earningRateCaculator();
		LottoResult.resultContents();
	}
}
