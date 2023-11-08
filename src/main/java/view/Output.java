package view;

public class Output {
    //output 관련 메세지를 출력하는 뷰

    public static void printCount(int purchase) {
        System.out.println("");
        System.out.println(purchase + "개를 구매했습니다.");
    }

    public static void printResult() {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
