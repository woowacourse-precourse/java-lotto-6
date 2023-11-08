package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputManager inputManager = new InputManager();
        int purchaseAmount = inputManager.getPurchaseAmount();

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i <purchaseAmount/LOTTO_PRICE; i++) {
            Lotto lotto = lottoGenerator.generateLotto();
            lottos.add(lotto);
        }

        ResultManager resultManager = new ResultManager();
        resultManager.viewLottos(lottos);

        List<Integer> winningNumbers = inputManager.getWinnigNumbers();
        int bonusNumber = inputManager.getBonusNumber(winningNumbers);
        
        resultManager.calculatePrizes(lottos, winningNumbers, bonusNumber);
    }
}
