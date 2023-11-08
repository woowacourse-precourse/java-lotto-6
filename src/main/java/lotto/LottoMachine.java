package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.LottoInfo;
import lotto.enums.LottoPrize;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static lotto.Input.getNaturalNumber;
import static lotto.Input.getSplitNaturalNumberList;
import static lotto.enums.LottoPrize.lottoResultToLottoPrize;

public class LottoMachine {
    private final int MIN_NUMBER;
    private final int MAX_NUMBER;
    private final int NUMBERS_PER_LOTTO;
    private final int LOTTO_PRICE;
    private final DecimalFormat formatter;

    LottoMachine(DecimalFormat decimalFormat) {
        this.MIN_NUMBER = LottoInfo.MIN_NUMBER.getNumber();
        this.MAX_NUMBER = LottoInfo.MAX_NUMBER.getNumber();
        this.NUMBERS_PER_LOTTO = LottoInfo.NUMBERS_PER_LOTTO.getNumber();
        this.LOTTO_PRICE = LottoInfo.LOTTO_PRICE.getNumber();
        this.formatter = decimalFormat;
    }

    public void run() {
        int lottoCount = setLottoCount();
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<List<Integer>> myLottos = getAllLotto(lottoCount);
        System.out.println(lottoToString(myLottos));
        Lotto lotto = setWinningNumbers();
        int bonus = setBonusNumber(lotto);
        List<LottoResult> lottoResults = getCountingMatches(lotto, bonus, myLottos);
        TreeMap<LottoPrize, Integer> winningCount = countLottoPrize(lottoResults);
        System.out.println(getLottoResult(winningCount));
        double profit = calculateProfit(lottoCount, winningCount)*100;
        System.out.println("총 수익률은 " + formatter.format(profit) + "%입니다.");
    }

    public int setLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                int number = getNaturalNumber();
                Validation.validateMultipleOfLottoPrice(number);
                return number/LOTTO_PRICE;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<List<Integer>> getAllLotto(int count) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ret.add(getLotto());
        }
        return ret;
    }

    public String lottoToString(List<List<Integer>> lottos) {
        StringBuilder ret = new StringBuilder();
        lottos.forEach(i -> {
            ret.append(i.toString());
            ret.append("\n");
        });
        return ret.toString().trim();
    }

    public List<LottoResult> getCountingMatches(Lotto lotto, int bonus, List<List<Integer>> myLottos) {
        List<LottoResult> count = new ArrayList<>();
        myLottos.forEach(i -> {
            count.add(new LottoResult(i, lotto, bonus));
        });
        return count;
    }

    public TreeMap<LottoPrize, Integer> countLottoPrize(List<LottoResult> lottoResults) {
        TreeMap<LottoPrize, Integer> count = new TreeMap<>();
        lottoResults.forEach(lottoResult -> {
            LottoPrize item = lottoResultToLottoPrize(lottoResult);
            count.put(item, count.getOrDefault(item, 0)+1);
        });
        return count;
    }

    public String getLottoResult(TreeMap<LottoPrize, Integer> winningCount) {
        StringBuilder ret = new StringBuilder();
        ret.append("당첨 통계\n").append("---\n");
        for (LottoPrize lottoPrize: LottoPrize.values()) {
            int count = winningCount.getOrDefault(lottoPrize, 0);
            buildLottoResult(ret, lottoPrize, count);
        }
        return ret.toString().trim();
    }

    public double calculateProfit(int lottoCount, TreeMap<LottoPrize, Integer> winningCount) {
        double totalPrice = lottoCount*LOTTO_PRICE;
        double ret = 0;
        for (LottoPrize lottoPrize: LottoPrize.values()) {
            long prizeMoney = lottoPrize.getPrizeMoney();
            ret += winningCount.getOrDefault(lottoPrize, 0)*prizeMoney;
        }
        return ret/totalPrice;
    }

    private Lotto setWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                List<Integer> numbers = getSplitNaturalNumberList(",");
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int setBonusNumber(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                int number = getNaturalNumber();
                Validation.validateDuplicate(lotto, number);
                return number;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getLotto() {
        List<Integer> ret = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_PER_LOTTO);
        return ret.stream().sorted().toList();
    }

    private void buildLottoResult(StringBuilder ret, LottoPrize lottoPrize, int count) {
        int matchingNumbers = lottoPrize.getMatchingNumbers();
        long prizeMoney = lottoPrize.getPrizeMoney();
        if (prizeMoney != 0) {
            ret.append(matchingNumbers).append("개 일치");
            if (lottoPrize == LottoPrize.MATCH_5_BONUS) {
                ret.append(", 보너스 볼 일치");
            }
            ret.append(" (").append(String.format("%,d", prizeMoney)).append("원)")
                    .append(" - ").append(count).append("개")
                    .append("\n");
        }
    }
}
