package lotto;

public class LottoGame {
    private final UserInterface userInterface = new UserInterface();
    private UserLottos userLottos;

    // 로또 게임 진행 시작
    public void start() {
        int amount = getLottoAmount();
        UserLottos userLottos = new UserLottos(amount);
        showLottos(userLottos);
    }

    // 구입금액 입력
    private int getLottoAmount() {
        String amount = "";
        while (true) {
            try {
                userInterface.showText("구입금액을 입력해 주세요.");
                amount = userInterface.getUserInput();
                Validator.validateAmount(amount);
            } catch (IllegalArgumentException e) {
                userInterface.showText(e.getMessage());
                continue;
            }
            userInterface.newLine();
            return Integer.parseInt(amount);
        }
    }

    // 발행한 로또 수량 및 번호 출력
    private void showLottos(UserLottos userLottos) {
        userInterface.showText(userLottos.getSize() + "개를 구매했습니다.");
        userInterface.showText(userLottos.getLottosString() + "\n");
    }
}
