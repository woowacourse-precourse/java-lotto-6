package lotto.domain;

import lotto.system.Constants;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserLotto {
    private final LottoRepository userLottoRepository = new LottoRepository();
    public UserLotto() {
        buyLotto();
        printAllLottoInfo();
    }
    public Lotto get(int index) {
        return userLottoRepository.get(index);
    }
    private void buyLotto() {
        long count = inputAmount() / Constants.MONEY_UNIT.getConstants();
        registerLotto(count);
    }

    private void registerLotto(long lottoCount) {
        while (lottoCount-- > 0) {
            userLottoRepository.add(makeLotto());
        }
    }

    private Lotto makeLotto() {
        return new Lotto(RandomNumber.makeUniqueRandomList());
    }

    private long inputAmount() {
        return InputView.inputPurchaseAmount();
    }


    private void printAllLottoInfo() {
        System.out.println();
        OutputView.printMyLotto(userLottoRepository.size());
        userLottoRepository.printAllLottoInfo();
    }
}
