package lotto.service;

import lotto.domain.Lotto;
import lotto.exception.LottoException;
import lotto.vo.LottoWinningBonusNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

// 테스트 코드 이므로 *을 썼다.
import static org.assertj.core.api.Assertions.*;

public class LottoWinningNumbersPickServiceTest {
    private LottoWinningNumbersPickService service;

    @BeforeEach
    void beforeEach() {
        service = LottoWinningNumbersPickService.getInstance();
    }

    @Test
    @DisplayName("당첨 번호 생성 테스트")
    void pickWinningNumbers() throws LottoException {
        String input = "1,2,3,4,5,6";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Lotto result = service.pickWinningNumbers(input);

        assertThat(lotto).isNotNull();
        assertThat(lotto).isEqualTo(result);
    }

    @Test
    @DisplayName("보너스 번호 생성 테스트")
    void pickBonusNumber() {
        String input = "7";
        LottoWinningBonusNumber bonusNumber = new LottoWinningBonusNumber(7);

        LottoWinningBonusNumber result = service.pickBonusNumber(input);

        assertThat(bonusNumber).isEqualTo(result);
    }
}
