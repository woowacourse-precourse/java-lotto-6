package lotto.domain.lottoManage;

import lotto.config.Prize;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.PlayerLotto;
import lotto.dto.response.PrizeResponse;
import lotto.util.RandomUtil;

import java.util.*;

public class LottoManager {

    private List<Lotto> winningLottos;
    private PlayerLotto playerLotto;

    private LottoManager(List<Lotto> winningLottos, PlayerLotto playerLotto) {
        this.winningLottos = winningLottos;
        this.playerLotto = playerLotto;
    }

    public static LottoManager create(List<Lotto> winningLottos, PlayerLotto playerLotto) {
        return new LottoManager(winningLottos, playerLotto);
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
        return playerLotto.getPurchasedLottoCount();
    }

    public List<PrizeResponse> getWinningResult() {
        List<Prize> winningPrizes = getWinningPrizes(playerLotto);
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

    private List<Prize> getWinningPrizes(PlayerLotto playerLotto) {
        List<Prize> prizes = new ArrayList<>();
        for (int i = 0; i < getPurchasedLottoCount(); i++) {
            Lotto winningLotto = winningLottos.get(i);
            int matchingNumberCount = winningLotto.getMatchingNumberCount(playerLotto.getLotto());
            prizes.add(getWinningPrize(matchingNumberCount, winningLotto.hasBonusNumber(playerLotto.getBonusNumber())));
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

    public double calculateProfitRate(List<PrizeResponse> prizeResponses) {
        int purchaseAmount = playerLotto.getPurchaseAmount();
        int totalProfit = 0;
        for (PrizeResponse prizeResponse : prizeResponses) {
            totalProfit += prizeResponse.getPrizeMoney();
        }
        double value = ((double) totalProfit / purchaseAmount) * 100;
        return Math.round(value * 100.0) / 100.0;
    }
}
