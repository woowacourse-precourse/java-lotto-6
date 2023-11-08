package lotto.domain;

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

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호와 다른 로또 번호는 서로 몇개가 맞는지 비교할 수 있다.")
    @Test
    void matchCount() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        //when
        int matchCount = lotto1.matchCount(lotto2);

        //then
        assertThat(matchCount).isEqualTo(5);
    }

    @DisplayName("로또 번호에 인자로 들어온 번호가 있으면 true를 반환한다.")
    @Test
    void includesWithTrue() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        boolean isInclude = lotto.includes(1);

        //then
        assertThat(isInclude).isTrue();
    }

    @DisplayName("로또 번호에 인자로 들어온 번호가 없으면 false를 반환한다.")
    @Test
    void includesWithFalse() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        boolean isInclude = lotto.includes(7);

        //then
        assertThat(isInclude).isFalse();
    }
}