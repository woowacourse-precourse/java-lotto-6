package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String PURCHASE_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println("\n" + WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println("\n" + BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }


}