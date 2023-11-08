package lotto.io;

import java.util.List;

import lotto.enumContainer.LottoResult;


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
		System.out.println(generateResult(new StringBuilder()));
	}

	private String generateResult(StringBuilder resultBuilder) {
		resultBuilder.append("\n");
		resultBuilder.append("당첨 통계").append("\n");
		resultBuilder.append("---").append("\n");
		resultBuilder.append(LottoResult.THREE.getResultString()).append("\n");
		resultBuilder.append(LottoResult.FOUR.getResultString()).append("\n");
		resultBuilder.append(LottoResult.FIVE.getResultString()).append("\n");
		resultBuilder.append(LottoResult.FIVE_BONUS.getResultString()).append("\n");
		resultBuilder.append(LottoResult.SIX.getResultString());
		return resultBuilder.toString();
	}

	@Override
	public void printBenefit(double benefit) {
		System.out.println("총 수익률은 " + benefit + "%입니다.");
	}
}
