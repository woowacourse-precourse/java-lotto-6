package lotto.view;

import java.util.List;

public class OutputMessage {
    private OutputMessage() {
    }

    public static void purchasedLotto(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public static void showLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
