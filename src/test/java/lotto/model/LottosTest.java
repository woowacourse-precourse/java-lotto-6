package lotto.model;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    private static Lottos defaultLottos;
    private static Lotto defaultLotto;

    @BeforeAll
    static void setLottos() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        defaultLotto = new Lotto(lottoNumbers);
        defaultLottos = new Lottos();
    }

    @BeforeEach
    void addLottos() {
        defaultLottos.addLotto(defaultLotto);
    }

    @AfterEach
    void resetLottos() {
        defaultLottos.clearLottos();
    }

    @DisplayName("로또 저장 테스트 - 정상 데이터 - 성공")
    @Test
    void addLottoTest() {
        List<Integer> testLottoNumbers = Arrays.asList(7, 8, 9, 10, 11, 12);
        Lotto testLotto = new Lotto(testLottoNumbers);
        defaultLottos.addLotto(testLotto);

        assertThat(defaultLottos.getLottos()).contains(testLotto);
        assertThat(defaultLottos.getLottos()).contains(defaultLotto);
    }
}
