package lotto.Service;

import static lotto.etc.ErrorConstant.BETWEEN_ONE_AND_FORTY_FIVE_ERROR;
import static lotto.etc.ErrorConstant.BONUS_ERROR;
import static lotto.etc.ErrorConstant.DUPLICATE_ERROR;
import static lotto.etc.ErrorConstant.LOW_THOUSAND_ERROR;
import static lotto.etc.ErrorConstant.NOT_DIVIDE_THOUSAND_ERROR;
import static lotto.etc.ErrorConstant.NOT_NUMBER_ERROR;
import static lotto.etc.ErrorConstant.NOT_SIX_ERROR;
import static lotto.etc.RuleConstant.DIGITS;
import static lotto.etc.RuleConstant.SIX_MATCH;
import static lotto.etc.SystemConstant.THREE_ZERO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.dto.BonusRequestDTO;

public class ValidateService {

    private static final ValidateService instance = new ValidateService();
    private ValidateService() {}
    public static ValidateService getInstance() {
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
    public void checkLengthValidate(String time){
        if (time.length() <= 3)
            throw new IllegalArgumentException(LOW_THOUSAND_ERROR.toString());
    }
    public void checkDivideThousand(String time){
        String lastThreeChars = time.substring(time.length() - DIGITS.toInt());
        if (!lastThreeChars.equals(THREE_ZERO.toString()))
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
    public void duplicateBonusNumber(BonusRequestDTO bonusRequestDTO){
        List<Integer> lotto = bonusRequestDTO.getLotto()
                .getNumbers();
        int bonus = Integer.parseInt(bonusRequestDTO.getBonus());
        Set<Integer> userSet = new HashSet<>(lotto);
        userSet.add(bonus);
        if(userSet.size() == SIX_MATCH.toInt())
            throw new IllegalArgumentException(BONUS_ERROR.toString());
    }
}
