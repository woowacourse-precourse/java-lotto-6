package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class WinningLottoTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = LottoService.getInstance();
    }

    @ParameterizedTest
    @CsvSource(delimiterString = ":",
            value = {
                    "1,2,3,4,5,6:3",
                    "1,38,20,32,18,45:45",
                    "1,24,37,25,17,41:37"
            })
    @DisplayName("당첨번호와 보너스번호가 중복된 경우")
    void 당첨번호와_보너스번호가_중복된_경우(String winningNumber, String bonusNumber) throws Exception {
        //given
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lottoService.makeWinningLotto(winningNumber, bonusNumber);
                })
                .withMessage(ErrorMessage.DUPLE_BONUS_NUM_TO_WINNING_NUM.getMessage());
    }
}