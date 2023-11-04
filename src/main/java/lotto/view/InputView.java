package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern LOTTO_PATTERN = Pattern.compile("^-?\\d+(\\s*,\\s*-?\\d+)*$");
    private static final Pattern NUMBER = Pattern.compile("^-?\\d+$");

    private InputView() {
    }

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readInput();
    }

    public static String inputWinningLottoNumbers() {
        printLottoNumbers();
        final String lottoNumbers = readInput();
        validateLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    public static int inputBonusLottoNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        final String bonusNumber = readInput();
        validateIsNumeric(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void validateIsNumeric(final String bonusNumber) {
        if (!NUMBER.matcher(bonusNumber).matches()) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    private static void printLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private static void validateLottoNumbers(final String lottoNumbers) {
        if (!LOTTO_PATTERN.matcher(lottoNumbers).matches()) {
            throw new IllegalArgumentException("[1,2,3,4,5,6] 같은 형식으로 숫자만 입력해주세요.");
        }
    }

    private static String readInput() {
        return Console.readLine();
    }
}
