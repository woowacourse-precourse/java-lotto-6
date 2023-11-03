package lotto.view;

public class Output {
    private static final String Input_Purchase_Amount = "구입금액을 입력해 주세요.";
    private static final String Count_Lotto = "개를 구매했습니다";
    private static final String Input_Winning_Number = "당첨 번호를 입력해 주세요.";
    private static final String Input_Bonus_Number = "보너스 번호를 입력해 주세요.";
    private static final String Print_statistics = "당첨 통계";

    public static void input_Purchase_Amount(int count) {
        System.out.println(count + Count_Lotto);
    }

    public static void input_Winning_Number() {
        System.out.println(Input_Winning_Number);
    }

    public static void input_Bonus_Number() {
        System.out.println(Input_Bonus_Number);
    }

    public static void statistics() {
        System.out.println(Print_statistics);
        System.out.println("---");
    }

    public static void result_match(int matchCount) {
        System.out.println(matchCount + "개");
    }

    public static void total_return(double rate) {
        System.out.println("총 수익률은 " + String.valueOf(rate) + "%입니다.");
    }
}
