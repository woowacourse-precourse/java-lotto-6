package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoCompany;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoCompanyTest {
    private static final HashMap<String, Integer> RANK_INDEXES = new HashMap<String, Integer>() {{
        put("FIRST", 4);
        put("SECOND", 3);
        put("THIRD", 2);
        put("FOURTH", 1);
        put("FIFTH", 0);
    }};
    @BeforeEach
    void beforeEach() {
        LottoCompany.setPrizeNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoCompany.setBonusNumber(7);
    }
    @Test
    void testFirstRank() {
        //given
        //when
        int result = LottoCompany.matchPrize(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThat(result).isEqualTo(RANK_INDEXES.get("FIRST"));
    }

    @Test
    void testSecondRank() {
        //given
        //when
        int result = LottoCompany.matchPrize(List.of(1, 2, 3, 4, 5, 7));

        //then
        assertThat(result).isEqualTo(RANK_INDEXES.get("SECOND"));
    }

    @Test
    void testThirdRank() {
        //given
        //when
        int result = LottoCompany.matchPrize(List.of(1, 2, 3, 4, 5, 9));

        //then
        assertThat(result).isEqualTo(RANK_INDEXES.get("THIRD"));
    }

    @Test
    void testFourthHRank() {
        //given
        //when
        int result = LottoCompany.matchPrize(List.of(1, 2, 3, 4, 8, 9));

        //then
        assertThat(result).isEqualTo(RANK_INDEXES.get("FOURTH"));
    }

    @Test
    void testFifthRank() {
        //given
        //when
        int result = LottoCompany.matchPrize(List.of(1, 2, 3, 9, 10, 8));

        //then
        assertThat(result).isEqualTo(RANK_INDEXES.get("FIFTH"));
    }
}
