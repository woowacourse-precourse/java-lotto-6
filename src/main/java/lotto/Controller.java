package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    public void run() {
        int money = convertMoney(inputMoney());
        int lotto = numberOfLotto(money);
        Lottos lottos = getLottos(lotto);

        System.out.println(money);
        System.out.println(lotto);
        lottos.getLottos().forEach(System.out::println);
    }

    private String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private int convertMoney(String input) {
        return Integer.parseInt(input);
    }

    private int numberOfLotto(int money) {
        return money / 1000;
    }

    private Lottos getLottos(int ticket) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoGroup(ticket));
    }
}
