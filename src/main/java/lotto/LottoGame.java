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
    private List<Lotto> lottos = new ArrayList<>();
    private final Map<LottoResult, Integer> resultCounts = new EnumMap<>(LottoResult.class);
    private LottoWinning winning = new LottoWinning();

    public void start() {
        UserInput input = new UserInput();
        int count = input.purchase();
        Map<LottoResult,Integer> map = guessNumbers(generateLottoNumbers(count),input.luckyNumber(),input.bonusNumber());
        winning.winningLottos(map); // 당첨 통계 출력
        int earningMoney = winning.money(resultCounts); // 총 당첨금
        winning.calcualteEarningRate(count*1000, earningMoney);
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
        FOUR_MATCH("4개 일치 (50,000원)", 50000),
        FIVE_MATCH("5개 일치 (1,500,000원)", 1500000),
        FIVE_MATCH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
        SIX_MATCH("6개 일치 (2,000,000,000원)", 2000000000);

        private final String description;
        private final int prize;

        LottoResult(String description, int prize) {
            this.description = description;
            this.prize = prize;
        }

        public String getDescription() {
            return description;
        }
        public int getPrize(){
            return prize;
        }

    }

    public Map<LottoResult, Integer> guessNumbers(List<Lotto> randoms, List<Lotto> lucky, int bonus) {
        initializeResultCounts(resultCounts);
        countMatchingNumbers(resultCounts, randoms, lucky, bonus);

        return resultCounts;
    }

    private void initializeResultCounts(Map<LottoResult, Integer> resultCounts) {
        for (LottoResult result : LottoResult.values()) {
            resultCounts.put(result, 0);
        }
    }

    private void countMatchingNumbers(Map<LottoResult, Integer> resultCounts, List<Lotto> randoms, List<Lotto> lucky, int bonus) {
        for (Lotto random : randoms) {
            int count = countMatchingNumbersInLotto(random, lucky, bonus);
            if (count >= 3 && count <= 6) {
                handleMatchingCount(resultCounts, count, lucky, bonus);
            }
        }
    }

    private void handleMatchingCount(Map<LottoResult, Integer> resultCounts, int count, List<Lotto> lucky, int bonus) {
        if (count == 5 && lucky.stream().anyMatch(lotto -> lotto.containsNumber(bonus))) {
            resultCounts.put(LottoResult.FIVE_MATCH_BONUS, resultCounts.get(LottoResult.FIVE_MATCH_BONUS) + 1);
        }
        if (count != 5){
            LottoResult result = LottoResult.values()[count - 3];
            resultCounts.put(result, resultCounts.get(result) + 1);
        }
    }

    private int countMatchingNumbersInLotto(Lotto random, List<Lotto> lucky, int bonus) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            int number = random.getNumber(i);
            if (isNumberInLuckyLotto(number, lucky) || number == bonus) {
                count++;
            }
        }
        return count;
    }

    public boolean isNumberInLuckyLotto(int number, List<Lotto> lucky) {
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