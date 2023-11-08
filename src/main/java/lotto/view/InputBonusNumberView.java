package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ErrorMessage;
import lotto.common.SystemMessage;

import java.util.regex.Pattern;

public class InputBonusNumberView {
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public Integer inputBonusNumber(){
        System.out.println(SystemMessage.INPUT_MONEY.getMessage());
        String input = Console.readLine();
        System.out.println();
        validate(input);
        return Integer.parseInt(input);
    }

    private void validate(String inputValue){
        validateFormat(inputValue);
    }

    private void validateFormat(String inputValue){
        if(!PATTERN.matcher(inputValue).matches()){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
