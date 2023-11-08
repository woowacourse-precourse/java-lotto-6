package lotto.model;

import lotto.constant.LotteryRank;
import lotto.constant.LottoConstant;
import lotto.utils.LottoMachine;

import java.util.*;

public class Player {
    private List<Lotto> lottos;
    private Capital capital;

    public Player(Capital capital) {
        this.lottos = getLottery(capital.getNumberOfPurchasedLotto());
        this.capital = capital;
    }

    private List<Lotto> getLottery(int lottoCount) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            result.add(new Lotto());
        }
        return result;
    }

    public WinningDetails getWinningDetails(LottoMachine lottoMachine) {
        List<LotteryRank> lotteryRanks = calculateLotteryRanks(lottoMachine);

        return new WinningDetails(getBreakdown(lotteryRanks), calculateROI(lotteryRanks));
    }

    private Map<LotteryRank, Integer> getBreakdown(List<LotteryRank> lotteryRanks) {
        Map<LotteryRank, Integer> result = new HashMap<>();

        LottoConstant.LOTTERY_RANKS
                .forEach(lotteryRank -> {
                    result.put(lotteryRank, Collections.frequency(lotteryRanks, lotteryRank));
                });

        return result;
    }

    private float calculateROI(List<LotteryRank> lotteryRanks) {
        long netReturn = lotteryRanks.stream().mapToLong(LotteryRank::getReward).sum();
        int costOfInvestment = capital.amount();

        return (float) netReturn / costOfInvestment;
    }

    private List<LotteryRank> calculateLotteryRanks(LottoMachine lottoMachine) {
        List<LotteryRank> result = new ArrayList<>();

        lottos.stream()
                .map(lotto -> {
                    int matchingNumbersCount = lotto.matchingNumbersCount(lottoMachine.getWinningLotto());
                    boolean containsBonusNumber = lotto.containsNumber(lottoMachine.getBonusNumber());
                    return new LotteryResult(matchingNumbersCount, containsBonusNumber);
                })
                .forEach(lotteryResult -> {
                    result.add(LotteryRank.getLotteryRank(lotteryResult));
                });

        return result;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }
}
