package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

    @DisplayName("입력한 구매 금액이 로또 가격의 단위가 아니면 에외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1500, 5999})
    void lottoCountNotInteger(int amount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Assertions.assertThatThrownBy(() -> lottoGenerator.generateLottoBundle(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 구매 금액이 양수가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1000, 0})
    void lottoCountNotPositive(int amount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Assertions.assertThatThrownBy(() -> lottoGenerator.generateLottoBundle(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
