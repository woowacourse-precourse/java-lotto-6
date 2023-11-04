package Controller;

import Model.BonusNumber;
import Model.Lotto;
import Model.PurchaseAmount;
import camp.nextstep.edu.missionutils.Randoms;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    List<Lotto> myLottoNumbers = new ArrayList<>();
    Lotto winningLottoNumbers;
    BonusNumber winningBonusNumber;

    public void buyMyLotto() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.getPurchaseAmount());
        publishMyLotto(purchaseAmount);

        OutputView.printMyLotto(myLottoNumbers);
    }

    public void assignLotto() {
        winningLottoNumbers = new Lotto(InputView.getLotto());
        winningBonusNumber = new BonusNumber(InputView.getBonusNumber());
        winningBonusNumber.validateAlreadyExist(winningLottoNumbers);
    }

    public void publishMyLotto(PurchaseAmount purchaseAmount) {
        List<Integer> numbers;
        int lottoAmount = (purchaseAmount.getPurchaseAmount()) / 1000;
        for (int i = 1; i <= lottoAmount; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLottoNumbers.add(new Lotto(numbers));
        }
    }





    public List<Lotto> getLottoNumbers() {
        return myLottoNumbers;
    }

    public Lotto getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
