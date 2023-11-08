package lotto.module.console.input.impl;

import lotto.module.console.input.ConsoleReader;
import lotto.module.console.input.validation.InputValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 콘솔에 입력하는 값을 읽어드리는 클래스
 */
public class ConsoleReaderImpl implements ConsoleReader {

    private final InputValidation inputValidation;
    private static final String SEPARATOR = ",";

    private ConsoleReaderImpl(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }

    public static ConsoleReaderImpl newInstance(InputValidation inputValidation) {
        return new ConsoleReaderImpl(inputValidation);
    }

    @Override
    public int readPurchaseAmount() {
        final String inputPurchaseAmount = readLine();
        inputValidation.validatePurchaseAmountString(inputPurchaseAmount);

        return Integer.parseInt(inputPurchaseAmount);
    }

    @Override
    public List<Integer> readWinningLottoNumbers() {
        final String inputWinningLottoNumbers = readLine();
        String[] numbers = inputWinningLottoNumbers.trim().split(SEPARATOR);

        return Arrays.stream(numbers)
                .peek(inputValidation::validateLottoNumbersRange)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public int readLottoBonusNumber() {
        final String inputLottoBonusNumber = readLine();
        inputValidation.validateLottoNumbersRange(inputLottoBonusNumber);

        return Integer.parseInt(inputLottoBonusNumber);
    }

}
