package lotto.view.output;

public class LottoOutputView {
    public void printLotto(String lotto) {
        System.out.print(lotto);
    }

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printTotalYield(double yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
