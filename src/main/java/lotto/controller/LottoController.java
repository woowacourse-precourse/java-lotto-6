package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumberCandidateString;
import lotto.domain.Rank;
import lotto.domain.WinnerLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        NumberCandidateString numberCandidateString = new NumberCandidateString(InputView.collectionOfMoney());
        Integer amount = numberCandidateString.getNumber();
        Money money = Money.of(amount);
        Lottos lottos = Lottos.from(money.calcBillCount());
        OutputView.printPurchaseHistory(lottos.getList());

        String winningNumber = InputView.receiveWinningNumber();
        NumberCandidateStrings numberCandidateStrings = NumberCandidateStrings.valueOf(winningNumber.split(","));
        Lotto lotto = new Lotto(numberCandidateStrings.toLottoNumberList());

        NumberCandidateString bonusNumber = new NumberCandidateString(InputView.receiveBonusNumber());
        LottoNumber bounus = new LottoNumber(bonusNumber.getNumber());

        WinnerLotto winnerLotto = new WinnerLotto(lotto, bounus);
        List<Rank> result = lottos.chargeResult(winnerLotto);
        Money profit = result.stream().map(Rank::getMoney).reduce(Money.ZERO, Money::sum);
        Double profitRate = profit.calcProfitRate(money);

        HashMap<Rank, Integer> map = new HashMap<>();
        for(Rank rank:result){
            map.put(rank,map.getOrDefault(rank,0)+1);
        }

        OutputView.renderingResult(new ResultDto(map,profitRate));
    }

}
