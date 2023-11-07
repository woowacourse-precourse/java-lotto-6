package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.exception.NonNumberException;
import lotto.exception.lotto.LottoFormatException;

public class InputView {
    private static final Pattern LOTTO_PATTERN = Pattern.compile("^-?\\d+(\\s*,\\s*-?\\d+)*$");
    private static final Pattern NUMBER = Pattern.compile("^-?\\d+$");
    private static final String INPUT_PRICE_MSG = "구입금액을 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MSG = "당첨 번호를 입력해 주세요.";

    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(INPUT_PRICE_MSG);
        return readInput();
    }

    public static String inputWinningLottoNumbers() {
        printLottoNumbers();
        final String lottoNumbers = readInput();
        validateLottoNumbers(lottoNumbers);
        printSpace();
        return lottoNumbers;
    }

    public static int inputBonusLottoNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MSG);
        final String bonusNumber = readInput();
        validateIsNumeric(bonusNumber);
        printSpace();
        return Integer.parseInt(bonusNumber);
    }

    private static void validateIsNumeric(final String bonusNumber) {
        if (!NUMBER.matcher(bonusNumber).matches()) {
            throw new NonNumberException();
        }
    }

    private static void printLottoNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MSG);
    }

    private static void validateLottoNumbers(final String lottoNumbers) {
        if (!LOTTO_PATTERN.matcher(lottoNumbers).matches()) {
            throw new LottoFormatException();
        }
    }

    private static String readInput() {
        return Console.readLine();
    }

    private static void printSpace() {
        System.out.println();
    }
}