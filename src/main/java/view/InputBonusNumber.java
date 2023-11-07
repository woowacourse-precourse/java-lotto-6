package view;

import message.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputBonusNumber{
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final String INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Integer inputBonusNumber() {
        System.out.println(INPUT_MESSAGE);
        String bonusNumber = Console.readLine();
        System.out.println();
        validate(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private void validate(String bonusNumber) {
        validateFormat(bonusNumber);
    }

    private void validateFormat(String bonusNumber) {
        if (!PATTERN.matcher(bonusNumber).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_ERROR);
        }
    }
}