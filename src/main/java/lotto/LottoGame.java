package lotto;

import lotto.domain.UserLottos;
import lotto.domain.WinLotto;
import lotto.type.LottoResult;
import lotto.ui.UI;

import java.util.Arrays;
import java.util.List;

import static lotto.validator.Validator.*;

public class LottoGame {
    private final UI UI = new UI();
    private WinLotto winLotto;
    private UserLottos userLottos;

    // 로또 게임 진행 시작
    public void start() {
        int amount = getLottoAmount();
        userLottos = new UserLottos(amount);
        showLottos(userLottos);
        winLotto = new WinLotto(getWinNumbers());
        winLotto.setBonusNumber(getBonusNumber());
        showResult();
    }

    // 구입금액 입력
    private int getLottoAmount() {
        String amount = "";
        while (true) {
            try {
                UI.show("구입금액을 입력해 주세요.");
                amount = UI.input();
                validateAmount(amount);
            } catch (IllegalArgumentException e) {
                UI.show(e.getMessage());
                continue;
            }
            UI.newLine();
            return Integer.parseInt(amount);
        }
    }

    // 발행한 로또 수량 및 번호 출력
    private void showLottos(UserLottos userLottos) {
        UI.show(userLottos.getSize() + "개를 구매했습니다.");
        UI.show(userLottos.getLottosString());
    }

    // 당첨 번호 입력
    private List<String> getWinNumbers() {
        String numbers = "";
        while (true) {
            try {
                UI.show("당첨 번호를 입력해 주세요.");
                numbers = UI.input();
                validateWinNumbers(numbers);
            } catch (IllegalArgumentException e) {
                UI.show(e.getMessage());
                continue;
            }
            UI.newLine();
            return Arrays.asList(numbers.split(","));
        }
    }

    // 보너스 번호 입력
    private int getBonusNumber() {
        String number = "";
        while (true) {
            try {
                UI.show("보너스 번호를 입력해 주세요.");
                number = UI.input();
                validateBonusNumber(number, winLotto.getWinLotto().getNumbers());
            } catch (IllegalArgumentException e) {
                UI.show(e.getMessage());
                continue;
            }
            UI.newLine();
            return Integer.parseInt(number);
        }
    }

    // 당첨 통계 출력
    private void showResult() {
        int winAmount = 0;
        UI.show("당첨 통계\n---");
        List<Integer> winResult = winLotto.getWinCheck(userLottos);
        LottoResult[] values = LottoResult.values();
        for (int i = 0; i < 5; i++) {
            UI.show(values[i].getWinInfo() + " - " +
                    winResult.get(i) + "개");
            winAmount += winResult.get(i) * values[i].getReward();
        }

        UI.show("총 수익률은 " +
                Math.round((double) winAmount / (userLottos.getSize() * 1000.0) * 1000) / 10.0 + "%입니다.");
    }
}
