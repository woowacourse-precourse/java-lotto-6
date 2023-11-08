package lotto;

import static lotto.domain.UserInput.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.RandomGenerate;
import lotto.domain.UserInput;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        RandomGenerate randomGenerate = new RandomGenerate();
        int money = userInput.money();
        List<Lotto> allLottoNumbers = new ArrayList<>();
        for (int i = 0; i<money/LOTTO_PRICE; i++){
            allLottoNumbers.add(new Lotto(randomGenerate.createNumbers()));
        }
        randomGenerate.createNumbers();
        Lotto.lottoPrint(allLottoNumbers, money/LOTTO_PRICE);
        Lotto lotto = userInput.winningNumbers();
        List<Integer> result = lotto.allCompare(allLottoNumbers, lotto.getNumbers(), userInput.bonusNumber());
        Lotto.prizePrint(result);
        System.out.println("총 수익률은 "+ Lotto.profitCalc(result, money) +"%입니다.");
    }
}
