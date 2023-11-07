package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyLotto {

    private final InputManager inputManager = new InputManager();
    private List<Lotto> lottos;

    public List<Lotto> buy() {
        System.out.println("구입 금액을 입력 해 주세요.");
        long money = inputManager.getMoney();
        long lottoCount = money / 1000;
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateLotto());
        }
        showLottos();
        return lottos;
    }

    public List<Integer> getCorrectNumbers() {
        System.out.println("당첨 번호를 입력 해 주세요");
        return inputManager.getCorrectNumbers();
    }

    public int getBonus() {
        System.out.println("보너스 번호를 입력 해 주세요");
        return inputManager.getBonus();
    }

    public void showLottos() {
        for (Lotto l : lottos) {
            l.showBallNumber();
        }
    }

    public Lotto generateLotto() {
        List<Integer> balls = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(balls);
    }
}
