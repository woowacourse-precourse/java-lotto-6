package lotto;


import java.util.List;
import lotto.Controller.UIController;
import lotto.Model.Lotto;


public class Application {

    public static void main(String[] args) {
        Integer price = UIController.makePurchasePrice();
        List<Lotto> lottos = UIController.makeLotto(price);
        UIController.makeLottoStatus(lottos);
        List<Integer> winningNumbers = UIController.makeWinningNumbers();
        // TODO : makeWinningNumbers , makeBonusNumber , makeStatistics


    }
}
