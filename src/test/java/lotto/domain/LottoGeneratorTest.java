package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {
    LottoGenerator lottoGenerator = new LottoGenerator();
    final String testMoney = "10000";

    @BeforeEach
    void setUp() {
        lottoGenerator.configMoney(testMoney);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234567890123", "-1", "abc", ""})
    @DisplayName("사용자 금액 입력에 대한 예외 처리")
    void configMoney(String input) {
        assertThatThrownBy(() -> lottoGenerator.configMoney(input)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoGenerator.configMoney(input)).hasMessageContaining("[ERROR]");
    }

    @Test
    void Given_TenThousandWon_When_generatedLottos_Then_getTenLotto() {
        Lottos lottos = lottoGenerator.generateLottos();
        assertThat(lottos.size()).isEqualTo(10);
    }
    
}