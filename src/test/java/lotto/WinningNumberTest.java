package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @DisplayName("우승 번호를 생성한다.")
    @Test
    public void purchaseNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ), new LottoNumber(7));
        assertThat(winningNumber.getNumbersValue()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningNumber.getBonusNumberValue()).isEqualTo(7);
    }

    @DisplayName("우승 번호가 6글자가 아니면 예외가 발생한다.")
    @Test
    public void purchaseNumberLength() {
        assertThatThrownBy(
                () -> {
                    new WinningNumber(List.of(
                            new LottoNumber(1),
                            new LottoNumber(2),
                            new LottoNumber(3),
                            new LottoNumber(4),
                            new LottoNumber(5)
                    ), new LottoNumber(7));
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("우승 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    public void purchaseNumberDuplicated() {
        assertThatThrownBy(
                () -> {
                    new WinningNumber(List.of(
                            new LottoNumber(1),
                            new LottoNumber(1),
                            new LottoNumber(3),
                            new LottoNumber(4),
                            new LottoNumber(5),
                            new LottoNumber(6)
                    ), new LottoNumber(7));
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("우승 번호에 보너스 번호 중복이 있으면 예외가 발생한다.")
    @Test
    public void purchaseNumberAndBonus() {
        assertThatThrownBy(
                () -> {
                    new WinningNumber(List.of(
                            new LottoNumber(1),
                            new LottoNumber(1),
                            new LottoNumber(3),
                            new LottoNumber(4),
                            new LottoNumber(5),
                            new LottoNumber(6)
                    ), new LottoNumber(6));
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}