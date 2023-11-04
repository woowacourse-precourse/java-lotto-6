package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("로또 번호 생성기 테스트")
class LottoNumberGeneratorServiceTest {

    @DisplayName("생성된 로또 번호는 1-45 범위를 지킨다")
    @RepeatedTest(50)
    void testGeneratedLottoNumberIsInRange() {
        LottoNumberGeneratorService lottoNumberGeneratorService = new LottoNumberGeneratorService();
        Assertions.assertThatNoException().isThrownBy(lottoNumberGeneratorService::generate);
    }

}