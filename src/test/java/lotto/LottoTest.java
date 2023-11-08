package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("로또 번호는 오름차순으로 정렬한다.")
    @Test
    void lottoNumberSortedInAsc() {
        Lotto lotto = new Lotto(List.of(5, 4, 3, 2, 1, 6));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호가 1 ~ 45 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 46"})
    void lottoNumberInRange(String inputNumber) {
        List<Integer> numbers = Stream.of(inputNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers));
    }
}