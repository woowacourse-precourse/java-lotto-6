package lotto.domain;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.repository.LottoRepository;
import lotto.system.Constant;
import lotto.util.RandomNumGenerator;


public class UserLotto {

    private final LottoRepository userLottory = new LottoRepository();

    public UserLotto() {
        buyLotto();
        printMyLotto();
    }

    private void buyLotto() {
        int count = InputHandler.readMoney() / Constant.MONEY_UNIT;
        for (int i = 0; i < count; i++) {
            userLottory.add(makeLotto());
        }
    }

    public Lotto getIndexAt(int index){
        return userLottory.get(index);
    }

    public int size(){
        return userLottory.size();
    }

    private Lotto makeLotto() {
        return new Lotto(RandomNumGenerator.makeUniqueRandomList());
    }

    private void printMyLotto() {
        OutputHandler.printReceipts(userLottory.size());
        userLottory.printAllLotto();
    }
}
