package lotto;

public class OutputView {
    public static void printNumberOfLotto(int numberOfLotto){
        String format=String.format("%d개를 구입하였습니다.", numberOfLotto);
        System.out.println(format);
    }
}
