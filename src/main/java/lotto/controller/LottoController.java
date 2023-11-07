package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private volatile static LottoController INSTANCE;
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public static LottoController getInstance() {
        if (INSTANCE == null) {
            synchronized (LottoController.class) {
                generateInstance();
            }
        }
        return INSTANCE;
    }

    private static void generateInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LottoController();
        }
    }

    public void run() {
        Money money = requestMoney();
        List<Lotto> lottos = buyLottos(money);
        List<Integer> winningNumbers = requestWinningNumbers();
        int bonusNumber = requestBonusNumber(winningNumbers);
        Map<Prize, Integer> prizeResult = lottoService.getPrizeResult(lottos, winningNumbers, bonusNumber);

        responsePrizeResult(prizeResult);
        responseRevenue(prizeResult, money);

    }


    private Money requestMoney() {
        Money money;
        while (true) {
            try {
                outputView.printRequestMoneyMessage();
                money = new Money(inputView.readMoney());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    private List<Lotto> buyLottos(Money money) {
        List<Lotto> lottos = lottoService.getLottos(money);
        responseLottos(lottos, money);
        return lottos;
    }

    private List<Integer> requestWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                outputView.printRequestWinningNumberMessage();
                winningNumbers = lottoService.getWinningNumbers(inputView.readWinningNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private int requestBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        while (true) {
            try {
                outputView.printRequestBonusNumber();
                bonusNumber = lottoService.getBonusNumber(inputView.readBonusNumber(), winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private void responseLottos(List<Lotto> lottos, Money money) {
        outputView.printBuyLottoMessage(money.calculateTicket());
        StringBuilder sb = new StringBuilder();
        lottos.stream().forEach(lotto -> sb.append(lotto.getNumbers()).append("\n"));
        outputView.printLottos(sb.toString());
    }

    private void responsePrizeResult(Map<Prize, Integer> prizeResult) {
        outputView.printPrizeResultMessage();
        StringBuilder sb = new StringBuilder();
        for (Prize prize : prizeResult.keySet()) {
            int count = prizeResult.get(prize);
            String message = prize.getMessage();
            sb.append(message).append(count).append("개").append("\n");
        }
        outputView.printPrizeResult(sb.toString());
    }

    private void responseRevenue(Map<Prize, Integer> prizeResult, Money money) {
        String revenue = lottoService.getRevenue(prizeResult, money);
        outputView.printRevenue(revenue);
    }


}
