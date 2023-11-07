import Board.Board;
import WinningNumber.WinningNumber;
import lotto.Lotto;

import java.util.List;

public class Controller {
    Board board;
    WinningNumber winningNumber;
    List<Lotto> lotteries;

    public Controller(Board board, WinningNumber winningNumber, List<Lotto> lotteries){
        this.board = board;
        this.winningNumber = winningNumber;
        this.lotteries = lotteries;
    }

    public void inputLottoToBoard(Lotto lotto){
        board.writeOutcome(Calculator.calLottoOutcome(winningNumber, lotto));
    }

    public void inputLotteriesToBoard(){
        for(Lotto lotto: lotteries)
            inputLottoToBoard(lotto);
    }
}
