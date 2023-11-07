package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputUITest {
    private InputUI inputUI;

    @BeforeEach
    void setUp() {
        inputUI = new InputUI();
    }

//    @ParameterizedTest
//    @CsvSource({
//            "100,[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.",
//            "-25,[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.",
//    })
//    void checkExceptionWinning_입력값_범위_판단(int winning, String expect) {
//        assertThatThrownBy(() -> inputUI.checkExceptionWinning(winning))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(expect);
//    }

    @Test
    void checkLengthWinning_입력값_6자리_판단() {
        String[] invalidInputs = {"1", "2", "3", "4", "5", "6", "7"};
        assertThatThrownBy(() -> inputUI.checkLengthWinning(invalidInputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "100,[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.",
            "-20,[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.",
            "\0,[ERROR] 보너스 번호는 정수여야 합니다.",
            "삼십,[ERROR] 보너스 번호는 정수여야 합니다."
    })
    void checkValidBonusNum_보너스_입력값_에러여부_판단(String input, String expect) {

        assertThatThrownBy(() -> inputUI.checkValidBonusNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expect);
    }

    @ParameterizedTest
    @CsvSource({
            "15,[ERROR] 구입 금액은 1000원 단위여야 합니다.",
            "-20,[ERROR] 구입 금액은 0원 이상이여야 합니다.",
            "\0,[ERROR] 구입 금액은 정수여야 합니다.",
            "만원,[ERROR] 구입 금액은 정수여야 합니다."
    })
    void checkValidPurchase_입력값_에러여부_판단(String input, String expect) {

        assertThatThrownBy(() -> inputUI.checkValidPurchase(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expect);
    }


}