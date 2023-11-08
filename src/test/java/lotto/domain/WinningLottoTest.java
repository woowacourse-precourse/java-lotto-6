package lotto.domain;

import java.io.ByteArrayOutputStream;
import java.util.List;
import lotto.ErrorType;
import lotto.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class WinningLottoTest {

    @Test
    void 당첨_로또_정상_범위_테스트() {
        assertThatCode(() -> WinningLotto.createLotto(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @Test
    void 당첨_로또_보너스넘버_정상_테스트() {
        WinningLotto.createLotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto.setBonusNumber(7);
        assertThatCode(() -> WinningLotto.validateBonusNumber())
                .doesNotThrowAnyException();
    }
}
