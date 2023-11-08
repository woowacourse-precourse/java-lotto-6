package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String INPUT_HOW_MUCH_TO_BUY_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String HOW_MANY_BOUGHT_ANNOUNCE_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_WINNER_NUMBERS_GUIDE_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_GUIDE_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_ANNOUNCE_INTRO_MESSAGE = "당첨 통계\n---";
    private static final List<String> RANK_MESSAGE_LIST = Arrays.asList("3개 일치 (5,000원) - ", "4개 일치 (50,000원) - ", "5개 일치 (1,500,000원) - ", "5개 일치, 보너스 볼 일치 (30,000,000원) - ", "6개 일치 (2,000,000,000원) - ");
    private static final List<Rank> RANK_LIST = Arrays.asList(Rank.FIFTH,Rank.FORTH,Rank.THIRD,Rank.SECOND,Rank.FIRST);
    private static final Integer RANK_TYPES = 5;
    private static final String RETURN_RATE_ANNOUNCE_MESSAGE_HEAD = "총 수익률은 ";
    private static final String RETURN_RATE_ANNOUNCE_MESSAGE_TAIL = "%입니다.";
    private static final String UNIT_STRING = "개";
    private static final String DOT = ".";

    public void printInputHowMuchToBuyGuideMessage(){
        System.out.println(INPUT_HOW_MUCH_TO_BUY_GUIDE_MESSAGE);
    }

    public void printAllLottoNumbers(Long amountOfLottoPapers, List<Lotto> lottoList){
        System.out.println(amountOfLottoPapers + HOW_MANY_BOUGHT_ANNOUNCE_MESSAGE);
        for (Lotto lotto : lottoList){
            System.out.println(lotto.getNumbers());
        }
    }

    public void printInputWinnerNumbersGuideMessage(){
        System.out.println(INPUT_WINNER_NUMBERS_GUIDE_MESSAGE);
    }

    public void printInputBonusNumberGuideMessage(){
        System.out.println(INPUT_BONUS_NUMBER_GUIDE_MESSAGE);
    }

    public void printStatistics(Map<Rank,Integer> rankMap, Double percentage){
        System.out.println(STATISTICS_ANNOUNCE_INTRO_MESSAGE);
        //5,4,3,2,1등 result 출력
        for (int i = 0 ; i < RANK_TYPES; i++){
            System.out.println(RANK_MESSAGE_LIST.get(i) + rankMap.get(RANK_LIST.get(i)) + UNIT_STRING + DOT);
        }
        System.out.println(RETURN_RATE_ANNOUNCE_MESSAGE_HEAD + percentage + RETURN_RATE_ANNOUNCE_MESSAGE_TAIL);
    }
}
