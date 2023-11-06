package lotto;

import java.util.List;

public class LottoGame {
    private final UserInterface userInterface = new UserInterface();
    private final Validator validator = new Validator();
    private List<Lotto> lottos;

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
                // 구입금액 검증 로직 구현
            } catch (IllegalArgumentException e) {
                userInterface.showText(e.getMessage());
                continue;
            }
            userInterface.newLine();
            break;
        }
    }

    // 발행한 로또 수량 및 번호 출력
    private void showLottos(List<Lotto> lottos) {
        userInterface.showText(lottos.size() + "개를 구매했습니다.");
//        for (Lotto lotto : lottos)
//            userInterface.showText(lotto.getNumbers());
        userInterface.newLine();
    }
}
