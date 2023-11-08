package lotto.Controller;

import java.util.ArrayList;
import java.util.List;

import lotto.Model.Lotto;
import lotto.View.OutputView;
import static lotto.Constants.*;
import static lotto.Util.*;

public class LottoController {
    private Lotto winningLotto;
    private final List<Lotto> randomLotto = new ArrayList<>();
    private final List<Integer> resultLotto = new ArrayList<>();
    private int lottoCount;
    private int bonusNumber;
    private double lottoRate;
    private int BonusNumberMatchCount = 0;

    public LottoController() {
        set();
        matchingStart();
        rateCalculation();
        printResult();
    }

    public void set() {
        lottoCount = InputController.setLottoCount();
        for(int i = 0; i < lottoCount; i++){
            randomLotto.add(new Lotto (sortLottoNumbers(getRandomNum())));
        }
        OutputView.printPurchaseResult(randomLotto, lottoCount);
        winningLotto = InputController.setLotto();
        bonusNumber = InputController.setBonusNumber();
    }

    public void matchingStart() {
        for(int i = 0; i < lottoCount; i++){
            int matchCount = 0;
            for(int j = 0; j < Numbers.SIX.getValue(); j++){
                if(randomLotto.get(i).isSameNumber(winningLotto.getValue(j))){
                    matchCount++;
                }
            }
           resultLotto.add(matchCount);
        }
    }

    public void rateCalculation() {
        double total = 0;
        for(int i = 0; i < resultLotto.size(); i++){
            if(resultLotto.get(i) == Numbers.THREE.getValue()) {
                total = total +  5_000;
            }
            if(resultLotto.get(i) == Numbers.FOUR.getValue()) {
                total = total +  50_000;
            }
            if(resultLotto.get(i) == Numbers.FIVE.getValue()) {
                if(randomLotto.get(i).isSameNumber(bonusNumber)) {
                    total = total + 30_000_000;
                    BonusNumberMatchCount++;
                    continue;
                }
                total = total +  1_500_000;
            }
            if(resultLotto.get(i) == Numbers.SIX.getValue()) {
                total = total +  2_000_000_000;
            }
        }
        lottoRate = total / (lottoCount * PRICE_OF_LOTTO) * 100.0;
    }

    public void printResult() {
        OutputView.printWinningStatistics(resultLotto, BonusNumberMatchCount);
        OutputView.printReturnRate(Math.round(lottoRate * 10.0) / 10.0);
    }
}
