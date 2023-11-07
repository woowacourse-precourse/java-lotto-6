package lotto.event;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.LottoMatchingTable;
import lotto.domain.LottoRewardTable;
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

        final var matchResults = lottoBundle.checkResult(answerLotto);

        final var joinResult = EnumSet.allOf(LottoRewardTable.class).stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        result -> matchResults.stream().map(LottoMatchingTable::of)
                                .filter(m -> Objects.equals(result.getLottoMatchingTable(), m))
                                .count(),
                        (prev, next) -> next,
                        () -> new EnumMap<>(LottoRewardTable.class)
                ));

        final var profit = joinResult.entrySet()
                .stream().mapToLong((lottoRewardTableLongEntry ->
                        lottoRewardTableLongEntry.getKey().getReward() * lottoRewardTableLongEntry.getValue()))
                .sum();

        final var messages = joinResult.entrySet()
                .stream().map(lottoRewardTableLongEntry -> new MessagePerCount(lottoRewardTableLongEntry.getKey().getMessage(),
                        lottoRewardTableLongEntry.getValue()))
                .toList();

        return new WinningStatisticsState(
                paymentPrice.calculateProfit(new Money(profit)),
                messages
        );
    }
}
