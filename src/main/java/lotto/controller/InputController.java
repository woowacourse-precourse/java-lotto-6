package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Money;
import lotto.validator.ExceptionHandler;

public final class InputController {
    private InputController() {}

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
        LottoNumber lottoNumber = new LottoNumber();
        String numbers = ExceptionHandler.handleException(
                Message.INPUT_WINNING_NUMBER,
                InputController::readLineWithMessage
        );
        lottoNumber.createWinningNumber(numbers);
        return new Lotto(lottoNumber.getLottoNumbers());
    }

    public static int inputBonusNumber() {
        return ExceptionHandler.handleException(
                Message.INPUT_BONUS_NUMBER,
                InputController::parseIntWithMessage
        );
    }

    private static Money requestMoneyWithMessage() {
        return new Money(parseIntWithMessage());
    }

    private static String readLineWithMessage() {
        return Console.readLine();
    }

    private static int parseIntWithMessage() {
        return Integer.parseInt(Console.readLine());
    }
}
