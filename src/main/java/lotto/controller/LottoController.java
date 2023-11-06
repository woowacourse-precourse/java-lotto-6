package lotto.controller;

import java.util.*;
import lotto.view.*;
import lotto.model.*;
import lotto.exception.*;
public class LottoController {

    public int processInputPurchaseAmount() {
        int price;

        while (true) {
            price = LottoView.inputPurchaseAmount();
            if (Lotto.validateInputPurchaseAmount(price)) {
                // 유효한 금액이 입력되면 반복문 종료
                break;
            }

            try {
                // 예외 발생
                Exceptions.exceptionInputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                // 예외 메시지 출력
                System.out.println(e.getMessage());
            }
        }
        return price;
    }

    public void processCreateLotto(int price){
        // 구매한 개수 및 로또번호 리스트 출력
        List<Lotto> lottoList = Lotto.createLottoList(price);
        LottoView.printPurchaseResult(lottoList);
    }

}
