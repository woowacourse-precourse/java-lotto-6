package lotto.View;

import static lotto.View.OutputMessage.Enter_Bonus_Numbers;
import static lotto.View.OutputMessage.Enter_Lotto_Numbers;
import static lotto.View.OutputMessage.Enter_Purchase_Mount;
import static lotto.View.OutputMessage.TOTAL_PRIZE_TITLE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Model.Prize;
import lotto.Model.ScoreBoard;
import lotto.Model.LottoData;

public class Output {
    private static final String DIVIDE_POINT =", ";
    private static final String START_PRINT_POINT ="[";
    private static final String END_PRINT_POINT ="]";
    public static void printLottos(ArrayList<LottoData> lottos){

        System.out.printf(OutputMessage.PURCHASE_COUNT.getMessage(),lottos.size());

        lottos.stream()
                .map(LottoData::getNumbers)
                .forEach(Output::printLotto);
        System.out.println();
    }

    public static void printScores(ScoreBoard roundScore){
            System.out.println(OutputMessage.TOTAL_PRIZE_TITLE.getMessage());

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
        System.out.printf(OutputMessage.TOTAL_EARN_RATE.getMessage(),earnRate);
    }
    private static void printScore(Prize prize,Integer prizeCount){
        if(prize == Prize.NO_RANK){
            return;
        }
        if(prize != Prize.SECOND){
            System.out.printf(OutputMessage.TOTAL_PRIZE_COUNT.getMessage(), prize.getMatchCount(), prize.getReward(), prizeCount);
            return;
        }
        System.out.printf(OutputMessage.TOTAL_BONUS_COUNT.getMessage(), prize.getMatchCount(), prize.getReward(), prizeCount);

}
    public static void printInsertBonusNumber(){
        System.out.println();
        System.out.println(Enter_Bonus_Numbers.message);
    }

    private static void printLotto(List<Integer> lotto) {
        List<Integer> sortedNumbers = sortedNumbers(lotto);
        String formattedLotto = splitNumbersWithDelimiter(sortedNumbers,DIVIDE_POINT);
        System.out.println(START_PRINT_POINT+formattedLotto+END_PRINT_POINT);
    }

    private static String splitNumbersWithDelimiter(List<Integer> numbers, String Delimiter){
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(Delimiter));
    }

    private static List<Integer> sortedNumbers(List<Integer> numbers){
        return numbers.stream()
                .sorted()
                .toList();
    }

}
