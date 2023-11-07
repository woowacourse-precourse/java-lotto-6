package lotto.service;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.PrizeTable;
import lotto.domain.WinningNumbers;
import lotto.util.Utils;

import java.util.HashMap;

import static lotto.util.LottoConstants.*;

public class Service {

    public void buyLotto(Buyer buyer) {
        int count = buyer.getPurchaseAmount() / MIN_UNIT;
        while (count > 0) {
            Lotto lotto = generateLottoNumbers();
            buyer.buyLotto(lotto);
            count--;
        }
    }

    private Lotto generateLottoNumbers() {
        return new Lotto(Utils.randomUniqueNumbers(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBERS_SIZE));
    }

    public HashMap<PrizeTable, Integer> checkMyLotto(Buyer buyer, WinningNumbers winningNumbers) {
        HashMap<PrizeTable, Integer> result = PrizeSetting();
        for (Lotto lotto : buyer.getPurchasedLotteries()) {
            int countSameNumber = countSameNumber(lotto, winningNumbers);
            boolean hasBonusNumber = matchBonusNumber(lotto, winningNumbers.getBonusNumber());
            determineRank(countSameNumber, hasBonusNumber, result);
        }
        return result;
    }

    public boolean matchBonusNumber(Lotto lotto, int bonusNumber) {
        return Utils.countContainNumber(lotto.getLottoNumbers(), bonusNumber);
    }

    public int countSameNumber(Lotto lotto, WinningNumbers winningNumbers) {
        return Utils.countSameElements(lotto.getLottoNumbers(), winningNumbers.getWinningNumbers());
    }

    public HashMap<PrizeTable, Integer> determineRank(int countSameNumber, boolean hasBonusNumber, HashMap<PrizeTable, Integer> result) {
        if (countSameNumber == 6) {
            result.put(PrizeTable.FIRST_PRIZE, result.get(PrizeTable.FIRST_PRIZE)+1);
        } else if (countSameNumber == 5 && hasBonusNumber) {
            result.put(PrizeTable.SECOND_PRIZE, result.get(PrizeTable.SECOND_PRIZE)+1);
        } else if (countSameNumber == 5) {
            result.put(PrizeTable.THIRD_PRIZE,result.get(PrizeTable.THIRD_PRIZE)+1);
        } else if (countSameNumber == 4) {
            result.put(PrizeTable.FOURTH_PRIZE,result.get(PrizeTable.FOURTH_PRIZE)+1);
        } else if (countSameNumber == 3) {
            result.put(PrizeTable.FIFTH_PRIZE,result.get(PrizeTable.FIFTH_PRIZE)+1);
        }
        return result;
    }


    public HashMap<PrizeTable, Integer> PrizeSetting() {
        HashMap<PrizeTable, Integer> result = new HashMap<>();
        result.put(PrizeTable.FIRST_PRIZE, 0);
        result.put(PrizeTable.SECOND_PRIZE, 0);
        result.put(PrizeTable.THIRD_PRIZE, 0);
        result.put(PrizeTable.FOURTH_PRIZE, 0);
        result.put(PrizeTable.FIFTH_PRIZE, 0);
        result.put(PrizeTable.NO_RANK_TWO, 0);
        result.put(PrizeTable.NO_RANK_ONE, 0);
        result.put(PrizeTable.NO_RANK_ZERO, 0);
        return result;
    }




}
