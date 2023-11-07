package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.constant.ExceptionConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteriesTest {

    RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
    ParticularNumberGenerator particularNumberGenerator = new ParticularNumberGenerator(List.of(1, 1, 2, 3, 4, 5));

    @DisplayName("구매수량에 따라 복권이 생성되는지 확인한다.")
    @Test
    void checkLotteriesSizeByPurchaseCount() {
        int purchaseCount = 5;
        Lotteries lotteries = Lotteries.of(5, numberGenerator);

        assertThat(lotteries.getLotteries().size()).isEqualTo(purchaseCount);
    }

    @DisplayName("랜덤 api가 중복되지 않는지 확인한다. 중복 숫자를 생성하는 로직이 들어갈 경우 예외가 발생한다.")
    @Test
    void createLotteriesByParticularNumberGenerator() {
        assertThatThrownBy(() -> Lotteries.of(3, particularNumberGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionConstant.LOTTO_NUMBER_DUPliCATE.getMessage());
    }

    @DisplayName("Lotteries 객체가 불변한지 확인한다. 반환한 객체를 수정하려 할 경우 예외가 발생한다.")
    @Test
    void checkLotteriesIsImmutable() {
        Lotteries lotteries = Lotteries.of(1, numberGenerator);

        assertThatThrownBy(() -> lotteries.getLotteries().clear())
                .isInstanceOf(UnsupportedOperationException.class);
    }
}