package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 발행한 로또 번호는 6자리 숫자여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 발행한 로또 번호는 중복이 있으면 안됩니다.");
    }

    @DisplayName("발행한 각 로또 번호가 1~45의 숫자가 아니면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void createLottoByRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 발행한 로또 번호는 1~45의 숫자여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 발행한 로또 번호는 1~45의 숫자여야 합니다.");
    }

    @DisplayName("로또 내 숫자는 오름차순으로 정렬되어야 한다.")
    @Test
    void sortLottoToAscending() {
        //given
        List<Integer> sortBeforeLottoNumber = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1));
        List<Integer> sortAfterLottoNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        //when
        Lotto lotto = new Lotto(sortBeforeLottoNumber);

        //then
        Assertions.assertThat(lotto.getLottoNumbers()).isEqualTo(sortAfterLottoNumber);
    }

}