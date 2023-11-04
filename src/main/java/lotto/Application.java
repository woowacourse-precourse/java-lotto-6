package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        int lottoPrice = 1000;
        int parseMoney = 0;
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();

        if (money.isBlank()) {
            throw new IllegalStateException("[ERROR] 아무 것도 입력되지 않았습니다.");
        }

        try {
            parseMoney = Integer.parseInt(money);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("[ERROR] 숫자 형식이 아닙니다.");
        }

        if (money.charAt(0) == '0') {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 숫자입니다.");
        }

        if (parseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }

        int buyLottoCount = parseMoney / lottoPrice;

        List<Lotto> lotties = new ArrayList<>();
        for (int i = 0; i < buyLottoCount; i++) {
            Lotto lotto = new Lotto(makeLotto());
            lotties.add(lotto);
        }

    }

    public static List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
