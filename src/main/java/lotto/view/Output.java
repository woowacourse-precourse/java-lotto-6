package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class Output {
    private static final String MESSAGE_ONLY_NUMBER = "[ERROR] 공백이 없는 숫자만 입력 가능합니다.";
    public static final String ERROR_MONEY_NIN_NUMBER = "[ERROR] 최소 입력 금액은 1000원 입니다.";
    public static final String ERROR_MONEY_UNIT = "[ERROR] 1000의 배수값만 입력 가능합니다.";

   public static void printErrorMessage(String error){
       System.out.println("[ERROR] " + error);

   }

   public static void printPurchasedLottoCount(int count){
       System.out.println(count+"개를 구매했습니다.");
   }

   public static void printPurchasedLottoList(List<Integer> lotto){
       System.out.println(lotto);

   }
}
