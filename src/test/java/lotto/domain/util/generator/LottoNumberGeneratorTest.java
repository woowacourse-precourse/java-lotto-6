package lotto.domain.util.generator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.config.LottoConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {
    private ILottoNumberGenerator iLottoNumberGenerator;

    @BeforeEach
    void setUp() {
        iLottoNumberGenerator = new LottoNumberGenerator();
    }

    @DisplayName("랜덤으로 숫자를 생성하는지 확인한다.")
    @Test
    public void createRandom_랜덤_숫자_생성() {
        List<Integer> answer = List.of(3, 42, 10, 34, 21, 25);

        assertRandomUniqueNumbersInRangeTest(() -> {
            List<Integer> result = iLottoNumberGenerator.createRandom();
            assertThat(result).hasSize(LottoConfig.SIZE.getValue()).isEqualTo(answer);
        }, answer);
    }
}