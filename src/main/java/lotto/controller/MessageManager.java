package lotto.controller;

import lotto.Winner;

import java.text.DecimalFormat;
import java.util.EnumMap;

public class MessageManager {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    public static final String ADD_COIN = "구입금액을 입력해 주세요.";
    public static final String BUY_LOTTOS = "개를 구매했습니다.";
    public static final String SET_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String SET_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String ERROR_IS_NOT_NUMBER = "[ERROR] 숫자로 입력해야 합니다.";
    public static final String ERROR_IS_NOT_1000_UNIT = "[ERROR] 금액은 1,000원 단위로만 입력해야 합니다.";
    public static final String ERROR_IS_ALREADY_CONTAIN = "[ERROR] 중복된 숫자가 존재합니다.";
    public static final String ERROR_IS_NOT_CORRECT_SIZE = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    public static final String ERROR_OUT_OF_RANGE = "[ERROR] 1~45 사이의 숫자만 입력 가능합니다.";

    public void showResult(EnumMap<Winner, Integer> winnersResult){
        for(Winner winner: Winner.values()){
            if(winner.getMatch() == -5){
                System.out.println("5개 일치, 보너스 볼 일치 ("+decimalFormat(winner.getPrize())+"원) - " + winnersResult.get(winner).toString()
                + "개");
            }else{
                System.out.println(winner.getMatch() +"개 일치 ("+decimalFormat(winner.getPrize())+"원) - " + winnersResult.get(winner).toString()
                        + "개");
            }
        }
    }

    public String decimalFormat(int amount){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(amount);
    }
}
