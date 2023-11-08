package service;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.WinningStatus;

public class PrintService {
    private static final String BUY_MESSAGE  = "개를 구매했습니다.";
    private static final String ERROR = "[ERROR] ";

    public void requestUserInputMessage(String requestMessage){
        System.out.println(requestMessage);
    }
    public void errorMessage(String errorMessage) {
        System.out.println(ERROR + errorMessage);
    }


    public void printAmount(int amount){
        System.out.println(amount + BUY_MESSAGE);
    }

    public void printLottoList(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public void printWinningStatistics(Map<WinningStatus, Integer> statistics){
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Map.Entry<WinningStatus, Integer> entry : statistics.entrySet()) {
            WinningStatus status = entry.getKey();
            Integer count = entry.getValue();
            if(status.name().equals("bonus")){
                System.out.println(
                        status.getMatchNumberInfo() + "개 일치, 보너스 볼 일치" + status.getWinningMoney() + " - " + count + "개");

            }
            if(!status.name().equals("bonus")) {
                System.out.println(
                        status.getMatchNumberInfo() + "개 일치 " + status.getWinningMoney() + " - " + count + "개");
            }
        }
    }

    public void printWinningAmount(double winningAmount){
        System.out.println("총 수익률은 " + Math.round(winningAmount*100)/100.0);
    }


}
