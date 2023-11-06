package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class LottoServiceTest {
    @DisplayName("랜덤으로 생성된 로또 번호가 6개인지 확인한다.")
    @RepeatedTest(1000)
    void generateLottoNumbersShouldReturnSizeSix() {
        // given
        final int LOTTO_NUMBERS_SIZE = 6;
        // when
        LottoService lottoService = new LottoService();
        List<Integer> lottoNumbers = lottoService.generateLottoNumbers();
        // then
        assertThat(lottoNumbers.size()).isEqualTo(LOTTO_NUMBERS_SIZE);
    }
}