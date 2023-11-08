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

@DisplayName("[Unit] LotteryRetailer에 대한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class LotteryRetailTest {
    private LottoRandom random = new FixedRandom();
    private LotteryOperator operator = new LotteryOperator(new LotteryRound(1),
            List.of(TestLotteryRanking.values()), 1000);
    private LotteryRetailer retailer = new LotteryRetailer(random);

    @Test
    void purchase_amount가_0보다_같거나_작으면_예외를_발생시킨다() {
        assertThatThrownBy(() -> retailer.purchase(operator, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void purchase_amount가_lotteryPrice로_나누어_떨어지지_않는다면_예외를_발생시킨다() {
        assertThatThrownBy(() -> retailer.purchase(operator, 1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 16, 32, 64, 128, 256})
    void purhcase_구매하는_수량만큼_복권을_발행한다(int quantity) {
        assertThat(retailer.purchase(operator, quantity * operator.getLotteryPrice()))
                .hasSize(quantity);
    }
}
