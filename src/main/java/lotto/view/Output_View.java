package lotto.view;

public class Output_View {
    public static void print_ticket_counts(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void print_winning_stat_message(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void print_winning_stat_prize(String prize_message,int prize_amount){
        System.out.println(prize_message + prize_amount + "개" );
    }

    public static void print_earning_rate(double earning_rate){
        System.out.println("총 수익률은 " + String.format("%,.1f",earning_rate) + "%입니다.");
    }
}
