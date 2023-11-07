package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    final List<Lotto> issuedLottos;

    public LottoMachine() {
        issuedLottos = new ArrayList<>();
    }

    public void issue(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            issuedLottos.add(new Lotto(numbers));
        }
    }

    public WinningResult checkWinning(Lotto winningLotto, int bonusNumber) {
        WinningResult result = new WinningResult();
        for (Lotto lotto : issuedLottos) {
            int matchCount = lotto.countMatch(winningLotto);
            if (matchCount < 3) {
                continue;
            }
            if (matchCount == 6) {
                result.addWinningRank(Rank.FIRST);
            } else if (matchCount == 5 && lotto.contains(bonusNumber)) {
                result.addWinningRank(Rank.SECOND);
            } else if (matchCount == 5) {
                result.addWinningRank(Rank.THIRD);
            } else if (matchCount == 4) {
                result.addWinningRank(Rank.FOURTH);
            } else if (matchCount == 3) {
                result.addWinningRank(Rank.FIFTH);
            }
        }
        return result;
    }

    public void printIssuedLottos() {
        for (Lotto lotto : issuedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}