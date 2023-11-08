package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {

    public static List<Lotto> issueLotto(String money) {
        validateMoney(money);

        int issueNumber = Integer.parseInt(money) / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issueNumber; i++) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(new ArrayList<>(list)));
        }

        return lottos;
    }

    private static void validateMoney(String money) {
        if(!isNumeric(money)) throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");

        int M = Integer.parseInt(money);
        if(M % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1,000원 단위로 금액을 입력해주세요. ");
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

}
