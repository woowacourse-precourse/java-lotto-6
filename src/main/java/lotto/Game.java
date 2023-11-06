package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private List<Lotto> lottos;
    private Integer buyingPrice;

    public Game() {
        this.lottos = new ArrayList<>();
        this.buyingPrice = 0;
    }

    public void run() {
        saveBuyingPrice();
        giveLotto();
    }

    private void saveBuyingPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String readLine = Console.readLine();
        buyingPrice = Integer.parseInt(readLine);
    }

    private void giveLotto() {
        int count = buyingPrice / 1000;
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            showLotto(uniqueNumbers);
            lottos.add(new Lotto(uniqueNumbers));
        }
    }

    private void showLotto(List<Integer> uniqueNumbers) {
        String result = uniqueNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }
}
