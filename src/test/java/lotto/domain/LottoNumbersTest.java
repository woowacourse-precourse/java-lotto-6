package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import lotto.util.GenerateLottoNumbersSuccessTest;
import lotto.util.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @DisplayName("getLottoNumbers() : 로또 발행 테스트")
    @Test
    void getLottoNumbers_Success() throws Exception {
        //given
        RandomUtils randomUtils = new GenerateLottoNumbersSuccessTest();

        //when
        LottoNumbers lottoNumbers = new LottoNumbers(randomUtils);

        //then
        System.out.println(lottoNumbers.getLottoNumbers());
    }
}