package lotto;

public class LottoGame {
    private final UserInterface userInterface = new UserInterface();

    // 로또 게임 진행 시작
    public void start() {
        getLottoAmount();
    }

    // 구입금액 입력
    private void getLottoAmount() {
        while (true) {
            try {
                userInterface.showText("구입금액을 입력해 주세요.");
                String amount = userInterface.getUserInput();
                // 구입금액 입력 로직 구현
            } catch (IllegalArgumentException e) {
                userInterface.showText(e.getMessage());
                continue;
            }
            break;
        }
    }
}
