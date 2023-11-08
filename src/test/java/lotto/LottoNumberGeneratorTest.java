package lotto;

import lotto.dto.LottoNumberDTO;
import lotto.model.Lotto;
import lotto.service.LottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {
    private static LottoNumberGenerator lottoNumberGenerator;
    @BeforeEach
    void init() {
        lottoNumberGenerator = LottoNumberGenerator.getLottoNumberGenerator();
    }
    @DisplayName("랜덤 로또 번호 생성 테스트")
    @Test
    void 랜던_로또_번호_생성_테스트() {
        assertThat(lottoNumberGenerator.generate().getLotto()).asList()
                .isNotNull().hasSize(6);
    }
}
