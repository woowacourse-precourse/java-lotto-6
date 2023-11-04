package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;

import java.util.List;

public class InputView {
    public static final String USER_PURCHASE_PRICE_INPUT = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String WINNING_BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";

    public static int getPurchasePriceInput() {
        print(USER_PURCHASE_PRICE_INPUT);
        String money = Console.readLine();
        // TODO: 검증 로직 추가
        return Integer.parseInt(money);
    }
    public static List<Integer> getWinningNumberInput() {
        print(WINNING_NUMBERS_INPUT);

        String winningNumbers = Console.readLine();
        return Parser.parse(winningNumbers);
    }
    public static int getBonusNumberInput() {
        print(WINNING_BONUS_NUMBER_INPUT);

        // TODO: 검증 로직추가
        String bonus = Console.readLine();
        return Integer.parseInt(bonus);

    }
    private static void print(String message) {
        System.out.println(message);
    }


}
