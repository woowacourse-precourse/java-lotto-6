package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.system.Constant;
import lotto.util.RandomNumGenerator;

import java.util.stream.IntStream;


public class UserLotto {

    private final LottoRepository userRepository = new LottoRepository();

    public UserLotto() {
        buyLotto();
        printMyLotto();
    }

    public UserLotto(int lottoNum) {
        IntStream.range(0, lottoNum)
                .forEach(i -> userRepository.add(makeLotto()));
    }

    public Lotto getIndexAt(int index) {
        return userRepository.get(index);
    }

    public int size() {
        return userRepository.size();
    }

    private void buyLotto() {
        int lottoCount = calculateLottoNum();
        IntStream.range(0, lottoCount)
                .forEach(i -> userRepository.add(makeLotto()));
    }

    private Lotto makeLotto() {
        return new Lotto(RandomNumGenerator.makeUniqueRandomList());
    }

    private void printMyLotto() {
        OutputView.printReceipts(userRepository.size());
        userRepository.printAllLotto();
    }

    private int calculateLottoNum() {
        return InputView.readMoney() / Constant.MONEY_UNIT;
    }
}
