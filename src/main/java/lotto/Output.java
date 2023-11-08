package lotto;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class Output {

    static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    static final String LOTTO_PURCHASE_AMOUNT_ERROR_MESSAGE = "구매 금액은 1000원 단위로 입력해주세요.";
    static final String LOTTO_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    static final String LOTTO_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String LOTTO_WINNING_NUMBERS_ERROR_MESSAGE = "1 ~ 45 사이의 중복되지 않는 숫자 6개를 입력해주세요.";
    static final String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    static final String LOTTO_BONUS_NUMBER_ERROR_MESSAGE = "1 ~ 45 사이의 당첨 번호와 중복되지 않는 숫자 1개를 입력해주세요.";

    public void printLottoPurchaseCountMessage(int count){
        System.out.println(count + LOTTO_PURCHASE_COUNT_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos){
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printResult(HashMap<Ranking, Integer> result, Double profit){
        DecimalFormat decimalFormat = new DecimalFormat("#,###.0");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault(Ranking.FIFTH,0) +"개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault(Ranking.FOURTH,0) +"개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault(Ranking.THIRD,0) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault(Ranking.SECOND,0) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault(Ranking.FIRST,0) +"개");
        System.out.println("총 수익률은 "+ decimalFormat.format(profit) +"%입니다.");

    }
}
