package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1과 45사이의 값이 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,4,5,6,70)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("해당 숫자를 가지고 있는지 확인한다.")
    @Test
    void checkNumberContained() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int containNumber = 5;

        Assertions.assertThat(lotto.isContain(containNumber)).isTrue();
    }

    @DisplayName("숫자가 몇 개 일치하는지 확인한다.")
    @Test
    void countSameLottoNumbers() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(1,2,3,10,11,12));

        Assertions.assertThat(lotto1.countSameNumber(lotto2)).isEqualTo(3);
    }
    // 아래에 추가 테스트 작성 가능
}