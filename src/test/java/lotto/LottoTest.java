package lotto;

import lotto.domain.BonusBall;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @Test
    void 보너스볼과_같은_숫자를_가지고있는지_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusBall(1, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 맞춘_번호의_갯수를_리턴한다() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        LottoNumber lottoNumber = new LottoNumber(List.of(1,2,3,4,5,6));
        assertThat(lotto.calculateWinNumber(lottoNumber)).isEqualTo(6);
    }
}