package lotto.controller;

import lotto.model.Lotto;
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
        List<List<Integer>> lottoTickets = buyLottoTickets();
        consoleOutputView.outputBuyLottoTickets(lottoTickets);

        String inputUserLottoNumbers = getUserLottoNumbers();
        String inputUserBonusNumber = getUserBonusNumber(inputUserLottoNumbers);
        Map<String, String> userLottoNumbersAndBonusNumber = lottoService.setUserLottoNumbersAndBonusNumber(
                inputUserLottoNumbers, inputUserBonusNumber
        );
    }

    private String getUserBonusNumber(String inputUserLottoNumbers) {
        while (true) {
            try {
                String inputUserBonusNumber = consoleInputView.inputUserBonusNumber();
                lottoService.userBonusNumberValidate(inputUserLottoNumbers, inputUserBonusNumber);
                return inputUserBonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getUserLottoNumbers() {
        while (true) {
            try {
                String inputUserLottoNumbers = consoleInputView.inputUserLottoNumbers();
                lottoService.userLottoNumbersValidate(inputUserLottoNumbers);
                return inputUserLottoNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<List<Integer>> buyLottoTickets() {
        while (true) {
            try {
                String inputBuyLottoAmount = consoleInputView.inputBuyLottoAmount();
                lottoService.buyLottoAmountValidate(inputBuyLottoAmount);
                return lottoTicketGenerator.createRandomLottoTickets(inputBuyLottoAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
