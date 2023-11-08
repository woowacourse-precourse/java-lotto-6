package lotto.view;

import static lotto.view.OutputView.printEmptyLine;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.WinningNumbersDto;
import lotto.util.Converter;
import lotto.util.validator.InputValidator;

public class InputView {
    private InputView() {
    }

    public static int inputPurchase() {
        return inputInteger("구입금액을 입력해 주세요.");
    }

    public static WinningNumbersDto inputWinningNumbers() {
        String rawWinningNumbers = inputString("당첨 번호를 입력해 주세요.");
        return WinningNumbersDto.from(rawWinningNumbers);
    }

    public static int inputBonusNumber() {
        return inputInteger("보너스 번호를 입력해 주세요.");
    }

    private static int inputInteger(String message) {
        String rawValue = inputString(message);
        InputValidator.validateNumber(rawValue);
        return Converter.convertToInt(rawValue);
    }

    private static String inputString(String message) {
        System.out.println(message);
        String rawValue = Console.readLine();
        printEmptyLine();
        InputValidator.validateNull(rawValue);
        return rawValue;
    }
}
