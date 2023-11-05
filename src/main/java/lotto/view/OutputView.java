package lotto.view;

import java.util.List;

public class OutputView {
    private final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public void printLottoAmount(int amountOfLotto) {
        printEmptyLine();
        System.out.println(amountOfLotto + LOTTO_AMOUNT_MESSAGE);
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
