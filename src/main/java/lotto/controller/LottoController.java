package lotto.controller;

import lotto.view.inputView;
public class LottoController {
    public void run() {
        //로또 구매
        buyLotto();

        //로또 추첨
            // 당첨번호 입력
            //보너스 번호 입력
        //추첨 결과
            //추첨 결과 안내
            //수익률 안내
    }
    public void buyLotto() {
        //구매 금액 입력
        String moneyForBuyLotto = inputView.getREQUEST_MONEY();
        System.out.println(moneyForBuyLotto);
        //수량으로 변환

        //수량만큼 로또 발행

    }
}
