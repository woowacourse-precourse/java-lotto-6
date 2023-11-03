package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class GenerateLottoTest {

    @Test
    public void 로또_번호_생성_테스트() throws Exception {

        //given
        GenerateLotto generateLotto = new GenerateLotto();
        int count = 5;

        //when
        List<Lotto> lottos = generateLotto.getLottoNumbers(count);

        //then
        assertThat(lottos.size()).isEqualTo(5);
    }

}