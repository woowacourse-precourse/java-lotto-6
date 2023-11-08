package lotto.view;

import static lotto.constant.OutputMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.OutputMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.constant.OutputMessage.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constant.WinningRanking;
import lotto.domain.Lotto;
import lotto.dto.ResponseDto.LottoGameResultDto;

public class View {

    public String inputPurchaseAmount(){
        println(INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String inputWinningNumber(){
        breakLine();
        println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber(){
        breakLine();
        println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    public void printMessagePurchase(int count){
        breakLine();
        println(count + "개를 구매했습니다.");

    }

    public void printWinningStatistics(LottoGameResultDto resultDto){
        for (int ranking = 5; ranking >= 1; ranking--) {
            WinningRanking winningRanking = getWinningInfo(ranking);
            String output = getWinningInfoOutput(winningRanking)
                + resultDto.getCountWinning()[ranking] + "개";
            println(output);
        }
        printRateOfReturn(resultDto.getRateOfReturn());

    }

    private String getWinningInfoOutput(WinningRanking winningRanking) {
        StringBuilder sb = new StringBuilder();
        sb.append(winningRanking.getMatchNumCnt())
            .append("개 일치 ")
            .append("(")
            .append(winningRanking.getWinnings())
            .append(") - ");
        return sb.toString();
    }

    private void printRateOfReturn(double rateOfReturn) {
        println("총 수익률은 " + rateOfReturn + "%입니다." );
    }

    private WinningRanking getWinningInfo(int ranking) {
        for(WinningRanking winningRanking : WinningRanking.values()){
            if(winningRanking.getRanking() == ranking){
                return winningRanking;
            }
        }
        return null;
    }

    private void println(String input){
        System.out.println(input);
    }

    private void breakLine(){
        System.out.println();
    }
}
