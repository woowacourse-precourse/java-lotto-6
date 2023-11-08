package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.constant.LotteryRankConstant;
import lotto.domain.BonusNumber;
import lotto.domain.LotteryResult;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.UserMoney;
import lotto.domain.WinningLottoNumbers;
import lotto.dto.LottoNumbers;
import lotto.dto.UserLottoGameResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.exception.LottoInputException;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoService = new LottoService();
    }

    public void playGame() {
        UserMoney userMoney = initUserMoney();
        Lottos userLottos = lottoService.createUserLottos(userMoney.getUserMoney());
        outputView.printLine();
        printNumberOfLottos(userLottos.getNumberOfLottos());
        outputView.printLine();
        printLottoContents(userLottos.getLottos());

        WinningLottoNumbers winningLottoNumbers = initWinningLottoNumbers();
        outputView.printLine();
        BonusNumber bonusNumber = initBonusNumber(winningLottoNumbers);
        LotteryResult lotteryResult = lottoService.generateLotteryResult(winningLottoNumbers, bonusNumber);

        UserLottoGameResult userLottoGameResult = lottoService.generateUserLottoGameResult(lotteryResult, userLottos);
        printUserLottoGameResult(userLottoGameResult.getUserLottoRanks(), userLottoGameResult.getRateOfReturn());
        endGame();
    }

    private UserMoney initUserMoney() {
        try {
            long userMoney = askToInsertUserMoney();
            return lottoService.initUserMoney(userMoney);
        } catch (LottoInputException e) {
            outputView.printErrorMessage(e.getMessage());
            return initUserMoney();
        }
    }

    private long askToInsertUserMoney() {
        outputView.askToInsertUserMoney();
        return inputView.getUserMoney();
    }

    private void printNumberOfLottos(final long numberOfLottos) {
        outputView.printNumberOfLottos(numberOfLottos);
    }

    private void printLottoContents(final List<Lotto> lottos) {
        for (Lotto l : lottos) {
            outputView.printLottoContent(LottoNumbers.from(l));
        }
        outputView.printLine();
    }

    private WinningLottoNumbers initWinningLottoNumbers() {
        try {
            List<Integer> winningLottoNumbers = askToInsertWinningLottoNumbers();
            return lottoService.initWinningLottoNumbers(winningLottoNumbers);
        } catch (LottoInputException e) {
            outputView.printErrorMessage(e.getMessage());
            return initWinningLottoNumbers();
        }
    }

    private List<Integer> askToInsertWinningLottoNumbers() {
        outputView.askUserToInsertLottoWinningNumbers();
        return inputView.getWinningLottoNumbers();
    }

    private BonusNumber initBonusNumber(final WinningLottoNumbers winningLottoNumbers) {
        try {
            int bonusNumber = askToInsertBonusNumber();
            return lottoService.initBonusNumber(winningLottoNumbers, bonusNumber);
        } catch (LottoInputException e) {
            outputView.printErrorMessage(e.getMessage());
            return initBonusNumber(winningLottoNumbers);
        }
    }

    private int askToInsertBonusNumber() {
        outputView.askUserToInsertBonusNumber();
        return inputView.getBonusNumber();
    }

    public void printUserLottoGameResult(final Map<LotteryRankConstant, Integer> userLottoRanks,
                                         final double rateOfReturn) {
        outputView.printWinningStatistics(userLottoRanks, rateOfReturn);
    }

    private void endGame() {
        Console.close();
    }
}