package lotto.validate;

import static lotto.view.LottoConsoleIn.inputBonusNumber;
import static lotto.view.LottoConsoleIn.inputNumberOfWinningNumbers;
import static lotto.view.LottoConsoleIn.inputPurchaseAmount;

import java.util.Arrays;
import java.util.List;


public class InputValidator {
    private List<Integer> list;

    private static final String ERROR_PREFIX = "[ERROR] ";

    public Long validatePurchaseAmount(String number){
        try{
            Long longNumber = validateCorrectLongFormat(number);
            validateNonNegativeLong(longNumber);
            validateDivideByThousand(longNumber);
            return longNumber;
        }catch (Exception e){
            System.out.println(ERROR_PREFIX+e.getMessage());
            return inputPurchaseAmount();
        }
    }

    private void validateDivideByThousand(Long longNumber){
        if (longNumber % 1000 != 0L){
            throw new IllegalArgumentException("1,000 단위의 구매 가격을 입력해주세요.");
        }
    }

    private Long validateCorrectLongFormat(String number) {
        try {
            return Long.parseLong(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력해주세요(범위 1,000~1,000,000,000)");
        }
    }




    private void validateNonNegativeLong(Long number) {
        if (number < 0) {
            throw new IllegalArgumentException("0 이상의 숫자를 입력해주세요.");
        }
    }


}


