package lotto;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        int lottoAmount = gameManager.getPaymentForLottoByRead();
        List<Lotto> lottos = new ArrayList<>();

        List<Integer> correctNumbers = gameManager.getCorrectLottoNumberByRead();
        int bonusNumber = gameManager.getBonusLottoNumberByRead();

        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto(gameManager.createRandomNumber());
            lotto.setCorrectNumbers(correctNumbers);
            lotto.setBonusNumber(bonusNumber);
            lottos.add(lotto);
        }

        System.out.println(lottoAmount+"개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
