package lotto;

public class OutputView {
     static final String PURCHASE_QUANTITY_PRINT_MESSAGE = "개를 구매했습니다.";
     static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
     static final String MATCHES_THREE_NUMBER_MESSAGE = "3개 일치 (5,000원) - ";
     static final String MATCHES_FOUR_NUMBER_MESSAGE = "4개 일치 (50,000원) - ";
     static final String MATCHES_FIVE_NUMBER_MESSAGE = "5개 일치 (1,500,000원) - ";
     static final String MATCHES_FIVE_AND_BONUS_NUMBER_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
     static final String MATCHES_SIX_NUMBER_MESSAGE = "6개 일치 (2,000,000,000원) - ";


     public static void printPurchaseQuantity(int quantity) {
          System.out.println(quantity + PURCHASE_QUANTITY_PRINT_MESSAGE);
     }

     public static void printMatchesThreeNumber(int matchedNumber) {
          System.out.println(MATCHES_THREE_NUMBER_MESSAGE + matchedNumber + "개");
     }

     public static void printMatchesFourNumber(int matchedNumber) {
          System.out.println(MATCHES_FOUR_NUMBER_MESSAGE + matchedNumber + "개");
     }

     public static void printMatchesFiveNumber(int matchedNumber) {
          System.out.println(MATCHES_FIVE_NUMBER_MESSAGE + matchedNumber + "개");
     }

     public static void printMatchesFiveAndBonusNumber(int matchedNumber) {
          System.out.println(MATCHES_FIVE_AND_BONUS_NUMBER_MESSAGE + matchedNumber + "개");
     }

     public static void printMatchesSixNumber(int matchedNumber) {
          System.out.println(MATCHES_SIX_NUMBER_MESSAGE + matchedNumber + "개");
     }

     public static void printProfitRate(float profitRate) {
          System.out.println("총 수익률은 " + profitRate + "%입니다.");
     }

     public static void printResults() {
          System.out.println(WINNING_STATISTICS_MESSAGE);
          System.out.println("---");
     }
}
