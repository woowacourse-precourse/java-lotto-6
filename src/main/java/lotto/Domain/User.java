package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ExceptionChecker;
import lotto.Utils;

import java.util.ArrayList;
import java.util.List;


public class User {
    private final int inputMoney;
    private final List<Lotto> lottos;
    private final Utils utils = Utils.INSTANCE;

    private final ExceptionChecker exceptionChecker = ExceptionChecker.INSTANCE;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public User(String inputMoney) {
        validate(inputMoney);
        this.inputMoney = Integer.parseInt(inputMoney);
        this.lottos = buyLottos(this.inputMoney);
    }

    private void validate(String inputMoney) {
        exceptionChecker.checkNull(inputMoney);
        exceptionChecker.checkNumber(inputMoney);
        exceptionChecker.checkDivisibleBy1000(inputMoney);
    }

    private List<Lotto> buyLottos(int inputMoney) {
        int LottoCount = inputMoney / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < LottoCount; i++) {
            List<Integer> numbers = generate();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        utils.selectionSort(numbers);
        return numbers;
    }
}
