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
        for(int i = 0; i < money ; i+= 1000){
            Lotto lotto = makeLotto();
            lottos.add(lotto);
            PrintManager.printPickedLottoNumbers(lotto);
        }
    }

    private Lotto makeLotto() {
        Lotto lotto;
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        try{
            lotto = new Lotto(numbers);
        }catch (IllegalArgumentException e){
            return makeLotto();
        }
        return lotto;
    }

}
