package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {
    @DisplayName("성공: 숫자를 입력하면 1000으로 나눈 값을 반환한다.")
    @Test
    void createLottoCount() {
        LottoCount lottoCount = new LottoCount();
        assertThat(lottoCount.inputLottoCost(4000)).isEqualTo(4);
    }

    @DisplayName("로또 구매 비용이 1000단위의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoCountByThousand() {
        LottoCount lottoCount = new LottoCount();
        assertThatThrownBy(() -> lottoCount.inputLottoCost(3500))
                .isInstanceOf(IllegalArgumentException.class);
    }

}