package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<Integer> WinningNum;
    private int maxLotto;
    private List<Lotto> lottos;


    public void run() {

    }

    public void decideMaxLotto(User user) {
        int userAmount = user.getAmount();
        this.maxLotto = userAmount / 1000;
        LottoInfo();
    }

    public void LottoInfo() {
        System.out.printf("%d개를 구매했습니다.\n", this.maxLotto);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void lottery() {
        lottos = new ArrayList<>(maxLotto);
        for (int i = 0; i < lottos.size(); i++) {
            lottos.add(new Lotto(generateLottoNum()));
        }
    }

    public List<Integer> generateLottoNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
