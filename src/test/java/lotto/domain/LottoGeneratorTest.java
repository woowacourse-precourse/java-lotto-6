package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {
    @ParameterizedTest
    @CsvSource(value = {"1", "2", "10", "30", "100"})
    @DisplayName("입력으로 들어온 개수의 로또 생성")
    void 입력으로_들어온_개수의_로또_생성(int count) {
        //given
        RandomSixNumberGenerator randomNumberGenerator = mock(RandomSixNumberGenerator.class);
        when(randomNumberGenerator.getSixNumber()).thenReturn(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoGenerator lottoGenerator = new LottoGenerator(randomNumberGenerator);

        //when
        List<Lotto> lottos = lottoGenerator.generateLottos(count);

        //then
        assertThat(lottos.size()).isEqualTo(count);
    }
}