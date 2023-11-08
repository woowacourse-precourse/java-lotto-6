package lotto;

import lotto.UI.InputHandler;
import lotto.UI.OutputHandler;
import lotto.constants.LottoEnum;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.utils.CommonHelper;

import java.util.List;

public class ApplicationManager {
    public void start() {
        InputHandler inputHandler = new InputHandler();
        int cost = CommonHelper.strToInt(inputHandler.inputCost());
        int ticketCnt = CommonHelper.divide(cost, LottoEnum.LOTTO_PRICE.getValue());
        LottoManager lottoManager = new LottoManager(ticketCnt);
        List<Lotto> lottos = lottoManager.createLotto(ticketCnt);
        OutputHandler outputHandler = new OutputHandler();
        outputHandler.printLottos();
        List<Integer> userLottoNumbers = inputHandler.inputWinningNumbers();
        int bonusNumber = CommonHelper.strToInt(inputHandler.inputBonusNumber());
    }
}
