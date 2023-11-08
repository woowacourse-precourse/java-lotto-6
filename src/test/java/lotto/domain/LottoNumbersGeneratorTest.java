package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumbersGeneratorTest {

    @Test
    @DisplayName("로또 당첨 번호 랜덤 생성 테스트")
    void 로또_당첨_번호_랜덤_생성() {
        List<Integer> lottoWinningNumbers = LottoNumbersGenerator.generate();

        assertThat(lottoWinningNumbers).isNotNull();
    }
}
