package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class OutputView {

    private final static String PRINT_BUY_AMOUNT = "%d개를 구매했습니다.\n";

    public void printLottoBundle(List<Lotto> lottoBundle) {
        int buyAmount = lottoBundle.size();
        List<Integer> numbers;

        printBuyAmount(buyAmount);
        for (Lotto lotto : lottoBundle) {
            numbers = lotto.getNumbers();
            printLotto(numbers);
        }
    }

    private void printLotto(List<Integer> numbers) {
        String numbersLine = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(numbersLine);
    }

    private void printBuyAmount(int buyAmount) {
        System.out.printf(PRINT_BUY_AMOUNT, buyAmount);
    }


}
