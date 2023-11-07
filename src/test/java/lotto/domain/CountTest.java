package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountTest {

    @Test
    void 다음_count를_반환한다() {
        assertEquals(new Count(3).next(), new Count(2));
    }

    @Test
    void 남아있는_count가_있을시_true를_반환한다() {
        assertTrue(new Count(1).hasMoreCount());
    }

    @Test
    void 남아있는_count가_없을시_false를_반환한다() {
        assertFalse(new Count(0).hasMoreCount());
    }
}