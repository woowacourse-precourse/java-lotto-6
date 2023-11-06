package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.view.InputView;

public class LottoGame {
    private Money money;
    private Lotto lotto; // 당첨 번호
    private Bonus bonus; // 보너스 번호

    public void run(){
        start();
        end();
    }

    private void start(){
        money = InputView.LoopInputMoney();
        // 사용자 로또 출력
        lotto = InputView.LoopInputSixNumbers();
        bonus = InputView.LoopInputBonusNumber(lotto);
        // 게임 종료
        end();
    }

    private void end(){

    }


}