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

        // 사용자가 구매 금액을 입력하고, 그 가격에 맞게 로또를 발행한다.
        String buyLottoAmount = getBuyLottoAmount();
        List<List<Integer>> lottoTickets = lottoTicketGenerator.createRandomLottoTickets(buyLottoAmount);
        consoleOutputView.outputBuyLottoTickets(lottoTickets);

        // 사용자가 당첨 번호와 보너스 번호를 입력하여 그 정보를 저장한다.
        Map<String, String> userLottoNumbersAndBonusNumber = getUserLottoNumberAndBonusNumber();

        // 구매한 로또와 사용자의 로또를 비교하여 등수를 구한다.
        Map<LottoRank, Integer> lottoWinningResult = lottoService.getLottoWinningResult(userLottoNumbersAndBonusNumber, lottoTickets);
        consoleOutputView.outputLottoWinningResult(lottoWinningResult);
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
