package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Util;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.NUM_COUNT;
import static lotto.Util.getRandomNum;
import static lotto.Util.sortLottoNumbers;

public class LottoController {
    private Lotto winningLotto;
    private final List<Lotto> randomLotto = new ArrayList<>();
    private final List<Integer> resultLotto = new ArrayList<>();
    private int lottoCount;
    private int bonusNumber;
    private double lottoRate;
    private List<Boolean> isBonusNumberMatch;

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
            for(int j = 0; j < NUM_COUNT; j++){
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
            if(resultLotto.get(i) == 3) {
                total = total +  5_000;
            }
            if(resultLotto.get(i) == 4) {
                total = total +  50_000;
            }
            if(resultLotto.get(i) == 5) {
                if(randomLotto.get(i).isSameNumber(bonusNumber)) {
                    total = total + 30_000_000;
                    continue;
                }
                total = total +  1_500_000;
            }
            if(resultLotto.get(i) == 6) {
                total = total +  2_000_000_000;
            }
        }
        lottoRate = total / (lottoCount * 1000.0) * 100.0;
    }

    public void printResult() {
        OutputView.printWinningStatistics(resultLotto);
        OutputView.printReturnRate(Math.round(lottoRate * 100.0) / 100.0);
    }
}
