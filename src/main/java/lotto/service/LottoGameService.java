package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.LottoDecision;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class LottoGameService {
    private static final int LOTTO_PRICE = 1000;
    private static final int WINNING_NUMBER_LENGTH = 7;
    private static final int BONUS_NUMBER_POSITION = 6;
    Buyer buyer;
    LottoDecision lottoDecision;

    public int buyLotto(int paymentAmount) {
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
        ArrayList<Integer> lotto = new ArrayList<>();
        while (lotto.size() < 6) {
            int number = Randoms.pickNumberInRange(1, 45);
            if (!lotto.contains(number)) {
                lotto.add(number);
            }
        }
        return new Lotto(lotto);
    }

    public ArrayList<Lotto> checkPurchasedLotto() {
        return buyer.getPurchasedLottoList();
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
}
