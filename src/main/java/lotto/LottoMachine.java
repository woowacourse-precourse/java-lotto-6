package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoMachine {

    static final int BOUNUS_CHECK_MATCH_COUNT = 5;

    private final Lotto winningLotto;
    private final int bonusNum;

    InputValidation iv = new InputValidation();

    public LottoMachine() {
        this.winningLotto = enterWinningLottoNums();
        this.bonusNum = enterBonusNum();
    }

    public LottoMachine(Lotto winningLotto, int bonusNum) {
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

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

    public int enterBonusNum() {
        int bonusNum;
        while (true) {
            try {
                printBonusNumEnterGuideStatement();
                String input = Console.readLine();
                bonusNum = iv.toInt(input);
                bonusNumValidation(bonusNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNum;
    }

    private void bonusNumValidation(int bonusNum) {
        iv.isWithinRange(bonusNum);
        iv.isBonusDuplicateOfLotto(winningLotto, bonusNum);
    }

    Map<Rank, Integer> draw(List<Lotto> lottos) {
        Map<Rank, Integer> drawResult = initDrawResult();
        for (Lotto lotto : lottos) {
            int matchCount = calculateMatchCount(lotto);
            boolean bonus = hasBonus(lotto, matchCount);
            Rank rank = Rank.getRank(matchCount, bonus);
            drawResult.put(rank, drawResult.get(rank) + 1);
        }
        return drawResult;
    }

    boolean hasBonus(Lotto lotto, int matchCount) {
        return matchCount == BOUNUS_CHECK_MATCH_COUNT && lotto.getNumbers().contains(bonusNum);
    }

    int calculateMatchCount(Lotto lotto) {
        List<Integer> totalNumber = new ArrayList<>(lotto.getNumbers());
        totalNumber.addAll(winningLotto.getNumbers());
        return totalNumber.size() - Set.copyOf(totalNumber).size();
    }

    Map<Rank, Integer> initDrawResult() {
        Map<Rank, Integer> drawResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            drawResult.put(rank, 0);
        }
        return drawResult;
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
            nums.add(iv.toInt(str));
        }
        return nums;
    }

    private void printWinningLottoNumsEnterGuideStatement() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void printBonusNumEnterGuideStatement() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
