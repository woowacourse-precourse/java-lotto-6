package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import lotto.domain.generator.LottoGeneratorImpl;
import lotto.domain.generator.RandomLottoGenerator;

public class LottosTest {
    @Test
    void 로또_개수에_따라_로또가_생성되어야_함() {
        //given
        int givenLottoCount = 5;
        
        //when
        LottoGeneratorImpl lottoGenerator = new RandomLottoGenerator();
        Lottos lottos = Lottos.fromCount(givenLottoCount, lottoGenerator);
        int lottoCount = lottos.getLottos().size();
        
        //then
        assertThat(lottoCount).isEqualTo(givenLottoCount);
    }
}
