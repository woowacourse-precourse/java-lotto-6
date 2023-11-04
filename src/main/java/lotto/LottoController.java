package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private int money;
    private List<Lotto> lottos;
    private final OutputView outputView;

    public LottoController() {
        this.lottos = new ArrayList<>();
        this.outputView = new OutputView();
    }

    public void inputPurchaseMoney() {
        do {
            money = Integer.parseInt(Console.readLine());
        } while (validMoneyInput());
    }

    public void createLottos() {
        for (int i = 0; i < money / 1000; i++) {
            List<Integer> numbers = generateLottoNumbers();
            Lotto newLotto = new Lotto(numbers);
            lottos.add(newLotto);
        }
        outputView.printCreateLottoNumbers(lottos);
    }

    private boolean validMoneyInput() {
        try {
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위입니다. 다시 입력하세요.");
            }
            return false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return true;
        }
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
