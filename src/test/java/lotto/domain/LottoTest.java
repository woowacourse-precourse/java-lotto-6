package lotto.domain;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(new LottoNumbers("1,2,3,4,5,6,7")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(new LottoNumbers("1,2,3,4,5,5")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호를_알_수_있다() {
        // given
        Lotto lotto = new Lotto(new LottoNumbers("1,2,3,4,5,6"));

        // when
        String actual = lotto.getLottoMessage();

        // then
        Assertions.assertThat(actual).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}