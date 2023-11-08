package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        int price = Input.inputPrice();
        List<Lotto> lottos = lottoGame.buyLottos(lottoGame.getLottoCounts(price));

        List<Integer> winNums = Input.inputWinNums();
        int bonusNum = Input.inputBonusNum(winNums);

        List<Rank> ranks = lottos.stream().map(lotto -> lotto.getRank(winNums, bonusNum)).toList();

        lottoGame.printResult(ranks);
        lottoGame.printEarningRate(ranks, price);
    }
}
