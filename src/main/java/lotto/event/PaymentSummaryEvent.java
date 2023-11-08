package lotto.event;

import lotto.domain.Money;
import lotto.event.EventListener.ReturnEvent;
import lotto.repository.LottoRepository;
import lotto.state.WinningStatisticsState;
import lotto.state.WinningStatisticsState.MessagePerCount;

public record PaymentSummaryEvent(LottoRepository lottoRepository) implements ReturnEvent<WinningStatisticsState> {
    
    @Override
    public WinningStatisticsState execute() {
        final var paymentPrice = lottoRepository.findPayment();
        final var answerLotto = lottoRepository.findAnswerLotto();
        final var lottoBundle = lottoRepository.findPurchasedLottoBundle();

        final var winningResults = lottoBundle.checkWinningResults(answerLotto);
        final var profit = winningResults.calculateProfit();

        return new WinningStatisticsState(
                paymentPrice.calculateProfitMargin(new Money(profit)),
                winningResults.convert(MessagePerCount::new)
        );
    }

}
