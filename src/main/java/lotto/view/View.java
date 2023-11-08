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
        println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber(){
        println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    public void printIssuedLotto(List<Lotto> lottos){
        println(lottos.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            println(lotto.toString());
        }
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
}
