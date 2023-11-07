package lotto.controller.handler;

import lotto.exception.AmountException;
import lotto.exception.LottoNumberException;

import java.util.List;

public class ExceptionHandler {
    public void handlePurchaseAmountException(String input){
        AmountException amountException = new AmountException();

        amountException.checkBlank(input);             //빈칸 입력
        amountException.checkEmptySpace(input);        //공백
        amountException.checkPositiveInteger(input);   //자연수
        amountException.checkOutOfIntegerRange(input); //정수 범위
        amountException.checkLessThanMaxAmount(input); //구매금액의 최댓값
        amountException.checkThousandUnits(input);     //1,000단위 입력
    }

    public void handleLottoNumberException(String input) {
        LottoNumberException lottoNumberException = new LottoNumberException();
        List<String> numbers = List.of(input.split(","));

        lottoNumberException.checkBlank(input);         //빈값 입력
        lottoNumberException.checkEndWithNumber(input); //[1,2,3,4,5,6,] 입력시 예외발생
        lottoNumberException.checkSixInputs(numbers);    //6개 입력
        lottoNumberException.checkSixNumbers(numbers);   //6개 숫자
        lottoNumberException.checkDuplicate(numbers);    //중복 검사
    }
}
