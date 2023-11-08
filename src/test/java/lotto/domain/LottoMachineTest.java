package lotto.domain;

import lotto.common.LottoFinalConsts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest implements LottoFinalConsts {

    private Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private int lottoPurchase = LOTTO_PURCHASE_DIVIDABLE;
    private List<Lotto> lottos = new ArrayList<>(List.of(lotto));
    private HashMap<LottoRank, Integer> lottoRanks = new HashMap<>();
    private LottoMachine lottoMachine = new LottoMachine(lottoPurchase, lottos, lottoRanks);

    @BeforeEach
    void 로또_머신을_초기화한다() {
        lottoMachine = new LottoMachine(lottoPurchase, lottos, lottoRanks);
    }

    @Test
    void 사용자가_입력한_당첨번호에_중복이_있는_경우_예외를_발생한다() {
        List<Integer> lottoWinningNumbers = new ArrayList<>(List.of(6, 7, 8, 9, 10, 11));
        assertThatThrownBy(() -> lottoMachine.isNumberAlreadyExist(6, lottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}