package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.IllegalArgumentExceptionType;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또_숫자_개수_검증_실패_테스트")
    @Test
    void createLottoByInvalidSize() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.NUMBER_AMOUNT_INVALID.getMessage());
        softAssertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.NUMBER_AMOUNT_INVALID.getMessage());
        softAssertions.assertAll();

    }

    @DisplayName("로또_중복숫자_검증_실패_테스트")
    @Test
    void createLottoByDuplicatedNumber2() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 3, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.DUPLICATED_NUMBER_ERROR.getMessage());
        softAssertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.DUPLICATED_NUMBER_ERROR.getMessage());
        softAssertions.assertAll();
    }

    @DisplayName("로또_정렬_테스트")
    @Test
    void validIsLottoSorted() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        List<Integer> numbers1 = lotto1.getNumbers();
        List<Integer> numbers2 = lotto2.getNumbers();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(numbers1).isSorted();
        softAssertions.assertThat(numbers2).isSorted();
        softAssertions.assertAll();
    }

    @DisplayName("로또_원소_테스트")
    @Test
    void checkLottoNumbers() {
        List<Integer> input1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> input2 = List.of(6, 5, 4, 3, 2, 1);
        Lotto lotto1 = new Lotto(input1);
        Lotto lotto2 = new Lotto(input2);
        List<Integer> numbers1 = lotto1.getNumbers();
        List<Integer> numbers2 = lotto2.getNumbers();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(numbers1).isEqualTo(input1);
        softAssertions.assertThat(numbers2).isEqualTo(input1);
        softAssertions.assertAll();
    }

    @DisplayName("로또_숫자_범위_테스트")
    @Test
    void createLottoByInvalidNumberRange() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgumentExceptionType.LOTTO_RANGE_ERROR.getMessage());

        softAssertions.assertThatThrownBy(() -> new Lotto(List.of(41, 42, 43, 44, 45, 46)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgumentExceptionType.LOTTO_RANGE_ERROR.getMessage());

        softAssertions.assertAll();
    }

}