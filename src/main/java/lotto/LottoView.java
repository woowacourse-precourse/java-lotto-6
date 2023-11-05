package lotto;

public class LottoView {
    public void userCountInputAnnouncement() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage + " 다시 입력해주세요.");
    }
}
