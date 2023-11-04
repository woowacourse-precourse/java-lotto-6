package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

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

        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumber = Console.readLine();

        if (winNumber.isBlank()) {
            throw new IllegalStateException("[ERROR] 아무 것도 입력되지 않았습니다.");
        }

        if (winNumber.charAt(0) == ',' || winNumber.charAt(winNumber.length()) == ',') {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 숫자입니다.");
        }

        int[] winNumbers = Stream.of(winNumber.split(",")).mapToInt(Integer::parseInt).toArray();

        List<Integer> parseWinNumbers = Arrays.stream(winNumbers).boxed().collect(Collectors.toList());

        if (winNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }

        System.out.println("보너스 번호를 입력해주세요.");
        String bonusNumber = Console.readLine();
        int parseBounusNumber = Integer.parseInt(bonusNumber);

        if (bonusNumber.isBlank()) {
            throw new IllegalStateException("[ERROR] 아무 것도 입력되지 않았습니다.");
        }

        if (parseBounusNumber < 1 || parseBounusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
        }

        if(parseWinNumbers.contains(parseBounusNumber)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 다른 번호를 입력해주세요.");
        }

    }

    public static List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
