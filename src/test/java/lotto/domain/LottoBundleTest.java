package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBundleTest {
    private Lotto lotto1;
    private Lotto lotto2;
    private List<Lotto> expectedLottos;
    private LottoBundle lottoBundle;

    @BeforeEach
    void setUp() {
        lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto2 = new Lotto(List.of(2, 4, 6, 8, 10, 12));
        expectedLottos = List.of(lotto1, lotto2);
        lottoBundle = LottoBundle.from(expectedLottos);
    }

    @DisplayName("구매한 로또번호 List를 LottoBundle 객체로 생성한다.")
    @Test
    void createLottoBundle() {
        assertThat(lottoBundle.getLottos()).isEqualTo(expectedLottos);
    }

    @DisplayName("구매한 로또번호를 줄바꿈으로 구분하여 문자열로 변환한다.")
    @Test
    void toStringTest() {
        String actualString = lottoBundle.toString();
        String expectedString = lotto1.toString() + "\n" + lotto2.toString();

        assertThat(actualString).isEqualTo(expectedString);
    }
}