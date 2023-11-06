package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoNumberCreatorTest {

    @Test
    public void 로또_숫자_생성_테스트() {
        //given
        int number = 5;
        LottoNumberCreator lottoNumberCreator = new LottoNumberCreator();

        //when
        Lottos lottos = lottoNumberCreator.createLottoNumbers(number);

        //then
        Assertions.assertThat(lottos.getSize()).isEqualTo(number);
    }
}
