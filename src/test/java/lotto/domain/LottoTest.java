package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.message.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("Lotto: 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(Error.INVALID_NUMBER_COUNT.getMessage(), 6));
    }

    @Test
    @DisplayName("Lotto: 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.DUPLICATE_NUMBER_EXIST.getMessage());
    }

    @Test
    @DisplayName("Lotto: 로또 번호가 1~45 사이가 아니면 예외가 발생한다")
    void createLottoWithInvalidNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("Lotto: 요구사항에 맞는 로또 번호가 주어질 경우 로또 발급에 성공한다")
    void createLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    @DisplayName("Lotto: 로또 번호가 오름차순으로 정렬된다")
    void CreateLotto_번호_정렬() {
        List<Integer> ImmutableNumbers = List.of(6, 5, 4, 3, 2, 1);
        List<Integer> numbers = new ArrayList<>(ImmutableNumbers);
        Lotto lotto = new Lotto(ImmutableNumbers);

        numbers.sort(Comparator.naturalOrder());
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }
}