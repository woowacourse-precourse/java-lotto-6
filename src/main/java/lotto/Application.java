package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    final static int LOTTO_PRICE = 1000;
    final static int LOTTO_NUMBER_COUNT = 6;
    final static int LOTTO_RANGE_START = 1;
    final static int LOTTO_RANGE_END = 45;

    public static void main(String[] args) {
        int money = getInputMoney();
        int numberOfTicket = unsafeDivideBy1000(money);

        List<Lotto> lottos = makeLottos(numberOfTicket);
        printLotto(lottos);

        Lotto prizeNumbers = getInputFirstPrizeLotto();
        int bonusNumber = getInputBonusNumber();

        var result = calculateLottoPrize(prizeNumbers, bonusNumber, lottos);
        var earningRate = calculateEarningRate(result, money);
        printResultStatics(result, earningRate);
    }

    public static double calculateEarningRate(Map<PRIZE_TYPE, Integer> result, int inputMoney) {
        double earn = 0.0;
        Map<PRIZE_TYPE, Integer> code = Map.of(
                PRIZE_TYPE.FIVETH, 5000,
                PRIZE_TYPE.FOURTH, 50000,
                PRIZE_TYPE.THIRD, 1500000,
                PRIZE_TYPE.SECOND, 30000000,
                PRIZE_TYPE.FIRST, 2000000000,
                PRIZE_TYPE.NONE, 0
        );

        for (PRIZE_TYPE prizeType : result.keySet()) {
            earn += (double) code.get(prizeType) *
                    result.get(prizeType);
        }

        return earn / inputMoney;
    }

    public static void printResultStatics(Map<PRIZE_TYPE, Integer> result, double earningRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.get(PRIZE_TYPE.FIVETH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(PRIZE_TYPE.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(PRIZE_TYPE.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(PRIZE_TYPE.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(PRIZE_TYPE.FIRST) + "개");
        System.out.println("총 수익률은 " + String.format("%.2f", earningRate) + "%입니다.");
    }

    public static Map<PRIZE_TYPE, Integer> calculateLottoPrize(Lotto prizeNumbers, int bonusNumber,
                                                               List<Lotto> lottos) {
        var result = new HashMap<PRIZE_TYPE, Integer>();

        for (PRIZE_TYPE prizeType : PRIZE_TYPE.values()) {
            result.put(prizeType, 0);
        }

        for (Lotto lotto : lottos) {
            var lottoResult = lotto.calculatePrize(prizeNumbers, bonusNumber);
            int value = result.get(lottoResult);
            result.put(lottoResult, value + 1);
        }

        return result;
    }


    public static int getInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String str = Console.readLine();
        int num = unsafeString2Int(str);
        validateNumberRange(num);
        System.out.println();

        return num;
    }


    public static Lotto getInputFirstPrizeLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<String> numString = Arrays.stream(input.split(",")).toList();
        List<Integer> numbers = new ArrayList<>();

        for (String s : numString) {
            int value = unsafeString2Int(s);
            uniqueAdd(numbers, value);
        }
        validatePrizeNumbers(numbers);
        System.out.println();
        return new Lotto(numbers);
    }

    private static void uniqueAdd(List<Integer> list, Integer value) {
        if (list.contains(value)) {
            return;
        }
        list.add(value);
    }

    private static void validatePrizeNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }

        for (int num : numbers) {
            validateNumberRange(num);
        }
    }

    private static void validateNumberRange(int num) {
        if (num < LOTTO_RANGE_START || LOTTO_RANGE_END < num) {
            throw new IllegalArgumentException();
        }
    }

    public static void printLotto(List<Lotto> lotto) {
        String temp;
        System.out.println(lotto.size() + "개를 구매했습니다.");
        for (Lotto value : lotto) {
            var item = value.getNumbers();
            var strLotto = list2String(item);
            System.out.println(strLotto);
        }
        System.out.println();

    }


    private static String list2String(List<Integer> item) {
        StringBuilder sb = new StringBuilder();

        sb.append('[');
        sb.append(item.get(0));
        for (int k = 1; k < item.size(); ++k) {
            sb.append(", ");
            sb.append(item.get(k));
        }
        sb.append(']');
        return sb.toString();
    }

    public static List<Lotto> makeLottos(int numberOfLotto) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; ++i) {
            lotto.add(makeLotto());
        }

        return lotto;
    }

    public static Lotto makeLotto() {
        List<Integer> num = Randoms
                .pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_NUMBER_COUNT);
        Collections.sort(num);
        return new Lotto(num);
    }

    public static int getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        var input = Console.readLine();
        System.out.println();

        return unsafeString2Int(input);
    }

    public static int unsafeString2Int(String str) {
        int money;
        try {
            money = Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    public static int unsafeDivideBy1000(int num) {
        if (num % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }

        return num / LOTTO_PRICE;
    }

}
