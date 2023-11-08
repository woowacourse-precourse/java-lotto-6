package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    void 맞춘_로또_번호() {
        LottoNumber lottoNumber = new LottoNumber(List.of(1,2,3,4,5,6));
        assertThat(lottoNumber.calculateScore(1)).isTrue();
    }

}
