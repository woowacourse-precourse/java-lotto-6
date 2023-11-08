package lotto;

import lotto.module.lotto.Lotto;
import org.assertj.core.api.Assertions;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    void 로또_체크_메서드_성공_테스트() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int expectedCount = 6;
        // when
        int count = lotto1.getIncludedNumbersCount(lotto2);

        // then
        assertThat(count)
                .isEqualTo(expectedCount);
    }

    @Test
    void 번호_체크_메서드_성공_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int number = 4;

        // when
        boolean isContains = lotto.contains(number);

        // then
        assertThat(isContains)
                .isTrue();
    }

    @Test
    void 복사본_수정시_원본이_훼손되지_않는지_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int expectedCount = 6;
        int removeIndex = 0;

        // when
        List<Integer> copyLottoNumber1 = lotto.getNumbers();
        copyLottoNumber1.remove(removeIndex);
        copyLottoNumber1.remove(removeIndex);
        copyLottoNumber1.remove(removeIndex);

        List<Integer> copyLottoNumber2 = lotto.getNumbers();
        Lotto newLotto = new Lotto(copyLottoNumber2);

        int count = lotto.getIncludedNumbersCount(newLotto);

        // then
        Assertions.assertThat(count).isEqualTo(expectedCount);
    }


}