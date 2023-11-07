package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoMachineTest {

    @ParameterizedTest
    @DisplayName("로또 게임 수에 맞는 로또를 발행하는 지 확인한다.")
    @MethodSource("generateLottoGameCountData")
    void lottoPublishingTest(int gameCount, int expectedPublishedLotto) {
        int publishedLotto = LottoMachine.purchaseLotto(gameCount).size();

        assertThat(publishedLotto).isEqualTo(expectedPublishedLotto);
    }

    static Stream<Arguments> generateLottoGameCountData() {
        return Stream.of (
                Arguments.of(4, 4),
                Arguments.of(5, 5),
                Arguments.of(10, 10)
        );
    }
}
