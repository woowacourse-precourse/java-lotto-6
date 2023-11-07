package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import lotto.data.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ViewProcessorTest {
    private ViewProcessor viewProcessor;

    @BeforeEach
    void setUp() {
        viewProcessor = new ViewProcessor();
    }

//    @ParameterizedTest
//    @CsvSource({
//            "100,[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.",
//            "-25,[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.",
//    })
//    void checkExceptionWinning_입력값_범위_판단(int winning, String expect) {
//        assertThatThrownBy(() -> viewProcessor.checkExceptionWinning(winning))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(expect);
//    }

    @Test
    void checkLengthWinning_입력값_6자리_판단() {
        String[] invalidInputs = {"1", "2", "3", "4", "5", "6", "7"};
        assertThatThrownBy(() -> viewProcessor.checkLengthWinning(invalidInputs))
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

        assertThatThrownBy(() -> viewProcessor.checkValidBonusNum(input))
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

        assertThatThrownBy(() -> viewProcessor.checkValidPurchase(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expect);
    }

    @ParameterizedTest
    @MethodSource("parameterProviderMoneyEdit")
    void moneyEdit_상금액수_출력형식_변경_테스트(Rewards reward, String expect) {
        assertThat(viewProcessor.moneyEdit(reward)).isEqualTo(expect);
    }

    static Stream<Arguments> parameterProviderMoneyEdit() {
        return Stream.of(
                arguments(Rewards.FIRST, "(2,000,000,000원)"),
                arguments(Rewards.SECOND, "(30,000,000원)"),
                arguments(Rewards.THIRD, "(1,500,000원)"),
                arguments(Rewards.FOURTH, "(50,000원)"),
                arguments(Rewards.FIFTH, "(5,000원)")
        );
    }


}