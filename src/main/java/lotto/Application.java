package lotto;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        Consumer consumer = new Consumer();

        int lottoAmount = gameManager.getPaymentForLottoByRead(consumer);

        List<Integer> winningNumbers = gameManager.getWinningLottoNumberByRead();
        int bonusNumber = gameManager.getBonusLottoNumberByRead();


        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto(gameManager.createRandomNumber());
            consumer.lotto.add(lotto);
        }

        System.out.println(lottoAmount + "개를 구매했습니다.");
        consumer.lotto.forEach(lotto -> System.out.println(lotto.getNumbers()));

        gameManager.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        gameManager.printWinning(consumer.lotto);
        System.out.println("총 수익률은 " + gameManager.getProfitRate(consumer.lotto, consumer.getPayment()) + "%입니다.");
    }
}
