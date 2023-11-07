package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.WinningDataCategory;
import lotto.exception.InvalidDuplicateNumberException;
import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.LottoDecision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class LottoGameService {
    private static final int LOTTO_PRICE = 1000;

    private static final int WINNING_NUMBER_LENGTH = 7;
    private static final int BONUS_NUMBER_POSITION = 6;
    private static final int WINNING_DATA_LENGTH = 6;
    Buyer buyer;
    LottoDecision lottoDecision;

    public int setUpPurchasedLotto(int paymentAmount) {
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

    private Lotto lottoGenerator(){
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lotto);
    }

    public ArrayList<Lotto> checkPurchasedLotto() {
        return buyer.getPurchasedLotto();
    }

    public void completeMakingWinningNumber(List<String> defaultWinningNumbers, int bonusWinningNumber) {
        int[] finalWinningNumber = makeFinalWinningNumber(defaultWinningNumbers, bonusWinningNumber);
        finalWinningNumber[BONUS_NUMBER_POSITION] = bonusWinningNumber;
        lottoDecision = new LottoDecision(finalWinningNumber);
    }

    private int[] makeFinalWinningNumber(List<String> defaultWinningNumbers, int bonusWinningNumber) {
        int[] finalWinningNumber = new int[WINNING_NUMBER_LENGTH];

        int i = 0;
        for (String number : defaultWinningNumbers) {
            finalWinningNumber[i] = Integer.parseInt(number);
            i ++;
        }

        finalWinningNumber[WINNING_NUMBER_LENGTH - 1] = bonusWinningNumber;
        return finalWinningNumber;
    }

    public void makeWinningData() {
        ArrayList<Lotto> purchasedLotto = buyer.getPurchasedLotto();
        int[] winningNumber = lottoDecision.getWinningNumber();
        int[] winningData = new int[WINNING_DATA_LENGTH];

        for (Lotto lotto : purchasedLotto) {
            List<Integer> numbers = lotto.getNumbers();
            int lottoResult = decisionWinningCount(numbers, winningNumber);
            settingWinningData(numbers, winningData, lottoResult, winningNumber);
        }
        lottoDecision.setWinningData(winningData);
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

    private void settingWinningData(List<Integer> numbers, int[] lottoResultList, int lottoResult, int[] winningNumber) {
        if (lottoResult == 3) {
            lottoResultList[WinningDataCategory.THREE_MATCH.getPosition()] += 1;
        }
        if (lottoResult == 4) {
            lottoResultList[WinningDataCategory.FOUR_MATCH.getPosition()] += 1;
        }
        if (lottoResult == 5) {
            if (!isBonusNumberExist(numbers, winningNumber)) {
                lottoResultList[WinningDataCategory.FIVE_MATCH.getPosition()] += 1;
            }
            if (isBonusNumberExist(numbers, winningNumber)) {
                lottoResultList[WinningDataCategory.BONUS_MATCH.getPosition()] += 1;
            }
        }
        if (lottoResult == 6) {
            lottoResultList[4] += 1;
        }
    }

    private boolean isBonusNumberExist(List<Integer> numbers, int[] winningNumber) {
        return numbers.contains(winningNumber[BONUS_NUMBER_POSITION]);
    }

    public int[] getWinningData() {
        return lottoDecision.getWinningData();
    }

    public double calculateProfitRate(int[] winningData) {
        int totalProfit = 0;
        for (int i = 0; i < winningData.length - 1; i++) {
            totalProfit += WinningDataCategory.values()[i].getPrize() * winningData[i];
        }

        double buyerPay = 1000.0 * buyer.getPurchasedLottoCount();
        return (totalProfit / buyerPay) * 100.0;
    }
}
