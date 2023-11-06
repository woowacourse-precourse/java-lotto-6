package lotto.service.generate;

import lotto.constant.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.exception.LottoException;
import lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoAutoGenerateServiceTest {

    @Test
    @DisplayName("로또 1개를 정상적으로 생성하는 테스트")
    void generateLotto() throws LottoException {
        LottoAutoGenerateService autoGenerateService = LottoAutoGenerateService.getInstance();
        Lottos lottos = autoGenerateService.generate(1);

        List<Lotto> lottoGroup = lottos.lottoGroup();
        assertThat(lottoGroup.size()).isEqualTo(1);

        for (Lotto lotto : lottoGroup) {
            List<LottoNumber> lottoNumbers = lotto.getNumbers();
            assertEquals(6, lottoNumbers.size());
            for (LottoNumber number : lottoNumbers) {
                assertThat(number.value() >= LottoConstants.LOTTO_MIN_NUMBER.getValue()).isTrue();
                assertThat(number.value() <= LottoConstants.LOTTO_MAX_NUMBER.getValue()).isTrue();
            }
        }
    }

    @Test
    @DisplayName("로또 여러 개를 생성하는 정상 테스트")
    void generateLottos() throws LottoException {
        LottoAutoGenerateService autoGenerateService = LottoAutoGenerateService.getInstance();
        Lottos lottos = autoGenerateService.generate(5);

        List<Lotto> lottoGroup = lottos.lottoGroup();
        assertThat(lottoGroup.size()).isEqualTo(5);

        for (Lotto lotto : lottoGroup) {
            List<LottoNumber> lottoNumbers = lotto.getNumbers();
            assertEquals(6, lottoNumbers.size());
            for (LottoNumber number : lottoNumbers) {
                assertThat(number.value() >= LottoConstants.LOTTO_MIN_NUMBER.getValue()).isTrue();
                assertThat(number.value() <= LottoConstants.LOTTO_MAX_NUMBER.getValue()).isTrue();
            }
        }
    }
}
