package lotto;

import java.util.LinkedList;
import java.util.List;
import lotto.domain.PlayLotto;
import lotto.domain.UserLotto;
import lotto.view.InputMoney;
import lotto.view.OutputLottoNumbers;

public class Application {
    public static void main(String[] args) {
        int inputMoney = new InputMoney().input();
        int cnt = new PlayLotto(inputMoney).lottoTry();
        System.out.println('\n' + "개를 구매했습니다.");
        List<List<Integer>> LottoNumbers = new LinkedList<>();
        while (cnt-- > 0) {
            List<Integer> lotto = new UserLotto().getNumbers();
            LottoNumbers.add(OutputLottoNumbers.print_Lotto(lotto));
        }
    }
}
