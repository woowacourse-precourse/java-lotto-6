package lotto.view;

import java.util.List;
import java.util.stream.Stream;
import camp.nextstep.edu.missionutils.Console;
import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.UserMoneyDto;
import lotto.dto.request.WinningNumbersDto;
import lotto.util.BlankValidator;
import lotto.util.DigitsOnlyValidator;
import lotto.util.DigitsWithCommaSeparatedValidator;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_FORMAT_EXCEPTION = "숫자(정수)형태의 문자열만 숫자로 변환할 수 있습니다.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public UserMoneyDto readUserMoney() {
        println(MONEY_INPUT_MESSAGE);
        String rawUserMoney = Console.readLine();
        printEmptyLine();
        validateUserMoney(rawUserMoney);
        int userMoney = convertToInt(rawUserMoney);
        return new UserMoneyDto(userMoney);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private void validateUserMoney(String rawMoney) {
        BlankValidator.validate(rawMoney);
        DigitsOnlyValidator.validate(rawMoney);
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    public WinningNumbersDto readWinningNumbers() {
        println(WINNING_NUMBER_INPUT_MESSAGE);
        String rawWinningNumber = Console.readLine();
        printEmptyLine();
        validateWinningNumber(rawWinningNumber);
        List<Integer> winningNumbers = splitToInt(WINNING_NUMBER_DELIMITER, rawWinningNumber);
        return new WinningNumbersDto(winningNumbers);
    }

    private void validateWinningNumber(String rawWinningNumber) {
        BlankValidator.validate(rawWinningNumber);
        DigitsWithCommaSeparatedValidator.validate(rawWinningNumber);
    }

    private List<Integer> splitToInt(String delimiter, String input) {
        return Stream.of(input.split(delimiter))
                .map(Integer::parseInt)
                .toList();
    }

    public BonusNumberDto readBonusNumber() {
        println(BONUS_NUMBER_INPUT_MESSAGE);
        String rawBonusNumber = Console.readLine();
        printEmptyLine();
        validateBonusNumber(rawBonusNumber);
        int bonusNumber = convertToInt(rawBonusNumber);
        return new BonusNumberDto(bonusNumber);
    }

    private void validateBonusNumber(String rawBonusNumber) {
        BlankValidator.validate(rawBonusNumber);
        DigitsOnlyValidator.validate(rawBonusNumber);
    }

    private static class LazyHolder {
        private static final InputView INSTANCE = new InputView();

    }
}
