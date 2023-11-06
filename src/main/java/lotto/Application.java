package lotto;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        Consumer consumer = new Consumer();

        System.out.println("구입금액을 입력해 주세요.");
        int lottoAmount = gameManager.getPaymentForLottoByRead(consumer);
        System.out.println();

        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto(gameManager.createRandomNumber());
            consumer.lotto.add(lotto);
        }

        System.out.println(lottoAmount + "개를 구매했습니다.");
        consumer.lotto.forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = gameManager.getWinningLottoNumberByRead();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = gameManager.getBonusLottoNumberByRead();
        System.out.println();

        gameManager.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("---");
        gameManager.printWinning(consumer.lotto);
        System.out.println("총 수익률은 " + gameManager.getProfitRate(consumer.lotto, consumer.getPayment()) + "%입니다.");
    }
}
