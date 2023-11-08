package lotto;

import lotto.Domain.Comparison;
import lotto.Domain.Verifier;
import lotto.Domain.DataConverter;
import lotto.View.OutputView;
import lotto.View.InputView;
import lotto.Domain.QuickPicks;
import lotto.View.Constants.InfoMessage;
import lotto.View.Constants.WinningMessage;

import java.util.List;

public class Controller {

    static long quantity;

    static long money;

    static int bonusBall;

    private static List<Integer> winningBall;



    static QuickPicks quickPicks = new QuickPicks();

    static Comparison comparison = new Comparison();

    static OutputView outputView = new OutputView();


    public static void play(){

        gameMoneyInputProcess();

        buyLottoPaper(quantity);

        winningNumberInputProcess();

        bonusNumberInputProcess(winningBall);

        numberComparisonProcess();

        winningOutput();

    }
    public static void gameMoneyInputProcess() {
        String input = null;
        input = InputView.gameMoney();

        try {
            Verifier.inputNoting(input);
            Verifier.onlyNumberConsist(input);

            money = DataConverter.gameMoney(input);
            quantity = DataConverter.gameQuantity(money);

        }catch (IllegalArgumentException e2){

            gameMoneyInputProcess();
            return;
        }
        System.out.println();
    }

    public static void  buyLottoPaper (long gameRepeat) {
        System.out.println(gameRepeat + InfoMessage.PURCHASE_QUANTITY_MESSAGE.getMessage());
        quickPicks.lottoPaper(gameRepeat);
        System.out.println();
    }



public static void winningNumberInputProcess() {

    String input = null;
    List<String> win;

    input = InputView.winningNumber();

    try{
        Verifier.inputNoting(input);
        Verifier.onlyNumberAndComma(input);

        win = DataConverter.winningInput(input);
        winningBall = DataConverter.winningBalls(win);

    }catch (IllegalArgumentException e2){

        winningNumberInputProcess();
        return;
    }

    System.out.println(win +" "+winningBall);
}


    public static void bonusNumberInputProcess(List<Integer> winning) {

        int bonusBall;
        String input = null;
        List<Integer> balls = winning;

        input = InputView.bonusNumber();

        try {
            Verifier.inputNoting(input);
            bonusBall = DataConverter.bonusBall(input,balls);
        } catch (IllegalArgumentException e) {
            bonusNumberInputProcess(winning);
            return;
        }

        System.out.println(bonusBall);
    }

    public static void numberComparisonProcess(){
        System.out.println(InfoMessage.WINNING_SUN_UP.getMessage());
        System.out.println(InfoMessage.CUTTING_LINE.getMessage());
        comparison.traverseGames(winningBall,(int)quantity,bonusBall);
        comparison.overAllWinning();
    }


    public static void winningOutput(){
        WinningMessage[] winningMessages = WinningMessage.values();
        outputView.corrects(Comparison.correctType, winningMessages);

        long profitSums = DataConverter.profitSum(Comparison.correctType);
        double percent = DataConverter.profitPercent(profitSums,money);

        outputView.profitPercentOutput(percent);

    }

}
