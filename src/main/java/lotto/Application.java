package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    static int lottoMoney = 0;
    static List<Integer> winningLottoNumber;
    public static boolean lottoMoneyInput() {
        try {
            String userInput = Console.readLine();
            lottoMoney = Integer.parseInt(userInput);
            if (lottoMoney % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
    public static void main(String[] args) {
        // 로또 구입 금액 입력받고 예외처리
        boolean flag = true;
        while(flag) {
            System.out.println("구입금액을 입력해 주세요.");
            flag = lottoMoneyInput();
        }
        System.out.println();

        // 발행한 로또 수량 출력
        int lottoAmount = lottoMoney / 1000;
        System.out.println(lottoAmount + "개를 구매했습니다.");

        // 발행한 로또 번호 오름차순으로 출력하기
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> userLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(userLottoNumber);
            System.out.println(userLottoNumber);
        }

        // 당첨 번호 6개 쉼표로 구분하여 입력받기
        while (true) {
            List<Integer> numbers = new ArrayList<>();
            System.out.println("당첨 번호를 입력해 주세요.");
            String userInput = Console.readLine();
            String[] splitNumber = userInput.split(",");
            for (int i = 0; i < splitNumber.length; i++) {
                numbers.add(Integer.parseInt(splitNumber[i]));
            }
            try {
                Lotto lotto = new Lotto(numbers);
                winningLottoNumber = lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }
}
