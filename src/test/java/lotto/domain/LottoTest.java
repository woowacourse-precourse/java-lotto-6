package lotto.domain;

import java.util.Comparator;
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

    @DisplayName("로또 번호에 유효하지 않은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByInvalidNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, -1, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 저장할 때 정렬 후 저장한다.")
    @Test
    void sortNumbers() {
        // given
        List<Integer> list = List.of(2, 1, 4, 3, 6, 5);

        // when
        Lotto lotto = new Lotto(list);

        // then
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호를 조회할 때는 수정할 수 없는 리스트를 반환한다.")
    @Test
    void getNumbers() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        List<Integer> numbers = lotto.getNumbers();

        // then
        assertThat(numbers).as("case1").isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> numbers.sort(Comparator.naturalOrder())).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("로또는 숫자가 포함되어있는지 확인한다.")
    @Test
    void hasNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int case1 = 1;
        int case2 = 45;

        // when
        boolean result1 = lotto.hasNumber(case1);
        boolean result2 = lotto.hasNumber(case2);

        // then
        assertThat(result1).as("case1").isEqualTo(true);
        assertThat(result2).as("case2").isEqualTo(false);
    }

    @DisplayName("로또 번호를 문자열로 변환한다.")
    @Test
    void testToString() {
        // given
        Lotto case1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        String result = case1.toString();

        // then
        assertThat(result).as("case1").isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}