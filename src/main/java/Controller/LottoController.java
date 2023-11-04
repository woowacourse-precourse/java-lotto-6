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
        matchingCounts = new ArrayList<>(Collections.nCopies(5, 0));

        for (int i = 0; i < lottoAmount; i++) {
            Lotto myLotto = myLottoNumbers.get(i);
            int matchingCount = myLotto.howManySameNumbers(winningLottoNumbers);
            if (matchingCount < 3) continue;

            int index = findIndexWithValue(matchingCount, myLotto);
            int newValue = matchingCounts.get(index) + 1;
            matchingCounts.set(index, newValue);
        }
    }

    public int findIndexWithValue(int number, Lotto lotto) {
        List<Integer> counts = List.of(3, 4, 5, 0, 6);
        List<Integer> indexes = List.of(0, 1, 2, 0, 4);
        int index = counts.indexOf(number);
        if (number == 5 && lotto.isContains(winningBonusNumber)) {
            index += 1;
        }
        return indexes.get(index);
    }

    public List<Lotto> getLottoNumbers() {
        return myLottoNumbers;
    }

    public Lotto getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
