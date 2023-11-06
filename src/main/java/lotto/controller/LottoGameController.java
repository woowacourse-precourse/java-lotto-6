package lotto.controller;

import static lotto.constant.LottoInfo.ONE_LOTTO_PRICE;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.StatisticDto;
import lotto.model.Lotteries;
import lotto.model.Lotto;
import lotto.model.ProfitRate;
import lotto.model.RandomLottoNumberGenerator;
import lotto.model.Statistic;
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
        showTicketCount(ticketCount);

        Lotteries lotteries = initLotteries(ticketCount);
        showLotteriesNumber(lotteries);

        Lotto winningLotto = initWinningLotto();
        BonusNumber bonusNumber = initBonusNumber(winningLotto.getNumbers());

        Statistic statistic = createStatistic(lotteries, winningLotto, bonusNumber);
        ProfitRate profitRate = calculateProfitRate(statistic, buyAmount);
        showResult(statistic, profitRate);
    }

    private BuyAmount initBuyAmount() {
        return view.getBuyAmount();
    }

    private TicketCount initTicketCount(final BuyAmount buyAmount) {
        Integer count = buyAmount.amount() / ONE_LOTTO_PRICE.getValue();
        TicketCount ticketCount = new TicketCount(count);

        return ticketCount;
    }

    private Lotteries initLotteries(final TicketCount ticketCount) {
        return Lotteries.createLotteries(ticketCount, new RandomLottoNumberGenerator());
    }

    private Lotto initWinningLotto() {
        return view.getWinningLotto();
    }

    private BonusNumber initBonusNumber(final List<Integer> winningNumbers) {
        return view.getBonusNumber(winningNumbers);
    }

    private Statistic createStatistic(final Lotteries lotteries, final Lotto winningLotto,
                                      final BonusNumber bonusNumber) {
        return lotteries.getResult(bonusNumber, winningLotto);
    }

    private ProfitRate calculateProfitRate(final Statistic statistic, final BuyAmount buyAmount) {
        return ProfitRate.from(statistic.getRank(), buyAmount);
    }

    private void showTicketCount(final TicketCount ticketCount) {
        view.showTicketCount(ticketCount.count());
    }

    private void showLotteriesNumber(final Lotteries lotteries) {
        view.showLotteriesNumber(LottoDto.toDto(lotteries.getLotteries()));
    }

    private void showResult(final Statistic statistic, final ProfitRate profitRate) {
        view.showStatistics(StatisticDto.from(statistic));
        view.showProfitRate(profitRate.getRate());
    }
}
