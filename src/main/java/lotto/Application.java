package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        // 1. 구입 금액 입력
        System.out.println("구입금액을 입력해 주세요.");
        int price = 0;
        boolean validInput = false;
        while(!validInput) {
            String input = Console.readLine();
            try {
                price = Integer.parseInt(input);
                if(price % LOTTO_PRICE != 0) {
                    System.out.println("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
                    continue;
                }
                validInput = true;
            }
            catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입금액은 숫자를 입력하여야 합니다.");
            }
        }

        // 2. 로또 구매
        int count = price / LOTTO_PRICE;
        List<Lotto> purchasedLotto = new ArrayList<>();
        for(int i=0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            purchasedLotto.add(lotto);
        }

        System.out.printf("%d개를 구매했습니다.\n", count);
        for(Lotto lotto: purchasedLotto) {
            lotto.printLotto();
        }

        // 3. 당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumInput = Console.readLine();
        List<Integer> winNumbers;
        try {
            String[] seps = winNumInput.split(",");
            List<Integer> intList = new ArrayList<>();
            for(String sep: seps){
                int num = Integer.parseInt(sep);
                if(num > 45 || num < 0) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                if(intList.contains(num)) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
                }
                intList.add(num);
            }
            winNumbers = intList;

            if(winNumbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자로 구성되어야 합니다.");
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 로또 번호 형식입니다.");
        }

        // 4. 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        int bonus;
        try {
            bonus = Integer.parseInt(bonusInput);
            if(bonus <= 0 || bonus > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 로또 번호 형식입니다.");
        }
    }
}
