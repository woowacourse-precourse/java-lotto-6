package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoPrice;
import lotto.validation.ErrorMessage;

public class InputView {

    public static LottoPrice inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            validateString(input);
            return new LottoPrice(Integer.parseInt(input));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPrice();
        }
    }

    public static void validateString(String inputString) {
        for(char c : inputString.toCharArray()){
            if(!Character.isDigit(c))
                throw new IllegalArgumentException(ErrorMessage.NOT_INTGER_ERROR.getMessage());
        }
    }
}
