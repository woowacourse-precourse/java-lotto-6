package lotto.view;

import static lotto.constant.LottoNumber.ZERO;
import static lotto.constant.message.ErrorMessage.NON_INTEGER_BONUS_NUMBER;
import static lotto.constant.message.ErrorMessage.NON_INTEGER_MONEY;
import static lotto.constant.message.ErrorMessage.NON_INTEGER_WINNING_NUMBER;
import static lotto.constant.message.InputMessage.BONUS_NUMBER;
import static lotto.constant.message.InputMessage.DELIMITER;
import static lotto.constant.message.InputMessage.PURCHASE_PRICE;
import static lotto.constant.message.InputMessage.WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static int requestPurchasePrice() {
        System.out.println(PURCHASE_PRICE);

        int money = ZERO.getNumber();
        try {
            Integer.parseInt(readNumber());
        } catch (NumberFormatException e) {
            System.out.println(NON_INTEGER_MONEY);
            requestPurchasePrice();
        }

        return money;
    }

    public static List<Integer> requestWinningNumber() {
        System.out.println(WINNING_NUMBER);

        List<Integer> winningNumbers = new ArrayList<>();
        try {
            winningNumbers = Arrays.stream(readNumber().split(DELIMITER.getMessage(), -1))
                            .map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println(NON_INTEGER_WINNING_NUMBER);
        }

        return winningNumbers;
    }

    public static int requestBonusNumber() {
        System.out.println(BONUS_NUMBER);

        int bonusNumber = ZERO.getNumber();
        try {
            Integer.parseInt(readNumber());
        } catch (NumberFormatException e) {
            System.out.println(NON_INTEGER_BONUS_NUMBER);
            requestBonusNumber();
        }

        return bonusNumber;
    }

    private static String readNumber() {
        return Console.readLine();
    }

}
