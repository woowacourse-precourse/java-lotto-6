package lotto;

import java.util.List;
import lotto.UI.Input;
import lotto.UI.Output;
import lotto.domain.Lotto;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        int price = input.inputPrice();

        List<Integer> lottoNumbers = input.inputLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);

        int bonusNumber = input.inputBonusNumber();

        List<List<Integer>> randomLottoNumbers = lotto.buyLotto(price);

        Output output = new Output();
//        Output.printRandomLottoNumbers(randomLottoNumbers);
    }
}
