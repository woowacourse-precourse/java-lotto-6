import Board.Board;
import WinningNumber.WinningNumber;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.List;

public class Controller {
    Board board;
    WinningNumber winningNumber;
    List<Lotto> lotteries;
    int money;



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

    public void InputMoney(){
        money = Integer.parseInt(Console.readLine());
    }
}
