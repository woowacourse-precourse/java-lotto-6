package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoScanner;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoScannerTest {

    private static final LottoScanner LOTTO_SCANNER = new LottoScanner();
    private static Lottos lottos;
    @BeforeAll
    static void init() {
        LottoScanner lottoScanner = new LottoScanner();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(9, 10, 11, 12, 13, 14));
        Lotto lotto4 = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        Lotto lotto5 = new Lotto(List.of(4, 5, 6, 7, 8, 12));
        lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4, lotto5));
    }
//    @Test
//    @DisplayName("보너스 숫자가 일치 하지 않는 로또 중 일치 하는 숫자 찾기")
//    void numberCheckWithoutBonusNumber() {
//        assertThat(lottoService.checkMatchedStandardNumberWithoutBonusNumber(lottos, new WinningLotto(List.of(3, 4, 5, 6, 7, 8), 12)))
//                .contains(4, 6);
//    }
//
//    @Test
//    @DisplayName("보너스 숫자가 일치 하는 로또 중 일치 하는 숫자 찾기")
//    void numberCheckWithBonusNumber() {
//        assertThat(lottoService.checkMatchedStandardNumberWithBonusNumber(lottos, new WinningLotto(List.of(3, 4, 5, 6, 7, 8), 12)))
//                .contains(2, 0);
//    }

    @Test
    @DisplayName("로또 당첨 여부 확인후 enum으로 리턴")
    void fullLottoService() {
        assertThat(LOTTO_SCANNER.sendAnalyzedResult(lottos, new WinningLotto(new Lotto(List.of(3, 4, 5, 6, 7, 8)), 12)))
                .contains(Rank.FOURTH, Rank.FIRST, Rank.SECOND);
    }
}
