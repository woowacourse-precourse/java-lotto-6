package Controller;

import Model.BonusNumber;
import Model.Enum.Prize;
import Model.Lotto;
import Model.PurchaseAmount;
import camp.nextstep.edu.missionutils.Randoms;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    private Integer lottoAmount = 0;
    private List<Lotto> myLottoNumbers;
    private Lotto winningLottoNumbers;
    private BonusNumber winningBonusNumber;
    private List<Integer> matchingCounts;
    private double rateOfReturn = 0.0;

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
        calculateRateOfReturn();
    }

    public void publishMyLotto(PurchaseAmount purchaseAmount) {
        myLottoNumbers = new ArrayList<>();
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

    public void calculateRateOfReturn() {
        int prize = calculatePrize(matchingCounts);
        rateOfReturn = ((double) prize / (lottoAmount * 1000)) * 100;
    }

    public int calculatePrize(List<Integer> matchingCounts) {
        int lottoReward;
        List<Prize> rewards = List.of(
                Prize.FIFTH_PRIZE,
                Prize.FOURTH_PRIZE,
                Prize.THIRD_PRIZE,
                Prize.SECOND_PRIZE,
                Prize.FIRST_PRIZE
        );
        lottoReward = 0;
        for (int i = 0; i < 5; i++) {
            Prize prize = rewards.get(i);
            lottoReward += matchingCounts.get(i) * prize.get();
        }
        return lottoReward;
    }

    public List<Lotto> getLottoNumbers() {
        return myLottoNumbers;
    }

    public Lotto getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
