package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.MatchResult;
import lotto.model.MyLottoNumbers;
import lotto.model.PurchasePrice;
import lotto.model.UniqueRandomNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final int ONE_LOTTO_PRICE = 1000;
    private PurchasePrice purchasePrice;
    private Lottos lottos;
    private MyLottoNumbers myLottoNumbers;
    private MatchResult matchResult = new MatchResult();

    public void start() {
        setPurchasePrice();
        makeSeveralLottos();
        makeMyLottoNumbers();
        compareLottos();
        OutputView.printEarningsRate(matchResult,purchasePrice);
    }

    private void setPurchasePrice() {
        purchasePrice = new PurchasePrice(InputView.inputPrice());
    }

    private Lotto makeLotto() {
        return new Lotto(new UniqueRandomNumbers().getNumbers());
    }

    private void makeSeveralLottos() {
        lottos = new Lottos();
        for (int nums = 0; nums < purchasePrice.countPurchasedLottos(); nums++) {
            lottos.add(makeLotto());
        }
        OutputView.printLottos(lottos);
    }

    private void makeMyLottoNumbers() {
        myLottoNumbers = new MyLottoNumbers(InputView.inputMyLottoNumbers());
        myLottoNumbers.setBonusNumber(InputView.inputBonusNumber());
        //System.out.println(myLottoNumbers.getMyNumbers());
        //System.out.println(myLottoNumbers.getBonusNumber());
    }

    private void compareLottos() {
        for (Lotto lotto : lottos.get()) {
            countingMatch(lotto.getSortedNumbers());
        }
        OutputView.printMatchResult(matchResult);
    }

    private void countingMatch(List<Integer> lottoNumbers) {
        int count = 0 ,bonus = 0;
        for (int myNumber : myLottoNumbers.getMyNumbers()) {
            if (lottoNumbers.contains(myNumber)) {
                count++;
            }
        }
        if (lottoNumbers.contains(myLottoNumbers.getBonusNumber())) {
            bonus++;
        }
        matchResult.setMatchCountByRank(count,bonus);
    }
}
