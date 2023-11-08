/**
 * @Package_name : view
 * @Class_name : OutputView
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package view;

import java.util.List;
import java.util.Map;
import model.enums.LottoWinResults;

public class OutputView {

    /**
     * Description : 구입 금액 입력 메세지 출력
     *
     * @Method : ()
     */
    public void printLottoBuy() {
        System.out.print(OutputMessage.LOTTO_BUY_MONEY.getMessage());
    }

    /**
     * Description : 로또 구입 개수 메세지 출력
     *
     * @Method : printLottoBuyComplete()
     */
    public void printLottoBuyComplete(int lottoTicketCount) {
        System.out.printf(lottoTicketCount + OutputMessage.LOTTO_BUY_COMPLETE.getMessage());
    }

    /**
     * Description : 로또 번호 묶음 메세지 오름차순 출력
     *
     * @Method : printLottoNums()
     */
    public void printLottoNums(List<Integer> LottoNums) {
        System.out.println(LottoNums);
    }

    /**
     * Description : 당청 번호 요청 메세지 출력
     *
     * @Method : printLottoNumRequest()
     */
    public void printLottoNumRequest() {
        System.out.print(OutputMessage.LOTTO_NUM_REQUEST.getMessage());
    }

    /**
     * Description : 보너스 번호 요청 메세지 출력
     *
     * @Method : printBonusNumRequest()
     */
    public void printBonusNumRequest() {
        System.out.print(OutputMessage.BONUS_NUM_REQUEST.getMessage());
    }

    /**
     * Description : 당첨 통계 메세지 출력
     *
     * @Method : printWinStatistic()
     */
    public void printWinStatistic(Map<String, Integer> winResults) {
        printWinStatisticTitle();
        printWinStatistic3(winResults.get(LottoWinResults.LOTTO_3SAME.getMessage()));
        printWinStatistic4(winResults.get(LottoWinResults.LOTTO_4SAME.getMessage()));
        printWinStatistic5(winResults.get(LottoWinResults.LOTTO_5SAME.getMessage()));
        printWinStatistic5Bonus(winResults.get(LottoWinResults.LOTTO_5SAME_BONUS.getMessage()));
        printWinStatistic6(winResults.get(LottoWinResults.LOTTO_6SAME.getMessage()));
    }

    /**
     * Description : 당첨 통계 타이틀 메세지 출력
     *
     * @Method : printWinStatisticTitle()
     */
    public void printWinStatisticTitle() {
        System.out.print(OutputMessage.WIN_STATISTIC.getMessage());
    }

    /**
     * Description : 당첨 통계 3개 일치 메세지 출력
     *
     * @Method : printWinStatistic3()
     */
    public void printWinStatistic3(int count) {
        System.out.print(
                OutputMessage.WIN_STATISTIC_3.getMessage() + count + OutputMessage.WIN_STATISTIC_COUNT.getMessage());
    }

    /**
     * Description : 당첨 통계 4개 일치 메세지 출력
     *
     * @Method : printWinStatistic4()
     */
    public void printWinStatistic4(int count) {
        System.out.print(
                OutputMessage.WIN_STATISTIC_4.getMessage() + count + OutputMessage.WIN_STATISTIC_COUNT.getMessage());
    }

    /**
     * Description : 당첨 통계 5개 일치 메세지 출력
     *
     * @Method : printWinStatistic5()
     */
    public void printWinStatistic5(int count) {
        System.out.print(
                OutputMessage.WIN_STATISTIC_5.getMessage() + count + OutputMessage.WIN_STATISTIC_COUNT.getMessage());
    }

    /**
     * Description : 당첨 통계 5개,보너스 일치 메세지 출력
     *
     * @Method : printWinStatistic4()
     */
    public void printWinStatistic5Bonus(int count) {
        System.out.print(OutputMessage.WIN_STATISTIC_5_BONUS.getMessage() + count
                + OutputMessage.WIN_STATISTIC_COUNT.getMessage());
    }

    /**
     * Description : 당첨 통계 6개 일치 메세지 출력
     *
     * @Method : printWinStatistic6()
     */
    public void printWinStatistic6(int count) {
        System.out.print(
                OutputMessage.WIN_STATISTIC_6.getMessage() + count + OutputMessage.WIN_STATISTIC_COUNT.getMessage());
    }

    /**
     * Description : 수익률 메세지 출력
     *
     * @Method : printWinStatistic6()
     */
    public void printTotalProfit(double Profit) {
        System.out.print(
                OutputMessage.TOTAL_PROFIT_1.getMessage() + Profit + OutputMessage.TOTAL_PROFIT_2.getMessage());
    }

    /**
     * Description : 줄바꿈 출력
     *
     * @Method : printWinStatistic6()
     */
    public void printNextLine() {
        System.out.print(OutputMessage.NEXT_LINE.getMessage());
    }

}
