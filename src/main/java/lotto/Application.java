package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        int money = 0;
        int lottoTickets = 0;

        do {
            System.out.println("구입금액을 입력해 주세요.");
            money = inputValidator.checkMoneyValidate(Console.readLine());
        } while (money == 0);
        System.out.println();

        lottoTickets = money / 1000;
        System.out.println(lottoTickets + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
