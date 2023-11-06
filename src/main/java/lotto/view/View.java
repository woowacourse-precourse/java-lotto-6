package lotto.view;

import static lotto.settings.Announcement.BUY_LOTTO;
import static lotto.settings.Announcement.PER_LOTTO_TOTAL_COUNT;
import static lotto.settings.Announcement.PURCHASE_NUMBER;
import static lotto.settings.Announcement.REQUEST_LOTTO_BONUS_NUMBERS;
import static lotto.settings.Announcement.REQUEST_LOTTO_WINNING_NUMBERS;
import static lotto.settings.Announcement.REQUEST_PURCHASE_AMOUNT;
import static lotto.settings.Announcement.WINNING_STATISTICS;
import static lotto.settings.WinningSettings.RATE_OF_RETURN;

import java.util.List;
import lotto.settings.Announcement;
import lotto.settings.WinningAmount;
import lotto.settings.WinningSettings;

public class View {

    public static void requestPurchaseAmount(){
        print(REQUEST_PURCHASE_AMOUNT);
    }

    public static void purchaseCount(int count){
        System.out.printf(PURCHASE_NUMBER.getPrint(), count);
    }

    public static void requestWinningNumber(){
        print(REQUEST_LOTTO_WINNING_NUMBERS);
    }

    public static void requestBonusNumber(){
        print(REQUEST_LOTTO_BONUS_NUMBERS);
    }

    public static void winningStatistics(){
        print(WINNING_STATISTICS);
    }

    public static void result(String prize, int num){
        System.out.printf(prize+PER_LOTTO_TOTAL_COUNT.getPrint(),num);
    }
    public static void buyLottos(String lottoNumber){
        System.out.printf(BUY_LOTTO.getPrint(),lottoNumber);}
    public static void rateOfReturn(double rateOfReturn){
        System.out.printf(RATE_OF_RETURN.getResult(),rateOfReturn);
    }
    private static void print(Announcement announcement){
        System.out.println(announcement.getPrint());
    }
}
