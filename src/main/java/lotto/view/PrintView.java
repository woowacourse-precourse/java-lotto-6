package lotto.view;

import lotto.domain.Lottos;

public class PrintView {

    private void newLine() {
        System.out.println();
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printNumberOfLottos(int purchaseMoney) {
        int lottoNumber = purchaseMoney / 1000;
        newLine();
        System.out.printf("%d개를 구매했습니다", lottoNumber);
        newLine();
    }

    public void printLottoNumbers(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        newLine();
    }
}
