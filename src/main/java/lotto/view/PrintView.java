package lotto.view;

public class PrintView {

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printNumberOfLottos(int purchaseMoney) {
        int lottoNumber = purchaseMoney / 1000;
        System.out.printf("%d개를 구매했습니다", lottoNumber);
    }
}
