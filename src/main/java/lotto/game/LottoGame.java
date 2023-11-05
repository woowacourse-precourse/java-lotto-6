package lotto.game;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.WinLotto;
import lotto.util.InputManager;
import lotto.util.PrintManager;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos = new ArrayList<>();
    private WinLotto winLotto;
    private int money;
    private int[] prizeCount = new int[LottoPrize.values().length];


    public void play(){
        money = InputManager.getInputMoney();
        try {
            List<Integer> winNumbers = InputManager.getInputWinNumbers();
            int bonusNumber = InputManager.getInputBonusNumber();
            winLotto = new WinLotto(winNumbers, bonusNumber);
        }catch (IllegalArgumentException e){
            PrintManager.printIllegalArgumentExceptionWinLotto();
            play();
            return;
        }

        pickLottoNumbers();
        calculateResult();
    }

    private void calculateResult() {
        //TODO 결과 계산
        //TODO 결과 출력
    }

    private void pickLottoNumbers() {
        //TODO 금액 만큼의 번호 뽑고 로또 생성
    }

}
