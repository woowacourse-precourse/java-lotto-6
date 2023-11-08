package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.dto.BonusNumberRequest;
import lotto.dto.LottosIssuanceResponse;
import lotto.dto.MatchResultResponse;
import lotto.dto.MoneyRequest;
import lotto.dto.RateOfReturnResponse;
import lotto.dto.WinningNumbersRequest;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Lottos lottos;
    private WinningLotto winningLotto;
    public LottoController() {
        start();
    }

    public void start() {
        createLottos();
        this.winningLotto = new WinningLotto(getNumbers(), getBonusNumber());
        Draw(winningLotto);
    }

    private void createLottos() {
        MoneyRequest moneyRequest = new MoneyRequest(InputView.readMoney());
        int count = moneyRequest.getMoney()/1000;
        this.lottos = new Lottos(count);
        OutputView.printLottosIssuance(new LottosIssuanceResponse(count,this.lottos));
    }

    private List<LottoNumber> getNumbers() {
        WinningNumbersRequest winningNumbersRequest = new WinningNumbersRequest(InputView.readWinningLotto());
        return winningNumbersRequest.getWinningLotto().getLotto();
    }

    private LottoNumber getBonusNumber() {
        BonusNumberRequest bonusNumberRequest = new BonusNumberRequest(InputView.readBonusNumber());
        return bonusNumberRequest.getBonusNumber();
    }

    private void Draw(WinningLotto money) {
        Map<Rank, Integer> rankCount = initializeRankCount();;
        List<Lotto> lottos = this.lottos.getLottos();
        for(Lotto lotto : lottos){
            int sameNumberCount = winningLotto.countSameNumber(lotto);
            if (isWinningLotto(sameNumberCount)) {
                Rank rank = winningLotto.calculateRank(lotto);
                rankCount.put(rank, rankCount.get(rank) + 1);
            }
        }
        MatchResultResponse matchResultResponse = new MatchResultResponse(rankCount);
        RateOfReturnResponse rateOfReturnResponse = new RateOfReturnResponse(this.lottos, rankCount);
    }

    public Map<Rank, Integer> initializeRankCount() {
        Map<Rank, Integer> rankResult = new HashMap<>();
        for(Rank rank: Rank.values()) {
            rankResult.put(rank, 0);
        }
        return rankResult;
    }

    public boolean isWinningLotto(int sameNumberCount) {
        if(sameNumberCount >= 3) {
            return true;
        }
        return false;
    }

    public Lottos getLottos() { return lottos; }




}
