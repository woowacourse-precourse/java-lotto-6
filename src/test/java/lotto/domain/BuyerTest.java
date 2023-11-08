package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.utils.LottoUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BuyerTest {

    @DisplayName("금액에 맞게 로또의 개수가 맞는지 확인하는 기능")
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 5000000})
    public void 금액에_맞게_로또의_개수가_맞는지_확인하는_기능(long amount) {
        // given
        Buyer buyer = new Buyer(amount);

        // when
        long lottoAmount = LottoUtils.getLottoAmount(amount);

        // then
        assertThat(buyer.getLottos().size()).isEqualTo(lottoAmount);
    }

}