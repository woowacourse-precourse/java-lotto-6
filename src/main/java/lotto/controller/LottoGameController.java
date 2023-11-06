package lotto.controller;

import static lotto.constant.LottoInfo.ONE_LOTTO_PRICE;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoDto;
import lotto.model.Lotteries;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResultCalculator;
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

        LottoResultCalculator lottoResultCalculator = initLottoResultCalculator(lotteries, winningLotto, bonusNumber);

        Map<LottoRank, Integer> result = lottoResultCalculator.getResult();
        Double profitRate = lottoResultCalculator.calculateRateOfProfit(result, buyAmount);

        showResult(result, profitRate);
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

    private LottoResultCalculator initLottoResultCalculator(final Lotteries lotteries, final Lotto winningLotto,
                                                            final BonusNumber bonusNumber) {
        return LottoResultCalculator.from(lotteries, winningLotto, bonusNumber);
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

    private void showResult(Map<LottoRank, Integer> result, double profitRate) {
        view.showStatistics(result);
        view.showProfitRate(profitRate);
    }
}
