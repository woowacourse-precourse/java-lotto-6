package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.LottoWinCategory;

public class LottoDraw {
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;
    private final List<LottoWinCategory> lottoWinCategory;

    private LottoDraw() {
        lottoWinCategory = List.of(LottoWinCategory.values());
    }

    private LottoDraw(Lotto winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoWinCategory = List.of(LottoWinCategory.values());
    }

    public static LottoDraw of(Lotto winningNumbers, BonusNumber bonusNumber) {
        return new LottoDraw(winningNumbers, bonusNumber);
    }

    public LottoWinCategory getWinning(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        boolean hasBonus = lottoNumbers.contains(bonusNumber.getNumber());

        lottoNumbers.retainAll(winningNumbers.getNumbers());

        return LottoWinCategory.getWinningCategoryByCountAndBonus(lottoNumbers.size(), hasBonus, lottoWinCategory);
    }

    public Map<LottoWinCategory, Integer> getWinnings(LottoTicket lottoTicket) {
        Map<LottoWinCategory, Integer> winnings = lottoWinCategory.stream()
                .collect(Collectors.toMap(category -> category, category -> 0));

        lottoTicket.getLotto().forEach(lotto -> {
            LottoWinCategory winning = getWinning(lotto);
            winnings.merge(winning, 1, Integer::sum);
        });

        return winnings;
    }
    public double getWinningRate(Map<LottoWinCategory, Integer> winnings, int totalPurchaseAmount) {
        int totalWinningAmount = winnings.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return ((double) totalWinningAmount / totalPurchaseAmount) * 100;
    }
}
