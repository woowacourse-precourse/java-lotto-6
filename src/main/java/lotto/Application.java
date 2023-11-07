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

        System.out.println("구입금액을 입력해 주세요.");
        money = Integer.parseInt(Console.readLine());
        if(money % unit != 0) {
            System.out.println("[ERROR] 구입금액은 " + unit + "원으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }

        System.out.println((money / unit) + "개를 구매했습니다.");
        for(int i=0; i<money/unit; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startLottoNumber, endLottoNumber, pickLottoCount);
            purchasedLotto.add(new Lotto(numbers));
        }
        for(int i=0; i<purchasedLotto.size(); i++) {
            Collections.sort(purchasedLotto.get(i).getNumbers());
            System.out.println(purchasedLotto.get(i).getNumbers());
        }





    }


}
