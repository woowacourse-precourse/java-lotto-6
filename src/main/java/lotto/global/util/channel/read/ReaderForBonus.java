package lotto.global.util.channel.read;

import camp.nextstep.edu.missionutils.Console;

import lotto.global.exception.GlobalException;
import lotto.global.util.channel.print.Printer;
import lotto.global.util.channel.base.DefaultReader;
import lotto.global.util.channel.validator.LottoNumberValidator;

import lotto.presentation.message.Ask;

public class ReaderForBonus extends LottoNumberValidator implements DefaultReader {


    @Override
    public String read() {
        String input;
        do {
            Printer.print(Ask.WINNING_BONUS_NUMBER);
            input = Console.readLine();
        } while (!validate(input.trim()));
        return input;
    }

    @Override
    protected boolean validate(String input) {
        try {
            checkIsBlank(input);
            checkIsNumber(input);
            checkIsAvailableLottoNumber(input);
            return true;
        } catch (GlobalException exception) {
            Printer.print(exception.getMessage());
            return false;
        }
    }
}
