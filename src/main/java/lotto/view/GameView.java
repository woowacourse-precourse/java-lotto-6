package lotto.view;

import static lotto.view.constants.ConstantMessage.ASK_LOTTO_PURCHASE_AMOUNT;
import static lotto.view.constants.ConstantMessage.ASK_WINNING_LOTTO_BONUS_NUMBER;
import static lotto.view.constants.ConstantMessage.ASK_WINNING_LOTTO_NUMBERS;
import static lotto.view.constants.ConstantMessage.DISPLAY_LOTTO_PURCHASE_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.constants.ConstantMessage;

public class GameView {
    public static void printConstantMessage(ConstantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }

    public static String inputLottoPurchaseAmount() {
        printConstantMessage(ASK_LOTTO_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static void printLottoCount(int lottoPurchaseCount) {
        printlnEmpty();
        System.out.print(lottoPurchaseCount);
        printConstantMessage(DISPLAY_LOTTO_PURCHASE_COUNT);
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static String inputLottoNumbers() {
        printlnEmpty();
        printConstantMessage(ASK_WINNING_LOTTO_NUMBERS);
        return Console.readLine();
    }

    public static String inputLottoBonusNumber() {
        printlnEmpty();
        printConstantMessage(ASK_WINNING_LOTTO_BONUS_NUMBER);
        return Console.readLine();
    }

    public static void printlnEmpty() {
        System.out.println();
    }

}

