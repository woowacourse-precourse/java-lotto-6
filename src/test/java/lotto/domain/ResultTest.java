package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void 여섯개_일치인_경우_그에_맞는_객체를_반환한다() {
        assertEquals(Result.SIX_MATCH, Result.of(6, false));
    }

    @Test
    void 다섯개_일치인_경우_그에_맞는_객체를_반환한다() {
        assertEquals(Result.FIVE_MATCH, Result.of(5, false));
    }

    @Test
    void 네개_일치인_경우_그에_맞는_객체를_반환한다() {
        assertEquals(Result.FOUR_MATCH, Result.of(4, false));
    }
}
