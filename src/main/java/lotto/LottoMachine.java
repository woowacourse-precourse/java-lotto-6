package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Exception.LottoNumbersException;
import lotto.Exception.MoneyException;

public class LottoMachine {

    private int lottoCount;
    private List<Lotto> lottoBundle;

    public void insertMoneyView() {

        try {
            System.out.println("구입금액을 입력해 주세요.");
            insertMoney(Console.readLine());
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            insertMoneyView();
        }

    }

    public List<Lotto> lottoBundleView() {
        printLottoBundle();

        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.lottoFormat());
        }

        return lottoBundle;
    }

    private void insertMoney(String input) {
        MoneyException.notParsableNumber(input);
        MoneyException.notValidNumber(Integer.parseInt(input));
        MoneyException.notDividedWithThousand(Integer.parseInt(input));

        lottoCount = Integer.parseInt(input) / 1000;
    }

    private void printLottoBundle() {
        lottoBundle = new ArrayList<Lotto>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto processingLotto = new Lotto(generateLottoNumbers());
            lottoBundle.add(processingLotto);
        }
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers;

        try {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            LottoNumbersException.validateLottoNumbers(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateLottoNumbers();
        }

        return numbers;
    }

}
