package lotto;

import java.util.Arrays;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private Lotto lotto;
    @BeforeEach
    void before(){
        lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
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


    @Test
    @DisplayName("일치하는 로또의 번호가 몇개인지 리턴")
    void countMatchTest(){
        assertThat(
                lotto.countMatch(Arrays.asList(1,2,3,4,5,6))
        ).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 번호와 일치하는 번호가있는지 확인")
    void bonusMatchTest(){
        assertThat(
                lotto.bonusMatch(5)
        ).isEqualTo(true);
    }
}