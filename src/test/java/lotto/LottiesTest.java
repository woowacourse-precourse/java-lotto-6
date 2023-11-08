package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.model.Lotties;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottiesTest {
    private Lotties lotties;
    private List<Lotto> lottoList;

    @BeforeEach
    void setUp() {
        lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        lotties = new Lotties(lottoList);
    }

    @DisplayName("Lotties의 get()은 list의 get()과 동일하다")
    @Test
    void testGet() {
        Lotto lotto0 = lotties.get(0);
        Lotto lotto1 = lotties.get(1);
        Lotto lotto2 = lotties.get(2);

        assertEquals(lottoList.get(0), lotto0);
        assertEquals(lottoList.get(1), lotto1);
        assertEquals(lottoList.get(2), lotto2);
    }

    @DisplayName("Lotties의 size()는 list의 size()와 동일하다")
    @Test
    void testSize() {
        int size = lotties.size();
        assertEquals(lottoList.size(), size);
    }

    @DisplayName("로또를 \\n으로 구분해서 String으로 반환한다")
    @Test
    void testToString() {
        String expected = "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n[13, 14, 15, 16, 17, 18]\n";
        assertEquals(expected, lotties.toString());
    }

    @DisplayName("getLotties()는 인스턴스 변수를 그대로 반환한다")
    @Test
    void testGetLotties() {
        List<Lotto> retrievedLottos = lotties.getLotties();
        assertEquals(lottoList, retrievedLottos);
    }
}
