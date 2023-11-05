package lotto;

import java.util.List;

public class LottoView {

    public void printGap() {
        System.out.println();
    }

    public void userCountInputAnnouncement() {
        printGap();
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoNumberAnnouncement(int numberOfLotto) {
        printGap();
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    public void printLottoNumber(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage + " 다시 입력해주세요.");
    }
}
