package lotto.View;

public class OuputView {
    public static final String printTickets = "%d개를 구매했습니다.";

    public static void printNumOfTicket(int num) {
        System.out.printf((printTickets) + "%n", num);
    }
    public static void resultPrint() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    public static void printErrorMessage(String error){
        System.out.println(error);
    }
}

