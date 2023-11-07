package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.congin.LottoWinningAmount;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.prizecalculator.LottoPrizeCalculator;
import lotto.domain.prizecalculator.WinningNumbers;
import lotto.domain.repository.UserLottoRepository;
import lotto.dto.WinningStatisticsDto;

public class LottoProgram {
    private final LottoGenerator lottoGenerator;
    private final LottoPrizeCalculator lottoPrizeCalculator;
    private final UserLottoRepository userLottoRepository;
    private LottoMoney lottoMoney;

    public LottoProgram() {
        this.lottoGenerator = new LottoGenerator();
        this.lottoPrizeCalculator = new LottoPrizeCalculator();
        this.userLottoRepository = new UserLottoRepository();
    }

    public List<Lotto> getLottoListByPrice(int price) {
        this.lottoMoney = new LottoMoney(price);
        return lottoGenerator.createLottoList(lottoMoney);
    }

    public WinningStatisticsDto getWinningNumber(List<Integer> number, Integer bonus) {
        WinningNumbers winningNumbers = new WinningNumbers(number, bonus);
        lottoPrizeCalculator.setLottoPrizeCalculator(winningNumbers);
        List<Lotto> userLotto = userLottoRepository.getUserLotto();
        Map<LottoWinningAmount, Integer> winningAmount = lottoPrizeCalculator.countWinningNumbers(userLotto);

        int investmentProfit = 0;
        for (Entry<LottoWinningAmount, Integer> lottoWinningAmountIntegerEntry : winningAmount.entrySet()) {
            investmentProfit +=
                    lottoWinningAmountIntegerEntry.getKey().getWinningAmount() * lottoWinningAmountIntegerEntry.getValue();
        }
        float lottoYield = lottoMoney.getLottoYield(investmentProfit);

        return new WinningStatisticsDto(winningAmount, lottoYield);

    }

}
