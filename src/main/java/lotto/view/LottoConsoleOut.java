package lotto.view;

import static lotto.view.ViewConstant.BONUS_NUMBER_MESSAGE;
import static lotto.view.ViewConstant.LOTTO_NUMBERS_MESSAGE;
import static lotto.view.ViewConstant.PRICE_MESSAGE;
import static lotto.view.ViewConstant.PURCHASE_COMPLETED_MESSAGE;
import static lotto.view.ViewConstant.WINNING_STATISTIC_MESSAGE;

import lotto.domain.LottoStatus;
import lotto.domain.model.LottoTicketList;

public class LottoConsoleOut {

    public static void messageOfPurchaseAmount(){
        System.out.println(PRICE_MESSAGE);
    }

    public static void outputPurchaseNumber(int numberOfTickets){
        System.out.println(numberOfTickets + PURCHASE_COMPLETED_MESSAGE);
    }

    public static void noticeLottoTickets(LottoTicketList lottoTickets){
        System.out.println(lottoTickets);
    }

    public static void noticeWinningNumbers(){
        System.out.println(LOTTO_NUMBERS_MESSAGE);
    }

    public static void noticeTicketNumbers(Integer numberOfTickets){
        System.out.printf("%d개를 구매했습니다.%n", numberOfTickets);
    }
    public static void noticeBonusNumber(){
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public static void noticeWinningStatistics(){
        System.out.println(WINNING_STATISTIC_MESSAGE);
    }

    public static void noticeWinningResult(LottoStatus status){
        System.out.println(status);
    }

    public static void noticeTotalRevenueRate(Float totalRevenue){
        System.out.printf("총 수익률은 %.1f%%입니다.\n",totalRevenue);
    }
}
