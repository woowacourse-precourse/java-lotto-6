package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbersGenerator;
import lotto.domain.PurchaseAmount;
import lotto.domain.Ranking;
import lotto.domain.WinningNumbers;
import lotto.dto.ConsumerDto;
import lotto.dto.WinningLottoDto;

public class MainController {

    Calculator calculator;

    public MainController() {
        this.calculator = new Calculator();
    }

    public void settingConsumerLottos(ConsumerDto consumerDto) {
        PurchaseAmount purchaseAmount = consumerDto.getPurchaseAmount();
        int ticketQuantity = purchaseAmount.getTicketQuantity();
        ArrayList<Lotto> consumerLottos = new ArrayList<>();
        publishLottoByTicketQuantity(ticketQuantity, consumerLottos);

        consumerDto.setConsumerLottos(consumerLottos);
    }

    private void publishLottoByTicketQuantity(int ticketQuantity, ArrayList<Lotto> lottos) {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        while (ticketQuantity-- > 0) {
            List<Integer> randomNumbers = lottoNumbersGenerator.generateRandomNumbers();
            lottos.add(new Lotto(randomNumbers));
        }
    }

    public void setRankingResult(ConsumerDto consumerDto, WinningLottoDto winningLottoDto) {
        ArrayList<Lotto> consumerLottos = consumerDto.getConsumerLottos();
        WinningNumbers winningNumbers = winningLottoDto.getWinningNumbers();
        Map<Ranking, Integer> resultBoard = makeResultMap();
        for (Lotto lotto : consumerLottos) {
            Ranking rank = calculator.calculateRanking(lotto, winningNumbers);
            resultBoard.put(rank, resultBoard.getOrDefault(rank, 0) + 1);
        }
        consumerDto.setResultBoard(resultBoard);
    }

    private Map<Ranking, Integer> makeResultMap() {
        Map<Ranking, Integer> board = new TreeMap<>();
        Arrays.stream(Ranking.values())
                .forEach((rank) -> board.put(rank, 0));

        return board;
    }

    public void setReturnOfRate(ConsumerDto consumerDto) {
        Map<Ranking, Integer> resultBoard = consumerDto.getResultBoard();
        PurchaseAmount purchaseAmount = consumerDto.getPurchaseAmount();
        float returnOfRate = calculator.calculateReturnOfRate(resultBoard, purchaseAmount);

        consumerDto.setReturnOfRate(returnOfRate);
    }

}
