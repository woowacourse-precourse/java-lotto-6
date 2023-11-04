package lotto;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        Consumer consumer = new Consumer();

        int lottoAmount = gameManager.getPaymentForLottoByRead(consumer);
        List<Lotto> lottos = new ArrayList<>();

        List<Integer> winningNumbers = gameManager.getWinningLottoNumberByRead();
        int bonusNumber = gameManager.getBonusLottoNumberByRead();

        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto(gameManager.createRandomNumber());
            lotto.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
            lottos.add(lotto);
        }

        System.out.println(lottoAmount + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        gameManager.printWinning(lottos);
        System.out.println("총 수익률은 " + gameManager.getProfitRate(lottos, consumer.getPayment()) + "%입니다.");
    }
}
