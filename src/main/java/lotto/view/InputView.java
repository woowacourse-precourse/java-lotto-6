package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.ErrorCode;

public class InputView {
    public String inputMoney(){
        String input = Console.readLine();
        validateNotBlank(input);
        validateNumberic(input);
        return input;
    }
    public String inputWinningNumbers(){
        String input = Console.readLine();
        validateNotBlank(input);
        validateNumbericAndCommas(input);
        return input;
    }

    public String inputBonus(){
        String input = Console.readLine();
        validateNotBlank(input);
        validateNumberic(input);
        return input;
    }

    private void validateNotBlank(String input){
        if(input.isEmpty())
            throw new IllegalArgumentException(ErrorCode.INPUT_IS_NULL.getMessage());
    }

    private void validateNumbericAndCommas(String input){
        if(input.matches("[^0-9,]*"))
            throw new IllegalArgumentException(ErrorCode.IS_NOT_NUMBERIC_AND_COMMA.getMessage());
    }

    private void validateNumberic(String input){
        if(input.matches(".*\\D.*"))
            throw new IllegalArgumentException(ErrorCode.IS_NOT_NUMBERIC.getMessage());
    }
}
