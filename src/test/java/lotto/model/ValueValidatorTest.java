package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValueValidatorTest {
    private ValueValidator valueValidator;

    @BeforeEach
    public void setup() {
        valueValidator = new ValueValidator();
    }

    @DisplayName("구매 가격에 숫자 외 다른 문자가 있으면 예외를 발생합니다.")
    @Test
    void 구매_가격_테스트_1() {
        assertThatThrownBy(() -> valueValidator.validatePurchasedPrice("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 가격이 1000 원 이하일 때 예외를 발생합니다.")
    @Test
    void 구매_가격_테스트_2() {
        assertThatThrownBy(() -> valueValidator.validatePurchasedPrice("900"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또의 개수가 6 이하이면 예외를 발생합니다.")
    @Test
    void 당첨_로또_테스트_1() {
        assertThatThrownBy(() -> valueValidator.validateWinningNumbersValue(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또에 중복 숫자가 존재하면 예외를 발생합니다.")
    @Test
    void 당첨_로또_테스트_2() {
        assertThatThrownBy(() -> valueValidator.validateWinningNumbersValue(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또에 숫자외의 문자가 존재하면 예외를 발생합니다.")
    @Test
    void 보너스_숫자_테스트_1() {
        assertThatThrownBy(() -> valueValidator.validateBonusNumber("1b"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또의 범위가 1 이상 45 이하가 아닌 경우 예외를 발생합니다.")
    @Test
    void 보너스_숫자_테스트_2() {
        assertThatThrownBy(() -> valueValidator.validateBonusNumber("90"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}