package lotto.view;

import java.util.List;

public class OutputView {
    public void displayticket(int ticket) {
        System.out.println(ticket + "개를 구매했습니다.");
    }

    public void displayLottiesNumber(List<List<Integer>> lottiesNumber) {
        for (List<Integer> numbers : lottiesNumber) {
            System.out.println(numbers);
        }
    }
}
