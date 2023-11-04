package Controller;

import Model.BonusNumber;
import Model.Lotto;
import Model.PurchaseAmount;
import camp.nextstep.edu.missionutils.Randoms;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    private Integer lottoAmount;
    private List<Lotto> myLottoNumbers = new ArrayList<>();
    private Lotto winningLottoNumbers;
    private BonusNumber winningBonusNumber;
    private List<Integer> matchingCounts;

    public void buyMyLotto() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.getPurchaseAmount());
        publishMyLotto(purchaseAmount);
        lottoAmount = (purchaseAmount.get()) / 1000;

        OutputView.printMyLotto(myLottoNumbers);
    }

    public void assignLotto() {
        winningLottoNumbers = new Lotto(InputView.getLotto());
        winningBonusNumber = new BonusNumber(InputView.getBonusNumber());
        winningBonusNumber.validateAlreadyExist(winningLottoNumbers);
    }

    public void calculateGameResult() {
        calculateMatchingNumbers();
    }

    public void publishMyLotto(PurchaseAmount purchaseAmount) {
        List<Integer> numbers;
        for (int i = 1; i <= lottoAmount; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLottoNumbers.add(new Lotto(numbers));
        }
    }

    public void calculateMatchingNumbers() {
        matchingCounts = new ArrayList<>(Collections.nCopies(7, 0));
        for (int i = 0; i < lottoAmount; i++) {
            Lotto myLotto = myLottoNumbers.get(i);
            int matchingCount = myLotto.howManySameNumbers(winningLottoNumbers);
            int newValue = matchingCounts.get(matchingCount) + 1;
            matchingCounts.set(matchingCount, newValue);
        }
    }



    public List<Lotto> getLottoNumbers() {
        return myLottoNumbers;
    }

    public Lotto getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
