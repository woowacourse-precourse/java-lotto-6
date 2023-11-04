package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.Lotto;
import lotto.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGeneratorTest {
    @DisplayName("입력 변수 만큼의 Lotto를 생성하는 기능")
    @ParameterizedTest
    @ValueSource(ints={3,5,7,9})
    void 로또_여러개_생성_기능(int count){
        LottoGenerator lottoGenerator=LottoGenerator.INSTANCE;
        List<Lotto> lottos=lottoGenerator.generate(count);

        assertThat(lottos.size()).isEqualTo(count);
    }

}
