package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //가격 입력
        int amount = CheckAmountLotto();
        BuyLotto(amount);

    }

    public static void BuyLotto(int amountLotto) {
        int realAmount = amountLotto / 1000;
        System.out.println("\n" + realAmount+ "개를 구매했습니다.");

        ArrayList<Lotto> lottoList = new ArrayList<>();

        for(int i=0; i<realAmount; i++) {
            //한 횟수당 랜덤하게 6개씩 뽑을 것
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto lottoInstance = new Lotto(numbers);
            System.out.println(numbers);
            lottoList.add(lottoInstance);
        }
    }

    public static int CheckAmountLotto() {
        boolean validInput = false;
        int amountLotto = 0;

        while(!validInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                amountLotto = Integer.parseInt(Console.readLine());
                if(amountLotto % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
                }

                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("\n[ERROR] 구입 금액은 1000원 단위여야 합니다.");
            }
        }
        return amountLotto;
    }
}
