package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoService;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    @Test
    @DisplayName("보너스 숫자가 일치 하지 않는 로또 중 일치 하는 숫자 찾기")
    void numberCheckWithoutBonusNumber() {
        LottoService lottoService = new LottoService();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(9, 10, 11, 12, 13, 14));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3));
        assertThat(lottoService.checkMatchedStandardNumberWithoutBonusNumber(lottos, new WinningLotto(List.of(3, 4, 5, 6, 7, 8), 12)))
                .contains(2, 4, 0);


    }
}
