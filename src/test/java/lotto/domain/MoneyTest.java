package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    public void 금액_객체생성_정상문자값() {
        // Given
        String input = "5000";

        // When
        Money money = Money.create(input);

        // Then
        assertTrue(money.isSameAmount(5000));
    }

    @Test
    public void 금액_객체생성_정상정수값() {
        // Given
        int input = 5000;

        // When
        Money money = Money.create(input);

        // Then
        assertTrue(money.isSameAmount(5000));
    }

    @Test
    public void 금액_앞뒤의_공백제거() {
        // Given
        String input = " 1000 ";

        // When
        Money money = Money.create(input);

        // Then
        assertTrue(money.isSameAmount(1000));
    }

    @Test
    public void 금액_정수가아닌_문자일시_예외발생() {
        // Given
        String input = "k";

        // When && Then
        assertThatThrownBy(() -> Money.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 2,147,483,647 이하의 정수 값이 필요합니다.");
    }

    @Test
    public void 금액_정수범위_벗어난_숫자일시_예외발생() {
        // Given
        String input = "2200000000";

        // When && Then
        assertThatThrownBy(() -> Money.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 2,147,483,647 이하의 정수 값이 필요합니다.");
    }

    @Test
    public void 금액_1000의배수_아닐시_예외발생() {
        // Given
        String input = "1234";

        // When && Then
        assertThatThrownBy(() -> Money.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000의 배수인 숫자가 필요합니다.");
    }

    @Test
    public void 금액_값이동일하면_true() {
        // Given
        Money money1 = Money.create(1000);

        // When
        boolean result = money1.isSameAmount(1000);

        // Then
        assertTrue(result);
    }

    @Test
    public void 금액_값이다르면_false() {
        // Given
        Money money1 = Money.create(1000);

        // When
        boolean result = money1.isSameAmount(2000);

        // Then
        assertFalse(result);
    }

    @Test
    public void 금액_더하기는_새로운Money객체_반환() {
        // Given
        Money money1 = Money.create(1000);
        Money money2 = Money.create(2000);

        // When
        Money result = money1.plus(money2);

        // Then
        assertThat(result).isNotSameAs(money1);
        assertThat(result).isNotSameAs(money2);
        assertTrue(result.isSameAmount(3000));
    }

    @Test
    public void 금액_천단위_구분자_문자형식으로_변환() {
        // Given
        Money money1 = Money.create(1000);

        // When
        String result = money1.toString();

        // Then
        assertThat(result).isEqualTo("1,000");
    }
}
