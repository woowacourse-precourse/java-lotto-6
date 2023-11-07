package Controller;

import Model.BonusNumber;
import Model.Constant.Constants;
import Model.Enum.Prize;
import Model.Enum.Rank;
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
                lottoAmount = (purchaseAmount.get()) / Constants.DIVISOR;

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
            numbers = Randoms.pickUniqueNumbersInRange(
                    Constants.MIN_NUM, Constants.MAX_NUM, Constants.NUM_COUNT);
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
        List<Integer> matchingCounts = new ArrayList<>(
                Collections.nCopies(Constants.RANK_COUNT, 0));

        for (int i = 0; i < lottoAmount; i++) {
            Lotto myLotto = myLottoNumbers.get(i);
            int matchingCount = myLotto.howManySameNumbers(winningLottoNumbers);
            if (matchingCount < Constants.MIN_RANK) continue;

            int index = findIndexWithValue(matchingCount, myLotto);
            int newValue = matchingCounts.get(index) + 1;
            matchingCounts.set(index, newValue);
        }

        return matchingCounts;
    }

    public int findIndexWithValue(int number, Lotto lotto) {
        List<Rank> counts = List.of(Rank.FIFTH_RANK, Rank.FOURTH_RANK,
                Rank.THIRD_RANK, Rank.SECOND_RANK, Rank.FIRST_RANK);
        List<Integer> indexes = List.of(0, 1, 2, 3, 4);

        int pos = 0;
        for (int i = 0; i < Constants.RANK_COUNT; i++) {
            Rank rank = counts.get(i);
            if (number == rank.get()) {
                pos = i;
                break;
            }
        }
        if (number == Rank.THIRD_RANK.get() && lotto.isContains(winningBonusNumber)) {
            pos += 1;
        }
        return indexes.get(pos);
    }

    public double calculateRateOfReturn(List<Integer> matchingCounts) {
        long prize = calculatePrize(matchingCounts);
        return ((double) prize / (lottoAmount * Constants.DIVISOR)) * Constants.PERCENT;
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
        for (int i = 0; i < Constants.RANK_COUNT; i++) {
            Prize prize = rewards.get(i);
            lottoReward += matchingCounts.get(i) * prize.get();
        }
        return lottoReward;
    }
}
