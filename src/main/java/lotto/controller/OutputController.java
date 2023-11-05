package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.utils.Converter;
import lotto.view.OutView;

public class OutputController {

    public void orderPrintTicketQuantity(int ticketQuantity){
        OutView.printTicketQuantity(ticketQuantity);
    }

    public void orderPrintConsumerLottos(ArrayList<Lotto> consumerLottos) {
        OutView.printWinningStaticInfoMessage();
        for(Lotto consumerLotto : consumerLottos){
            List<String> numbers = Converter.lottoToString(consumerLotto);
            String outputConsumerNumbers = String.join(", ", numbers);
            OutView.printConsumerLottos(outputConsumerNumbers);
        }
    }

    public void orderPrintRanking(Map<Ranking, Integer> result) {
        for(Map.Entry<Ranking,Integer> eachRank : result.entrySet()){
            printWithoutNone(eachRank);
        }
    }

    private static void printWithoutNone(Entry<Ranking, Integer> eachRank) {
        if(eachRank.getKey() !=Ranking.None){
            Ranking ranking = eachRank.getKey();
            int numbersOfWinning = eachRank.getValue();
            OutView.printRanking(ranking.getMessage(),numbersOfWinning);
        }
    }

    public void orderPrintReturnOfRate(float returnOfRate) {
        OutView.printRateOfReturn(returnOfRate);
    }

}
