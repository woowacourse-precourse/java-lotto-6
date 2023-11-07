package lotto.contorller;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoController {
    final int START_DIGIT = 1;
    final int END_DIGIT = 45;
    final int LOTTO_NUM = 6;
    WinningLotto winningLotto;
    public void issueWinningLotto(int count) {
        List<Lotto> winningLottoList = new ArrayList<>();

        for(int i=0;i<count;i++) {
            List<Integer> nums = Randoms.pickUniqueNumbersInRange(START_DIGIT, END_DIGIT, LOTTO_NUM);
            winningLottoList.add(new Lotto(nums));
        }

        winningLotto = new WinningLotto(winningLottoList);
    }
}
