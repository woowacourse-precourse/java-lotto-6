package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final int unit = 1000;
        final int startLottoNumber = 1;
        final int endLottoNumber = 45;
        final int pickLottoCount = 6;

        int money;
        List<Lotto> purchasedLotto = new ArrayList<>();
        List<Integer> inputLottoNumber = new ArrayList<>();
        Lotto winLotto = null;
        int bonusLotto;



        System.out.println("구입금액을 입력해 주세요.");
        money = Integer.parseInt(Console.readLine());
        if(money % unit != 0) {
            System.out.println("[ERROR] 구입금액은 " + unit + "원으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }

        System.out.println("\n" + (money / unit) + "개를 구매했습니다.");
        for(int i=0; i<money/unit; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startLottoNumber, endLottoNumber, pickLottoCount);
            purchasedLotto.add(new Lotto(numbers));
        }
        for(int i=0; i<purchasedLotto.size(); i++) {
            Collections.sort(purchasedLotto.get(i).getNumbers());
            System.out.println(purchasedLotto.get(i).getNumbers());
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] inputs = Console.readLine().split(",");
        for(int i=0; i<inputs.length; i++) {
            int input = Integer.parseInt(inputs[i]);
            validateRange(input, startLottoNumber, endLottoNumber);
            inputLottoNumber.add(input);
        }
        winLotto = new Lotto(inputLottoNumber);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusLotto = Integer.parseInt(Console.readLine());
        validateRange(bonusLotto, startLottoNumber, endLottoNumber);












    }

    public static void validateRange(int number, int startLottoNumber, int endLottoNumber) {
        if(number > endLottoNumber || number < startLottoNumber) {
            System.out.println("[ERROR] 로또 번호는 " + startLottoNumber + "부터 " + endLottoNumber + " 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }


}
