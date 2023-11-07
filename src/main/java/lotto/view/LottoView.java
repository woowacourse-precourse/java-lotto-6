package lotto.view;


import java.util.Arrays;

public class LottoView {
    public void printEnterLottosCount() {
        System.out.print("구입금액을 입력해주세요.");
        this.newLine();
    }

    public void printBuyedLottosCount(int count) {
        System.out.print(count + "개를 구매했습니다.");
        this.newLine();
    }

    public void printLottoNumbers(int[] lottoNumbers) {
        System.out.print(Arrays.toString(lottoNumbers));
        this.newLine();
    }

    public void printEnterLottoWinningNumbers() {
        System.out.print("당첨 번호를 입력해 주세요.");
        this.newLine();
    }

    public void printEnterBonusNumber() {
        System.out.print("보너스 번호를 입력해 주세요.");
        this.newLine();
    }

    public void printDrawSummaryTitle() {
        System.out.print("당첨 통계");
        this.newLine();
        System.out.print("---");
        this.newLine();
    }



    public void newLine() {
        System.out.println();
    }
}
