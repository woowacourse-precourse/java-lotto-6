package lotto.domain;

import static lotto.constant.ConstantInteger.LOTTO_MAX_NUMBER;
import static lotto.constant.ConstantInteger.LOTTO_MIN_NUMBER;
import static lotto.exception.ExceptionMessage.DUPLICATED_BONUS_NUMBER_MESSAGE;
import static lotto.exception.ExceptionMessage.NOT_IN_RANGE_NUMBER_INPUT_MESSAGE;

import java.util.List;

public class LottoTicketManager {

    private List<Lotto> lottoTickets;
    private Lotto luckyNumbers;
    private Integer bonusNumber;

    public LottoTicketManager(){
    }

    public Integer countTickets(String price) {
        return convertPrice(price)/1000 ;
    }

    private Integer convertPrice(String price){
        return Integer.parseInt(price);
    }

    public void getUserLottoTickets(List<Lotto> lottoTickets){
        this.lottoTickets=lottoTickets;
    }

    public void getLuckyNumber(Lotto luckyNumbers){
        this.luckyNumbers=luckyNumbers;
    }

    public void getBonusNumber(Integer bonusNumber){
        validate(bonusNumber);
        this.bonusNumber=bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicateBonusNumberInLuckyNumber(bonusNumber);
    }

    private void validateNumberRange(Integer bonusNumber){
        if(!isInRangeNumber(bonusNumber)){
            throw new IllegalArgumentException(NOT_IN_RANGE_NUMBER_INPUT_MESSAGE.getMessage());
        }
    }

    private boolean isInRangeNumber(Integer number){
        return LOTTO_MIN_NUMBER <= number && number <= LOTTO_MAX_NUMBER;
    }

    private void validateDuplicateBonusNumberInLuckyNumber(Integer bonusNumber){
        if(luckyNumbers.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_MESSAGE.getMessage());
        }
    }
}
