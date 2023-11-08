package lotto.service;

import static lotto.constants.Constants.SEPARATOR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.WinningLotto;
import lotto.exception.DataTypeRangeException;
import lotto.validation.LottoNumberValidator;
import lotto.view.Input;
import lotto.view.Output;

public class WinningNumberService {

    private final Input input;

    public WinningNumberService() {
        this.input = new Input();
    }

    public WinningLotto fetchValidatedWinningNumber() {
        while (true) {
            try {
                Output.askWinningNumberEnter();
                String readLine = input.getReadLine();
                LottoNumberValidator.validateWinningNumberReadLine(readLine);
                return new WinningLotto(validateParseNumbers(readLine));
            } catch (IllegalArgumentException e) {
                Output.printErrorMessage(e);
            }
        }
    }

    private List<Integer> validateParseNumbers(String readLine) {
        try {
            return Arrays.stream(readLine.split(SEPARATOR)).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw DataTypeRangeException.dataTypeRangeException;
        }
    }
}
