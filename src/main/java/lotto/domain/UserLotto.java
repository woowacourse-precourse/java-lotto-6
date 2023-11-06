package lotto.domain;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.system.Constant;
import lotto.util.RandomNumGenerator;

import java.util.stream.IntStream;


public class UserLotto {

    private final LottoRepository userRepository = new LottoRepository();

    public UserLotto() {
        buyLotto();
        printMyLotto();
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
        OutputHandler.printReceipts(userRepository.size());
        userRepository.printAllLotto();
    }

    private int calculateLottoNum(){
        return InputHandler.readMoney() / Constant.MONEY_UNIT;
    }
}
