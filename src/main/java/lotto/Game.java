package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void startGame() {
        int price = Display.readPrice();
        int issueCnt = price / 1000;
        List<Lotto> issuedLottos = issueLottos(issueCnt);
        Display.showIssuedLottos(issuedLottos);
        Lotto winningNumbers = Display.readWinningNumbers();
        int bonusNumber = Display.readBonusNumber();
        List<Rank> resultRanks = assignEachRank(winningNumbers, bonusNumber, issuedLottos);
    }

    private List<Rank> assignEachRank(Lotto winningNumbers, int bonusNumber, List<Lotto> issuedLottos) {
        List<Rank> results = new ArrayList<>();
        for(Lotto lotto : issuedLottos) {
            int matchCnt = winningNumbers.matchLotto(lotto);
            if(matchCnt == 6) {
                results.add(Rank.first);
            }
            if(matchCnt == 5 && lotto.getNumbers().contains(bonusNumber)) {
                results.add(Rank.second);
                continue;
            }
            if(matchCnt == 5) {
                results.add(Rank.third);
            }
            if(matchCnt == 4) {
                results.add(Rank.fourth);
            }
            if(matchCnt == 3) {
                results.add(Rank.fifth);
            }
        }
        return results;
    }

    public List<Lotto> issueLottos(int issueCnt) {
        List<Lotto> lottos = new ArrayList<>();
        while(lottos.size() < issueCnt) {
            try {
                lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            } catch (IllegalArgumentException ignored) {}
        }
        return lottos;
    }
}
