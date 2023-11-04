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

        gameManager.getCorrectLottoNumberByRead();
        gameManager.getBonusLottoNumberByRead();
    }
}
