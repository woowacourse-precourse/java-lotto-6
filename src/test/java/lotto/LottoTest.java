package lotto;

import lotto.controller.ErrorCheck;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    //     아래에 추가 테스트 작성 가능
    @DisplayName("로또 범위를 넘어갔을 경우 예외가 발생한다")
    @Test
    void validateMaxAndMinNumTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 0, 46, 2, 3, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.isMaxAndMinValue());
    }

    @DisplayName("1000으로 안 나누어질 경우 예외가 발생한다")
    @Test
    void priceErrorCheckTest() {
        assertThatThrownBy(() -> ErrorCheck.priceErrorCheck("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.notPriceMessage());
    }

    @DisplayName("정수형이 아닐 경우 예외가 발생한다")
    @Test
    void isDigitErrorCheckTest() {
        String[] stringArr = {"a", " 2", "$", " "};
        assertThatThrownBy(() -> ErrorCheck.stringChangeChar(stringArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.notIntegerMessage());
    }

    @DisplayName("중복된 값이 있을 경우 예외가 발생한다")
    @Test
    void isDuplicationErrorcheckTset() {
        String choice = "1";
        assertThatThrownBy(() -> ErrorCheck.isDuplicationErrorCheck(choice, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.isDuplication());
    }

    @DisplayName("로또 범위를 넘어갔을 경우 예외가 발생한다")
    @Test
    void isValidateMaxAndMinNumTest() {
        String[] stringArr = {"0", "46", "234", "3215"};
        for (String s : stringArr) {
            assertThatThrownBy(() -> ErrorCheck.isValidateMaxAndMinNum(s))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.isMaxAndMinValue());
        }
    }

    @DisplayName("공백을 입력했을 경우 예외가 발생한다")
    @Test
    void isSpaceValueTest() {
        String space = "";
        assertThatThrownBy(() -> ErrorCheck.isSpaceValue(space))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.isSpace());
    }


    @DisplayName("Lotto클래스 값의 범위를 넘었을경우 예외가 발생한다")
    @Test
    void lottoMaxAndMinNumTest() {
        List<Integer> numbers = List.of(1, 45, 6, 0, 74, 100);
        assertThatThrownBy(() -> Lotto.validateMaxAndMinNum(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.isMaxAndMinValue());

    }

    @DisplayName("Lotto 클래스의 값에 중봑이 있을경우 예외가 발생한다")
    @Test
    void lottoDuplicationTest() {
        List<Integer> numbers = List.of(1, 2, 1, 4, 5, 5);
        assertThatThrownBy(() -> Lotto.validateIsDuplicationErrorCheck(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.isDuplication());
    }

    @DisplayName("Lotto 클래스의 값의 길이가 6이 아닐경우 예외가 발생한다")
    @Test
    void validateTest() {
        List<List<Integer>> numbers = new ArrayList<>(List.of(List.of(1,2,3),
                                                      List.of(1,2,3,4,5,6,7)));
        for (List<Integer> number : numbers) {
            assertThatThrownBy(() -> new Lotto(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.notValue());
        }
    }
}