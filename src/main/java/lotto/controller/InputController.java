package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.constant.Message;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.exceptions.ExceptionHandler;
import lotto.validator.ValidateObject;

public final class InputController {
    private InputController() {
    }

    public static Customer inputMoney() {
        Money money = ExceptionHandler.handleException(
                Message.INPUT_BUDGET,
                InputController::requestMoneyWithMessage
        );
        Customer customer = new Customer(money);
        customer.setLottos(customer.purchaseLotto());
        return customer;
    }

    public static Lotto inputWinningNumber() {
        return ExceptionHandler.handleException(
                Message.NULL,
                () -> {
                    List<Integer> numbers = ExceptionHandler.handleException(
                            Message.INPUT_WINNING_NUMBER,
                            InputController::requestLottoNumbersWithMessage
                    );
                    return new Lotto(numbers);
                }
        );
    }


    public static int inputBonusNumber(Lotto lotto) {
        return ExceptionHandler.handleException(
                Message.INPUT_BONUS_NUMBER,
                () -> {
                    int bonusNumber = parseIntWithMessage();
                    ValidateObject.validateBonusNumber(lotto, bonusNumber);
                    return bonusNumber;
                }
        );
    }

    private static Money requestMoneyWithMessage() {
        return new Money(parseIntWithMessage());
    }

    private static int parseIntWithMessage() {
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> requestLottoNumbersWithMessage() {
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
