package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNotSixSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 개수는 6개여야만 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복된 숫자를 고를 수 없습니다.");
    }

    @DisplayName("로또 번호를 출력 요구 사항에 맞추어 문자열로 반환한다.")
    @Test
    void printLottoNumberByString() {
        Lotto lotto = new Lotto(List.of(8, 12, 28, 30, 31, 41));

        String lottoNumbers = lotto.getLottoNumberString();

        assertThat(lottoNumbers).isEqualTo("[8, 12, 28, 30, 31, 41]");
    }
}