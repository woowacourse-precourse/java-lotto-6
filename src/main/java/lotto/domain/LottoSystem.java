package lotto.domain;

import lotto.config.Prize;
import lotto.domain.lotto.Lotto;
import lotto.domain.player.Player;
import lotto.dto.response.PrizeResponse;
import lotto.util.RandomUtil;

import java.util.*;

public class LottoSystem {

    private List<Lotto> winningLottos;
    private Player player;

    private LottoSystem(List<Lotto> winningLottos, Player player) {
        this.winningLottos = winningLottos;
        this.player = player;
    }

    public static LottoSystem create(List<Lotto> winningLottos, Player player) {
        return new LottoSystem(winningLottos, player);
    }

    public static List<Lotto> generateWinningLottos(int purchasedLottoCount) {
        List<Lotto> winningLottos = new ArrayList<>();
        for (int i = 0; i < purchasedLottoCount; i++) {
            winningLottos.add(generateWinningLotto());
        }
        return winningLottos;
    }

    private static Lotto generateWinningLotto() {
        return Lotto.create(RandomUtil.generateRandomLottoNumber());
    }

    private int getPurchasedLottoCount() {
        return player.getPurchasedLottoCount();
    }

    public List<PrizeResponse> getWinningResult() {
        List<Prize> winningPrizes = getWinningPrizes();
        Map<Prize, Integer> winningCounts = getWinningCountForEachPrize(winningPrizes);

        return winningCounts.entrySet().stream()
                .map(winningCount -> PrizeResponse.of(winningCount.getKey(), winningCount.getValue()))
                .toList();
    }

    private Map<Prize, Integer> getWinningCountForEachPrize(List<Prize> winningPrizes) {
        Map<Prize,Integer> winningCounts = new HashMap<>();
        for (Prize winningPrize : winningPrizes) {
            if (Arrays.asList(Prize.values()).contains(winningPrize)) {
                winningCounts.put(winningPrize, winningCounts.getOrDefault(winningPrize, 0) + 1);
            }
        }
        return winningCounts;
    }

    private List<Prize> getWinningPrizes() {
        List<Prize> prizes = new ArrayList<>();
        for (int i = 0; i < getPurchasedLottoCount(); i++) {
            Lotto winningLotto = winningLottos.get(i);
            int matchingNumberCount = getMatchingNumberCount(winningLotto);
            prizes.add(getWinningPrize(matchingNumberCount, hasBonusNumber(winningLotto)));
        }
        return prizes;
    }

    private Prize getWinningPrize(int matchingNumberCount, boolean hasBonusNumber) {
        if (matchingNumberCount == 5 && hasBonusNumber) {
            return Prize.FIVE_NUMBER_AND_BONUS_NUMBER_MATCH;
        }
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchingNumberCount() == matchingNumberCount)
                .findAny()
                .orElse(Prize.NONE);
    }

    private int getMatchingNumberCount(Lotto winningLotto) {
        return (int) winningLotto.getLottoNumbers()
                .stream()
                .filter(winningLottoNumber -> player.getLotto().getIntegerNumber().contains(winningLottoNumber.getLottoNumber()))
                .count();
    }

    private boolean hasBonusNumber(Lotto winningLotto) {
        return winningLotto.getLottoNumbers()
                .stream()
                .anyMatch(lottoNumber -> Objects.equals(lottoNumber.getLottoNumber(), player.getBonusNumber()));
    }

    public double calculateProfitRate(List<PrizeResponse> prizeResponses) {
        int purchaseAmount = player.getPurchaseAmount();
        int totalProfit = 0;
        for (PrizeResponse prizeResponse : prizeResponses) {
            totalProfit += prizeResponse.getPrizeMoney();
        }
        double value = ((double) totalProfit / purchaseAmount) * 100;
        return Math.round(value * 100.0) / 100.0;
    }
}
