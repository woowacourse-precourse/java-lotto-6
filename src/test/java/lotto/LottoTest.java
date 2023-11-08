package lotto;

import lotto.domain.lotto.Lotto;
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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자는 6개여야 합니다 : 7개");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자는 중복될 수 없습니다");
    }

    @DisplayName("일치 개수 테스트")
    @Test
    void getCorrectCountTest(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto anotherLotto = new Lotto(List.of(1,2,3,4,5,7));
        assertThat(lotto.getCorrectCount(anotherLotto)).isEqualTo(5);
    }


}