package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        int gameCount = Lotto.inputYourMoney();

        List<List<Integer>> myLottoNumber = Lotto.myLottoNumber(gameCount);

        do{
            try {
                List<Integer> winningNumber = Lotto.isNumberOneToFortyFiv();

                Lotto lotto = new Lotto(winningNumber);

                int bonusNumber = lotto.bonusNumber();

                lotto.lottoGame(bonusNumber, myLottoNumber);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        while (true);

    }
}
