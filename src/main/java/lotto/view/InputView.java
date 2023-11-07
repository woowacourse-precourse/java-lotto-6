package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

	public static String inputAmountOfMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return Console.readLine();
	}

	public static List<Integer> inputLottoNumber() {
		System.out.println("당첨 번호를 입력해 주세요.");
		String[] stringLottoNumberList = Console.readLine()
				.split(",");
		List<Integer> lottoNumberList = new ArrayList<>();
		for (int i = 0; i < stringLottoNumberList.length; i++) {
			lottoNumberList.add(Integer.valueOf(stringLottoNumberList[i]));
		}
		return lottoNumberList;
	}

	public static int inputBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		return Integer.parseInt(Console.readLine());
	}
}
