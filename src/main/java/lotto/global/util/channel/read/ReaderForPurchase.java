package lotto.global.util.channel.read;

import camp.nextstep.edu.missionutils.Console;

import lotto.global.constant.ConstValue;
import lotto.global.exception.GlobalError;
import lotto.global.exception.GlobalException;
import lotto.global.util.channel.print.Printer;
import lotto.global.util.channel.base.DefaultReader;
import lotto.global.util.channel.validator.NumberValidator;

import lotto.presentation.message.Ask;

public class ReaderForPurchase extends NumberValidator implements DefaultReader {


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
            checkIsNumber(input);
            checkIsEnoughMoney(input);
            checkIsDivided(input);
            return true;
        } catch (GlobalException exception) {
            Printer.print(exception.getMessage());
            return false;
        }
    }

    /** 1,000원 이하인지 확인한다. */
    private void checkIsEnoughMoney(String input) {
        long amount = Long.parseLong(input);
        if (amount < ConstValue.LOTTO_PRICE) {
            throw new GlobalException(GlobalError.NOT_AVAILABLE_AMOUNT);
        }
    }


    /** 1,000원으로 나누어 떨어지는지 확인한다. */
    private void checkIsDivided(String input) {
        long amount = Long.parseLong(input);
        if (!(amount % ConstValue.LOTTO_PRICE == 0)) {
            throw new GlobalException(GlobalError.NOT_AVAILABLE_AMOUNT);
        }
    }
}
