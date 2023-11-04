package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class LottoNumberGeneratorTest {

    @RepeatedTest(value = 10, name = "{currentRepetition}/{totalRepetitions}")
    @DisplayName("생성되는 로또 번호의 길이는 6이어야 한다.")
    void 로또_번호_크기_테스트() {
        //given, when
        List<Integer> lottoNumbers = LottoNumberGenerator.generateNumber();

        //then
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
