package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoCreatorTest {

    @Test
    void 로또생성기_로또리스트_반환_테스트() {
        LottoCreator lottoCreator = new LottoCreator();

        int lottoCount = 5;
        lottoCreator.createLotto(lottoCount);

        Assertions.assertThat(lottoCreator.getCreatedLottos().size()).isEqualTo(lottoCount);
    }

}
