package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ThousandUnitMoneyTest {

    @Test
    public void 금액_객체생성_정상문자값() {
        // Given
        String input = "5000";

        // When
        ThousandUnitMoney money = ThousandUnitMoney.create(input);

        // Then
        assertTrue(money.isSameAmount(5000));
    }

    @Test
    public void 금액_객체생성_정상정수값() {
        // Given
        int input = 5000;

        // When
        ThousandUnitMoney money = ThousandUnitMoney.create(input);

        // Then
        assertTrue(money.isSameAmount(5000));
    }

    @Test
    public void 금액_앞뒤의_공백제거() {
        // Given
        String input = " 1000 ";

        // When
        ThousandUnitMoney money = ThousandUnitMoney.create(input);

        // Then
        assertTrue(money.isSameAmount(1000));
    }

    @Test
    public void 금액_정수가아닌_문자일시_예외발생() {
        // Given
        String input = "k";

        // When && Then
        assertThatThrownBy(() -> ThousandUnitMoney.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 2,147,483,647 이하의 정수 값이 필요합니다.");
    }

    @Test
    public void 금액_정수범위_벗어난_숫자일시_예외발생() {
        // Given
        String input = "2200000000";

        // When && Then
        assertThatThrownBy(() -> ThousandUnitMoney.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 2,147,483,647 이하의 정수 값이 필요합니다.");
    }

    @Test
    public void 금액_1000의배수_아닐시_예외발생() {
        // Given
        String input = "1234";

        // When && Then
        assertThatThrownBy(() -> ThousandUnitMoney.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000의 배수인 숫자가 필요합니다.");
    }

    @Test
    public void 금액_값이동일하면_true() {
        // Given
        ThousandUnitMoney money1 = ThousandUnitMoney.create(1000);

        // When
        boolean result = money1.isSameAmount(1000);

        // Then
        assertTrue(result);
    }

    @Test
    public void 금액_값이다르면_false() {
        // Given
        ThousandUnitMoney money1 = ThousandUnitMoney.create(1000);

        // When
        boolean result = money1.isSameAmount(2000);

        // Then
        assertFalse(result);
    }

    @Test
    public void 금액_더하기는_int합_반환() {
        // Given
        ThousandUnitMoney money1 = ThousandUnitMoney.create(1000);
        ThousandUnitMoney money2 = ThousandUnitMoney.create(2000);

        // When
        int result = money1.plus(money2);

        // Then
        assertThat(result).isEqualTo(3000);
    }

    @Test
    public void 금액_더하기_int범위초과시_예외처리() {
        // Given
        ThousandUnitMoney money1 = ThousandUnitMoney.create(1200000000);
        ThousandUnitMoney money2 = ThousandUnitMoney.create(1000000000);

        // When && Then
        assertThatThrownBy(() -> money1.plus(money2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수 범위를 벗어난 값은 더할 수 없습니다.");
    }


    @Test
    public void 금액_천단위_구분자_문자형식으로_변환() {
        // Given
        ThousandUnitMoney money1 = ThousandUnitMoney.create(1000);

        // When
        String result = money1.toString();

        // Then
        assertThat(result).isEqualTo("1,000");
    }
}
