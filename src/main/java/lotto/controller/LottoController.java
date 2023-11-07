package lotto.controller;

import static lotto.model.Lotto.*;
import static lotto.model.Lotto.validateInputWinningNumberInRange;
import static lotto.view.LottoView.*;

import java.util.*;
import lotto.view.*;
import lotto.model.*;
import lotto.exception.*;
public class LottoController {

    public int processInputPurchaseAmount() {
        int price;

            while (true) {
                price = inputPurchaseAmount();
                try {
                    // 입력 금액이 유효하면 종료
                    validateInputPurchaseAmount(price);
                    break; //
                } catch (IllegalArgumentException e) {
                    // 예외 메시지 출력
                    System.out.println(e.getMessage());
                }
            }
            return price;
    }

    public void processCreateLotto(int price){
        // 구매한 개수 및 로또번호 리스트 출력
        List<Lotto> lottoList = createLottoList(price);
        printPurchaseResult(lottoList);
    }

    public void processInputWinningNumber(){
        String inputWinningNumber;
        while (true) {
            inputWinningNumber= inputWinningNumber();
            try {
                // 입력 당첨 번호가 유효하면 종료
                String[] numberStrings=validateInputWinningNumberInRange(inputWinningNumber);
                validateInputWinningNumberDuplication(numberStrings);
                break; //
            } catch (IllegalArgumentException e) {
                // 예외 메시지 출력
                System.out.println(e.getMessage());
            }
        }
    }

}
