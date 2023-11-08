package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPlayer {
    private final List<Lotto> lottos = new ArrayList<>();
    private int money = 0;

    public void buyLottos(int number) {
        System.out.printf("%d개를 구매했습니다.\r\n", number);
        for (int i = 0; i < number; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toList()));
            printLotto(lotto);
            lottos.add(lotto);
        }
        System.out.println();
    }

    public void printRateOfProfit(int priceLotto) {
        double rateOfProfit = (float) money / (lottos.size() * priceLotto) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfProfit);
    }

    private void printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder("[");
        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "]");
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
