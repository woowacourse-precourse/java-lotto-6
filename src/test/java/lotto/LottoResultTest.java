package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBonus;
import lotto.domain.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("로또 결과 저장할 Map 초기화 테스트")
    @Test
    void resultSetTest() {
        Map<LottoRank, Integer> result = new LinkedHashMap<>();

        for(LottoRank rank : LottoRank.values()){
            result.put(rank, 0);
        }

        for (LottoRank rank : LottoRank.values()) {
            assertThat(result.get(rank)).isZero();
        }
    }
    @DisplayName("로또 결과 테스트_FIRST")
    @Test
    void resultCalculateTest_FIRST() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lottoWinning = new Lotto(List.of(1,2,3,4,5,6));
        LottoBonus lottoBonus = new LottoBonus(lottoWinning, 7);
        LottoRank rank;

        int hit = lotto.countHit(lottoWinning);
        boolean matchBonus = lotto.containNumber(lottoBonus.getNumber());

        rank = LottoRank.valueOf(hit, matchBonus);

        Assertions.assertThat(rank).isEqualTo(FIRST);
    }

    @DisplayName("로또 결과 테스트_SECOND")
    @Test
    void resultCalculateTest_SECOND() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        Lotto lottoWinning = new Lotto(List.of(1,2,3,4,5,6));
        LottoBonus lottoBonus = new LottoBonus(lottoWinning, 7);
        LottoRank rank;

        int hit = lotto.countHit(lottoWinning);
        boolean matchBonus = lotto.containNumber(lottoBonus.getNumber());

        rank = LottoRank.valueOf(hit, matchBonus);

        Assertions.assertThat(rank).isEqualTo(SECOND);
    }

    @DisplayName("로또 결과 테스트_THIRD")
    @Test
    void resultCalculateTest_THIRD() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,8));
        Lotto lottoWinning = new Lotto(List.of(1,2,3,4,5,6));
        LottoBonus lottoBonus = new LottoBonus(lottoWinning, 7);
        LottoRank rank;

        int hit = lotto.countHit(lottoWinning);
        boolean matchBonus = lotto.containNumber(lottoBonus.getNumber());

        rank = LottoRank.valueOf(hit, matchBonus);

        Assertions.assertThat(rank).isEqualTo(THIRD);
    }

    @DisplayName("로또 결과 테스트_FOURTH")
    @Test
    void resultCalculateTest_FOURTH() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,8,9));
        Lotto lottoWinning = new Lotto(List.of(1,2,3,4,5,6));
        LottoBonus lottoBonus = new LottoBonus(lottoWinning, 7);
        LottoRank rank;

        int hit = lotto.countHit(lottoWinning);
        boolean matchBonus = lotto.containNumber(lottoBonus.getNumber());

        rank = LottoRank.valueOf(hit, matchBonus);

        Assertions.assertThat(rank).isEqualTo(FOURTH);
    }

    @DisplayName("로또 결과 테스트_FIFTH")
    @Test
    void resultCalculateTest_FIFTH() {
        Lotto lotto = new Lotto(List.of(1,2,3,8,9,10));
        Lotto lottoWinning = new Lotto(List.of(1,2,3,4,5,6));
        LottoBonus lottoBonus = new LottoBonus(lottoWinning, 7);
        LottoRank rank;

        int hit = lotto.countHit(lottoWinning);
        boolean matchBonus = lotto.containNumber(lottoBonus.getNumber());

        rank = LottoRank.valueOf(hit, matchBonus);

        Assertions.assertThat(rank).isEqualTo(FIFTH);
    }

    @DisplayName("로또 결과 테스트_MISS_TWO")
    @Test
    void resultCalculateTest_MISS_TWO() {
        Lotto lotto = new Lotto(List.of(1,2,8,9,10,11));
        Lotto lottoWinning = new Lotto(List.of(1,2,3,4,5,6));
        LottoBonus lottoBonus = new LottoBonus(lottoWinning, 7);
        LottoRank rank;

        int hit = lotto.countHit(lottoWinning);
        boolean matchBonus = lotto.containNumber(lottoBonus.getNumber());

        rank = LottoRank.valueOf(hit, matchBonus);

        Assertions.assertThat(rank).isEqualTo(MISS);
    }

    @DisplayName("로또 결과 테스트_MISS_ONE")
    @Test
    void resultCalculateTest_MISS_ONE() {
        Lotto lotto = new Lotto(List.of(1,8,9,10,11,12));
        Lotto lottoWinning = new Lotto(List.of(1,2,3,4,5,6));
        LottoBonus lottoBonus = new LottoBonus(lottoWinning, 7);
        LottoRank rank;

        int hit = lotto.countHit(lottoWinning);
        boolean matchBonus = lotto.containNumber(lottoBonus.getNumber());

        rank = LottoRank.valueOf(hit, matchBonus);

        Assertions.assertThat(rank).isEqualTo(MISS);
    }

    @DisplayName("로또 결과 테스트_MISS_ZERO")
    @Test
    void resultCalculateTest_MISS_ZERO() {
        Lotto lotto = new Lotto(List.of(8,9,10,11,12,13));
        Lotto lottoWinning = new Lotto(List.of(1,2,3,4,5,6));
        LottoBonus lottoBonus = new LottoBonus(lottoWinning, 7);
        LottoRank rank;

        int hit = lotto.countHit(lottoWinning);
        boolean matchBonus = lotto.containNumber(lottoBonus.getNumber());

        rank = LottoRank.valueOf(hit, matchBonus);

        Assertions.assertThat(rank).isEqualTo(MISS);
    }
}
