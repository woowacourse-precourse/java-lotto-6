package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @Test
    void 번호_출력() {
        LottoNumber lottoNumber = new LottoNumber(List.of(1,2,3,4,5,6));
        LottoNumber lottoNumber2 = new LottoNumber(List.of(6,7,8,9,10,11));
        List<LottoNumber> lottoNumbers = List.of(lottoNumber, lottoNumber2);
        LottoNumbers lotto = new LottoNumbers(lottoNumbers);
        assertThat(lotto.toString()).contains("[1, 2, 3, 4, 5, 6]");
        assertThat(lotto.toString()).contains("[6, 7, 8, 9, 10, 11]");
        System.out.println(lotto);
    }
}
