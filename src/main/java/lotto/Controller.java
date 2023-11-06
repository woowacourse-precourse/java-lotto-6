package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    public void run() {
        Money money = getMoney();
        Lottos lottos = getLottos(money.getTicket());

        System.out.println(money.getTicket());
        lottos.getLottos().forEach(System.out::println);
    }

    private String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private int convertMoney(String input) {
        return Integer.parseInt(input);
    }

    private Money getMoney() {
        int money = convertMoney(inputMoney());
        return new Money(money);
    }

    private Lottos getLottos(int ticket) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoGroup(ticket));
    }
}
