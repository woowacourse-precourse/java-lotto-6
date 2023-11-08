package lotto.model;

import lotto.constant.LotteryRank;
import lotto.constant.LottoConstant;
import lotto.utils.LottoMachine;

import java.text.DecimalFormat;
import java.util.*;

public class Player {
    private List<Lotto> lottos;
    private Capital capital;

    public Player(Capital capital) {
        this.lottos = purchaseLotto(capital.getNumberOfPurchasedLotto());
        this.capital = capital;
    }

    private List<Lotto> purchaseLotto(int lottoCount) {
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

    private double calculateROI(List<LotteryRank> lotteryRanks) {
        double netReturn = lotteryRanks
                .stream()
                .mapToDouble(LotteryRank::getReward)
                .sum();
        int costOfInvestment = capital.amount();

        DecimalFormat df = new DecimalFormat("#.#");

        return Double.parseDouble(df.format(netReturn / costOfInvestment));
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

    protected void setLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    protected void setCapital(Capital capital) {
        this.capital = capital;
    }

    public void clearLotto() {
        this.lottos.clear();
    }
}
