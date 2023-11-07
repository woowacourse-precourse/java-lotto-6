package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final static int MIN = 1;
    private final static int MAX = 45;
    private final static int NUMBER = 6;
    private final String ERROR = "[ERROR]";
    private List<Lotto> lottos = new ArrayList<>();
    private int result = 0;

    public void start() {
        UserInput input = new UserInput();
        int count = input.purchase();
        guessNumbers(generateLottoNumbers(count),input.luckyNumber(),input.bonusNumber());
//        System.out.println(oh);
    }

    // 1000으로 나누어 지는지 확인
    public boolean isNotDivisibleBy1000(int amount) {
        if (amount % 1000 != 0) {
            System.out.println(ERROR + " 1000으로 나누어 떨어지는 금액을 입력하세요.");
            return false;
        }
        return true;
    }

    public List<Lotto> generateLottoNumbers(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> generateNumbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, NUMBER);
            Lotto lotto = new Lotto(generateNumbers);
            lottos.add(lotto);
        }
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getRandomNumber());
        }
        return lottos;
    }

    public enum LottoResult {
        THREE_MATCH("3개 일치 (5,000원)", 5000),
        FOUR_MATCH("4개 일치 (10,000원)", 10000),
        FIVE_MATCH("5개 일치 (1,500,000원)", 1500000),
        SIX_MATCH("6개 일치 (2,000,000,000원)", 2000000000);

        private final String description;

        LottoResult(String description, int prize) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public void guessNumbers(List<Lotto> randoms, List<Lotto> lucky, int bonus) {
        Map<LottoResult, Integer> resultCounts = new EnumMap<>(LottoResult.class);
        for (LottoResult result : LottoResult.values()) {
            resultCounts.put(result, 0);
        }
        for (Lotto random : randoms) {
            int count = 0;
            for (int i = 0; i < 6; i++) {
                int number = random.getNumber(i);
                if (isNumberInLuckyList(number, lucky) || number == bonus) {
                    count++;
                }
            }
            if (count >= 3 && count <= 6) {
                LottoResult result = LottoResult.values()[count - 3];
                resultCounts.put(result, resultCounts.get(result) + 1);
            }
        }
        System.out.println("당첨 통계"+"\n---");
        for (LottoResult result : LottoResult.values()) {
            System.out.println(result.getDescription() + " - " + resultCounts.get(result));
        }
    }

    public boolean isNumberInLuckyList(int number, List<Lotto> lucky) {
        for (Lotto lotto : lucky) {
            for (int i = 0; i < 6; i++) {
                if (lotto.getNumber(i) == number) {
                    return true;
                }
            }
        }
        return false;
    }
}