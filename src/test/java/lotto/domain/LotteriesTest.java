package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteriesTest {

    RandomNumberGenerator numberGenerator = new RandomNumberGenerator();

    @DisplayName("구매수량에 따라 복권이 생성되는지 확인한다.")
    @Test
    void checkLotteriesSizeByPurchaseCount() {
        int purchaseCount = 5;
        Lotteries lotteries = Lotteries.of(5, numberGenerator);

        assertThat(lotteries.getLotteries().size()).isEqualTo(purchaseCount);
    }

    @DisplayName("Lotteries 객체가 불변한지 확인한다. 반환한 객체를 수정하려 할 경우 예외가 발생한다.")
    @Test
    void checkLotteriesIsImmutable() {
        Lotteries lotteries = Lotteries.of(1, numberGenerator);

        assertThatThrownBy(() -> lotteries.getLotteries().clear())
                .isInstanceOf(UnsupportedOperationException.class);
    }
}