package lotto.controller;

import lotto.util.InputVaildate;
import lotto.view.inputView;
public class LottoController {
    InputVaildate inputVaildate = new InputVaildate();
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
        int moneyForBuyLotto = Integer.parseInt(inputView.getREQUEST_MONEY());
        InputVaildate.moneyVaildate(moneyForBuyLotto);

        //수량으로 변환

        //수량만큼 로또 발행

    }
}
