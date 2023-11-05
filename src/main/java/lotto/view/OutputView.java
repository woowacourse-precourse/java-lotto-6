package lotto.view;

public class OutputView {
    public void printLottoNumbers(){
        System.out.println("개를 구매했습니다.");
    }

    public void printLottoStatistics(){
        System.out.println("당첨통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - ");
        System.out.println("4개 일치 (50,000원) - ");
        System.out.println("5개 일치 (1,500,000원) - ");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        System.out.println("6개 일치 (2,000,000,000원) - ");

        System.out.println("총 수익률은 입니다.");
    }
}
