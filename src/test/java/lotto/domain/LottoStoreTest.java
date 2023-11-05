package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {
    @DisplayName("정해진 횟수 만큼 로또를 생성 한다")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void issueLottoPerAttempt(int attempt) {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> issuedLotto = new ArrayList<>();

        for (int i = 0; i < attempt; i++) {
            lottoStore.issueLotto();
            issuedLotto = lottoStore.getIssuedLotto();
        }

        assertThat(issuedLotto.size()).isEqualTo(attempt);
    }
}