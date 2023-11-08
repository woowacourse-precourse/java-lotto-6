package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.utils.constants.ExceptionMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ValidatorTest {

    private static Stream<Arguments> purchaseAmountAndGet_천단위_로또구매금액_검증_실패한다() {
        return Stream.of(
            Arguments.of(1500),
            Arguments.of(2550)
        );
    }

    private static Stream<Arguments> lottoNumberAndGet_로또_번호_검증_실패한다() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 46)),
            Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5)),
            Arguments.of(Arrays.asList(-1, 1, -2, -3, 5)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    private static Stream<Arguments> bonusNumberAndGet_보너스번호_검증_실패한다() {
        return Stream.of(
            Arguments.of("0", new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))),
            Arguments.of(100, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))
        );
    }

    private static Stream<Arguments> isBlank_공백입력_검증_실패한다() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of(" "),
            Arguments.of("  "),
            Arguments.of("\t")
        );
    }

    @Test
    void purchaseAmountAndGet_천단위_로또구매금액_검증_성공한다() {
        int purchaseAmount = 2000;
        assertDoesNotThrow(() -> Validator.purchaseAmountAndGet(String.valueOf(purchaseAmount)));
    }

    @ParameterizedTest
    @MethodSource("purchaseAmountAndGet_천단위_로또구매금액_검증_실패한다")
    void purchaseAmountAndGet_천단위_로또구미금액_검증_실패한다(Integer purchaseAmount) {
        assertThatThrownBy(() -> Validator.purchaseAmountAndGet(String.valueOf(purchaseAmount)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.PURCHASE_AMOUNT_SHOULD_BE_MULTIPLE_OF_THOUSAND.getMessage());

    }

    @Test
    void lottoNumberAndGet_로또_당첨번호_검증_성공한다() {
        List<Integer> numberStrings = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> Validator.lottoNumberAndGet(numberStrings));
    }

    @ParameterizedTest
    @MethodSource("lottoNumberAndGet_로또_번호_검증_실패한다")
    void lottoNumberAndGet_로또_번호_검증_실패한다(List<Integer> winningNumbers) {
        assertThatThrownBy(() -> Validator.lottoNumberAndGet(winningNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void bonusNumberAndGet_보너스번호_검증_성공한다() {
        String bonusNumberStr = "7";
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> Validator.bonusNumberAndGet(bonusNumberStr, winningNumbers));
    }

    @ParameterizedTest
    @MethodSource("bonusNumberAndGet_보너스번호_검증_실패한다")
    void bonusNumberAndGet_보너스번호_검증_실패한다(int bonusNumber, Lotto winningNumbers) {
        assertThatThrownBy(() -> Validator.bonusNumberAndGet(String.valueOf(bonusNumber), winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.INPUT_SHOULD_BE_IN_RANGE.getMessage());
    }

    @Test
    void isBlank_공백입력_검증_성공한다() {
        String numberValue = "1";
        assertDoesNotThrow(() -> Validator.isBlank(numberValue));
    }

    @ParameterizedTest
    @MethodSource("isBlank_공백입력_검증_실패한다")
    void isBlank_공백입력_검증_실패한다(String numberValue) {
        assertThatThrownBy(() -> Validator.isBlank(numberValue))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.INPUT_BLANK.getMessage());
    }
}
