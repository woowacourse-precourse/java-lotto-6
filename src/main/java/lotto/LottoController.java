package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final static Integer START = 0;
    private Lottos lottos;
    private BuyAmount buyAmount;
    private WinNumbers winNumbers;
    private BonusNumber bonusNumber;
    private WinResult winResult;

    public LottoController() {
        buyLotto();
        showLotto();
        inputLottoNumber();
        aggregateWinResult();
        showWinResult();
    }

    private void buyLotto() {
        Output.printBuyAmount();
        this.buyAmount = new BuyAmount(Input.user());
        List<Lotto> lottos = new ArrayList<>();
        for(int i = START; i < buyAmount.getBuyCount(); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
        this.lottos = new Lottos(lottos);

    }

    private void showLotto() {
        Output.printBuyCount(this.buyAmount.getBuyCount());
        for(Lotto lotto : this.lottos.getLottos()) {
            List<Integer> lottoNumber = lotto.getLotto();
            Output.printLottoNumber(Arrays
                    .toString(lottoNumber
                            .stream()
                            .mapToInt(Integer::intValue)
                            .toArray()));
        }
    }

    private void inputLottoNumber() {
        Output.printLottoWinNumber();
        String winNumberInput = Input.user();
        this.winNumbers = new WinNumbers(winNumberInput.split(","));
        Output.printLottoBonusNumber();
        String bonusNumberInput = Input.user();
        this.bonusNumber = new BonusNumber(bonusNumberInput);
    }

    private void aggregateWinResult() {
        winResult = new WinResult();
        for(Lotto lotto : this.lottos.getLottos()) {
            Rankings ranking = Rating.ranking(
                    lotto.getLotto(), winNumbers.getWinNumbers(), bonusNumber.getBonusNumber());
            winResult.setWinResult(ranking);
        }

    }

    private void showWinResult() {
        Output.printWinStatistics();
        Output.printSeperationLine();
        Map<Rankings, Integer> winResult = this.winResult.getWinResult();
        Output.printFifthRanking(winResult.get(Rankings.FIFTH));
        Output.printFourthRanking(winResult.get(Rankings.FOURTH));
        Output.printThirdRanking(winResult.get(Rankings.THIRD));
        Output.printSecondRanking(winResult.get(Rankings.SECOND));
        Output.printFirstRanking(winResult.get(Rankings.FIRST));
    }


}
