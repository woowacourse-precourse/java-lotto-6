package lotto.view;

import java.util.List;
import java.util.stream.Stream;
import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.InvestmentMoneyDto;
import lotto.dto.request.WinningLottoNumbersDto;
import lotto.util.BlankValidator;
import lotto.util.CommaSeparatedNumbersValidator;
import lotto.util.DigitsOnlyValidator;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;

public class InputView {
    private static final String INVESTMENT_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_FORMAT_EXCEPTION = "숫자(정수)형태의 문자열만 숫자로 변환할 수 있습니다.";
    private static final String WINNING_LOTTO_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBERS_DELIMITER = ",";

    private final Reader reader;
    private final Printer printer;

    private InputView(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer);
    }

    public InvestmentMoneyDto readInvestmentMoney() {
        printer.printLine(INVESTMENT_MONEY_INPUT_MESSAGE);
        String rawInvestmentMoney = reader.readLine();
        printer.printEmptyLine();
        validateInvestmentMoney(rawInvestmentMoney);
        int investmentMoney = convertToInt(rawInvestmentMoney);
        return new InvestmentMoneyDto(investmentMoney);
    }

    private void validateInvestmentMoney(String rawInvestMoney) {
        BlankValidator.validate(rawInvestMoney);
        DigitsOnlyValidator.validate(rawInvestMoney);
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    public WinningLottoNumbersDto readWinningLottoNumbers() {
        printer.printLine(WINNING_LOTTO_NUMBERS_INPUT_MESSAGE);
        String rawWinningLottoNumbers = reader.readLine();
        printer.printEmptyLine();
        validateWinningNumbers(rawWinningLottoNumbers);
        List<Integer> winningLottoNumbers = splitToInt(WINNING_LOTTO_NUMBERS_DELIMITER, rawWinningLottoNumbers);
        return new WinningLottoNumbersDto(winningLottoNumbers);
    }

    private void validateWinningNumbers(String rawWinningNumbers) {
        BlankValidator.validate(rawWinningNumbers);
        CommaSeparatedNumbersValidator.validate(rawWinningNumbers);
    }

    private List<Integer> splitToInt(String delimiter, String input) {
        return Stream.of(input.split(delimiter))
                .map(Integer::parseInt)
                .toList();
    }

    public BonusNumberDto readBonusNumber() {
        printer.printLine(BONUS_NUMBER_INPUT_MESSAGE);
        String rawBonusNumber = reader.readLine();
        printer.printEmptyLine();
        validateBonusNumber(rawBonusNumber);
        int bonusNumber = convertToInt(rawBonusNumber);
        return new BonusNumberDto(bonusNumber);
    }

    private void validateBonusNumber(String rawBonusNumber) {
        BlankValidator.validate(rawBonusNumber);
        DigitsOnlyValidator.validate(rawBonusNumber);
    }

}
