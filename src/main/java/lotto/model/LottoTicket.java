package lotto.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.global.ErrorCode;
import lotto.global.constant.LottoNumber;
import lotto.model.exception.LottoTicketNumberException;

public class LottoTicket {

    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<Integer> lottoNumbers){
        Map<Integer, Boolean> useLottoNumber = new HashMap<>();
        for (int lottoNumber : lottoNumbers) {
            checkLottoNumberWithinTheRange(lottoNumber);
            checkLottoNumbersDuplicate(useLottoNumber, lottoNumber);
            useLottoNumber.put(lottoNumber, true);
        }
        checkLottoNumbersCount(lottoNumbers);
    }

    private void checkLottoNumberWithinTheRange(int lottoNumber){
        if(lottoNumber < LottoNumber.MIN_LOTTO_NUMBER || lottoNumber > LottoNumber.MAX_LOTTO_NUMBER){
            throw new LottoTicketNumberException(ErrorCode.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }
    private void checkLottoNumbersCount(List<Integer> lottoNumbers){
        if(lottoNumbers.size() != LottoNumber.LOTTO_NUMBER_COUNT){
            throw new LottoTicketNumberException(ErrorCode.LOTTO_NUMBER_COUNT_INCORRECT);
        }
    }
    private void checkLottoNumbersDuplicate(Map<Integer, Boolean> useLottoNumber, int number){
        if(useLottoNumber.containsKey(number)){
            throw new LottoTicketNumberException(ErrorCode.LOTTO_NUMBER_DUPLICATED);
        }
    }

}
