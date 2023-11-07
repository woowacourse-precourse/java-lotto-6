package lotto.domain;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.LongStream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("[Unit] LotteryResultsCalculator에 관한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class LotteryResultsCalculatorTest {

    private  static LotteryOperator operator = new LotteryOperator(new LotteryRound(1), List.of(TestLotteryRanking.values()), 100000);
    private static long MAX = Long.MAX_VALUE /  operator.getLotteryPrice();

    @Test
    void getTotalResults_비어있는_receipt이면_빈_집합을_반환한다() {
        LotteryResultsCalculator calculator = new LotteryResultsCalculator(operator);
        LotteryReceipt receipt = new LotteryReceipt(Collections.emptyList(), operator);

        assertThat(calculator.getTotalResults(receipt))
                .isEqualTo(LotteryResults.emptyResults(List.of(TestLotteryRanking.values())));
    }

    @Disabled
    @Test
    void getTotalResults_총_PurchasedReceipt의_갯수가_MAX개_이상이면_예외를_발생한다() {
        LotteryRound round = new LotteryRound(1);
        LotteryResultsCalculator calculator = new LotteryResultsCalculator(operator);
        List<PurchasedLottery> lotteries = LongStream.range(0, MAX + 1)
                .mapToObj(i -> new PurchasedLottery(round, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .collect(toList());
        LotteryReceipt receipt = new LotteryReceipt(lotteries, operator);

        assertThatThrownBy(() -> calculator.getTotalResults(receipt))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
