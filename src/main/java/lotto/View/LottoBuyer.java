package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBuyer {
    public static Integer LOTTO_COUNT;
    public static final Integer LOTTO_PRICE = 1_000;
    private static final String LOTTO_BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PRICE_ERROR_MESSAGE = "%s 입력한 금액은 로또 한 장 가격(1,000원)의 배수여야 합니다.";
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    public static Integer inputMoney() {
        System.out.println(LOTTO_BUY_MESSAGE);
        Integer money = Integer.valueOf(Console.readLine());
        validateLottoPrice(money);
        return money;
    }

    private static void validateLottoPrice(Integer money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format(LOTTO_PRICE_ERROR_MESSAGE,Lotto.ERROR_NOTICE));
        }
    }

    private static Integer calculateLottoCount(Integer money) {
        LOTTO_COUNT = money / LOTTO_PRICE;
        return LOTTO_COUNT;
    }

    public static void printLottoCount() {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, LOTTO_COUNT));
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static List<Lotto> generateLottos(List<Integer> lottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < LOTTO_COUNT; i++) {
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
