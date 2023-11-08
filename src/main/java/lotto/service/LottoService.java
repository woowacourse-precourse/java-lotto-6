package lotto.service;

import static lotto.global.constant.LottoNumber.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.global.constant.LottoNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTickets;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;

public class LottoService {
    private static final int THREE_MATCH_REWARDS = 5000;
    private static final int FOUR_MATCH_REWARDS = 50000;
    private static final int FIVE_MATCH_REWARDS = 1500000;
    private static final int FIVE_AND_BONUS_MATCH_REWARDS = 30000000;
    private static final int SIX_MATCH_REWARDS = 2000000000;

    public int calPurchaseQuantity(int purchaseAmount){
        return purchaseAmount / LOTTO_PRICE;
    }

    public LottoTickets createLottoTickets(int purchaseQuantity) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for(int i=0;i<purchaseQuantity;i++){
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                    LOTTO_NUMBER_COUNT);
            lottoTickets.add(new Lotto(randomNumbers));
        }
        return new LottoTickets(lottoTickets);
    }

    public WinningStatistic statisticWinningResult(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        List<LottoResult> lottoResults = lottoTickets.resultOfLottoTickets(winningNumbers);
        List<Integer> lottoResultCount = countLottoResult(lottoResults);
        WinningStatistic winningStatistic = makeWinningStatistic(lottoResultCount);

        return winningStatistic;
    }

    private List<Integer> countLottoResult(List<LottoResult> lottoResults) {
        List<Integer> lottoResultCount = new ArrayList<>(Collections.nCopies(8,0));

        for (LottoResult lottoResult : lottoResults) {
            int count = lottoResult.matchCount();
            if(lottoResult.matchCount() == 5){ //5개 일치와 [5개 일치+보너스 번호 일치] 구분 위함
                count += lottoResult.bonusMatchCount();
            }
            if (lottoResult.matchCount() == 6) { //6개 일치는 7개로 치환
                count++;
            }
            lottoResultCount.set(count, lottoResultCount.get(count)+1);
        }
        return lottoResultCount;
    }

    private WinningStatistic makeWinningStatistic(List<Integer> lottoResultCount) {
        return new WinningStatistic(lottoResultCount.get(3), lottoResultCount.get(4), lottoResultCount.get(5)
                , lottoResultCount.get(6), lottoResultCount.get(7));
    }

    public double calTotalReturn(int purchaseAmount, WinningStatistic winningStatistic) {
        double totalEarning = 0;
        totalEarning += winningStatistic.threeMatchCount() * THREE_MATCH_REWARDS;
        totalEarning += winningStatistic.fourMatchCount() * FOUR_MATCH_REWARDS;
        totalEarning += winningStatistic.fiveMatchCount() * FIVE_MATCH_REWARDS;
        totalEarning += winningStatistic.fiveAndBonusMatchCount() * FIVE_AND_BONUS_MATCH_REWARDS;
        totalEarning += winningStatistic.sixMatchCount() * SIX_MATCH_REWARDS;

        double totalReturn = (totalEarning / purchaseAmount) * 100;
        return makeRound(totalReturn);
    }

    private double makeRound(double num) {
        return (Math.round(num * 10.0) / 10.0);
    }
}
