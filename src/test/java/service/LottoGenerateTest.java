package service;

import lotto.domain.Lotto;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoGeneratorServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGenerateTest {
    LottoGeneratorService lottoGeneratorService = LottoGeneratorServiceImpl.getInstance();

    @Test
    @DisplayName("나의 로또 생성 테스트")
    void myLottos() {
        List<Lotto> lottos = lottoGeneratorService.myLottos("7000");
        assertThat(lottos.size()).isEqualTo(7);
    }

    @Test
    @DisplayName("나의 로또 생성 실패 테스트 - 1000단위 실패")
    void myLottosFailWithUnitFirst() {
        assertThatThrownBy(() -> lottoGeneratorService.myLottos("7500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("나의 로또 생성 실패 테스트 - 1000단위 실패")
    void myLottosFailWithUnitSecond() {
        assertThatThrownBy(() -> lottoGeneratorService.myLottos("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("나의 로또 생성 실패 테스트 - 숫자 이외의 값")
    void myLottosFail() {
        assertThatThrownBy(() -> lottoGeneratorService.myLottos("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
