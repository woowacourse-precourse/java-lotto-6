package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.model.enums.ErrorMessage.ERROR_HEAD_MESSAGE;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개 초과인 경우 예외 확인")
    @Test
    void 로또_번호_사이즈_초과일_때_예외_확인() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_HEAD_MESSAGE.getErrorMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있는 경우 예외 확인")
    @Test
    void 로또_번호_중복일_때_예외_확인() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_HEAD_MESSAGE.getErrorMessage());
    }

    @DisplayName("로또 번호에 1~45 사이의 값이 아닌 숫자가 있는 경우 예외 확인")
    @Test
    void 로또_번호_범위값이_아닐_때_예외_확인() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_HEAD_MESSAGE.getErrorMessage());
    }

    @DisplayName("로또 번호 정렬 확인")
    @Test
    void 로또_번호_정렬_확인() {
        Lotto lottoNumbers = new Lotto(List.of(2, 6, 5, 3, 8, 7));
        assertThat(lottoNumbers.sortNumbers()).isEqualTo("2, 3, 5, 6, 7, 8");
    }

    @DisplayName("보너스 번호 포함 여부 확인")
    @Test
    void 보너스_번호_포함_확인() {
        Lotto lottoNumbers = new Lotto(List.of(2, 6, 5, 3, 8, 7));
        String bonusNumbers = "7";
        assertThat(lottoNumbers.hasBonusNumber(bonusNumbers)).isEqualTo(true);
    }
}