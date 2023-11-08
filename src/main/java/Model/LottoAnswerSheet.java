package Model;

import java.util.List;
import lotto.Lotto;

public class LottoAnswerSheet {
    public Lotto generateWinningLotto(List<Integer> winningLottoNumbers) {
        return new Lotto(winningLottoNumbers);
    }
}
