package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.util.Constants;

public class LottoStatistics {
    private List<Lotto> userLottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private LottoService lottoService;

    private final Map<LottoRank, Long> winsPerCategory;
    private final double totalRate;

    public LottoStatistics(List<Lotto> userLottos, List<Integer> winningNumbers,
                           int bonusNumber) {
        this.lottoService = LottoService.getInstance();
        this.userLottos = userLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        winsPerCategory = calculateWinsPerCategory();
        long totalRevenue = calculateTotalRevenue();
        totalRate = calculateRateOfReturn(totalRevenue);
    }

    public Map<LottoRank, Long> getWinsPerCategory() {
        return winsPerCategory;
    }

    public double getTotalRate() {
        return totalRate;
    }

    private Map<LottoRank, Long> calculateWinsPerCategory() {
        return userLottos.stream()
                .map(lotto -> lottoService.checkWinning(lotto.getNumbers(), winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private long calculateTotalRevenue() {
        return winsPerCategory.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double calculateRateOfReturn(long totalRevenue) {
        double purchaseAmount = userLottos.size() * Constants.LOTTO_PRICE;
        return (double) totalRevenue / purchaseAmount;
    }
}