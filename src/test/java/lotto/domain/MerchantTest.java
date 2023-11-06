package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MerchantTest {

    @Test
    void test_LotteryNumberCount() {
        Merchant merchant = Merchant.of();
        int price = 13000;
        List<Lotto> lotteryNumber = merchant.getLotteryNumberWith(price);

        Assertions.assertThat(lotteryNumber.size()).isEqualTo(price / 1000);
    }

}