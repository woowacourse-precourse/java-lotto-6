package lotto;

import java.util.List;
import lotto.UI.InputBonus;
import lotto.UI.InputNum;
import lotto.UI.InputPrice;
import lotto.UI.Output;
import lotto.domain.Lotto;
import lotto.domain.RandomNum;

public class Application {
    public static void main(String[] args) {
        InputPrice inputPrice = new InputPrice();
        InputNum inputNum = new InputNum();
        InputBonus inputBonus = new InputBonus();
        Output output = new Output();
        RandomNum randomNum = new RandomNum();

        int price = inputPrice.inputPrice();
        System.out.println();

        List<List<Integer>> randomLottoNumbers = randomNum.buyLotto(price);
        output.printRandomLottoNumbers(randomLottoNumbers);
        System.out.println();

        List<Integer> lottoNumbers = inputNum.inputLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);
        System.out.println();

        int bonusNumber = inputBonus.inputBonusNumber(lottoNumbers);
        System.out.println();

        List<List<Integer>> matchedNumer = lotto.getMatchedNumber(randomLottoNumbers, bonusNumber);
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");
        output.printLottoResult(matchedNumer, price);


    }
}
