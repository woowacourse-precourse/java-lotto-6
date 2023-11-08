package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int lottoCount;
    private int lottoPrice;
    private List<Lotto> lottos;

    public User() {
        lottos = new ArrayList<>();
    }

    private void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputText = Console.readLine();
        try {
            Validator.buyCheck(inputText);
            lottoPrice = Integer.parseInt(inputText) / 1000;
            lottoCount = lottoPrice;
        } catch (IllegalArgumentException e) {
            buyLotto();
        }
    }

    public void getLotto() {
        buyLotto();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
    }
}
