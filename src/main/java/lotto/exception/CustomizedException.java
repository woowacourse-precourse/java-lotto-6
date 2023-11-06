package lotto.exception;

import lotto.view.InputView;

public class CustomizedException{
    static final String ERROR_MESSAGE_INIT ="[ERROR]";
    public static void NotDivisibleByThousandException (int price){
        if(price%1000!=0||price==0){
            throw new IllegalArgumentException(ERROR_MESSAGE_INIT+"올바르지 않은 값입니다.다시 입력해주세요.");
        }
    }
}
