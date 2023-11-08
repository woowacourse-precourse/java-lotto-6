package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoNumberReaderTest {

    private Lotto winningLotto;
    private int bonusNumber;

    @BeforeEach
    void setWinningLotto() {
        winningLotto = new Lotto(List.of(2, 3, 5, 33, 10, 1));
        bonusNumber = 7;
    }

    @Test
    void 로또_1등_얻기() {
        Lotto purchasedLotto = new Lotto(List.of(2, 3, 5, 33, 10, 1));
        assertThat(LottoNumberReader.checkRanking(winningLotto, bonusNumber, purchasedLotto))
                .isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 로또_2등_얻기() {
        Lotto purchasedLotto = new Lotto(List.of(2, 3, 5, 33, 10, 7));
        assertThat(LottoNumberReader.checkRanking(winningLotto, bonusNumber, purchasedLotto))
                .isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 로또_3등_얻기() {
        Lotto purchasedLotto = new Lotto(List.of(2, 3, 5, 33, 10, 45));
        assertThat(LottoNumberReader.checkRanking(winningLotto, bonusNumber, purchasedLotto))
                .isEqualTo(LottoRank.THIRD);

    }

    @Test
    void 로또_4등_얻기() {
        Lotto purchasedLotto = new Lotto(List.of(2, 3, 5, 7, 10, 44));
        assertThat(LottoNumberReader.checkRanking(winningLotto, bonusNumber, purchasedLotto))
                .isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 로또_5등_얻기() {
        Lotto purchasedLotto = new Lotto(List.of(2, 3, 6, 7, 10, 31));
        assertThat(LottoNumberReader.checkRanking(winningLotto, bonusNumber, purchasedLotto))
                .isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void 꽝() {
        Lotto purchasedLotto = new Lotto(List.of(40, 41, 42, 43, 44, 45));
        assertThat(LottoNumberReader.checkRanking(winningLotto, bonusNumber, purchasedLotto))
                .isEqualTo(LottoRank.NO_WIN);
    }
}