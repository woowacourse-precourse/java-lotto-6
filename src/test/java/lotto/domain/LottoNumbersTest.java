package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
    private static List<Integer> lottoNumberList;

    @Test
    void 로또_랜덤숫자_생성() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumberList = lottoNumbers.setRandomNumbers();
        assertThat(lottoNumberList.size()).isEqualTo(6);
    }
}
