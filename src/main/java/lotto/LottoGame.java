package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private LottoGameView lottoGameView;

    public LottoGame() {
        this.lottoGameView = new LottoGameView();
    }

    public List<Lotto> issueLottery(int amount) {
        List<Lotto> lotteries = new ArrayList<>();

        lottoGameView.printLotteryAmount(amount);
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lotteries.add(lotto);
        }
        lottoGameView.printLotteries(lotteries);

        return lotteries;
    }
}
