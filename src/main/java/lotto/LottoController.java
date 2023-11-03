package lotto;

import static lotto.domain.util.LottoParser.*;

import java.util.*;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.numbergenerator.RandomNumberGenerator;
import lotto.exception.InputException;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printInputMoneyMessage();
        int validLottoCount = receiveValidLottoCounty();
        lottoMachine = new LottoMachine(validLottoCount, new RandomNumberGenerator());
        lottoMachine.makeLottos();

        List <Lotto> lottos = lottoMachine.getLottos();
        outputView.printLottoNumbers(parseLottoToInteger(lottos));

        outputView.printInputWinningNumbersMessage();
        List<Integer> validWinningNumbers = receiveValidWinningNumbers();

        outputView.printInputBonusNumberMessage();
        int validBonusNumber = receiveValidBonusNumber();

    }

    private int receiveValidLottoCounty() {
        try {
            String money = inputView.inputMoney();
            return parseMoneyToLottoCount(money);
        } catch (InputException | LottoException e) {
            System.out.println(e.getMessage());
            return receiveValidLottoCounty();
        }
    }

    private List<Integer> receiveValidWinningNumbers() {
        try {
            String winningNumbers = inputView.inputWinningNumber();
            return parseWinningNumbers(winningNumbers);
        } catch (InputException | LottoException e) {
            System.out.println(e.getMessage());
            return receiveValidWinningNumbers();
        }
    }

    private int receiveValidBonusNumber() {
        try {
            String bonusNumber = inputView.inputBonusNumber();
            return parseBonusNumber(bonusNumber);
        } catch (InputException | LottoException e) {
            System.out.println(e.getMessage());
            return receiveValidBonusNumber();
        }
    }
}
