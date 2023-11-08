package lotto.controller;

import lotto.constant.LottoPrice;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningPrize;
import lotto.model.WinningInfo;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.Message;
import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoService lottoService;
    private WinningInfo winningInfo;

    public LottoController(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        winningInfo = new WinningInfo();
        lottoService = new LottoService(winningInfo);
        start();
    }

    public void start(){
        int buyCount = readAndCalculateLottoCount();
        outputView.displayPurchaseCount(buyCount);
        Lottos lottos = new Lottos(buyCount);
        printInfo(lottos.getLottos());
        Map<Long, Long> winningResults = checkWinningNumbers(lottos);
        Message.displayStatistics();

        lottoService.WinningResults(winningResults);
        WinningResults(winningInfo.getWinnings());

        double profit = lottoService.calculateProfitRate(buyCount, winningResults);
        outputView.displayProfit(profit);
    }

    private int readAndCalculateLottoCount() {
        int money = inputView.readBuyAmount();
        return calculateLottoCount(money);
    }

    private Map<Long, Long> checkWinningNumbers(Lottos lottos) {
        List<Integer> winningNumbers = parseNumbers(inputView.readWinningNumbers());
        int bonusNumber = inputView.readBonusNumber();
        return lottos.checkWinningNumbers(winningNumbers, bonusNumber);
    }


    private void printInfo(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            outputView.printInfo(lotto.getNumbers());
        }
    }


    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int calculateLottoCount(int money) {
        LottoPrice lottoPrice = LottoPrice.ONE_TICKET_PRICE;
        if (money % lottoPrice.getPrice() != 0) {
            throw new IllegalArgumentException(Message.CHECK_AMOUNT);
        }
        return money / lottoPrice.getPrice();
    }

    public void WinningResults(Map<Long, Long> winningInfo) {
        LinkedHashMap<Integer, String> lottoPrizes = WinningPrize.getPrizeMap();

        for (Map.Entry<Integer, String> prizeEntry : lottoPrizes.entrySet()) {
            int prizeMatchingCount = prizeEntry.getKey();
            String prizeAmount = prizeEntry.getValue();
            Long winningCount = winningInfo.get((long) prizeMatchingCount);

            if (winningCount != null) {
                outputView.displayWinningResults(prizeMatchingCount, prizeAmount, winningCount);
            }
        }
    }

}
