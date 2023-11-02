package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.ErrorMessage;
import lotto.global.ValidationUtils;

public class InputView {
    public static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public long getPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        String input = Console.readLine();
        numberValidation(input);
        return Long.parseLong(input);
    }
    private void numberValidation(String input){
        if(!ValidationUtils.NUMBER_CHECK_PATTERN.matcher(input).matches()){
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_INPUT_NUMBER.getMessage());
        }
    }
}
