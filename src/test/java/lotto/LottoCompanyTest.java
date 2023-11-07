package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoCompany;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCompanyTest {
    LottoCompany lottoCompany = LottoCompany.INSTANCE;
    private static final HashMap<String, Integer> RANK_INDEXES = new HashMap<String, Integer>() {{
        put("FIRST", 4);
        put("SECOND", 3);
        put("THIRD", 2);
        put("FOURTH", 1);
        put("FIFTH", 0);
        put("NO", -1);
    }};

    @BeforeEach
    void beforeEach() {
        lottoCompany.setPrizeNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoCompany.setBonusNumber(7);
    }

    @DisplayName("1등 테스트")
    @Test
    void testFirstRank() {
        //given
        //when
        int result = lottoCompany.matchPrize(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThat(result).isEqualTo(RANK_INDEXES.get("FIRST"));
    }

    @DisplayName("2등 테스트")
    @Test
    void testSecondRank() {
        //given
        //when
        int result = lottoCompany.matchPrize(List.of(1, 2, 3, 4, 5, 7));

        //then
        assertThat(result).isEqualTo(RANK_INDEXES.get("SECOND"));
    }

    @DisplayName("3등 테스트")
    @Test
    void testThirdRank() {
        //given
        //when
        int result = lottoCompany.matchPrize(List.of(1, 2, 3, 4, 5, 9));

        //then
        assertThat(result).isEqualTo(RANK_INDEXES.get("THIRD"));
    }

    @DisplayName("4등 테스트")
    @Test
    void testFourthHRank() {
        //given
        //when
        int result = lottoCompany.matchPrize(List.of(1, 2, 3, 4, 8, 9));

        //then
        assertThat(result).isEqualTo(RANK_INDEXES.get("FOURTH"));
    }

    @DisplayName("5등 테스트")
    @Test
    void testFifthRank() {
        //given
        //when
        int result = lottoCompany.matchPrize(List.of(1, 2, 3, 9, 10, 8));

        //then
        assertThat(result).isEqualTo(RANK_INDEXES.get("FIFTH"));
    }

    @DisplayName("낙첨 테스트")
    @Test
    void testNoRank() {
        //given
        //when
        int result = lottoCompany.matchPrize(List.of(1, 2, 11, 9, 10, 8));

        //then
        assertThat(result).isEqualTo(RANK_INDEXES.get("NO"));
    }
}
