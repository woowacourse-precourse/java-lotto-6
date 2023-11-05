package lotto.global.util.channel.read;

import camp.nextstep.edu.missionutils.Console;

import lotto.global.exception.GlobalError;
import lotto.global.exception.GlobalException;
import lotto.global.util.channel.print.Printer;
import lotto.global.util.channel.base.DefaultReader;
import lotto.global.util.channel.validator.NumberValidator;

import lotto.presentation.message.Ask;

public class ReaderForPurchase extends NumberValidator implements DefaultReader {

    private static final int AMOUNT_LOWER_LIMIT = 1_000;

    @Override
    public String read() {
        String input;
        do {
            Printer.print(Ask.PAYMENT_AMOUNT);
            input = Console.readLine();
        } while (!validate(input));
        return input;
    }

    @Override
    protected boolean validate(String input) {
        try {
            checkIsBlank(input);
            checkIsEnoughMoney(input);
            return true;
        } catch (GlobalException exception) {
            Printer.print(exception.getMessage());
            return false;
        }
    }

    /** 1,000원 이하인지 확인한다. */
    private void checkIsEnoughMoney(String input) {
        checkIsNumber(input);
        long amount = Long.parseLong(input);
        if (amount < AMOUNT_LOWER_LIMIT) {
            throw new GlobalException(GlobalError.NOT_ENOUGH_MONEY);
        }
    }
}
