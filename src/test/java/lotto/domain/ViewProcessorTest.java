package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import lotto.data.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ViewProcessorTest {
    private ViewProcessor viewProcessor;

    static Stream<Arguments> parameterProviderMoneyEdit() {
        return Stream.of(
                arguments(Rewards.FIRST, "(2,000,000,000원)"),
                arguments(Rewards.SECOND, "(30,000,000원)"),
                arguments(Rewards.THIRD, "(1,500,000원)"),
                arguments(Rewards.FOURTH, "(50,000원)"),
                arguments(Rewards.FIFTH, "(5,000원)")
        );
    }

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

    @DisplayName("입력 값이 없으면 에러처리 한다.")
    @Test
    void checkIsNull() {
        String input = "";
        assertThatThrownBy(()->viewProcessor.checkIsNull(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 사용자 입력 값이 null");
    }

    @Test
    void checkLengthWinning_입력값_6자리_판단() {
        List<String> invalidInputs = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        assertThatThrownBy(() -> viewProcessor.checkLengthWinning(invalidInputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호의 범위가 1~45 사이가 아닐경우 에러 처리한다.")
    @ParameterizedTest
    @CsvSource({"-10","51"})
    void checkRangeWinning(int invalidNum) {
        assertThatThrownBy(() -> viewProcessor.checkRangeWinning(invalidNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호에 중복된 수가 있으면 예외처리 한다.")
    @Test
    void checkExistWinning() {
        List<Integer> ExsistList = List.of(1,2,3,4);
        assertThatThrownBy(() -> viewProcessor.checkExistWinning(ExsistList,4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 서로 다른 숫자여야 합니다.");
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

    @DisplayName("구입금액 에러여부 판단한다.")
    @ParameterizedTest
    @CsvSource({
            "15,[ERROR] 구입 금액은 1000원 단위여야 합니다.",
            "-20,[ERROR] 구입 금액은 0원 초과해야 합니다.",
            "\0,[ERROR] 구입 금액은 정수여야 합니다.",
            "만원,[ERROR] 구입 금액은 정수여야 합니다."
    })
    void checkValidPurchase_(String input, String expect) {

        assertThatThrownBy(() -> viewProcessor.checkValidPurchase(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expect);
    }

    @DisplayName("구입금액이 최소금액(0) 이하일 경우 에러가 발생한다.")
    @Test
    void checkRangePurchase() {
        assertThatThrownBy(() -> viewProcessor.checkRangePurchase(-100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 0원 초과해야 합니다.");
    }

    @DisplayName("구입금액이 천원 단위가 아닐경우 에러가 발생한다.")
    @Test
    void checkUnitPurchase() {
        assertThatThrownBy(() -> viewProcessor.checkUnitPurchase(50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("parameterProviderMoneyEdit")
    void moneyEdit_상금액수_출력형식_변경_테스트(Rewards reward, String expect) {
        assertThat(viewProcessor.moneyEdit(reward)).isEqualTo(expect);
    }

    @DisplayName("구입 금액 처리가 성공하면 SUCESS, 예외 발생시 FAILDURE 반환한다.")
    @ParameterizedTest
    @CsvSource({"10000,SUCESS","15,FAILDURE","만원,FAILDURE","-10,FAILDURE"})
    void purchase(String tempCost, String state) {
        boolean expect = state.equals("FAILDURE");
        assertThat(viewProcessor.purchase(tempCost)).isEqualTo(expect);
    }
}