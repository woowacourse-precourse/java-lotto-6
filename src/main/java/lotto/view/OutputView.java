package lotto.view;

public class OutputView {

    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }


    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printBeforeInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
