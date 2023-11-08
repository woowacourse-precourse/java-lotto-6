package view;

import domain.Place;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String PURCHASE_MESSAGE =
            "개를 구매했습니다.";

    public static final String STATISTICS_MESSAGE =
            "\n당첨 통계\n---\n";

    public static final String[] CORRECT_MESSAGE = {
            "3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "6개 일치 (2,000,000,000원) - "
    };
    public static final String NUMBER_OF_COUNT = "개";
    public static final String RATE_MESSAGE =
            "총 수익률은 ";
    public static final String END_LINE_OF_RATE =
            "%입니다.";


    public static void outputNumberOfLotto(int numberOfLotto){
        System.out.println("\n"+numberOfLotto+PURCHASE_MESSAGE);
    }

    public static void outputLottos(List<List<Integer>> lottos){

        for(List<Integer> lotto : lottos){
            List<String> lottoForOutput = lotto.stream()
                    .map(Object::toString)
                    .toList();

            String message = String.format("[%s]",String.join(", ",  lottoForOutput));
            System.out.println(message);
        }
    }


    public static void outputStatics(Map<Place,Integer> numberOfWins){
        System.out.println(STATISTICS_MESSAGE);

        Place[] places = Place.values();

        for(int i=0; i<CORRECT_MESSAGE.length; i++){
            System.out.println(CORRECT_MESSAGE[i]+numberOfWins.get(places[i])+NUMBER_OF_COUNT);
        }

    }


    public static void outputRate(double rate){

        System.out.println(RATE_MESSAGE+ rate +END_LINE_OF_RATE);
    }
}
