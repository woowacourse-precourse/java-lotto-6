/**
 * @Package_name   : view
 * @Class_name     : OutputView
 * <p>
 * Create Date : 2023-11-07
 * Create User : 정은채
 */
package view;

import java.util.ArrayList;

public class OutputView {

    /**
     * Description : 구입금액입력 메세지 출력
     *
     * @Method : ()
     */
    public void printLottoBuy(){
        System.out.print(OutputMessage.LOTTO_BUY_MONEY.getMessage());
    }
    /**
     * Description : 로또 구입 개수 메세지 출력
     *
     * @Method : printLottoBuyComplete()
     */
    public void printLottoBuyComplete(int lottoTicketCount){
        System.out.printf(lottoTicketCount + OutputMessage.LOTTO_BUY_COMPLETE.getMessage());
    }
    /**
     * Description : 로또 번호묶음 메세지 출력
     *
     * @Method : printLottoNums()
     */
    public void printLottoNums(ArrayList<Integer> LottoNums){
        System.out.println(LottoNums);
    }
    /**
     * Description : 당청 번호 요청메세지 출력
     *
     * @Method : printLottoNumRequest()
     */
    public void printLottoNumRequest(){
        System.out.print(OutputMessage.LOTTO_NUM_REQUEST.getMessage());
    }
    /**
     * Description : 보너스 번호 요청 메세지 출력
     *
     * @Method : printBonusNumRequest()
     */
    public void printBonusNumRequest(){
        System.out.print(OutputMessage.BONUS_NUM_REQUEST.getMessage());
    }
    /**
     * Description : 당첨 통계 메세지 출력
     *
     * @Method : printWinStatistic()
     */
    public void printWinStatistic(ArrayList<Integer> WinStatistics){
        printWinStatisticTitle();
        printWinStatistic3(WinStatistics.get(0));
        printWinStatistic4(WinStatistics.get(1));
        printWinStatistic5(WinStatistics.get(2));
        printWinStatistic5Bonus(WinStatistics.get(3));
        printWinStatistic6(WinStatistics.get(4));
    }
    /**
     * Description : 당첨 통계 타이틀 메세지 출력
     *
     * @Method : printWinStatisticTitle()
     */
    public void printWinStatisticTitle(){
        System.out.print(OutputMessage.WIN_STATISTIC.getMessage());
    }
    /**
     * Description : 당첨 통계 3개 일치 메세지 출력
     *
     * @Method : printWinStatistic3()
     */
    public void printWinStatistic3(int count){
        System.out.print(OutputMessage.WIN_STATISTIC_3.getMessage() + count + OutputMessage.WIN_STATISTIC_COUNT.getMessage());
    }
    /**
     * Description : 당첨 통계 4개 일치 메세지 출력
     *
     * @Method : printWinStatistic4()
     */
    public void printWinStatistic4(int count){
        System.out.print(OutputMessage.WIN_STATISTIC_4.getMessage() + count + OutputMessage.WIN_STATISTIC_COUNT.getMessage());
    }
    /**
     * Description : 당첨 통계 5개 일치 메세지 출력
     *
     * @Method : printWinStatistic5()
     */
    public void printWinStatistic5(int count){
        System.out.print(OutputMessage.WIN_STATISTIC_5.getMessage() + count + OutputMessage.WIN_STATISTIC_COUNT.getMessage());
    }
    /**
     * Description : 당첨 통계 5개,보너스 일치 메세지 출력
     *
     * @Method : printWinStatistic4()
     */
    public void printWinStatistic5Bonus(int count){
        System.out.print(OutputMessage.WIN_STATISTIC_5_BONUS.getMessage() + count + OutputMessage.WIN_STATISTIC_COUNT.getMessage());
    }
    /**
     * Description : 당첨 통계 6개 일치 메세지 출력
     *
     * @Method : printWinStatistic6()
     */
    public void printWinStatistic6(int count){
        System.out.print(OutputMessage.WIN_STATISTIC_6.getMessage() + count + OutputMessage.WIN_STATISTIC_COUNT.getMessage());
    }

    /**
     * Description : 수익률 메세지 출력
     *
     * @Method : printWinStatistic6()
     */
    public void printTotalProfit(int Profit){
        System.out.print(OutputMessage.TOTAL_PROFIT_1.getMessage() + Profit + OutputMessage.TOTAL_PROFIT_2.getMessage());
    }

}
