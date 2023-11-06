package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MerchantTest {

    @Test
    @DisplayName("상인이 받은 돈에 대응하는 갯수의 복권을 받는가")
    void test_LotteryNumberCount() {
        Merchant merchant = Merchant.of();
        int price = 13000;
        List<Lotto> lotteryNumber = merchant.getLotteryNumberWith(price);

        Assertions.assertThat(lotteryNumber.size()).isEqualTo(price / 1000);
    }

}