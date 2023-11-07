package lotto.Lottery.Util;

import lotto.Lottery.Enum.LottoWinnings;

import java.util.ArrayList;
import java.util.List;

public class ResultUtil {
    private static int SIZE_OF_WINNER_RECORD = 5;
    private static int SECOND_PRIZE_BONUS = 2;
    private static int THIRD_PRIZE = 5;

    public int evaluateSecondPrize(List<Integer> ticket, int resultOfLotto, int bonusNumber){
        if(resultOfLotto == THIRD_PRIZE){
            if(ticket.contains(bonusNumber))
                resultOfLotto += SECOND_PRIZE_BONUS;
        }
        return resultOfLotto;
    }

    public int updatePriceRecord(int resultOfLotto, int beforeSum){

        LottoWinnings lottoWinnings = LottoWinnings.valueOfMATCH(resultOfLotto);

        int winningPrize = lottoWinnings.getWinnings();
        int afterSum = beforeSum + winningPrize;

        return afterSum;
    }

    public List<Integer> initWinnerRecord(){
        List<Integer> winnerRecord = new ArrayList<>();

        for(int i = 0; i < SIZE_OF_WINNER_RECORD; i++)
            winnerRecord.add(0);

        return winnerRecord;
    }

    public int updateAllResult(Lotto lotto, int bonusNumber,
                               List<List<Integer>> lottoTickets, List<Integer> WinnerRecord, int winnerPrice){

        for(List<Integer> ticket: lottoTickets){
            int resultOfLotto = evaluateSecondPrize(ticket, lotto.evaluateWinnings(ticket), bonusNumber);
            winnerPrice = updatePriceRecord(resultOfLotto,winnerPrice);
            updateRecord(WinnerRecord, resultOfLotto);
        }

        return winnerPrice;
    }

    public int updateRecord(List<Integer> winnerRecord, int resultOfLotto){

        LottoWinnings lottoWinnings = LottoWinnings.valueOfMATCH(resultOfLotto);
        if(lottoWinnings.getOrder() == winnerRecord.size())
            return 0;

        int beforeRecord = winnerRecord.get(lottoWinnings.getOrder());
        int afterRecord = beforeRecord + 1;
        winnerRecord.set(lottoWinnings.getOrder(), afterRecord);

        return afterRecord;
    }
}
