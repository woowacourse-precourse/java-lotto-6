package lotto;

import java.util.List;

public class ResultManager {
    public void viewLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto: lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    private int calculateMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;

        for (int number : lotto.getLottoNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount ++;
            }
        }
        return matchCount;
    }
}
