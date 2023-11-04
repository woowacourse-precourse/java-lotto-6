package lotto.service;

import java.util.List;
import lotto.constant.message.InputMessage;
import lotto.domain.LottoWinningNumber;
import lotto.util.ValidationUtil;
import lotto.view.InputView;

public class WinningNumberService {
    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
    private final InputView inputView = new InputView();
    private final ValidationUtil validationUtil =new ValidationUtil();
    public void getInputWinningNumber(){
        String number = inputView.getInputWithMessage(InputMessage.INPUT_NUMBER.getMessage());
        List<Integer> winning = validationUtil.validateWinningNumber(number);
        String bonusNum = inputView.getInputWithMessage(InputMessage.INPUT_BONUS.getMessage());
        int bonus = validationUtil.validateWinningNumberWithBonus(bonusNum, winning);
        lottoWinningNumber.getWinningNumbersInfo(winning, bonus);
    }
}
