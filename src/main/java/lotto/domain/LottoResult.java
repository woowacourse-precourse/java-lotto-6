package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lotto.common.enums.LottoRank;
import lotto.common.utils.NumberUtil;
import lotto.service.LottoService;

public class LottoResult {
    private List<Lotto> userLottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private LottoService lottoService;

    private final Map<LottoRank, Long> winningResult;
    private final double totalRate;

    public LottoResult(List<Lotto> userLottos, List<Integer> winningNumbers,
            int bonusNumber) {
        this.lottoService = LottoService.getInstance();
        this.userLottos = Collections.unmodifiableList(userLottos);
        this.winningNumbers = Collections.unmodifiableList(winningNumbers);
        this.bonusNumber = bonusNumber;

        winningResult = calculateWinCategory();
        totalRate = calculateRateOfReturn();
    }

    public Map<LottoRank, Long> getWinningResult() {
        return winningResult;
    }

    public double getTotalRate() {
        return totalRate;
    }

    private Map<LottoRank, Long> calculateWinCategory() {
        return userLottos.stream()
                .map(lotto -> lottoService.winningCheck(lotto.getNumbers(), winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private long calculateTotalRevenue() {
        return winningResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double calculateRateOfReturn() {
        long totalRevenue = calculateTotalRevenue();
        double purchaseAmount = userLottos.size() * NumberUtil.LOTTO_PRICE;
        return (double) totalRevenue / purchaseAmount;
    }
}