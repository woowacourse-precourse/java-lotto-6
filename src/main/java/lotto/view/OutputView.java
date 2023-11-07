package lotto.view;

import java.util.List;
import lotto.domain.LottoPurchase;

public class OutputView {

    private final int lottoPurchase;
    private final List<List<Integer>> randomNumbers;

    public OutputView(int lottoPurchase, List<List<Integer>> randomNumbers) {
        this.lottoPurchase = lottoPurchase;
        this.randomNumbers = randomNumbers;
    }

    public void showRandomNumbers() {
        for(int i = 0; i < lottoPurchase; i++) {
            System.out.println(randomNumbers.get(i));
        }
    }

}
