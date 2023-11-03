package lotto.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.UserLotteries;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserLotteriesFactoryTest {

    @DisplayName("금액을 제공하면, 사용자 로또 객체를 생성한다.")
    @Test
    void createFromPurchaseAmount() {
        //given
        UserLotteriesFactory userLotteriesFactory =
                new UserLotteriesFactory(new LottoFactory(() -> List.of(1, 2, 3, 4, 5, 6)));
        //when
        UserLotteries userLotteries = userLotteriesFactory.createFromPurchaseAmount(1000);
        //then
        assertThat(userLotteries)
                .isNotNull()
                .isInstanceOf(UserLotteries.class);
    }

    @DisplayName("금액을 가지고 살 수 있는 만큼의 로또를 발행한다.")
    @ParameterizedTest
    @CsvSource(
            textBlock = """
            1000, 1
            23000, 23
            2000, 2
            """)
    void calculateCountOfPurchasedLotto(Integer purchaseAmount, Integer count) {
        //given
        UserLotteriesFactory userLotteriesFactory =
                new UserLotteriesFactory(new LottoFactory(() -> List.of(1, 2, 3, 4, 5, 6)));
        //when
        UserLotteries userLotteries = userLotteriesFactory.createFromPurchaseAmount(purchaseAmount);
        //then
        assertThat(userLotteries.lotteriesCount()).isEqualTo(count);
    }
}