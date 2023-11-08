package lotto.view;

import java.util.List;

public class OutputView {
    public static void promptForBuyAmount() {
        System.out.print(Message.FOR_BUY_AMOUNT.label());
    }

    public static void printLottoCnt(int lottoCnt) {
        System.out.println(String.format(Message.FOR_LOTTO_COUNT.label(), lottoCnt));
    }
    public static void printLottoList(List<Integer> numbers) {
        System.out.println(String.format(Message.FOR_LOTTO.label(),
                numbers.get(0), numbers.get(1), numbers.get(2),
                numbers.get(3), numbers.get(4), numbers.get(5)));
    }

    public static void promptForAnswerLottoNumbers() {
        System.out.println(Message.FOR_ANSWER_LOTTO_NUMBERS.label());
    }

    public static void promptForBonusNumber() {
        System.out.println(Message.FOR_BONUS_NUMBER.label());
    }
}
