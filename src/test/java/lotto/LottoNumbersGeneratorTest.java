package lotto;

import java.util.List;
import lotto.domain.LottoNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumbersGeneratorTest {


    @Test
    void 로또_번호_6개_생성_테스트() {
        //given

        //when
        List<Integer> lottoNumbers = LottoNumbersGenerator.generateRandomNumbers();
        //then
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    void 로또_번호_중복_테스트() {
        //given

        //when
        List<Integer> lottoNumbers = lottoNumbersGenerator.generateRandomNumbers();
        long count = lottoNumbers.stream()
                .distinct().count();
        //then
        Assertions.assertThat(count).isEqualTo(6);
    }
}