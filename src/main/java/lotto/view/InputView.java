package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;
import lotto.view.validator.InputValidator;
import lotto.view.validator.UnitValidator;

import java.util.List;

public class InputView {
    public static final String USER_PURCHASE_PRICE_INPUT = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String WINNING_BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";

    public static int getPurchasePriceInput() {
        print(USER_PURCHASE_PRICE_INPUT);
        String money = Console.readLine();
        InputValidator.validMoneyType(money);

        int responseMoney = Integer.parseInt(money);

        UnitValidator.validUnitCheck(responseMoney);
        return responseMoney;
    }
    public static List<Integer> getWinningNumberInput() {
        print(WINNING_NUMBERS_INPUT);

        String winningNumbers = Console.readLine();
        return Parser.parse(winningNumbers);
    }
    public static int getBonusNumberInput() {
        print(WINNING_BONUS_NUMBER_INPUT);
        String bonus = Console.readLine();
        InputValidator.validBonusType(bonus);

        int numberBonus = Integer.parseInt(bonus);

        UnitValidator.validBonusUnitCheck(numberBonus);
        return numberBonus;

    }
    private static void print(String message) {
        System.out.println(message);
    }


}
