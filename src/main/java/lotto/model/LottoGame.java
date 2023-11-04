package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.vo.BonusNumber;

public class LottoGame {

    private final Player player;
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private LottoGame(final Player player, final Lotto winningLotto, final BonusNumber bonusNumber) {
        this.player = player;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoGame createGame(final Player player, final Lotto lotto, final BonusNumber bonusNumber) {
        return new LottoGame(player, lotto, bonusNumber);
    }

    public Map<LottoRank, Integer> calculateScore() {
        Map<LottoRank, Integer> playerRank = new HashMap<>();

        List<Lotto> playerLotteries = player.getLotteries();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        playerLotteries.forEach(playerLotto ->
                calculateEachLotto(playerRank, winningNumbers, playerLotto));

        return playerRank;
    }

    private void calculateEachLotto(Map<LottoRank, Integer> playerRank,
                                    List<Integer> winningNumbers,
                                    Lotto playerLottery) {
        List<Integer> playerNumbers = playerLottery.getNumbers();
        LottoRank rank = determineRank(countMatchedNumber(winningNumbers, playerNumbers),
                containBonusNumber(bonusNumber, playerNumbers));
        
        playerRank.put(rank, playerRank.getOrDefault(rank, 0) + 1);
    }

    private LottoRank determineRank(Integer matchedCount, boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchedCount().equals(matchedCount) && rank.isIncludeBonus() == hasBonus)
                .findFirst()
                .orElse(LottoRank.NON_RANK);
    }

    private int countMatchedNumber(List<Integer> winningNumbers, List<Integer> playerNumbers) {
        return (int) playerNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean containBonusNumber(BonusNumber bonusNumber, List<Integer> playerNumbers) {
        Integer number = bonusNumber.number();

        if (playerNumbers.contains(number)) {
            return true;
        }
        return false;
    }
}
