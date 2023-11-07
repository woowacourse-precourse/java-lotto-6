package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class GameManager {
    User user = new User();
    Output output = new Output();
    List<Lotto> lotto = new ArrayList<>();
    public void start() {
        int inputPrice = user.inputPrice();
        System.out.println();
        int amountOfLotto = buyLotto(inputPrice);
        output.printAmount(amountOfLotto);
        for (int i = 0; i < amountOfLotto; i++) {
            List<Integer> lottoNumber = getLotto();
            output.printLotto(lottoNumber);
            lotto.add(new Lotto(lottoNumber));
        }
        System.out.println();
        List<Integer> winningNumber = user.winningNumbers();
        System.out.println();
        int bonusNumber = user.bonusNumber();
        System.out.println();
        output.printResult(winningNumber, bonusNumber);
    }

    public int buyLotto(int inputPrice) {
        return inputPrice / 1000;
    }

    public List<Integer> getLotto() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sort(lottoNumber);
        return lottoNumber;
    }
}
