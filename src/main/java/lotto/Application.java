package lotto;

import View.BatInput;
import View.WinnerInput;
import View.WinnerInput;
import Controller.Lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int price = BatInput.getPrice();
        int batCount=price/1000;
        List<Integer> winners;
        int bonus;
        Lotto lotto;
        int i =1;
        do {
            try {
                winners = WinnerInput.getWinner();
                lotto = new Lotto(winners);
                i=0;
                Console.close();
            }
            catch(IllegalArgumentException e){
                winners.clear();
            }
        }while (i==1);
        //winners는 6개
        bonus=lotto.getWinnerBonus();


    }
}
