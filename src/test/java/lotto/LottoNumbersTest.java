package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @Test
    void 번호_출력() {
        List<Integer> lottoNumber = List.of(1,2,3,4,5,6);
        List<Integer> lottoNumber2 = List.of(6,7,8,9,10,11);
        LottoNumbers lotto = new LottoNumbers(List.of(lottoNumber, lottoNumber2));
        assertThat(lotto.toString()).contains("[1, 2, 3, 4, 5, 6]");
        assertThat(lotto.toString()).contains("[6, 7, 8, 9, 10, 11]");
        System.out.println(lotto);
    }
}
