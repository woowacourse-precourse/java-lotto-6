package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private static final Integer INITIALIZE = 0;
    private static final Integer SIZE = 6;
    private static Calculator calculator = new Calculator();
    private static View view = new View();
    private static List<Lotto> tickets = new ArrayList<Lotto>();
    private static List<Integer> saveTicketsCount = new ArrayList<Integer>(Collections.nCopies(SIZE,INITIALIZE));
    private static List<Integer> prizeList = new ArrayList<Integer>();
    private static Lotto winLottery;
    private static Integer bonus;
    private static Integer cost = INITIALIZE;
    private static Integer profit = INITIALIZE;


    public void run()  throws IllegalArgumentException{
        gameSetting();
        gameInitialize();
        gameInputWinner();
        gameResult();
    }

    private void gameSetting() {
        prizeList = Calculator.setPrize();
    }

    private void gameInitialize() {
        while (true) {
            try {
                view.printStart();
                cost = Calculator.setPrice();
                Exceptions.checkDiv(cost);
                tickets = Calculator.LottoInitialize(cost);
                view.printBuyInfo(Calculator.getCount(cost), tickets);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR]");
            }
        }
    }

    private void gameInputWinner(){
        winLottery = view.printInputPrizeNumber();
        bonus = view.printRequireBonus();
    }

    private void gameResult(){
        gameDetailResult();
        view.printMargin(Calculator.getMargin(cost,profit));
    }

    private static List<String> getRating(){
        List<String> rating = new ArrayList<String>();
        rating = view.printWinnerStatistic();
        return rating;
    }

    private static void getPrize(){
        for(int i = 0 ; i < tickets.size(); i++){
            Integer duplicateCount  = Calculator.calContainsInTicket(bonus,tickets.get(i),winLottery);
            Integer index = Calculator.getArrayIndex(duplicateCount);
            saveTicketsCount.set(index,saveTicketsCount.get(index)+1);
        }
        System.out.println(saveTicketsCount);
    }
    private static void gameDetailResult(){
        List<String> list = new ArrayList<String>();
        list = getRating();
        getPrize();
        for(int i = 1 ; i < saveTicketsCount.size();i++){
            System.out.println(list.get(i-1)+saveTicketsCount.get(i));
        }
        for(int i = 1 ; i <saveTicketsCount.size() ; i++){
            profit += prizeList.get(i-1) * saveTicketsCount.get(i);
        }
    }


}
