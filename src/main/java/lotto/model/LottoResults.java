package lotto.model;

import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

import static lotto.model.Constants.*;

public class LottoResults {
    private final int userInputMoney;
    private final int lottoPapers;
    private int earnedMoney;
    private final List<Integer> results;

    public LottoResults(String userInputMoney) {
        InputValidator.checkUserInputIsNull(userInputMoney);
        InputValidator.checkUserInputIsInteger(userInputMoney);
        InputValidator.checkUserInputIsOverflow(userInputMoney);
        InputValidator.checkUserInputIsDivided(Integer.parseInt(userInputMoney),LOTTO_PRICE);

        this.userInputMoney = Integer.parseInt(userInputMoney);
        this.lottoPapers = this.userInputMoney/LOTTO_PRICE;

        this.earnedMoney = 0;
        // Results : [1등, 2등, 3등, 4등, 5등]
        results = Arrays.asList(0,0,0,0,0);
    }

    private LottoConstants getLottoPrize(int lottoMatch, boolean bonusMatch) {
        if (lottoMatch == 6) {return LottoConstants.FIRST_PRIZE;}
        if (lottoMatch == 5 && bonusMatch) {return LottoConstants.SECOND_PRIZE;}
        if (lottoMatch == 5) {return LottoConstants.THIRD_PRIZE;}
        if (lottoMatch == 4) {return LottoConstants.FOURTH_PRIZE;}
        if (lottoMatch == 3) {return LottoConstants.FIFTH_PRIZE;}
        return LottoConstants.NOTHING;
    }

    public void updateEachLottoResult(int lottoMatch, boolean bonusMatch) {
        LottoConstants prize = getLottoPrize(lottoMatch,bonusMatch);
        if (prize != LottoConstants.NOTHING) {
            earnedMoney += prize.getValue();
            results.set(prize.ordinal(),results.get(prize.ordinal())+1);
        }
    }

    public String getRateOfProfit() {
        return String.format("%.1f",earnedMoney*100.0/userInputMoney)
                .replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
    }

    public int getLottoPapers() {
        return this.lottoPapers;
    }

    public List<Integer> getLottoResults() {
        return results;
    }

}
