package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Output {
    private static final String MESSAGE_ONLY_NUMBER = "[ERROR] 공백이 없는 숫자만 입력 가능합니다.";
    public static final String ERROR_MONEY_NIN_NUMBER = "[ERROR] 최소 입력 금액은 1000원 입니다.";
    public static final String ERROR_MONEY_UNIT = "[ERROR] 1000의 배수값만 입력 가능합니다.";


    public static void printErrorMessage(String error) {
        System.out.println("[ERROR] " + error);
    }

    public static void printPurchasedLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printPurchasedLottoList(List<Integer> lotto) {
        Collections.sort(lotto);
        System.out.println(lotto);

    }

    public static void printResultRanking(double earningRate){
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate)+"%입니다.");

    }
    public static void printEarningRate(int  matchCount,int prizeMoney,int matchedResult){
        String matchCountText = matchCount+"개 일치";
        String prizeMoneyFormatted = String.format("%,d", prizeMoney);

        if(prizeMoney == Rank.SECOND.getPrizeMoney()){
            matchCountText += ", 보너스 볼 일치";
        }
        System.out.println(matchCountText + " (" + prizeMoneyFormatted + "원) - " + matchedResult + "개");

    }





}
