package view;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Place;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static int outputNumberOfLotto(int purchasePrice){
        int numberOfLotto = purchasePrice/1000;
        System.out.println("\n"+numberOfLotto+PURCHASE_MESSAGE);
        return numberOfLotto;
    }
    public static List<List<Integer>> outputLottos(int numberOfLotto){
        List<List<Integer>> lottos = new ArrayList<>(numberOfLotto);

        for(int i=0; i<numberOfLotto; i++){
            List<Integer> lotto;
            lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(lotto);

            outputMessageLotto(lotto);
        }

        return lottos;
    }

    private static void outputMessageLotto(List<Integer> lotto) {
        List<String> lottoForOutput = lotto.stream()
                .map(Object::toString)
                .toList();

        String message = String.format("[%s]",String.join(", ",  lottoForOutput));
        System.out.println(message);
    }

    public static Long outputStatics(Map<Place,Integer> numberOfWins){
        System.out.println(STATISTICS_MESSAGE);

        Place[] places = Place.values();

        for(int i=0; i<CORRECT_MESSAGE.length; i++){
            System.out.println(CORRECT_MESSAGE[i]+numberOfWins.get(places[i])+NUMBER_OF_COUNT);
        }

        Long profit = getProfit(numberOfWins, places);

        return profit;
    }

    private static Long getProfit(Map<Place, Integer> numberOfWins, Place[] places) {
        Long[] winningPrice = {5000L,50000L,1500000L,30000000L,2000000000L};
        Long profit = 0L;
        for(int i=0; i< winningPrice.length; i++){
            profit += winningPrice[i] * numberOfWins.get(places[i]);
        }
        return profit;
    }

    public static void outputRate(int purchasePrice, Long profit){
        double rate = ((double) profit / purchasePrice) * 100;
        BigDecimal bd = new BigDecimal(rate);
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        double roundedRate = bd.doubleValue();

        System.out.println(RATE_MESSAGE+ roundedRate +END_LINE_OF_RATE);
    }
}
