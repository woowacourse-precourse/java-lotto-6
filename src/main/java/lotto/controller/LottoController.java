package lotto.controller;

import lotto.model.LottoRank;
import lotto.model.LottoTicketGenerator;
import lotto.service.LottoService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final ConsoleInputView consoleInputView;
    private final ConsoleOutputView consoleOutputView;
    private final LottoService lottoService;
    private final LottoTicketGenerator lottoTicketGenerator;

    public LottoController(
            ConsoleInputView consoleInputView,
            ConsoleOutputView consoleOutputView,
            LottoService lottoService,
            LottoTicketGenerator lottoTicketGenerator
    ) {
        this.consoleInputView = consoleInputView;
        this.consoleOutputView = consoleOutputView;
        this.lottoService = lottoService;
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    // 게임 진행을 총괄하는 메서드
    public void lottoGamePlay() {
        String buyLottoAmount = getBuyLottoAmount();
        List<List<Integer>> lottoTickets = lottoTicketGenerator.createRandomLottoTickets(buyLottoAmount);
        consoleOutputView.outputBuyLottoTickets(lottoTickets);

        Map<String, String> userLottoNumbersAndBonusNumber = getUserLottoNumberAndBonusNumber();
        Map<LottoRank, Integer> lottoWinningResult = lottoService.getLottoWinningResult(
                userLottoNumbersAndBonusNumber, lottoTickets
        );
        consoleOutputView.outputLottoWinningResult(lottoWinningResult);

        double lottoRateOfReturn = lottoService.getLottoRateOfReturn(buyLottoAmount, lottoWinningResult);
        consoleOutputView.outputLottoRateOfReturn(lottoRateOfReturn);
    }

    private Map<String, String> getUserLottoNumberAndBonusNumber() {
        String inputUserLottoNumbers = getUserLottoNumbers();
        String inputUserBonusNumber = getUserBonusNumber(inputUserLottoNumbers);
        return lottoService.setUserLottoNumbersAndBonusNumber(inputUserLottoNumbers, inputUserBonusNumber);
    }

    private String getUserBonusNumber(String inputUserLottoNumbers) {
        while (true) {
            try {
                String inputUserBonusNumber = consoleInputView.inputUserBonusNumber();
                lottoService.userBonusNumberValidate(inputUserLottoNumbers, inputUserBonusNumber);
                System.out.println();
                return inputUserBonusNumber;
            } catch (IllegalArgumentException e) {
                consoleOutputView.outputErrorMessage(e);
            }
        }
    }

    private String getUserLottoNumbers() {
        while (true) {
            try {
                String inputUserLottoNumbers = consoleInputView.inputUserLottoNumbers();
                lottoService.userLottoNumbersValidate(inputUserLottoNumbers);
                System.out.println();
                return inputUserLottoNumbers;
            } catch (IllegalArgumentException e) {
                consoleOutputView.outputErrorMessage(e);
            }
        }
    }

    private String getBuyLottoAmount() {
        while (true) {
            try {
                String inputBuyLottoAmount = consoleInputView.inputBuyLottoAmount();
                lottoService.buyLottoAmountValidate(inputBuyLottoAmount);
                return inputBuyLottoAmount;
            } catch (IllegalArgumentException e) {
                consoleOutputView.outputErrorMessage(e);
            }
        }
    }
}
