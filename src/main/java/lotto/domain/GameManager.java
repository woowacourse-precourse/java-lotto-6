package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    public GameManager() {
    }

    public void startLottoGame() {
        System.out.println("로또 게임을 시작합니다.");
    }

    public void showLottoCount(int lottoCount) {
        if (lottoCount <= 0) {
            throw new IllegalStateException("[ERROR] lottoCount가 0이하입니다.");
        }
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public List<Lotto> instantiateLottos(int lottoCount) {
        // lottoCount만큼 로또를 생성하여 반환
        // 같은 로또가 생성되지 않도록 구현
        // 같은 로또 번호를 가진 lotto가 생성되지 않도록 구현
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            for (Lotto lotto1 : lottos) {
                if (lotto1.equals(lotto)) {
                    i--;
                    break;
                }
            }
            lottos.add(lotto);
        }
        return lottos;
    }

    public void showLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            // show the elements in the format: [1, 2, 3, 4, 5, 6]
            System.out.print("[");
            for (int i = 0; i < lotto.getNumbers().size(); i++) {
                System.out.print(lotto.getNumbers().get(i));
                if (i != lotto.getNumbers().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
    public void showDrawMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public void showBonusDrawMessage() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }
}