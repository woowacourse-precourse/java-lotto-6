package lotto.controller;

import java.util.List;
import lotto.port.InputPort;
import lotto.service.LottoService;

public class LottoGameController {

    private final String INPUT_PURCHASEAMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    private final InputPort inputPort;
    private final LottoService lottoService;


    public LottoGameController(InputPort inputPort, LottoService lottoService) {
        this.inputPort = inputPort;
        this.lottoService = lottoService;
    }

    public void playGame() {
        System.out.println(INPUT_PURCHASEAMOUNT_MESSAGE);
        String purchaseAmount = inputPort.readLine();
        int lottoTicketsCount = lottoService.calculateNumberOfLottoTickets(purchaseAmount);
        List<List<Integer>> allLottoNumbers = lottoService.generateLottoNumbers(lottoTicketsCount);
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumbers = inputPort.readLine();
        lottoService.addLottoNumberToWinningNumbers(winningNumbers);
    }
}
