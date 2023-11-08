package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.utils.FixedRandom;
import lotto.domain.utils.TestLotteryRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("[Unit] LotteryReceipt에 대한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class LotteryReceiptTest {
    private LottoRandom random = new FixedRandom();
    private LotteryOperator operator = new LotteryOperator(new LotteryRound(1), List.of(TestLotteryRanking.values()),
            1000);

    @Test
    void createLotteryReceipt_quantity가_1보다_작으면은_예외를_발생시킨다() {
        assertThatThrownBy(() -> LotteryReceipt.createLotteryReceipt(operator, 0, random))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLotteryReceipt_quantity만큼_복권을_발행한다() {
        LotteryReceipt receipt = LotteryReceipt.createLotteryReceipt(operator, 10, random);
        assertThat(receipt)
                .hasSize(10);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000})
    void getPurchasedAmount_정확한_값을_반환한다(long originalPrice) {
        long quantity = originalPrice / operator.getLotteryPrice();
        LotteryReceipt receipt = LotteryReceipt.createLotteryReceipt(operator, quantity, random);

        assertThat(receipt.getPurchasedAmount())
                .isEqualTo(originalPrice);
    }
}
