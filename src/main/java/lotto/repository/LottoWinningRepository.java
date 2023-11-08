package lotto.repository;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWinning;

public class LottoWinningRepository {
    private static LottoWinning lottoWinning;

    public LottoWinningRepository(){
        LottoWinningRepository.lottoWinning = new LottoWinning();
    }

    public void saveWinningNumbers(List<Integer> winningNumbers) {
        getLottoWinning().setWinningNumbers(new Lotto(winningNumbers));
    }

    public void saveBonusNumber(int bonusNumber) {
        getLottoWinning().setBonusNumber(bonusNumber);
    }

    public LottoWinning getLottoWinning(){
        return lottoWinning;
    }


}
