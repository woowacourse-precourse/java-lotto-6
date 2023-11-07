package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.LottoDecision;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGameService {
    private static final int LOTTO_PRICE = 1000;
    private static final int WINNING_NUMBER_LENGTH = 7;
    private static final int BONUS_NUMBER_POSITION = 6;
    private static final int WINNING_GRADE_LENGTH = 6;
    Buyer buyer;
    LottoDecision lottoDecision;

    public int setUpLotto(int paymentAmount) {
        int purchasableLottoCount = getPurchasableLottoCount(paymentAmount);
        buyer = new Buyer(purchasableLottoCount);
        IntStream.range(0, purchasableLottoCount)
                .mapToObj(i -> lottoGenerator())
                .forEach(buyer::addPurchasedLottoList);
        return purchasableLottoCount;
    }

    private int getPurchasableLottoCount(int paymentAmount) {
        if ((paymentAmount % LOTTO_PRICE) == 0) {
            return paymentAmount / LOTTO_PRICE;
        }
        throw new IllegalArgumentException();
    }

    private Lotto lottoGenerator() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lotto);
    }

    public ArrayList<Lotto> checkPurchasedLotto() {
        return buyer.getPurchasedLotto();
    }

    public void completeMakingWinningNumber(String enteredWinningNumbers, int bonusWinningNumber) {
        String[] defaultWinningNumbers = enteredWinningNumbers.split(",");
        int[] finalWinningNumber = makeFinalWinningNumber(defaultWinningNumbers, bonusWinningNumber);
        finalWinningNumber[BONUS_NUMBER_POSITION] = bonusWinningNumber;
        lottoDecision = new LottoDecision(finalWinningNumber);
    }

    private int[] makeFinalWinningNumber(String[] defaultWinningNumbers, int bonusWinningNumber) {
        int[] finalWinningNumber = new int[WINNING_NUMBER_LENGTH];

        int i = 0;
        for (String number : defaultWinningNumbers) {
            finalWinningNumber[i] = Integer.parseInt(number);
            i ++;
        }

        finalWinningNumber[WINNING_NUMBER_LENGTH - 1] = bonusWinningNumber;
        return finalWinningNumber;
    }

    public void makeWinningGrade() {
        ArrayList<Lotto> purchasedLotto = buyer.getPurchasedLotto();
        int[] winningNumber = lottoDecision.getWinningNumber();
        int[] winningGrade = new int[WINNING_GRADE_LENGTH];

        for (Lotto lotto : purchasedLotto) {
            List<Integer> numbers = lotto.getNumbers();
            int lottoResult = decisionWinningCount(numbers, winningNumber);
            settingWinningGrade(numbers, winningGrade, lottoResult, winningNumber);
        }
        lottoDecision.setWinningGrade(winningGrade);
    }

    private int decisionWinningCount(List<Integer> numbers, int[]winningNumber) {
        int winningCountPerOneLotto = 0;
        for (int i = 0; i < winningNumber.length - 1; i++) {
            if (numbers.contains(winningNumber[i])) {
                winningCountPerOneLotto += 1;
            }
        }
        return winningCountPerOneLotto;
    }

    private void settingWinningGrade(List<Integer> numbers, int[] lottoResultList, int lottoResult, int[] winningNumber) {
        if (lottoResult == 3) {
            lottoResultList[0] += 1;
        }
        if (lottoResult == 4) {
            lottoResultList[1] += 1;
        }
        if (lottoResult == 5) {
            if (isBonusNumberExist(numbers, winningNumber)) {
                lottoResultList[3] += 1;
            }
            if (!isBonusNumberExist(numbers, winningNumber)) {
                lottoResultList[2] += 1;
            }
        }
        if (lottoResult == 6) {
            lottoResultList[4] += 1;
        }
    }

    private boolean isBonusNumberExist(List<Integer> numbers, int[] winningNumber) {
        return numbers.contains(winningNumber[BONUS_NUMBER_POSITION]);
    }

    public int[] getWinningGrade() {
        return lottoDecision.getWinningGrade();
    }

    public double calculateProfitRate(int[] winningGrade) {
        int totalProfit = 0;
        totalProfit += 5000 * winningGrade[0];
        totalProfit += 50000 * winningGrade[1];
        totalProfit += 1500000 * winningGrade[2];
        totalProfit += 30000000 * winningGrade[3];
        totalProfit += 2000000000 * winningGrade[4];

        double buyerPay = 1000.0 * buyer.getPurchasedLottoCount();
        return (totalProfit / buyerPay) * 100.0;
    }
}
