package lotto.io;

import java.util.List;

public interface PrintGenerator {

	void printInputMent(String keyword);
	void printPurchaseNumbers(List<List<Integer>> purchaseNumbers);
	void printWinningStatistics();
	void printBenefit(double benefit);



}
