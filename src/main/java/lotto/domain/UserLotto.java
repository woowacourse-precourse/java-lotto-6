package lotto.domain;

import lotto.controller.InputController;
import lotto.system.Constants;
import lotto.view.OutputView;

public class UserLotto {

    private final LottoRepository userLottoRepository = new LottoRepository();

    public UserLotto() {
        buyLotto();
        printAllLottoInfo();
    }

    public int size() {
        return userLottoRepository.size();
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
        return InputController.inputAmountUntilSuccess();
    }


    private void printAllLottoInfo() {
        System.out.println();
        OutputView.printMyLotto(userLottoRepository.size());
        userLottoRepository.printAllLottoInfo();
    }
}
