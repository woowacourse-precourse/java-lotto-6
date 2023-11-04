package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBundleTest {
    @Test
    @DisplayName("LottoBundle 도메인 생성을 검증한다.")
    public void testGetLottoBundle() {
        // given
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        // when
        LottoBundle lottoBundle = new LottoBundle(lottoList);
        List<Lotto> retrievedLottoList = lottoBundle.getLottoBundle();

        // then
        assertEquals(lottoList, retrievedLottoList);
    }

    @Test
    @DisplayName("같은 LottoBundle 객체는 동등하다")
    public void testEquals() {
        // given
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        // when
        LottoBundle lottoBundle1 = new LottoBundle(lottoList);
        LottoBundle lottoBundle2 = new LottoBundle(lottoList);

        // then
        assertTrue(lottoBundle1.equals(lottoBundle2));
    }

    @Test
    @DisplayName("다른 LottoBundle 객체는 동등하지 않다")
    public void testNotEquals() {
        // given
        List<Lotto> lottoList1 = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        List<Lotto> lottoList2 = Arrays.asList(
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        // when
        LottoBundle lottoBundle1 = new LottoBundle(lottoList1);
        LottoBundle lottoBundle2 = new LottoBundle(lottoList2);

        // then
        assertFalse(lottoBundle1.equals(lottoBundle2));
    }

    @Test
    @DisplayName("같은 LottoBundle 객체의 해시코드는 동일하다")
    public void testHashCode() {
        // given
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        // when
        LottoBundle lottoBundle1 = new LottoBundle(lottoList);
        LottoBundle lottoBundle2 = new LottoBundle(lottoList);

        // then
        assertEquals(lottoBundle1.hashCode(), lottoBundle2.hashCode());
    }

    @Test
    @DisplayName("다른 LottoBundle 객체의 해시코드는 다르다")
    public void testNotEqualHashCode() {
        // given
        List<Lotto> lottoList1 = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        List<Lotto> lottoList2 = Arrays.asList(
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        // when
        LottoBundle lottoBundle1 = new LottoBundle(lottoList1);
        LottoBundle lottoBundle2 = new LottoBundle(lottoList2);

        // then
        assertFalse(lottoBundle1.hashCode() == lottoBundle2.hashCode());
    }
}