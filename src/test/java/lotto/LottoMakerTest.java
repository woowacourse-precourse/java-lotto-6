package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMakerTest {

    @DisplayName("전달 받은 갯수 만큼 로또를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void test(int amount) {
        List<Lotto> lottos = LottoMaker.makeLotto(amount);

        assertThat(lottos.size()).isEqualTo(amount);
    }
}