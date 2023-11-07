package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Winner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageManager {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    public static final String ADD_COIN = "구입금액을 입력해 주세요.";
    public static final String BUY_LOTTOS = "개를 구매했습니다.";
    public static final String SET_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String SET_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String SHOW_RESULT = "당첨 통계\n---";

    public static final String ERROR_IS_NOT_NUMBER = "[ERROR] 숫자로 입력해야 합니다.";
    public static final String ERROR_IS_NOT_1000_UNIT = "[ERROR] 금액은 1,000원 단위로만 입력해야 합니다.";
    public static final String ERROR_IS_ALREADY_CONTAIN = "[ERROR] 중복된 숫자가 존재합니다.";
    public static final String ERROR_IS_NOT_CORRECT_SIZE = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    public static final String ERROR_OUT_OF_RANGE = "[ERROR] 1~45 사이의 숫자만 입력 가능합니다.";
    public static final String ERROR_IS_NOT_POSITIVE = "[ERROR] 양수로 입력해야 합니다.";

    public final static ArrayList<Winner> WINNER_TYPE = new ArrayList<>(Arrays.asList(
            Winner.FIRST_PLACE,
            Winner.SECOND_PLACE,
            Winner.THIRD_PLACE,
            Winner.FOURTH_PLACE,
            Winner.FIFTH_PLACE));

    public void showLottos(List<Lotto> lottos){
        for(Lotto lotto: lottos){
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public void showWinningResult(ArrayList<Integer> winningCount){
        for(int i = 4; i >-1; i--){
            System.out.println(WINNER_TYPE.get(i).getMessage() + " - " + winningCount.get(i) + "개");
        }
    }

    public void showRateMoney(String rate){
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
