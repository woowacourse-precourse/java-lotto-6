package lotto;

import lotto.UI.InputHandler;
import lotto.constants.LottoEnum;
import lotto.domain.LottoManager;
import lotto.utils.CommonHelper;

public class ApplicationManager {
    public void start() {
        InputHandler inputHandler = new InputHandler();
        int cost = CommonHelper.strToInt(inputHandler.inputCost());
        int ticketCnt = CommonHelper.divide(cost, LottoEnum.LOTTO_PRICE.getValue());
        LottoManager lottoManager = new LottoManager(ticketCnt);
    }
}
