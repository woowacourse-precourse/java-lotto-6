package lotto;

import lotto.model.LottoMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoMakerTest {

    @DisplayName("1000원 단위로 로또가 생성되어야한다.")
    @Test
    void getLottosTest(){
        LottoMaker lottoMaker = new LottoMaker(3000);

        assertThat(lottoMaker.getLottos())
                .hasSize(3);

    }
}
