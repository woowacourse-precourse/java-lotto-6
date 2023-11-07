package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoMatchCountTest {

    @Test
    @DisplayName("LottoMatchCount 객체의 CountList를 반환한다.")
    void getCountList() {
        // given
        LottoMatchCount lottoMatchCount = new LottoMatchCount(3, 0,0,0,0);
        // when
        List<Integer> countList = lottoMatchCount.getCountList();
        List<Integer> expected = List.of(3, 0, 0, 0, 0);
        // then
        assertEquals(expected, countList);
    }
}