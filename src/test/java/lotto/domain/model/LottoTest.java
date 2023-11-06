package lotto.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.IllegalArgumentExceptionType;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_숫자개수_검증_실패_테스트() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.NUMBER_AMOUNT_INVALID.getMessage());
        softAssertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.NUMBER_AMOUNT_INVALID.getMessage());
        softAssertions.assertAll();

    }

    @Test
    void 로또_중복숫자_검증_실패_테스트() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 3, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.DUPLICATED_NUMBER_ERROR.getMessage());
        softAssertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.DUPLICATED_NUMBER_ERROR.getMessage());
        softAssertions.assertAll();
    }

    @Test
    void 로또_정렬_테스트() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        List<Integer> numbers1 = lotto1.getNumbers();
        List<Integer> numbers2 = lotto2.getNumbers();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(numbers1).isSorted();
        softAssertions.assertThat(numbers2).isSorted();
        softAssertions.assertAll();
    }

    @Test
    void 로또_원소_테스트() {
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

}