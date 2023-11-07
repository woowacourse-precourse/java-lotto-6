package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.StringConstants;
import lotto.port.InputPort;
import lotto.service.LottoService;

public class LottoGameController {

    private final InputPort inputPort;
    private final LottoService lottoService;


    public LottoGameController(InputPort inputPort, LottoService lottoService) {
        this.inputPort = inputPort;
        this.lottoService = lottoService;
    }

    public void playGame() {
        List<List<Integer>> userLottoNumbers = buyLottoTickets();
        List<Integer> winningNumbers = inputWinningNumber();
        int bonusNumber = inputBonusNumber(winningNumbers);
        Map<Integer, Integer> matchingCounts = lottoService.calculateMatchingCounts(userLottoNumbers, winningNumbers, bonusNumber);
        lottoService.printStatistics(matchingCounts);
        lottoService.printReturnRate(matchingCounts, userLottoNumbers.size());
    }

    private List<List<Integer>> buyLottoTickets() {
        System.out.println(StringConstants.INPUT_PURCHASEAMOUNT_MESSAGE);
        String purchaseAmount = inputPort.readLine();
        int lottoTicketsCount = lottoService.calculateNumberOfLottoTickets(purchaseAmount);

        return lottoService.generateLottoNumbers(lottoTicketsCount);
    }

    private List<Integer> inputWinningNumber() {
        System.out.println(StringConstants.INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumbers = inputPort.readLine();

        return lottoService.addLottoNumberToWinningNumbers(winningNumbers);
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(StringConstants.INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = inputPort.readLine();
        lottoService.validateBonusNumber(winningNumbers, bonusNumber);

        return Integer.parseInt(bonusNumber);
    }
}
