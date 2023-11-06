package lotto.controller;

import lotto.view.*;
import lotto.model.*;
import lotto.exception.*;
public class LottoController {

    public int processInputPurchaseAmount() {
        int price;

        while (true) {
            price = LottoView.inputPurchaseAmount();
            if (Lotto.validateInputPurchaseAmount(price)) {
                break; // 유효한 금액이 입력되면 반복문 종료
            }

            try {
                Exceptions.exceptionInputPurchaseAmount(); // 예외 발생 및 에러 메시지 출력
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 예외 메시지 출력
            }
        }
        return price;
    }

}
