package lotto.controller;

import static lotto.constant.LottoInfo.ONE_LOTTO_PRICE;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.StatisticDto;
import lotto.model.Lotteries;
import lotto.model.Lotto;
import lotto.model.ProfitRate;
import lotto.model.Statistic;
import lotto.util.RandomNumberGenerator;
import lotto.view.View;
import lotto.vo.BonusNumber;
import lotto.vo.BuyAmount;
import lotto.vo.TicketCount;

public class LottoGameController {

    private final View view;

    public LottoGameController(View view) {
        this.view = view;
    }

    public void run() {
        BuyAmount buyAmount = initBuyAmount();
        TicketCount ticketCount = initTicketCount(buyAmount);
        Lotteries lotteries = initLotteries(ticketCount);

        showLotteriesNumber(lotteries);

        Lotto winningLotto = initWinningLotto();
        BonusNumber bonusNumber = initBonusNumber(winningLotto.getNumbers());

        Statistic statistic = createStatistic(lotteries, winningLotto, bonusNumber);
        ProfitRate profitRate = calculateProfitRate(buyAmount, statistic);

        showResult(statistic, profitRate);
    }

    private ProfitRate calculateProfitRate(BuyAmount buyAmount, Statistic statistic) {
        return ProfitRate.from(statistic.getRank(), buyAmount);
    }

    private BuyAmount initBuyAmount() {
        return view.getBuyAmount();
    }

    private TicketCount initTicketCount(BuyAmount buyAmount) {
        Integer count = buyAmount.amount() / ONE_LOTTO_PRICE.getValue();
        TicketCount ticketCount = new TicketCount(count);
        view.printTicketCountMessage(count);

        return ticketCount;
    }

    private Lotteries initLotteries(final TicketCount ticketCount) {
        return Lotteries.createLotteries(ticketCount, new RandomNumberGenerator());
    }

    private Statistic createStatistic(final Lotteries lotteries, final Lotto winningLotto,
                                      final BonusNumber bonusNumber) {
        return Statistic.from(lotteries, winningLotto, bonusNumber);
    }

    private Lotto initWinningLotto() {
        return view.getWinningLotto();
    }

    private BonusNumber initBonusNumber(final List<Integer> winningNumbers) {
        return view.getBonusNumber(winningNumbers);
    }

    private void showLotteriesNumber(final Lotteries lotteries) {
        view.showLotteriesNumber(LottoDto.toDto(lotteries.getLotteries()));
    }

    private void showResult(Statistic statistic, ProfitRate profitRate) {
        view.showStatistics(StatisticDto.from(statistic));
        view.showProfitRate(profitRate.getRate());
    }
}
