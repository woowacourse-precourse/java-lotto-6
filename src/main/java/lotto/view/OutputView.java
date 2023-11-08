package lotto.view;

import lotto.model.MyLottoNumber;
import lotto.model.MyLottoNumbers;
import java.util.List;

import static lotto.util.Phrase.OutputPhrase.BUY_HOWMUCH;
import static lotto.util.Phrase.DrawPhrase.DRAW_STATISTIC;
import static lotto.util.Phrase.DrawPhrase.THREE_MATCHES;
import static lotto.util.Phrase.DrawPhrase.FOUR_MATCHES;
import static lotto.util.Phrase.DrawPhrase.FIVE_MATCHES;
import static lotto.util.Phrase.DrawPhrase.FIVE_AND_BONUS_MATCHES;
import static lotto.util.Phrase.DrawPhrase.SIX_MATCHES;
import static lotto.util.Phrase.RevenuePhrase.TOTAL_REVENUE_RATE;

public class OutputView {


    public void printNumberOfLotto(int NumberOfLotto) {
        System.out.printf(BUY_HOWMUCH.printMessage(), NumberOfLotto);
    }

    public void printMyNumbers(MyLottoNumbers myLottoNumbers) {
        for(MyLottoNumber myLottoNumber : myLottoNumbers.getMyLottoNumbers()){
            System.out.println((myLottoNumber.toString()));
        }
    }

    public void printDrawResult(List<Integer> results){
        int[] match = new int[7];
        System.out.println((DRAW_STATISTIC.printMessage()));
        for (int result : results) {
            if(result%10 == 5){
                result = 0;
            }
            match[result]++;
        }

            System.out.printf(THREE_MATCHES.printMessage(), match[3]);
            System.out.printf(FOUR_MATCHES.printMessage(), match[4]);
            System.out.printf(FIVE_MATCHES.printMessage(), match[5]);
            System.out.printf(FIVE_AND_BONUS_MATCHES.printMessage(), match[0]);
            System.out.printf(SIX_MATCHES.printMessage(), match[6]);

    }


    public void printRevenueResult(double totalRevenueRate){

        System.out.printf(TOTAL_REVENUE_RATE.printMessage(), totalRevenueRate);
    }
}