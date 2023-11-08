package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Nested
@DisplayName("LottoBundle 모델 검증 테스트")
public class LottoBundleTest {

    @Test
    @DisplayName("null이면 예외가 발생한다.")
    void fail1() {
        assertThrows(NullPointerException.class, () -> new LottoBundle(null));
    }


    @Test
    @DisplayName("비어있으면 예외가 발생한다.")
    void fail2() {
        assertThrows(IllegalArgumentException.class, () -> new LottoBundle(List.of()));
    }
}
