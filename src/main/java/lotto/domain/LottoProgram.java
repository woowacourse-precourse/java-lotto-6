package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.congin.LottoWinningAmount;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.prizecalculator.LottoPrizeCalculator;
import lotto.domain.prizecalculator.WinningNumbers;
import lotto.dto.WinningStatisticsDto;

public class LottoProgram {
    private final LottoGenerator lottoGenerator;
    private final LottoPrizeCalculator lottoPrizeCalculator;
    private LottoMoney lottoMoney;

    public LottoProgram() {
        this.lottoGenerator = new LottoGenerator();
        this.lottoPrizeCalculator = new LottoPrizeCalculator();
    }

    public List<Lotto> getLottoListByPrice(int price) {
        this.lottoMoney = new LottoMoney(price);
        return lottoGenerator.createLottoList(lottoMoney);
    }

    public WinningStatisticsDto getWinningNumber(List<Integer> number, Integer bonus) {
        if (lottoMoney == null) {
            throw new IllegalStateException("[ERROR] 로또를 사기 위한 돈이 존재하지 않습니다.");
        }
        Map<LottoWinningAmount, Integer> winningAmount = lottoPrizeCalculator.setLottoPrizeCalculator(
                new WinningNumbers(number, bonus));
        return new WinningStatisticsDto(winningAmount, calculateProfitPercentage(winningAmount));
    }

    private float calculateProfitPercentage(Map<LottoWinningAmount, Integer> winningAmount) {
        int investmentProfit = winningAmount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningAmount() * entry.getValue())
                .sum();
        return lottoMoney.getLottoYield(investmentProfit);
    }

}
