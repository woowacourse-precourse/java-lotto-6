package Controller;

import Model.Lotto;
import Model.PurchaseAmount;
import camp.nextstep.edu.missionutils.Randoms;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    List<Lotto> myLottoNumbers = new ArrayList<>();

    public void buyMyLotto() {
        int input = InputView.getPurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(input);

        publishMyLotto(purchaseAmount);
        OutputView.printMyLotto(myLottoNumbers);
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
}
