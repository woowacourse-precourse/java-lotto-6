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
    private Integer lottoAmount;
    private List<Lotto> myLottoNumbers;
    private Lotto winningLottoNumbers;
    private BonusNumber winningBonusNumber;

    public LottoController() {}

    public LottoController(Integer lottoAmount,
                           List<Lotto> myLottoNumbers,
                           Lotto winningLottoNumbers,
                           BonusNumber winningBonusNumber) {
        this.lottoAmount = lottoAmount;
        this.myLottoNumbers = myLottoNumbers;
        this.winningLottoNumbers = winningLottoNumbers;
        this.winningBonusNumber = winningBonusNumber;
    }

    public void playLottoGame() {
        buyMyLotto();
        assignLotto();
        showGameResult();
    }

    public void buyMyLotto() {
        assignPurchaseAmount();
        publishMyLotto();
        OutputView.printMyLotto(myLottoNumbers);
    }

    public void assignLotto() {
        assignLottoNumbers();
        assignBonusNumber();
    }

    public void showGameResult() {
        List<Integer> matchingCounts;
        double rateOfReturn;

        matchingCounts = calculateMatchingNumbers();
        rateOfReturn = calculateRateOfReturn(matchingCounts);

        OutputView.printWinningDetails(matchingCounts);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    public void assignPurchaseAmount() {
        boolean validInput = false;

        while(!validInput) {
            try {
                int inputPurchaseAmount = InputView.getPurchaseAmount();
                PurchaseAmount purchaseAmount = new PurchaseAmount(inputPurchaseAmount);
                lottoAmount = (purchaseAmount.get()) / 1000;

                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void publishMyLotto() {
        myLottoNumbers = new ArrayList<>();
        List<Integer> numbers;
        for (int i = 1; i <= lottoAmount; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLottoNumbers.add(new Lotto(numbers));
        }
    }

    public void assignLottoNumbers() {
        boolean validInput = false;

        while (!validInput) {
            try {
                List<Integer> inputLotto = InputView.getLotto();
                winningLottoNumbers = new Lotto(inputLotto);

                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void assignBonusNumber() {
        boolean validInput = false;

        while (!validInput) {
            try {
                int inputBonusNumber = InputView.getBonusNumber();
                winningBonusNumber = new BonusNumber(inputBonusNumber);
                winningBonusNumber.validateAlreadyExist(winningLottoNumbers);

                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> calculateMatchingNumbers() {
        List<Integer> matchingCounts = new ArrayList<>(Collections.nCopies(5, 0));

        for (int i = 0; i < lottoAmount; i++) {
            Lotto myLotto = myLottoNumbers.get(i);
            int matchingCount = myLotto.howManySameNumbers(winningLottoNumbers);
            if (matchingCount < 3) continue;

            int index = findIndexWithValue(matchingCount, myLotto);
            int newValue = matchingCounts.get(index) + 1;
            matchingCounts.set(index, newValue);
        }

        return matchingCounts;
    }

    public int findIndexWithValue(int number, Lotto lotto) {
        List<Integer> counts = List.of(3, 4, 5, 5, 6);
        List<Integer> indexes = List.of(0, 1, 2, 3, 4);
        int index = counts.indexOf(number);
        if (number == 5 && lotto.isContains(winningBonusNumber)) {
            index += 1;
        }
        return indexes.get(index);
    }

    public double calculateRateOfReturn(List<Integer> matchingCounts) {
        long prize = calculatePrize(matchingCounts);
        return ((double) prize / (lottoAmount * 1000)) * 100;
    }

    public long calculatePrize(List<Integer> matchingCounts) {
        long lottoReward;
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
}
