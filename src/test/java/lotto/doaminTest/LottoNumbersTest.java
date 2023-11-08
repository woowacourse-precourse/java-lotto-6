package lotto.doaminTest;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoNumbers.lottoNumberList;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    void 로또_랜덤숫자_생성(){
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> lottoNumberlist = lottoNumbers.setRandomNumbers();

       assertThat (lottoNumberList.size());
    }
}
