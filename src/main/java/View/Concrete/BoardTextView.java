package View.Concrete;

import Domain.Board.Board;
import Domain.lotto.LottoOutcome;
import View.BoardView;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class BoardTextView implements BoardView {

    public void printYieldRate(Board board){
        double yieldRate =  ((double)board.getPrize() / board.getMoney()) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", yieldRate) + "%입니다.");
    }

    public String recordOneLineToString(LottoOutcome outcome, int num){
        int numOfMatch = outcome.getMatchOfNum();

        String bonus = "";
        if(1 == outcome.getBonus())
            bonus = ", 보너스 볼 일치";

        String prize = String.format("%,d",outcome.getPrize());

        return numOfMatch + "개 일치" + bonus + " (" + prize + "원)" + " - " + num + "개";
    }

    public void printWinningRecord(Board board){
        Map<LottoOutcome, Integer> record = board.getWinningRecord();
        List<LottoOutcome> outcomeValues = new java.util.ArrayList<>(List.of(LottoOutcome.values()));
        outcomeValues.sort(Comparator.reverseOrder());
        StringJoiner joiner = new StringJoiner(",\n");
        for(LottoOutcome outcome: outcomeValues){
            if(outcome == LottoOutcome.none)
                continue;
            joiner.add(recordOneLineToString(outcome, record.get(outcome)));
        }
        System.out.println(joiner.toString());
    }
    public void printBoard(Board board) {
        printWinningRecord(board);
        printYieldRate(board);
    }
}
