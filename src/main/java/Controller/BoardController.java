package Controller;

import Domain.Board.Board;
import Domain.Calculator;
import Util.CheckNull;
import View.BoardView;
import Domain.WinningNumber.WinningNumber;
import Domain.lotto.Lotto;
import java.util.List;

public class BoardController {
    BoardView boardView;
    Board board;
    WinningNumber winningNumber;

    public BoardController(BoardView boardView){
        this.boardView = boardView;
    }

    public void setParameters(Board board, WinningNumber winningNumber, List<Lotto> lotteries){
        this.board = board;
        this.winningNumber = winningNumber;
        inputLotteriesToBoard(lotteries);
    }

    public void inputLottoToBoard(Lotto lotto){
        board.writeOutcome(Calculator.calLottoOutcome(winningNumber, lotto));
    }

    public void inputLotteriesToBoard(List<Lotto> lotteries){
        CheckNull.check(lotteries, "Board에 넣을 복권이 없습니다.");
        for(Lotto lotto: lotteries)
            inputLottoToBoard(lotto);
    }

    public void printBoard(){
        CheckNull.check(board, "ModuleController에 할당된 board가 없습니다.");
        boardView.printBoard(board);
    }
}
