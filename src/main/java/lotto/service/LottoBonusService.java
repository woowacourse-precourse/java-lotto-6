package lotto.service;

import java.util.List;
import lotto.domain.repository.LottoBonus;
import lotto.enums.LottoRule;
import lotto.enums.UserInterfaceMessage;

public class LottoBonusService {
    private LottoBonus lottoBonus;

    private LottoBonusService() {
    }

    private static class LottoBonusServiceHolder {
        private static final LottoBonusService LOTTO_BONUS_SERVICE = new LottoBonusService();
    }

    public static LottoBonusService getInstance(){
        return LottoBonusServiceHolder.LOTTO_BONUS_SERVICE;
    }

    public Integer getLottoBonusNumber() {
        return lottoBonus.getBonusNumber();
    }

    public void setLottoBonusNumber(String bonusNumber, List<Integer> LottoNumber) throws IllegalArgumentException {
        lottoBonus = new LottoBonus(validateNumberFormat(bonusNumber), LottoNumber);
    }

    private Integer validateNumberFormat(String bonusNumber) {
        Integer parsedBonusNumber = 0;
        try {
            parsedBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(String.format(UserInterfaceMessage.ERROR_INPUT_BONUS_NUMBER_INCLUSIVE.getValue(),
                    LottoRule.START.getValue(), LottoRule.END.getValue()));
        }
        return parsedBonusNumber;
    }
}
