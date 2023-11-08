package lotto.view;

import static lotto.constant.OutputMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.OutputMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.constant.OutputMessage.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.List;
import lotto.constant.WinningRanking;
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

    public void printIssuedLotto(List<List<Integer>> lottos){
        breakLine();
        println(lottos.size() + "개를 구매했습니다.");
        for (List<Integer> lotto : lottos) {
            println(lotto.toString());
        }
    }

    public void printWinningStatistics(LottoGameResultDto resultDto){
        breakLine();
        println("당첨 통계");
        println("---");
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
            .append(numberFormatting(winningRanking.getWinnings()))
            .append(") - ");
        return sb.toString();
    }

    private String numberFormatting(int num){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(num);
    }

    private void printRateOfReturn(double rateOfReturn) {
        double format = Math.round(rateOfReturn * 10.0) / 10.0;
        println("총 수익률은 " + format + "%입니다." );
    }

    private WinningRanking getWinningInfo(int ranking) {
        for(WinningRanking winningRanking : WinningRanking.values()){
            if(winningRanking.getRanking() == ranking){
                return winningRanking;
            }
        }
        return null;
    }

    public void println(String input){
        System.out.println(input);
    }

    public void close(){
        Console.close();
    }

    private void breakLine(){
        System.out.println();
    }

}
