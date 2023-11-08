package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoGeneratorTest {

    @DisplayName("비용에 맞게 로또 여러개를 생성한다.")
    @Test
    public void generateLottoBundle() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottoList = lottoGenerator.generateLottoBundle(10000);
        assertThat(lottoList.size()).isEqualTo(10);
    }

}