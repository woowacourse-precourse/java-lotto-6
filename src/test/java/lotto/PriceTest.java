package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.Model.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {
    private Price price;

    @DisplayName("Price는 숫자로만 이루어져야 한다.")
    @Test
    void isNumber1() {
        String input = "5000원";

        assertThatThrownBy(() -> new Price(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백이나 쉼표같은 특수기호 없이 숫자만을 입력하세요.(최대 구입금액은 20억입니다)");
    }

    @DisplayName("Price가 20억~int형 타입 사이일 때 테스트")
    @Test
    void isNumber2() {
        String input = "2000000001";

        assertThatThrownBy(() -> new Price(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또구입금액은 최대 20억입니다.");
    }

    @DisplayName("Price가 int타입 넘어갈 때 테스트")
    @Test
    void isNumber3() {
        String input = "4000000001";

        assertThatThrownBy(() -> new Price(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백이나 쉼표같은 특수기호 없이 숫자만을 입력하세요.(최대 구입금액은 20억입니다)");
    }

    @DisplayName("Price가 1000원 단위로 떨어지지 않을 때")
    @Test
    void isDivideWithOneThousands() {
        String input = "1500";

        assertThatThrownBy(() -> new Price(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로 입력하세요.");
    }

    @DisplayName("Price가 0원 이하일 때")
    @Test
    void isCorrectRange() {
        String input = "0";

        assertThatThrownBy(() -> new Price(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또구입금액은 최소 1000원입니다.");
    }

    @DisplayName("Price가 1000원 단위로 나눠지는지")
    @Test
    void divideWithOneThousands() {
        price = new Price("5000");

        assertThat(price.divideWithOneThousands()).isEqualTo(5);
    }

    @DisplayName("당첨금액/구매금액 * 100을 해서 수익률이 잘 생성되는지 테스트")
    @Test
    void divideWith() {
        price = new Price("8000");

        assertThat(price.divideWith(5000)).isEqualTo(62.5);
    }
}
