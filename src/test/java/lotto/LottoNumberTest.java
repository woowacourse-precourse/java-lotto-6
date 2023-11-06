package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @DisplayName("로또 번호를 생성한다.")
    @Test
    public void createLottoNumber() {
        int number = 1;
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber.getNumber())
            .isEqualTo(number);
    }

    @DisplayName("1 부터 45 밖의 수를 입력하면 예외가 발생한다.")
    @Test
    public void invalidLottoNumber() {
        assertThatThrownBy(
            () -> {
                int number = 47;
                new LottoNumber(number);
            }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
