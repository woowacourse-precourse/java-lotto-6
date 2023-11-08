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
    // 숫자와 쉼표들 사이에는 공백은 허용되도록 패턴을 정의했습니다.
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

    /** 요구사항의 입력 패턴과 동일한지 검사합니다. */
    protected void checkIsPatternAvailable(String input) {
        if (!input.matches(AVAILABLE_PATTERN)) {
            throw new GlobalException(GlobalError.NOT_AVAILABLE_LOTTO_NUMBERS_PATTERN);
        }
    }

    /** 쉼표로 분리한 각각의 숫자들이 유효한지 검사합니다. */
    protected void checkIsEachNumberAvailable(String input) {
        for (String numberInput : input.split(AVAILABLE_SEPARATOR)) {
            // 순수 이름값에 대해서만 길이를 재기 위해 String.trim() 을 수행합니다.
            numberInput = numberInput.trim();
            checkIsBlank(numberInput);
            checkIsAvailableLottoNumber(numberInput);
        }

    }
}
