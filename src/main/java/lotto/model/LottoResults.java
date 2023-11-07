package lotto.model;

import lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.model.Constants.*;

public class LottoResults {
    private final int userInputMoney;
    private final int lottoPapers;
    private int earnedMoney;
    private List<Integer> results;

    public LottoResults(String userInputMoney) {
        InputValidator.checkUserInputIsInteger(userInputMoney);
        InputValidator.checkUserInputIsDivided(Integer.parseInt(userInputMoney),LOTTO_PRICE);

        this.userInputMoney = Integer.parseInt(userInputMoney);
        this.lottoPapers = this.userInputMoney/LOTTO_PRICE;

        this.earnedMoney = 0;
        // Results : [1등, 2등, 3등, 4등, 5등]
        results = Arrays.asList(0,0,0,0,0);
    }

    private int getLottoPrize(int LottoMatch, boolean BonusMatch) {
        if (LottoMatch == 6) {return 0;}
        if (LottoMatch == 5 && BonusMatch) {return 1;}
        if (LottoMatch == 5) {return 2;}
        if (LottoMatch == 4) {return 3;}
        if (LottoMatch == 3) {return 4;}
        return -1;
    }

    public void updateEachLottoResults(int LottoMatch, boolean BonusMatch) {
        int prize = getLottoPrize(LottoMatch,BonusMatch);
        if (prize >= 0) {
            earnedMoney += LOTTO_CASH.get(prize);
            results.set(prize,results.get(prize)+1);
        }
    }

    public String getRateOfProfit() {
        return String.format("%.1f",earnedMoney*100.0/userInputMoney);
    }

    public int getLottoPapers() {
        return this.lottoPapers;
    }

    public List<Integer> getLottoResults() {
        return results;
    }

}
