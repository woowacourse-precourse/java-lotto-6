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
        OutputHandler outputHandler = new OutputHandler();
        int cost = CommonHelper.strToInt(inputHandler.inputCost());
        int ticketCnt = CommonHelper.divide(cost, LottoEnum.LOTTO_PRICE.getValue());
        LottoManager lottoManager = new LottoManager(ticketCnt);
        List<Lotto> lottos = lottoManager.createLotto(ticketCnt);
        outputHandler.printTicketCnt(ticketCnt);
        outputHandler.printLottos();
        List<Integer> userLottoNumbers = inputHandler.inputWinningNumbers();
        int bonusNumber = CommonHelper.strToInt(inputHandler.inputBonusNumber(userLottoNumbers));
        List<Integer> result = lottoManager.sameNumberForWin(userLottoNumbers, lottos, bonusNumber);
        outputHandler.printResult(result);
        System.out.println(outputHandler.printRoi(lottoManager.earningsRate(result, cost)));
    }
}
