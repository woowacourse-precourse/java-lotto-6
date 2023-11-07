package View.Concrete;

import Board.Board;
import Board.LottoOutcome;
import View.BoardView;

import java.util.Map;

public class BoardTextView implements BoardView {

    public void printYieldRate(Board board){
        double yieldRate = (double) board.getPrize() / board.getMoney();
        System.out.println("총 수익률은 " + String.format("%.1f", yieldRate) + " 입니다.");
    }

    public String recordOneLineToString(LottoOutcome outcome, int num){
        int numOfMatch = outcome.getMatchOfNum();

        String bonus = "";
        if(1 == outcome.getBonus())
            bonus = ", 보너스 볼 일치";

        int prize = outcome.getPrize();

        return numOfMatch + "개 일치" + bonus + "(" + prize + ")" + " - " + num;
    }

    public void printWinningRecord(Board board){
        Map<LottoOutcome, Integer> record = board.getWinningRecord();
        for(LottoOutcome outcome: LottoOutcome.values()){
            if(outcome == LottoOutcome.none)
                continue;
            System.out.println( recordOneLineToString(outcome, record.get(outcome)) );
        }
    }
    public void printBoard(Board board) {
        printYieldRate(board);
        printWinningRecord(board);
    }
}
