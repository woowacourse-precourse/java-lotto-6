package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("로또 번호가 1~45의 숫자가 아닌경우 예외가 발생한다.")
    @Test
    void createLottoByNotArrangeNumber(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 구매한 로또 번호와 당첨 번호를 비교하는 기능")
    @Test
    void matchLottoCount(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningLotto winningLotto = WinningLotto.create(new Lotto(List.of(1, 2, 3, 11, 12, 13)), BonusNumber.create(5));
        assertEquals(3,lotto.getMatchLottoCount(winningLotto));
    }

    @DisplayName("올바른 양식으로 문자를 출력하는지")
    @Test
    void toStringTest(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertEquals("[1, 2, 3, 4, 5, 6]",lotto.toString());
    }
}
