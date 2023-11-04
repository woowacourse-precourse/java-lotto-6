package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoManagerTest {

    @ParameterizedTest
    @CsvSource(value = {"8000, 8", "4000, 4", "1000, 1", "10000000, 10000"})
    void LottoManager는_구입금액받아_로또를_생성관리한다(int money, int count) {
        LottoManager manager = LottoManager.from(money);
        assertThat(manager.getLottos().size()).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {808, 10001, 5030})
    void money가_1000원단위_아닐경우_예외를반환(int money) {
        assertThatThrownBy(() -> LottoManager.from(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {808, 11, 0})
    void money로_로또1개도_구입못하면_예외반환(int money) {
        assertThatThrownBy(() -> LottoManager.from(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

}