package lotto.Service;

import static lotto.etc.ErrorConstant.BETWEEN_ONE_AND_FORTY_FIVE_ERROR;
import static lotto.etc.ErrorConstant.BONUS_ERROR;
import static lotto.etc.ErrorConstant.DUPLICATE_ERROR;
import static lotto.etc.ErrorConstant.LOW_THOUSAND_ERROR;
import static lotto.etc.ErrorConstant.NOT_DIVIDE_THOUSAND_ERROR;
import static lotto.etc.ErrorConstant.NOT_NUMBER_ERROR;
import static lotto.etc.ErrorConstant.NOT_SIX_ERROR;
import static lotto.etc.RuleConstant.LOTTO_PRICE;
import static lotto.etc.RuleConstant.SIX_MATCH;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;

public class ValidateService {

    private static ValidateService instance;
    private ValidateService() {}
    public static ValidateService getInstance() {
        if (instance == null) instance = new ValidateService();
        return instance;
    }

    public int validateNumber(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.toString());
        }
    }
    public int checkOneAndFortyFive(int number) {
        if (!(number >= 1 && number <= 45))
            throw new IllegalArgumentException(BETWEEN_ONE_AND_FORTY_FIVE_ERROR.toString());
        return number;
    }
    public void checkLengthValidate(int time){
        if (time < LOTTO_PRICE.toInt())
            throw new IllegalArgumentException(LOW_THOUSAND_ERROR.toString());
    }
    public void checkDivideThousand(int time){
        if (time % LOTTO_PRICE.toInt() != 0)
            throw new IllegalArgumentException(NOT_DIVIDE_THOUSAND_ERROR.toString());
    }
    public void checkSixLength(List<Integer> numbers){
        if (numbers.size() != SIX_MATCH.toInt())
            throw new IllegalArgumentException(NOT_SIX_ERROR.toString());
    }
    public void checkDuplicateNumber(List<Integer> numbers){
        if(new HashSet<>(numbers).size() != SIX_MATCH.toInt())
            throw new IllegalArgumentException(DUPLICATE_ERROR.toString());
    }
    public void duplicateBonusNumber(Lotto lotto,int bonus){
        List<Integer> ticket = lotto.getNumbers();
        Set<Integer> userSet = new HashSet<>(ticket);
        userSet.add(bonus);
        if(userSet.size() == SIX_MATCH.toInt())
            throw new IllegalArgumentException(BONUS_ERROR.toString());
    }
}
