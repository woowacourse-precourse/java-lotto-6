package LottoNumber;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class LottoWinningNumbersInput {
	private static List<Integer> winninglist;

	public static List<Integer> inputLottoWinningNumbers() {
		System.out.println("당첨 번호를 입력해 주세요.");
		return inputLottoWinning(Console.readLine());

	}
	
	

	public static List<Integer> inputLottoWinning(String numberList) {
		String[] winningst;
		winninglist = new ArrayList<>();
		winningst = numberList.split(",");

		for (int i = 0; i < winningst.length; i++) {
			winninglist.add(conventInt(winningst[i]));
		}
		return winninglist;
	}
	
	public static int bonusNumber() {
		System.out.println();
		System.out.println("보너스 번호를 입력해 주세요.");
		return Integer.parseInt(Console.readLine());
	}

	private static int conventInt(String number) {

		return Integer.parseInt(number);

	}

}
