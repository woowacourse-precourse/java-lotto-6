package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoRankEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameResultTest {

    @DisplayName("calculateLottoResult 메소드 : 로또 등수 반환 테스트")
    @Test
    void calculateLottoResult_rankResult() {
        LottoGameResult lottoGameResult = new LottoGameResult();

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = new ArrayList<>(List.of(4, 5, 6, 7, 8, 9));
        int bonusNumber = 1;
        Winning winning = new Winning(winningNumbers, bonusNumber);

        assertThat(lottoGameResult.calculateLottoRank(lotto, winning)).isEqualTo(LottoRankEnum.FIFTH);
    }
}