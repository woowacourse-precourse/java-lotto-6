package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import lotto.ApplicationConfig;
import lotto.model.lotto.Lotto;
import lotto.model.trade.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class AutoLottoGeneratorTest {
    final static int TEST_NUMBER = 5;
    ApplicationConfig applicationConfig;
    LottoGenerator autoLottoGenerator;

    @BeforeEach
    void setGenerator() {
        applicationConfig = new ApplicationConfig();
        autoLottoGenerator = applicationConfig.lottoGenerator();
    }

    @DisplayName("자동 로또 발행기는 하나의 로또를 발행해야 한다.")
    @Test
    void createLottoByAutoLottoGenerator() {
        //when, then
        assertThat(autoLottoGenerator.generate()).isInstanceOf(Lotto.class);
    }

    @DisplayName("자동 로또 발행기는 유효한 로또를 발행해야 한다.")
    @RepeatedTest(TEST_NUMBER)
    void createValidLottoByAutoLottoGenerator() {
        //when, then
        assertDoesNotThrow(() -> autoLottoGenerator.generate());
    }
}
