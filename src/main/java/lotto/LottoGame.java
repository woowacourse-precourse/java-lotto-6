package lotto;

import java.util.Arrays;

import static lotto.Validator.*;

public class LottoGame {
    private final UserInterface userInterface = new UserInterface();
    private WinLotto winLotto;
    private UserLottos userLottos;

    // 로또 게임 진행 시작
    public void start() {
        int amount = getLottoAmount();
        UserLottos userLottos = new UserLottos(amount);
        showLottos(userLottos);
        winLotto = getWinLotto();
    }

    // 구입금액 입력
    private int getLottoAmount() {
        String amount = "";
        while (true) {
            try {
                userInterface.showText("구입금액을 입력해 주세요.");
                amount = userInterface.getUserInput();
                validateAmount(amount);
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
        userInterface.showText(userLottos.getLottosString());
    }

    // 당첨 번호 입력
    private WinLotto getWinLotto() {
        String input = "";
        while (true) {
            try {
                userInterface.showText("당첨 번호를 입력해 주세요.");
                input = userInterface.getUserInput();
                validateWinNumbers(input);
            } catch (IllegalArgumentException e) {
                userInterface.showText(e.getMessage());
                continue;
            }
            userInterface.newLine();
            return new WinLotto(Arrays.asList(input.split(".")));
        }
    }
}
