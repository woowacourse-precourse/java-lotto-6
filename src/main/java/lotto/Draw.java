package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static lotto.Lotto.lottoRangeFirstNum;
import static lotto.Lotto.lottoRangeLastNum;

public class Draw {

    static final int BOUNUS_CHECK_MATCH_COUNT = 5;

    public Lotto enterWinningLottoNums() {
        Lotto winningLotto;

        while (true) {
            try {
                List<Integer> winningLottoNums = getWinningLottoNumsList();
                winningLotto = new Lotto(winningLottoNums);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }

    public int enterBonusNum(Lotto winningLotto) {
        int bonusNum;
        while (true) {
            try {
                printBonusNumEnterGuideStatement();
                String input = Console.readLine();
                bonusNum = toInt(input);
                isWithinRange(bonusNum);
                isDuplicate(winningLotto, bonusNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNum;
    }

    void isWithinRange(int num) {
        if (!(num >= lottoRangeFirstNum && num <= lottoRangeLastNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1~45입니다.");
        }
    }

    void isDuplicate(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 입력한 로또 번호와 중복될 수 없습니다.");
        }
    }

    public List<Integer> getWinningLottoNumsList() {
        printWinningLottoNumsEnterGuideStatement();
        String input = Console.readLine();
        String[] strings = input.split(",");
        return toIntList(strings);
    }

    List<Integer> toIntList(String[] strings) {

        List<Integer> nums = new ArrayList<>();

        for (String str : strings) {
            nums.add(toInt(str));
        }

        return nums;
    }

    int toInt(String str) {
        isPositiveNum(str);
        return Integer.parseInt(str);
    }

    void isPositiveNum(String str) {
        String regex = "^([1-9]+[0-9]+)$";
        if (!str.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 0보다 큰 숫자여야 합니다.");
        }
    }

    private void printWinningLottoNumsEnterGuideStatement() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void printBonusNumEnterGuideStatement() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public List<Lotto> issueLottos(int num) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < num / 1000; i++) {
            List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(pickedNumbers));
        }

        return lottos;
    }

    Map<Rank, Integer> draw(Lotto winning, int bonusNum, List<Lotto> lottos) {
        Map<Rank, Integer> drawResult = initDrawResult();
        for (Lotto lotto : lottos) {
            int matchCount = calculateMatchCount(winning, lotto);
            boolean bonus = hasBonus(lotto, matchCount, bonusNum);
            Rank rank = Rank.getRank(matchCount, bonus);
            drawResult.put(rank, drawResult.get(rank) + 1);
        }
        return drawResult;
    }

    boolean hasBonus(Lotto lotto, int matchCount, int bonusNum) {
        return matchCount == BOUNUS_CHECK_MATCH_COUNT && lotto.getNumbers().contains(bonusNum);
    }

    int calculateMatchCount(Lotto winning, Lotto lotto) {
        List<Integer> totalNumber = new ArrayList<>(lotto.getNumbers());
        totalNumber.addAll(winning.getNumbers());
        return totalNumber.size() - Set.copyOf(totalNumber).size();
    }

    Map<Rank, Integer> initDrawResult() {
        Map<Rank, Integer> drawResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            drawResult.put(rank, 0);
        }
        return drawResult;
    }
}
