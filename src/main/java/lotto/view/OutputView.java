package lotto.view;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.controller.Result;

public class OutputView {
    public static void promptForBuyAmount() {
        System.out.print(Message.FOR_BUY_AMOUNT.label());
    }

    public static void printLottoCnt(int lottoCnt) {
        System.out.printf((Message.FOR_LOTTO_COUNT.label()) + "%n", lottoCnt);
    }

    public static void printLottoList(List<Integer> numbers) {
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);
        System.out.printf((Message.FOR_LOTTO.label()) + "%n",
                mutableNumbers.get(0), mutableNumbers.get(1), mutableNumbers.get(2),
                mutableNumbers.get(3), mutableNumbers.get(4), mutableNumbers.get(5)
        );
    }

    public static void promptForAnswerLottoNumbers() {
        System.out.println(Message.FOR_ANSWER_LOTTO_NUMBERS.label());
    }

    public static void promptForBonusNumber() {
        System.out.println(Message.FOR_BONUS_NUMBER.label());
    }

    public static void printResults(List<Result> results) {
        System.out.println(Message.FOR_RESULT.label());

        for (Result result : results) {
            System.out.printf((Message.FOR_LOTTO_RESULT.label()) + "%n", result.label(), result.cnt());
        }
    }

    public static void printBenefits(double benefit) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        numberFormat.setMinimumFractionDigits(1);
        String formattedNumber = numberFormat.format(benefit);
        System.out.printf(Message.FOR_BENEFIT_RESILT.label(), formattedNumber);
    }
}
