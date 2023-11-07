package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.TestConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

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

    @DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutRangedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 생성한다.")
    @Test
    void createLotto() {
        Lotto lotto = new Lotto(TestConstant.NORMAL_NUMBERS);
    }

    @DisplayName("로또 생성시 숫자가 정렬된다.")
    @Test
    void createLottoExpectHasSortedNumbers() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));

        assertThat(lotto.getNumbers()).isEqualTo(TestConstant.NORMAL_NUMBERS);
    }

    @DisplayName("로또의 numbers는 읽기 전용 컬렉션이다.")
    @Test
    void getNumbersExpectReadOnly() {
        List<Integer> modifiableNumbers = new ArrayList<>(TestConstant.NORMAL_NUMBERS);
        Lotto lotto = new Lotto(modifiableNumbers);

        List<Integer> numbers = lotto.getNumbers();

        assertThatThrownBy(() -> numbers.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("로또 두 개를 비교하여 몇 개의 번호가 일치하는지 계산한다. - 6개 일치")
    @Test
    void calculateLottoNumberWhenMatchedSix() {
        Lotto lotto1 = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        Lotto lotto2 = new Lotto(TestConstant.NORMAL_NUMBERS);

        int matchedCount = lotto1.countMatchedNumber(lotto2);

        assertThat(matchedCount).isEqualTo(6);
    }

    @DisplayName("로또 두 개를 비교하여 몇 개의 번호가 일치하는지 계산한다. - 0개 일치")
    @Test
    void calculateLottoNumberWhenMatchedZero() {
        Lotto lotto1 = new Lotto(TestConstant.NORMAL_NUMBERS);
        Lotto lotto2 = new Lotto(List.of(45, 44, 43, 42, 41, 40));

        int matchedCount = lotto1.countMatchedNumber(lotto2);

        assertThat(matchedCount).isEqualTo(0);
    }

    @DisplayName("로또 두 개를 비교하여 몇 개의 번호가 일치하는지 계산한다. - 3개 일치")
    @Test
    void calculateLottoNumberWhenMatchedThree() {
        Lotto lotto1 = new Lotto(TestConstant.NORMAL_NUMBERS);
        Lotto lotto2 = new Lotto(List.of(1, 45, 2, 3, 44, 43));

        int matchedCount = lotto1.countMatchedNumber(lotto2);

        assertThat(matchedCount).isEqualTo(3);
    }
}