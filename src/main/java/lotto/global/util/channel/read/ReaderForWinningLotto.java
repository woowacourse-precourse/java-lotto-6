package lotto.global.util.channel.read;

import camp.nextstep.edu.missionutils.Console;

import lotto.global.exception.GlobalError;
import lotto.global.exception.GlobalException;
import lotto.global.util.channel.print.Printer;
import lotto.global.util.channel.base.DefaultReader;
import lotto.global.util.channel.validator.LottoNumberValidator;

import lotto.presentation.message.Ask;

public class ReaderForWinningLotto extends LottoNumberValidator implements DefaultReader {

    private static final String AVAILABLE_SEPARATOR = ",";
    private static final String AVAILABLE_PATTERN = "^(\\d{0,2}[\\s]*,)([\\s]*\\d{0,2}[\\s]*,)+([\\s]*\\d{0,2}[\\s]*)";


    @Override
    public String read() {
        String input;
        do {
            Printer.print(Ask.WINNING_NUMBERS);
            input = Console.readLine();
        } while (!validate(input));
        return input;
    }

    @Override
    protected boolean validate(String input) {
        try {
            checkIsBlank(input);
            checkIsPatternAvailable(input);
            checkIsEachNumberAvailable(input);
            return true;
        } catch (GlobalException exception) {
            Printer.print(exception.getMessage());
            return false;
        }
    }

    protected void checkIsPatternAvailable(String input) {
        if (!input.matches(AVAILABLE_PATTERN)) {
            throw new GlobalException(GlobalError.NOT_AVAILABLE_LOTTO_NUMBERS_PATTERN);
        }
    }

    protected void checkIsEachNumberAvailable(String input) {
        for (String numberInput : input.split(AVAILABLE_SEPARATOR)) {
            // 순수 이름값에 대해서만 길이를 재기 위해 String.trim() 을 수행합니다.
            numberInput = numberInput.trim();
            checkIsBlank(numberInput);
            checkIsAvailableLottoNumber(numberInput);
        }

    }
}
