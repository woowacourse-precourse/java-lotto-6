package lotto.service.manager;

import lotto.domain.entity.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoManagerTest {
    @DisplayName("보너스 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void createLottoManagerByOutOfRange(int bonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new LottoManager(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1 ~ 45이면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void createLottoManagerSuccess(int bonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatNoException().isThrownBy(() -> new LottoManager(lotto, bonusNumber));
    }

}