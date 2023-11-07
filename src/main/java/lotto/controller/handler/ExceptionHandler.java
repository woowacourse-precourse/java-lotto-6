package lotto.controller.handler;

import lotto.exception.AmountException;
import lotto.exception.LottoNumberException;

import java.util.List;

public class ExceptionHandler {
    public void handlePurchaseAmountException(String input) {
        AmountException exception = new AmountException();

        exception.checkBlank(input);             //빈칸 입력
        exception.checkEmptySpace(input);        //공백
        exception.checkPositiveInteger(input);   //자연수
        exception.checkOutOfIntegerRange(input); //정수 범위
        exception.checkLessThanMaxAmount(input); //구매금액의 최댓값
        exception.checkThousandUnits(input);     //1,000단위 입력
    }

    public void handleLottoNumbersException(String input) {
        LottoNumberException exception = new LottoNumberException();
        List<String> numbers = List.of(input.split(","));

        exception.checkBlank(input);         //빈값 입력
        exception.checkEndWithNumber(input); //[1,2,3,4,5,6,] 입력시 예외발생
        exception.checkSixInputs(numbers);    //6개 입력
        exception.checkSixNumbers(numbers);   //6개 숫자
        exception.checkDuplicate(numbers);    //중복 검사
    }

    public void handleBonusNumberException(String input) {
        LottoNumberException exception = new LottoNumberException();

        exception.checkBlank(input);        //빈칸
        exception.checkInteger(input);      //한 자리 숫자
        exception.checkLottoNumber(input);  //범위
    }
}
