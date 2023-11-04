package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {
    @DisplayName("정해진 횟수 만큼 로또를 생성 한다")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void issueLottoPerAttempt(int attempt) {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> issuedLottos = new ArrayList<>();

        for (int i = 0; i < attempt; i++) {
            issuedLottos.add(lottoMachine.issueLotto());
        }

        assertThat(issuedLottos.size()).isEqualTo(attempt);
    }
}