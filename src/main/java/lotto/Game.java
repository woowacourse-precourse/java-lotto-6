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
