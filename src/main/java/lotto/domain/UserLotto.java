package lotto.domain;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.repository.LottoRepository;
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
        int count = InputHandler.readMoney() / Constant.MONEY_UNIT;
        IntStream.range(0, count)
                .forEach(i -> userRepository.add(makeLotto()));
    }

    private Lotto makeLotto() {
        return new Lotto(RandomNumGenerator.makeUniqueRandomList());
    }

    private void printMyLotto() {
        OutputHandler.printReceipts(userRepository.size());
        userRepository.printAllLotto();
    }
}
