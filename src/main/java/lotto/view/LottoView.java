package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.MatchRanking;

public class LottoView {
    public static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String NUMBER_OF_BUYS_MESSAGE = "\n%d개를 구매했습니다.";
    public static final String EACH_LOTTO = "[%s]";
    public static final String COMMA_DELIMITER = ", ";
    public static final String INPUT_MATCH_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    public static final String MATCH_RESULT_MESSAGE = "\n당첨 통계\n---";
    public static final String MATCH_STATISTICS_MESSAGE = "3개 일치 (5,000원) - %d개\n"
            + "4개 일치 (50,000원) - %d개\n" + "5개 일치 (1,500,000원) - %d개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
            + "6개 일치 (2,000,000,000원) - %d개";
    public static final String TOTAL_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void startMessage(){
        System.out.println(START_MESSAGE);
    }
    public void buyMessage(Integer numberOfBuys){
        System.out.printf(NUMBER_OF_BUYS_MESSAGE,numberOfBuys);
    }
    public void lottosMessage(Lottos lottos){
        for (Lotto lotto : lottos.getLottos()) {
            eachLottoMessage(lotto.getNumbers());
        }
    }
    public void eachLottoMessage(List<Integer> numbers){
        String lottoMessage = String.join(COMMA_DELIMITER,numbers.stream()
                .map(number -> String.format("%d", number))
                .toArray(String[]::new));
        System.out.println(String.format(EACH_LOTTO,lottoMessage));
    }
    public void inputMatchNumberMessage(){
        System.out.println(INPUT_MATCH_NUMBER_MESSAGE);
    }
    public void inputBonusNumberMessage(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }
    public void matchResultMessage(){
        System.out.println(MATCH_RESULT_MESSAGE);
    }

    public void matchStatisticsMessage(Map<MatchRanking, Integer> rankingCount){
        int fifth = rankingCount.get(MatchRanking.FIFTH_PLACE);
        int fourth = rankingCount.get(MatchRanking.FOURTH_PLACE);
        int third = rankingCount.get(MatchRanking.THIRD_PLACE);
        int second = rankingCount.get(MatchRanking.SECOND_PLACE);
        int first = rankingCount.get(MatchRanking.FIRST_PLACE);

        System.out.println(String.format(MATCH_STATISTICS_MESSAGE, fifth,fourth,third,second,first));
    }
    public void totalReturnMessage(Double findReturn){
        System.out.println(String.format(TOTAL_RETURN_MESSAGE,findReturn));
    }

    public void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }
}
