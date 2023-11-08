package lotto.View;

import static lotto.View.OutputMessage.Enter_Bonus_Numbers;
import static lotto.View.OutputMessage.Enter_Lotto_Numbers;
import static lotto.View.OutputMessage.Enter_Purchase_Mount;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFormattedTextField;
import lotto.Controller.ErrorMessage;
import lotto.Model.Prize;
import lotto.Model.ScoreBoard;
import lotto.Model.VO.LottoData;

public class Output {
    public static void printLottos(ArrayList<LottoData> lottos){
        System.out.println();
        System.out.printf("%d개를 구매했습니다.",lottos.size());
        System.out.println();
        lottos.stream()
                .map(LottoData::getNumbers)
                .forEach(Output::printLotto);
        System.out.println();
    }

    public static void printScores(ScoreBoard roundScore){
            System.out.println();
            System.out.println("당첨 통계");
            System.out.println("---");

            for (Prize prize : Prize.values()) {
                int prizeCount = roundScore.getScoreByRank(prize);
                printScore(prize,prizeCount);
            }
    }


    public static void printError(String errorMessage){
        System.out.println(errorMessage);
    }


    public static void printInsertLottoNumbers(){System.out.println(Enter_Lotto_Numbers.message);}

    public static void printEnterPurchaseMount(){
        System.out.println(Enter_Purchase_Mount.message);
    }

    public static void printEarnRate(Double earnRate){
        System.out.printf("총 수익률은 %.1f%%입니다.",earnRate);
    }
    private static void printScore(Prize prize,Integer prizeCount){
        if(prize == Prize.NO_RANK){
            return;
        }
        if(prize != Prize.SECOND){
            System.out.printf("%d개 일치 (%,d원) - %d개%n", prize.getMatchCount(), prize.getReward(), prizeCount);
            return;
        }
        System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", prize.getMatchCount(), prize.getReward(), prizeCount);

}
    public static void printInsertBonusNumber(){
        System.out.println();
        System.out.println(Enter_Bonus_Numbers.message);
    }

    private static void printLotto(List<Integer> lotto) {
        List<Integer> sortedNumbers = lotto.stream()
                .sorted()
                .toList();

        String formattedLotto = sortedNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(formattedLotto);
    }


}
