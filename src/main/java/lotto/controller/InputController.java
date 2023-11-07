package lotto.controller;

import static lotto.view.View.printMessage;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constant.Message;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Money;

final class InputController {
    private InputController() {}

    interface InputSupplier<T, E extends Exception> {
        T get() throws E;
    }

    private static <T, E extends Exception> T getInputWithRetry(
            Message message,
            InputSupplier<T, E> supplier) throws E {
        while (true) {
            try {
                printMessage(message.getMessage());
                return supplier.get();
            } catch (Exception e) {
                if (e instanceof NumberFormatException) {   // 따로 Exception으로 빼기
                    System.out.print("[ERROR]");
                    readLineWithMessage();
                } else {
                    throw e; // 예외 종류가 일치하지 않으면 다시 던짐
                }
            }
        }
    }

    public static Customer inputMoney() {
        Money money = getInputWithRetry(
                Message.INPUT_BUDGET,
                InputController::requestMoneyWithMessage
        );
        Customer customer = new Customer(money);
        customer.setLottos(customer.purchaseLotto());
        return customer;
    }

    public static Lotto inputWinningNumber() {
        LottoNumber lottoNumber = new LottoNumber();
        String numbers = getInputWithRetry(
                Message.INPUT_WINNING_NUMBER,
                InputController::readLineWithMessage
        );
        lottoNumber.createWinningNumber(numbers);
        return new Lotto(lottoNumber.getLottoNumbers());
    }

    public static int inputBonusNumber() {
        return getInputWithRetry(
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
