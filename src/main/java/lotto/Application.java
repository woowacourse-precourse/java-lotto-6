package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Validation validation = new Validation();

        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput = Console.readLine();

        int purchaseAmount = validation.parsePurchaseAmount(moneyInput);
        validation.validateUnderZero(purchaseAmount);
        validation.validateDivideThousand(purchaseAmount);

        int purchaseCount = purchaseAmount / 1000;
        System.out.println(purchaseCount + "개를 구매했습니다.");

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println(lottoList.get(i).toString());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumbers = Console.readLine();

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
    }

}
