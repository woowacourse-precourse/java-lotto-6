package consts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {
    @Test
    @DisplayName("로또 등수가 1등인 경우")
    void 로또_등수가_1등인_경우() {
        assertEquals(Rank.FIRST, Rank.of(6, false));
    }

    @Test
    @DisplayName("로또 등수가 2등인 경우")
    void 로또_등수가_2등인_경우() {
        assertEquals(Rank.SECOND, Rank.of(5, true));
    }

    @Test
    @DisplayName("로또 등수가 3등인 경우")
    void 로또_등수가_3등인_경우() {
        assertEquals(Rank.THIRD, Rank.of(5, false));
    }
}
