package lotto.event;

import lotto.domain.Money;
import lotto.event.EventListener.ReturnEvent;
import lotto.repository.LottoRepository;
import lotto.state.WinningStatisticsState;

public record PaymentSummaryEvent(LottoRepository lottoRepository) implements ReturnEvent<WinningStatisticsState> {
    @Override
    public WinningStatisticsState execute() {
        final var paymentPrice = lottoRepository.findPayment();
        final var answerLotto = lottoRepository.findAnswerLotto();
        final var lottoBundle = lottoRepository.findPurchasedLottoBundle();

        final var winningResults = lottoBundle.checkWinningResults(answerLotto);

        return new WinningStatisticsState(
                paymentPrice.calculateProfitMargin(new Money(winningResults.calculateProfit())),
                winningResults.getWinningMessages()
        );
    }
}
