package lotto;

import static lotto.domain.UserInput.LOTTO_PRICE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.RandomGenerate;
import lotto.domain.UserInput;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        RandomGenerate randomGenerate = new RandomGenerate();
        System.out.println("구입 금액을 입력해 주세요.");
        int money = userInput.money();
        List<List<Integer>> allLottoNumbers = randomGenerate.createNumbers(money / LOTTO_PRICE);
        Lotto.lottoPrint(allLottoNumbers, money / LOTTO_PRICE);
        System.out.println("\n당첨 번호를 입력해 주세요.");
        Lotto winningNumbers = userInput.winningNumbers();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        List<Integer> result = winningNumbers.allCompare(allLottoNumbers, userInput.bonusNumber());
        Lotto.prizePrint(result);
        System.out.println("총 수익률은 " + Lotto.profitCalc(result, money) + "%입니다.");
    }
}
