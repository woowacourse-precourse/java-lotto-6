package lotto.io;

import java.util.List;

public class PrintGeneratorImpl implements PrintGenerator{
	@Override
	public void printInputMent(String keyword) {
		if (keyword.equals("구입금액을")) {
			System.out.println(keyword+" 입력해 주세요.");
			return;
		}
		System.out.println();
		System.out.println(keyword+" 입력해 주세요.");
	}

	@Override
	public void printPurchaseNumbers(List<List<Integer>> purchaseNumbers) {
		System.out.println();
		System.out.println(purchaseNumbers.size() + "개를 구매했습니다.");
		purchaseNumbers.forEach(System.out::println);
	}

	@Override
	public void printWinningStatistics() {

	}

	@Override
	public void printBenefit() {

	}
}
