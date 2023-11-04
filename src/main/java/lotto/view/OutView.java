package lotto.view;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

public class OutView {

    private static final String WINNING_STATIC_MESSAGE = "당첨 통계";
    private static final String CONTOUR = "---";
    private static final String FIFTH_MESSAGE = "3개 일치 (5,000원) - " ;
    private static final String FOURTH_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String THIRD_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIRST_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";


    public static void printTickekQuantity(int ticketQuantity) {
        System.out.println("\n"+ticketQuantity+"개를 구매했습니다.");
    }

    public static void printConsumerLottos(ArrayList<Lotto> lottos) {
        for(Lotto lotto : lottos){
            List<String> numbers = lotto.getNumbers()
                    .stream().map(String::valueOf)
                    .collect(Collectors.toList());
            String lottoNumbers = String.join(", ", numbers);
            System.out.println("["+lottoNumbers+"]");
        }

    }

    public static void printResult(Map<Ranking, Integer> result, int ticketQuantity) {
        System.out.println("\n"+WINNING_STATIC_MESSAGE);
        System.out.println(CONTOUR);
        printEachRankingResult(result);
    }

    private static void printEachRankingResult(Map<Ranking, Integer> result) {
        System.out.println(FIFTH_MESSAGE+result.get(Ranking.Fifth).intValue()+"개");
        System.out.println(FOURTH_MESSAGE+result.get(Ranking.fourth).intValue()+"개");
        System.out.println(THIRD_MESSAGE+result.get(Ranking.Third).intValue()+"개");
        System.out.println(SECOND_MESSAGE+result.get(Ranking.Second).intValue()+"개");
        System.out.println(FIRST_MESSAGE+result.get(Ranking.First).intValue()+"개");
    }

    public static void printRateOfReturn(float rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE,rateOfReturn);
    }
}
