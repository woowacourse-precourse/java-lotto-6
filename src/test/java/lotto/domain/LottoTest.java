package lotto.domain;

import static lotto.testutils.LottoCreator.createLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 테스트")
class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void testOverSizeLottoValidation() {
        assertThatThrownBy(() -> createLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_LENGTH.getErrorMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void testDuplicatedLottoValidation() {
        assertThatThrownBy(() -> createLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_LOTTO.getErrorMessage());
    }

    @DisplayName("조건에 맞는 로또는 검증을 통과한다.")
    @Test
    void testCreateLottoWithProperValues() {
        assertThatNoException().isThrownBy(() -> createLotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또는 특정 로또번호가 자신이 포함하고 있는지 알 수 있다")
    @Test
    void testContainsNumber() {
        Lotto lotto = createLotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(LottoNumber.from(1))).isTrue();
        assertThat(lotto.contains(LottoNumber.from(7))).isFalse();
    }

    @DisplayName("로또는 특정 로또와 자신을 비교하여 일치하는 숫자 개수를 계산할 수 있다")
    @Test
    void testCountMatchingNumber() {
        Lotto lotto1 = createLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = createLotto(List.of(1, 2, 3, 4, 5, 7));
        int matchingCount = lotto1.countMatchingNumber(lotto2);
        assertThat(matchingCount).isEqualTo(5);
    }
}