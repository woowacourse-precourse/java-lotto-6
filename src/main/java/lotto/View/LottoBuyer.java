package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBuyer {
    public static Integer lottoCount;
    public static Integer money;
    private static List<Lotto> boughtLottos;
    public static final Integer LOTTO_PRICE = 1_000;
    private static final String LOTTO_BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PRICE_ERROR_MESSAGE = "%s 입력한 금액은 로또 한 장 가격(1,000원)의 배수여야 합니다.";
    private static final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.";
    public static Integer inputMoney() {
        System.out.println(LOTTO_BUY_MESSAGE);
        money = Integer.valueOf(Console.readLine());
        validateLottoPrice(money);
        return money;
    }

    public static List<Lotto> getBoughtLottos(){
        return boughtLottos;
    }

    private static void validateLottoPrice(Integer money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format(LOTTO_PRICE_ERROR_MESSAGE,Lotto.ERROR_NOTICE));
        }
    }

    private static void calculateLottoCount(Integer money) {
        lottoCount = money / LOTTO_PRICE;
    }

    public static void printLottoCount() {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, lottoCount));
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        calculateLottoCount(money);

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
        boughtLottos = lottos;
        return boughtLottos;
    }

    public static void printLottos() {
        for (Lotto lotto : boughtLottos) {
            System.out.println(lotto.toString());
        }
    }
}
