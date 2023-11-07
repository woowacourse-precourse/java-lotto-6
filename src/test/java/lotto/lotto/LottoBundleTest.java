package lotto.lotto;

import lotto.model.LottoBundle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoBundleTest {
    @Test
    void validate_null이면_예외를_발생시킨다() {
        assertThrows(NullPointerException.class, () -> new LottoBundle(null));
    }

    @Test
    void validate_비어있으면_예외를_발생시킨다() {
        assertThrows(IllegalArgumentException.class, () -> new LottoBundle(List.of()));
    }
}
