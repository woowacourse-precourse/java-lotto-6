package lotto;

import Model.LottoProcess;
import View.BatInput;

import View.WinnerInput;
import View.WinnerInput;
import Controller.Lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        int price = BatInput.getPrice();
        int batCount=price/1000;
        List<Integer> winners;
        ArrayList<List<Integer>> lottoPicks=LottoProcess.getAutoLotto(batCount);
        int bonus;
        Lotto lotto;
        int i =1;
        do {
            winners = WinnerInput.getWinner();
            try {
                lotto = new Lotto(winners);
                i=0;
            }
            catch(IllegalArgumentException e){
                e.printStackTrace();
            }
        }while (i==1);
        //winners는 6개
       lotto = new Lotto(winners);
       bonus = lotto.getWinnerBonus();
       //System.out.println("번호: "+winners+"보너스: "+bonus);
    lottoModel(price,batCount,winners,bonus);
    Console.close();
    }
    public static int lottoModel(int price, int batCount, List<Integer>winners, int bonus){

        LottoProcess.calculation(price,batCount,winners,bonus);
        return 0;
    }
}
