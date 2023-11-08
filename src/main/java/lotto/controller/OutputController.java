package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Ranking;
import lotto.dto.ConsumerDto;
import lotto.utils.Converter;
import lotto.view.OutView;

public class OutputController {

    OutView outView;

    public OutputController() {
        this.outView = new OutView();
    }

    public void orderPrintTicketQuantity(ConsumerDto consumerDto) {
        PurchaseAmount purchaseAmount = consumerDto.getPurchaseAmount();
        int ticketQuantity = purchaseAmount.getTicketQuantity();
        outView.printTicketQuantity(ticketQuantity);
    }

    public void orderPrintConsumerLottos(ConsumerDto consumerDto) {
        outView.printWinningStaticInfoMessage();
        ArrayList<Lotto> consumerLottos = consumerDto.getConsumerLottos();
        for (Lotto consumerLotto : consumerLottos) {
            List<String> numbers = Converter.lottoToString(consumerLotto);
            String outputConsumerNumbers = String.join(", ", numbers);
            outView.printConsumerLottos(outputConsumerNumbers);
        }
    }

    public void orderPrintResult(ConsumerDto consumerDto) {
        Map<Ranking, Integer> resultBoard = consumerDto.getResultBoard();
        float returnOfRate = consumerDto.getReturnOfRate();
        for (Map.Entry<Ranking, Integer> eachRank : resultBoard.entrySet()) {
            printWithoutNone(eachRank);
        }
        outView.printRateOfReturn(returnOfRate);
    }

    private void printWithoutNone(Entry<Ranking, Integer> eachRank) {
        if (eachRank.getKey() != Ranking.None) {
            Ranking ranking = eachRank.getKey();
            int numbersOfWinning = eachRank.getValue();
            outView.printRanking(ranking.getMessage(), numbersOfWinning);
        }

    }

}
