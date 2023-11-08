package lotto.domain;

import lotto.constants.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private Lottos issuedLottos;

    private Lotto winningLotto;

    private int bonusNumber;

    @BeforeEach
    public void setUp() {
        bonusNumber = 7;
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        issuedLottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등 6
                        new Lotto(List.of(2, 3, 4, 5, 6, 7)), // 2등 5 + 1 -> matchingResult에서 검사불가능
                        new Lotto(List.of(2, 3, 4, 5, 6, 8)), // 3등 5
                        new Lotto(List.of(3, 4, 5, 6, 7, 8)), // 4등 4
                        new Lotto(List.of(4, 5, 6, 7, 8, 9)), // 5등 3개
                        new Lotto(List.of(5, 6, 7, 8, 9, 10)), // none 2개
                        new Lotto(List.of(6, 7, 8, 9, 10, 11)) // none 1개
                )
        );
    }

    @DisplayName("Lottos의 모든 로또 번호들을 당첨번호와 맞춰보고 결과를 반환")
    @Test
    public void matchAll() throws Exception {
        //when
        MatchingResults matchingResults = issuedLottos.matchAll(winningLotto, new LottoNumber(bonusNumber));

        //then
        List<LottoRank> lottoRanks = matchingResults.getLottoRanks();
        assertThat(lottoRanks).containsExactly(FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE, NONE);
    }
}
