package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoTicketGenerator;
import lotto.service.LottoService;
import lotto.view.ConsoleInputView;

import java.util.List;

public class LottoController {

    private final ConsoleInputView consoleInputView;
    private final LottoService lottoService;
    private final LottoTicketGenerator lottoTicketGenerator;

    public LottoController(
            ConsoleInputView consoleInputView,
            LottoService lottoService,
            LottoTicketGenerator lottoTicketGenerator
    ) {
        this.consoleInputView = consoleInputView;
        this.lottoService = lottoService;
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public void lottoGamePlay() {
        List<List<Integer>> lottoTickets = buyLottoTickets();
        /*for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }*/

        String inputUserLottoNumbers = consoleInputView.inputUserLottoNumbers();
        lottoService.userLottoNumbersValidate(inputUserLottoNumbers);

        String inputUserBonusNumber = consoleInputView.inputUserBonusNumber();
        lottoService.userBonusNumberValidate(inputUserLottoNumbers, inputUserBonusNumber);

        /*Map<String, String> userLottoNumbersAndBonusNumber =
                lottoService.setUserLottoNumbersAndBonusNumber(
                        inputUserLottoNumbers, inputUserBonusNumber
                );*/
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
