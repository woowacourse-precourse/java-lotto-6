package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoServiceTest {
    @Test
    void createLotto() {
        Lotto lotto = LottoService.createLotto();
        assertEquals(lotto.getNumbers().size(), 6);

    }
}
