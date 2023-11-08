package lotto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Game {
    private Amount amount;
    private List<Lotto> lottos;
    private Output output = new Output();
    private WinningLotto winningLotto;
    private Map<Ranking, Integer> result = new HashMap<>();

    public void setAmount() {
        while(true) {
            try {
                this.amount = new Amount(Input.getPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(Output.ERROR_MESSAGE_PREFIX + Output.LOTTO_PURCHASE_AMOUNT_ERROR_MESSAGE);
            }
        }
    }
    public void buyLotto(){
        lottos = Lotto.buyLotto(amount.getLottoCount());
        output.printLottoPurchaseCountMessage(amount.getLottoCount());
        output.printLottos(lottos);
    }

    public void checkWinning(){
        Lotto winningNumbers = winningLotto.getterWinningNumbers();
        int bonusNumber = winningLotto.getterBonusNumber();
        result = Ranking.getWinningResult(lottos, winningNumbers, bonusNumber);
    }

    public Double calculateProfit(HashMap<Ranking, Integer> result){
        Double sum =0.0;
        for (Map.Entry<Ranking, Integer> entry : result.entrySet()) {
            Ranking ranking = entry.getKey();
            Integer count = entry.getValue();
            sum += ranking.getReward() * count;
        }
        System.out.println(sum);
        return Math.round (((sum / this.amount.getMoney()) * 100) * 10.0) / 10.0;
    }
}
