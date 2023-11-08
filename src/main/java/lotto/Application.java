package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = 0;
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String inputAmount = Console.readLine();

            if (isValidInput(inputAmount)) {
                purchaseAmount = Integer.parseInt(inputAmount) / 1000;
                break;
            }
        }
        System.out.println(purchaseAmount + "개를 구매했습니다.");
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i<purchaseAmount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            Lotto lotto = new Lotto(randomNumbers);
            lottoList.add(lotto);
            System.out.println(randomNumbers);
        }
    }

    private static boolean isValidInput(String input) {
        try {
            int inputAmount = Integer.parseInt(input);
            if (inputAmount % 1000 != 0) {
                System.err.println("[ERROR] 구입금액은 1000원 단위여야 합니다. 다시 입력해주세요.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.err.println("[ERROR] 구입금액은 숫자로 입력해주세요.");
            return false;
        }
    }


}
