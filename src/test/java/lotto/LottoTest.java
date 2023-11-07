package lotto;

import lotto.domain.Lotto;
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

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void 중복된_보너스번호_예외테스트(){
        assertThatThrownBy(()->{
            Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
            lotto.validateBonusNumber(5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 미만의 숫자를 입력하면 예외가 발생한다.")
    @Test
    void 범위_미만_예외테스트(){
        assertThatThrownBy(()-> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("45를 초과하는 숫자를 입력하면 예외가 발생한다.")
    @Test
    void 범위_초과_예외테스트(){
        assertThatThrownBy(()-> new Lotto(List.of(41, 42, 43, 44, 45, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨된 로또 번호와 일치하는 로또 번호의 갯수를 출력해야한다.")
    @Test
    void 당첨된_번호_일치_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int matchedNumber = lotto.getMatchedNumber(winningLotto);
        assertThat(matchedNumber).isEqualTo(3);
    }

    @DisplayName("로또 번호 중 일치하지 않는 숫자를 반환해야 한다.")
    @Test
    void 일치하지_않는_번호_반환_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int unmatchedNumber = lotto.getUnmatchedNumber(winningLotto);
        assertThat(unmatchedNumber).isEqualTo(4);
    }
}