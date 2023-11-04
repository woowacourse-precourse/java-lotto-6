package lotto.domain;

public class PurchaseNumber {

	public static int buyCount(int buyAmount) {

		int lottoCount = buyAmount / 1000;
		return lottoCount;
	}
}
