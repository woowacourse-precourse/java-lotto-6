package lotto.service;

import lotto.common.LottoFinalConsts;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest implements LottoFinalConsts {

    private Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private int lottoPurchase = LOTTO_PURCHASE_DIVIDABLE;
    private List<Lotto> lottos = new ArrayList<>(List.of(lotto));
    private HashMap<LottoRank, Integer> lottoRanks = new HashMap<>();
    private LottoMachine lottoMachine = new LottoMachine(lottoPurchase, lottos, lottoRanks);
    private LottoService lottoService = new LottoService();

    @Test
    void saveWinningAndBonusNumbers() {
    }

    @Test
    void 사용자가_입력한_당첨번호가_6개가_아닌_경우_예외를_발생한다() {
        String winningNumber = "1,2,3,4,5,6,7";
        String[] winning = winningNumber.split(LOTTO_WINNING_SPLIT);
        assertThatThrownBy(() -> lottoService.validateWinningSize(winning))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    void isBonusNumberAlreadyExist() {
    }

    @Test
    void isNumberOutOfRange() {
    }

    @Test
    void saveRankCount() {
    }

    @Test
    void getCorrectCount() {
    }

    @Test
    void getLottoRank() {
    }

    @Test
    void getLottoReturn() {
    }

    @Test
    void computeLottoReturnRate() {
    }
}