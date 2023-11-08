package lotto.view;

import static lotto.settings.Announcement.BUY_LOTTO;
import static lotto.settings.Announcement.LOTTO_COUNT_PER_RANK;
import static lotto.settings.Announcement.PURCHASE_NUMBER;
import static lotto.settings.Announcement.RATE_OF_RETURN;
import static lotto.settings.Announcement.REQUEST_LOTTO_BONUS_NUMBERS;
import static lotto.settings.Announcement.REQUEST_LOTTO_WINNING_NUMBERS;
import static lotto.settings.Announcement.REQUEST_PURCHASE_AMOUNT;

import lotto.settings.Announcement;

public class View {

    public static void requestPurchaseAmount(){
        print(REQUEST_PURCHASE_AMOUNT);
    }

    public static void purchaseCount(int count){
        spaceSkip();
        System.out.printf(PURCHASE_NUMBER.getPrint(), count);
    }

    public static void requestWinningNumber(){
        print(REQUEST_LOTTO_WINNING_NUMBERS);
    }

    public static void requestBonusNumber(){
        print(REQUEST_LOTTO_BONUS_NUMBERS);
    }

    public static void winningStatistics(){
        spaceSkip();
        print(Announcement.WINNING_STATISTICS);
    }

    public static void result(String prize, int num){
        System.out.printf(prize+ LOTTO_COUNT_PER_RANK.getPrint(),num);
        spaceSkip();
    }

    public static void buyLottos(String lottoNumber){
        spaceSkip();
        System.out.printf(BUY_LOTTO.getPrint(),lottoNumber);
    }

    public static void rateOfReturn(double rateOfReturn){
        System.out.printf(RATE_OF_RETURN.getPrint(),rateOfReturn);
        spaceSkip();
    }

    public static void errorMessage(String message) {
        System.out.println(message);
        spaceSkip();
    }

    private static void print(Announcement announcement){
        System.out.println(announcement.getPrint());
    }

    public static void spaceSkip() {
        System.out.println();
    }

    public static void spaceSkipTwice() {
        spaceSkip();spaceSkip();
    }
}
