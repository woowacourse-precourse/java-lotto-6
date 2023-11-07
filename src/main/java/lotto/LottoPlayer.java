package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPlayer {
    private final List<Lotto> lottos = new ArrayList<>();
    private int money = 0;

    public void buyLottos(int number) {
        System.out.printf("%d개를 구매했습니다.\n", number);
        for (int i = 0; i < number; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)); // naturalOrder 적용 필요
            printLotto(lotto);
            lottos.add(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder("[");
        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        sb.replace(sb.length()-2, sb.length(), "]");
        System.out.println(sb);
    }

    public void removeLottos() {
        lottos.clear();
    }

    public void addMoney(int additionalMoney) {
        money += additionalMoney;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }
}
