package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.enums.Rank;
import lotto.input.Input;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            playLottoGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void playLottoGame() {
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
