package lotto.view;

import static lotto.view.constants.ConstantMessage.ASK_LOTTO_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.constants.ConstantMessage;

public class GameView {
    public static String inputLottoPurchaseAmount() {
        printConstantMessage(ASK_LOTTO_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static void printConstantMessage(ConstantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }

    public static void printLottoCount(int lottoPurchaseCount) {
        printlnEmpty();
        System.out.printf("%d개를 구매했습니다.", lottoPurchaseCount);
        printlnEmpty();
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printlnEmpty() {
        System.out.println();
    }
}

