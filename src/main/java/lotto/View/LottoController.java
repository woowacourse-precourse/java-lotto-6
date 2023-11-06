package lotto.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Config.LottoConfig;
import lotto.Controller.LottoView;
import lotto.Model.Lotto;

public class LottoController {
    private int purchaseAmount;
    private List<Lotto> lottoTicketes;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int[] rankCounts = new int[5]; // 1~5등까지 저장

    public void startGame() {
        try {
            getPrice();
            getWinningNumbers();
            getBonusNumber();
            calculateResults();
            calculateProfit();
        } catch (IllegalArgumentException e) {
            LottoView.printErrorMessage(e.getMessage());
        }
    }

    private void calculateProfit() {
        long totalPrize = 0;
        totalPrize += rankCounts[0] * LottoConfig.FIFTH_PRIZE.getPrizeMoney();
        totalPrize += rankCounts[1] * LottoConfig.SECOND_PRIZE.getPrizeMoney();
        totalPrize += rankCounts[2] * LottoConfig.THIRD_PRIZE.getPrizeMoney();
        totalPrize += rankCounts[3] * LottoConfig.FOURTH_PRIZE.getPrizeMoney();
        totalPrize += rankCounts[4] * LottoConfig.FIFTH_PRIZE.getPrizeMoney();
        double profit = ((double) totalPrize / purchaseAmount) * 100;
        LottoView.printProfit(profit);
    }

    private void calculateResults() {
        for (Lotto lotto : lottoTicketes) {
            int matchCount = countMatch(lotto);
            if (matchCount == LottoConfig.FIRST_PRIZE.getValue())
                rankCounts[0]++;
            if (matchCount == LottoConfig.SECOND_PRIZE.getValue() && lotto.getNumbers().contains(bonusNumber))
                rankCounts[1]++;
            if (matchCount == LottoConfig.THIRD_PRIZE.getValue() && !lotto.getNumbers().contains(bonusNumber))
                rankCounts[2]++;
            if (matchCount == LottoConfig.FOURTH_PRIZE.getValue())
                rankCounts[3]++;
            if (matchCount == LottoConfig.FIFTH_PRIZE.getValue())
                rankCounts[4]++;
        }
        printRank();
    }

    private void printRank() {
        LottoView.printResult();
        LottoView.printRank(rankCounts);
    }

    private int countMatch(Lotto lotto) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void getPrice() {
        try {
            purchaseAmount = LottoView.promptForPurchaseAmount();
            validateAmount(purchaseAmount);
            lottoTicketes = purchaseLottoTickets(purchaseAmount);
            LottoView.printLottoTickets(lottoTicketes);
        } catch (IllegalArgumentException e) {
            LottoView.printErrorMessage(e.getMessage());
            getPrice();
        }

    }

    private void getWinningNumbers() {
        try {
            winningNumbers = LottoView.promptForWinningNumbers();
            if (winningNumbers.size() != 6) {
                throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
            }
            for (int winningNumber : winningNumbers) {
                validateNumber(winningNumber);
            }
        } catch (IllegalArgumentException e) {
            LottoView.printErrorMessage(e.getMessage());
            getWinningNumbers();
        }
    }

    private void getBonusNumber() {
        try {
            bonusNumber = LottoView.promptForBonusNumber();
            validateNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            LottoView.printErrorMessage(e.getMessage());
            getBonusNumber();
        }
    }

    private List<Lotto> purchaseLottoTickets(int purchaseAmount) {
        List<Lotto> lottoes = new ArrayList<>();
        int numberOfLotto = purchaseAmount / LottoConfig.PRICE.getValue();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoes.add(generateLotto());
        }
        return lottoes;
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private void validateAmount(int amount) {
        if (amount % LottoConfig.PRICE.getValue() != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해주세요.");
        }
    }

    private void validateNumber(int number) {
        if (number < LottoConfig.MIN_NUMBER.getValue() || number > LottoConfig.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }
}
