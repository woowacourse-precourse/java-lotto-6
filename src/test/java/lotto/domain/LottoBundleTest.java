package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBundleTest {
    private LottoBundle lottoBundle;
    private List<Lotto> testLottos;

    @BeforeEach
    void setup() {
        testLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)));
    }

    @DisplayName("로또 묶음이 잘 생성되었는지 확인")
    @Test
    void checkBundle() {
        lottoBundle = new LottoBundle(testLottos);
        assertThat(lottoBundle.getBundle()).usingRecursiveComparison().isEqualTo(testLottos);
    }

    @DisplayName("로또 묶음의 구매 가격 확인")
    @Test
    void checkPriceOfBundle() {
        lottoBundle = new LottoBundle(testLottos);
        assertThat(lottoBundle.showInvestment()).isEqualTo(3000);
    }
}