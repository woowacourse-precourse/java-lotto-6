package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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

    @DisplayName("랜덤으로 생성된 로또 번호가 1부터 45 사이의 숫자인지 확인한다.")
    @RepeatedTest(1000)
    void generateLottoNumbersShouldReturnNumbersInRange() {
        // given
        final int MINIMUM_LOTTO_NUMBER = 1;
        final int MAXIMUM_LOTTO_NUMBER = 45;
        // when
        LottoService lottoService = new LottoService();
        List<Integer> lottoNumbers = lottoService.generateLottoNumbers();
        // then
        assertThat(lottoNumbers).allMatch(number -> number >= MINIMUM_LOTTO_NUMBER && number <= MAXIMUM_LOTTO_NUMBER);
    }

    @DisplayName("랜덤으로 생성된 로또 번호가 중복되지 않는지 확인한다.")
    @RepeatedTest(1000)
    void generateLottoNumbersShouldReturnUniqueNumbers() {
        // given
        // when
        LottoService lottoService = new LottoService();
        List<Integer> lottoNumbers = lottoService.generateLottoNumbers();
        // then
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }
}