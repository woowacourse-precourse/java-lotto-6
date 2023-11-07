package lotto.computer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.computer.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class RandomLottoGeneratorTest {

    private RandomLottoGenerator randomLottoGenerator;

    public RandomLottoGeneratorTest() {
        randomLottoGenerator = new RandomLottoGenerator();
        randomLottoGenerator.setMaxMoney(1000000);
    }

    @DisplayName("RandomLottoGenerator 랜덤 로또 생성 테스트")
    @ParameterizedTest
    @MethodSource("lotto.computer.MoneyArgumentsProvider#provideCorrectInput")
    void createUserLottosByCorrectInput(int money) {
        randomLottoGenerator.setMoney(money);
        assertThat(randomLottoGenerator.createLottos().lottoList().size())
                .isEqualTo(money / 1000);
    }

    @DisplayName("RandomLottoGenerator 설정 시 로또 구입 금액이 설정한 범위 밖일 때 예외 테스트")
    @ParameterizedTest
    @MethodSource("lotto.computer.MoneyArgumentsProvider#provideExceptionInput")
    void createUserLottosByExceptionInput(int money) {
        assertThatThrownBy(() -> randomLottoGenerator.setMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}