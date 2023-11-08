package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.exception.InvalidFormatException;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final Pattern MONEY_AND_BONUS_NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern LOTTO_NUMBER_PATTERN = Pattern.compile("\\d+(,\\d+)*");

    public Integer readMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String inputMoney = readInput();
        validateFormat(inputMoney, MONEY_AND_BONUS_NUMBER_PATTERN);
        return Integer.parseInt(inputMoney);
    }

    public List<Integer> readLottoNumbers() {
        System.out.println(INPUT_LOTTO_NUMBER_MESSAGE);
        String inputLottoNumbers = readInput();
        validateFormat(inputLottoNumbers, LOTTO_NUMBER_PATTERN);
        return Arrays.stream(inputLottoNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public Integer readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String inputBonusNumber = readInput();
        validateFormat(inputBonusNumber, MONEY_AND_BONUS_NUMBER_PATTERN);
        return Integer.parseInt(inputBonusNumber);
    }

    private void validateFormat(String inputValue, Pattern pattern) {
        if (!pattern.matcher(inputValue).matches()) {
            throw new InvalidFormatException();
        }
    }

    private String readInput() {
        return Console.readLine();
    }

}
