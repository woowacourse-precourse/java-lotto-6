package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @DisplayName("주어진 개수 만큼 로또를 발행 할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void createLottoAccordingGivenNumber(int number) {
        Lottos lottos = new Lottos(number);
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(number);
    }

}