package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @DisplayName("유저 입력값 전처리 테스트 - null 데이터 - 실패")
    @Test
    void preprocessInputNullTest() {
        String testString = null;

        assertThatThrownBy(() -> inputValidator.preprocessUserInput(testString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] null은 입력할 수 없습니다.");
    }

    @DisplayName("유저 입력값 전처리 테스트 - 빈 문자열 데이터 - 실패")
    @Test
    void preprocessInputEmptyTest() {
        String testString = "";

        assertThatThrownBy(() -> inputValidator.preprocessUserInput(testString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 값을 입력해주세요.");
    }

    @DisplayName("유저 입력값 전처리 테스트 - NonNumeric 데이터 - 실패")
    @Test
    void preprocessInputNonNumericTest() {
        String testString = "abcd";

        assertThatThrownBy(() -> inputValidator.preprocessUserInput(testString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }

    @DisplayName("유저 입력값 전처리 테스트 - 공백을 포함한 데이터 - 성공")
    @Test
    void preprocessInputCorrectTest() {
        String testString = "50 00";
        String expectedResult = "5000";

        assertThat(inputValidator.preprocessUserInput(testString)).isEqualTo(expectedResult);
    }

    @DisplayName("유저 입력값 구매금액 캐스팅 테스트 - 정상 데이터 - 성공")
    @Test
    void convertInputToPaymentAmountTest() {
        String testString = "5000";
        int expectedResult = 5000;

        assertThat(inputValidator.convertInputToPaymentAmount(testString)).isEqualTo(expectedResult);
    }

    @DisplayName("입력값 로또 번호 변환 테스트 - 4개의 쉼표 데이터 - 오류")
    @Test
    void convertWrongSeparatorInputTest() {
        String testString = "1,2,3,4,5";

        assertThatThrownBy(() -> inputValidator.convertInputToLottoNumbers(testString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구분자는 쉼표(,)를 사용해 6개의 번호를 입력해주세요.");
    }

    @DisplayName("입력값 로또 번호 변환 테스트 - 정상 데이터 - 성공")
    @Test
    void convertInputToLottoNumbersTest() {
        String testString = "1,2,3,4,5,6";
        List<Integer> expectedResult = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(inputValidator.convertInputToLottoNumbers(testString)).isEqualTo(expectedResult);
    }

    @DisplayName("입력값 보너스 번호 변환 테스트 - 2개 이상의 데이터 - 오류")
    @Test
    void convertBonusNumbersAmountTest() {
        String testString = "1,2";

        assertThatThrownBy(() -> inputValidator.convertInputToBonusNumber(testString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1개의 숫자만 입력해주세요.");
    }

    @DisplayName("입력값 보너스 번호 변환 테스트 - 정상 데이터 - 성공")
    @Test
    void convertCorrectBonusNumbersTest() {
        String testString = "12";
        Integer expectedResult = 12;

        assertThat(inputValidator.convertInputToBonusNumber(testString)).isEqualTo(expectedResult);
    }
}
