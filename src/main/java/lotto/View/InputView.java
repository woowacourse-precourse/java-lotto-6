//InputView.java
package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String getPayInput(){
		System.out.println("구입금액을 입력해 주세요.");
		return Console.readLine();
	}

	public static String getWinningNumbersInput(){
		System.out.println("\n당첨 번호를 입력해 주세요.");
		return Console.readLine();
	}

	public static String getBonusNumberInput(){
		System.out.println("\n보너스 번호를 입력해 주세요.");
		return Console.readLine();
	}
}
