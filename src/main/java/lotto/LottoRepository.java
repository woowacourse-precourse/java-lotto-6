package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {

    private List<Lotto> lottos = new ArrayList<>();
    private int count = 0;
    private int bonusCount = 0;

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public void printLottoNumbers() {
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getLotto());
        }
    }

    public void compareLottoNumberList(String[] winningNumbers, int bonusNumber) {
        for (int i = 0; i < lottos.size(); i++) {
            compareLottoNumber(lottos.get(i), winningNumbers, bonusNumber);
            increaseRank(count, bonusCount);
            count = 0;
            bonusCount = 0;
        }
    }

    private void compareLottoNumber(Lotto lotto, String[] winningNumbers, int bonusNumber) {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                checkSameNumber(lotto.getLottoIndex(i), Integer.parseInt(winningNumbers[j]));
            }
        }
        //보너스 번호 체크
        for (int i = 0; i < 6; i++) {
            if (lotto.getLottoIndex(i) == bonusNumber) {
                bonusCount++;
            }
        }
    }

    private void checkSameNumber(int lottoNumber, int winningNumber) {
        if (lottoNumber == winningNumber) {
            count++;
        }
    }

    private void increaseRank(int count, int bonusCount) {
        if (count == 3) {
            Rank.FIFTH.increaseCount();

        } else if (count == 4) {
            Rank.FOURTH.increaseCount();

        } else if (count == 5 && bonusCount == 0) {
            Rank.THIRD.increaseCount();

        } else if (count == 5 && bonusCount == 1) {
            Rank.SECOND.increaseCount();

        } else if (count == 6) {
            Rank.FIRST.increaseCount();
        }
    }
}
