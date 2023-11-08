package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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

    @Test
    @DisplayName("로또에 포함된 숫자는 true을 반환한다.")
    void returnTrueLottoContainNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int target = 1;
        //when
        boolean result = lotto.isContainNumber(target);
        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("로또의 포함되지 않은 숫자는 false를 반환한다.")
    void returnFalseLottoNotContainNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int target = 7;
        //when
        boolean result = lotto.isContainNumber(target);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("동일한 숫자의 개수를 반환한다.")
    void returnNumberMatchCount() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        //when
        int result = lotto.getMatchCount(otherLotto);
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("동일한 숫자가 존재하지 않을 경우 0을 반환한다.")
    void return0NotExistNumberMatch() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        //when
        int result = lotto.getMatchCount(otherLotto);
        //then
        assertThat(result).isEqualTo(0);
    }
}