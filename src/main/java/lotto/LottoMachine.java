package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Exception.LottoNumbersException;
import lotto.Exception.MoneyException;

public class LottoMachine {

    private int lottoCount;

    public void insertMoney(String input) {
        MoneyException.notParsableNumber(input);
        MoneyException.notValidNumber(Integer.parseInt(input));
        MoneyException.notDividedWithThousand(Integer.parseInt(input));

        lottoCount = Integer.parseInt(input) / 1000;
    }

    List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        LottoNumbersException.validateLottoNumbers(numbers);
        return numbers;
    }

    public List<Lotto> giveLottoBundle() {
        List<Lotto> lottoBundle = new ArrayList<Lotto>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto processingLotto = new Lotto(generateLottoNumbers());
            lottoBundle.add(processingLotto);
        }

        return lottoBundle;
    }

}
