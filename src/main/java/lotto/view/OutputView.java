package lotto.view;

import java.util.List;

public class OutputView {

    public void printLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void getInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void getInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void getInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
