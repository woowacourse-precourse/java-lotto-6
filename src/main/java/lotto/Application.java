package lotto;

import lotto.domain.Input;
import lotto.domain.Lotto;
import lotto.domain.Profit;
import lotto.domain.Winner;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Integer amount = input.readAmount();
        System.out.printf("%d개를 구매했습니다.",amount);
        System.out.println();

        ArrayList<Integer>[] result = new ArrayList[amount];
        for(int i=0; i<amount; i++){
            result[i] = input.IssueLotto();
            Lotto lotto = new Lotto(result[i]);
            lotto.printLotto();
        }

        ArrayList<Integer> winnerLotto =  input.readLotto();
        Lotto lotto = new Lotto(winnerLotto);

        Winner winner = new Winner();
        Integer bonus = input.readBonous();

        ArrayList<Integer> Lottoresult = winner.ConfirmLotto(result,winnerLotto,bonus);
        winner.PrintResult(Lottoresult);

        Profit profit = new Profit();
        double doubleProfit = profit.CalProfit(amount*1000,Lottoresult);
        String strProfit = String.format("%.1f", doubleProfit);
        System.out.printf("총 수익률은 %s%%입니다.",strProfit);
    }
}
