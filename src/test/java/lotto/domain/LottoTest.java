package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("알 수 없는 숫자 목록으로 로또를 생성할 수 없다.")
    @Test
    void checkNumbersNonNull() {
        assertThatThrownBy(() -> Lotto.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 숫자 목록으로 로또를 생성할 수 없습니다.");
    }

    @DisplayName("알 수 없는 번호가 포함된 숫자 목록으로 로또를 생성할 수 없다.")
    @Test
    void checkIncludeNull() {
        List<Integer> nullIncluded = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        nullIncluded.add(null);

        assertThatThrownBy(() -> Lotto.from(nullIncluded))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 숫자로 로또 번호를 생성할 수 없습니다.");
    }

    @DisplayName("알 수 없는 로또와 일치되는 번호의 갯수를 조회할 수 없다.")
    @Test
    void checkLottoNonNull() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lotto.matchWith(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 로또와 매치할 수 없습니다.");
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어갈 수 없다.")
    @Test
    void checkNumbersSize() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호의 개수는 최대 6개입니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자를 포함할 수 없다.")
    @Test
    void checkNumbersDuplication() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호에 중복된 숫자를 포함할 수 없습니다.");
    }

    @DisplayName("로또에 로또 번호가 들어오면 포함되어 있는지 확인 가능하다.")
    @Test
    void contains() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        boolean result = lotto.contains(LottoNumber.from(1));

        assertThat(result).isTrue();
    }

    @DisplayName("다른 로또와 비교해서 몇개의 번호가 일치하는지 확인할 수 있다.")
    @Test
    void matchWith() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto other = Lotto.from(List.of(1, 2, 3, 4, 5, 21));

        int result = lotto.matchWith(other);

        assertThat(result).isEqualTo(5);
    }
}
