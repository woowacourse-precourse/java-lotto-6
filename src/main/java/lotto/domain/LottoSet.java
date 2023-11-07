package lotto.domain;

import java.util.List;
import lotto.config.exception.ExceptionType;
import lotto.config.exception.InputException;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;
import lotto.domain.constant.LottoConstant;

public class LottoSet {
    private final List<Integer> lottoNumbers;
    private int bonusNumber;

    public LottoSet(Lotto lotto, int bonusNumber) {
        OutputMessage.print(MessageType.INPUT_START_BONUS);
        validate(lotto.get(), bonusNumber);
        this.lottoNumbers = lotto.get();
        this.bonusNumber = bonusNumber;
        OutputMessage.printf(MessageType.INPUT_BUYER_FORMAT, this.bonusNumber);
    }

    private void validate(List<Integer> lottoNumbers, int bonusNumber) {
        if (isLottoRange(bonusNumber)) {
            throw new InputException(ExceptionType.ERROR_LOTTO_RANGE);
        }

        if(isDuplicate(lottoNumbers, bonusNumber)){
            throw new InputException(ExceptionType.ERROR_LOTTO_DUPLICATE);
        }
    }

    private boolean isDuplicate(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private boolean isLottoRange(int bonusNumber) {
        return isHight(bonusNumber) || isLower(bonusNumber);
    }

    private boolean isHight(int bonusNumber) {
        return LottoConstant.LOTTO_END_NUMBER < bonusNumber;
    }

    private boolean isLower(int bonusNumber) {
        return LottoConstant.LOTTO_START_NUMBER > bonusNumber;
    }

    public int sameLottoNumber(List<Integer> ticket) {
        return (int) ticket.stream()
                .filter(integer -> lottoNumbers.contains(integer))
                .count();
    }

    public int sameBonusNumber(List<Integer> ticket){
        int bonusCount = 0;

        if (ticket.contains(this.bonusNumber)) {
            bonusCount = 1;
        }

        return bonusCount;
    }
}
