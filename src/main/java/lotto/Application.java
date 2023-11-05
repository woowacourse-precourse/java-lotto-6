package lotto;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        Consumer consumer = new Consumer();

        int lottoAmount = gameManager.getPaymentForLottoByRead(consumer);

        List<Integer> winningNumbers = gameManager.getWinningLottoNumberByRead();   // 당첨 번호
        int bonusNumber = gameManager.getBonusLottoNumberByRead();                // 보너스 번호


        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto(gameManager.createRandomNumber());
            consumer.lotto.add(lotto);
        }

        System.out.println(lottoAmount + "개를 구매했습니다.");
        consumer.lotto.forEach(lotto -> System.out.println(lotto.getNumbers()));

        gameManager.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);   // 당첨 번호와 보너스 번호를 GameManager에 저장

        gameManager.printWinning(consumer.lotto);
        System.out.println("총 수익률은 " + gameManager.getProfitRate(consumer.lotto, consumer.getPayment()) + "%입니다.");
    }
}
