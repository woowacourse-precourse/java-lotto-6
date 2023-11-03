package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.userIO.InputController;
import lotto.controller.userIO.InputValidator;
import lotto.controller.userIO.OutputController;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoRandomGenerator;
import lotto.model.WinningLotto;
import lotto.model.WinningStatistics;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputController inputController;
    private OutputController outputController;

    public void init() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidator inputValidator = new InputValidator();

        inputController = new InputController(inputView, inputValidator);
        outputController = new OutputController(outputView);
    }

    public void run() {
        init();
        startLottoGame();
    }

    private void startLottoGame() {
        // 구입 금액 입력 받기
        int budget = getBudget();

        // 구입할 수 있는 로또 개수 계산
        int quantity = budget / 1000;

        // 구입한 만큼 로또 생성
        List<Lotto> lottoTicketsPurchased = createLottoTickets(quantity, new LottoRandomGenerator());

        // 구입한 로또 개수 출력
        outputController.printLottoTicketsCount(lottoTicketsPurchased.size());

        // 구입한 로또 번호들 출력
        outputController.printLottoTickets(lottoTicketsPurchased);

        // 당첨 번호 + 보너스 번호 입력 받기
        WinningLotto winningLotto = getWinningLottoTicket();

        // 당첨 통계 계산
        WinningStatistics winningStatistics
                = new WinningStatistics(winningLotto, lottoTicketsPurchased);

        // 당첨 통계 출력
        outputController.printWinningStatistics(winningStatistics);

        // 수익률 계산 및 출력
        double rateOfReturn = calculateRateOfReturn(budget, winningStatistics.calculateSumOfPrize());
        outputController.printRateOfReturn(rateOfReturn);
    }

    private int getBudget() {
        return Integer.parseInt(inputController.scanBudget());
    }

    private WinningLotto getWinningLottoTicket() {
        String userInput = inputController.scanWinningLottoTicket();
        List<Integer> lotto = new ArrayList<>();
        Parser.parseWithComma(userInput)
                .forEach(number -> lotto.add(Integer.parseInt(number)));
        Lotto winningLottoTicket = new Lotto(lotto);
        int bonusNumber = getBonusNumber(winningLottoTicket);
        return new WinningLotto(winningLottoTicket, bonusNumber);
    }

    private int getBonusNumber(Lotto winningLottoTicket) {
        return Integer.parseInt(inputController.scanBonusNumber(winningLottoTicket));
    }

    private Double calculateRateOfReturn(int budget, Long earnedAmount) {
        return earnedAmount * 100 / (double) budget;
    }

    private List<Lotto> createLottoTickets(int quantity, LottoGenerator lottoGenerator) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(lottoGenerator.generate());
        }
        return lottoTickets;
    }
}
