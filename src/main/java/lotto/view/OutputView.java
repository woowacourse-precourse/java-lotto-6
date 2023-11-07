package lotto.view;

import java.util.List;

public class OutputView {
    public void displayticket(int ticket) {
        System.out.println(ticket + "개를 구매했습니다.");
    }

    public void displayLottosNumber(List<List<Integer>> lottosNumber) {
        for (List<Integer> numbers : lottosNumber) {
            System.out.println(numbers);
        }
    }
}
