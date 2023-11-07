package lotto;

import static lotto.ResultCase.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private Buying buying;
    private List<Lotto> lottos;
    private Lotto winning;
    private Integer bonusNumber;
    private Result result;

    public Game() {
        this.lottos = new ArrayList<>();
        this.bonusNumber = 0;
        this.result = new Result();
    }

    public void run() {
        saveBuyingPrice();
        giveLotto();
        saveWinningNumber();
        saveBonusNumber();
        informWinning();
        informRateOfReturn();
    }

    private void saveBuyingPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String readLine = Console.readLine();
        buying = new Buying(readLine);
    }

    private void giveLotto() {
        int buyingCount = buying.getBuyingCount();
        System.out.println(buyingCount + "개를 구매했습니다.");
        for (int i = 0; i < buyingCount; i++) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            showLotto(uniqueNumbers);
            lottos.add(new Lotto(uniqueNumbers));
        }
    }

    private void showLotto(List<Integer> uniqueNumbers) {
        Collections.sort(uniqueNumbers);
        String result = uniqueNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }

    private void saveWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String readLine = Console.readLine();
        String[] split = readLine.split(",");
        List<Integer> numbers = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        winning = new Lotto(numbers);
    }

    private void saveBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String readLine = Console.readLine();
        bonusNumber = Integer.parseInt(readLine);
    }

    private void informWinning() {
        System.out.println("당첨 통계\n---");
        printWinning(THREE_CORRECTNESS);
        printWinning(FOUR_CORRECTNESS);
        printWinning(FIVE_CORRECTNESS);
        printWinning(FIVE_AND_BONUS_CORRECTNESS);
        printWinning(SIX_CORRECTNESS);
    }

    private void printWinning(ResultCase resultCase) {
        int matchLotto = countMatchLotto(resultCase);
        result.changeResult(resultCase, matchLotto);
        System.out.print(resultCase.getInform());
        System.out.print(matchLotto);
        System.out.println("개");
    }

    private int countMatchLotto(ResultCase resultCase) {
        int matchLotto = 0;
        for (Lotto lotto : lottos) {
            int equalNumber = lotto.countEqualNumber(winning);
            if (resultCase == FIVE_AND_BONUS_CORRECTNESS) {
                equalNumber = addBonusNumber(lotto, equalNumber);
            }
            if (equalNumber == resultCase.getCorrectness()) {
                matchLotto++;
            }
        }
        return matchLotto;
    }

    private int addBonusNumber(Lotto lotto, int equalNumber) {
        if (lotto.contain(bonusNumber)) {
            equalNumber++;
        }
        return equalNumber;
    }

    private void informRateOfReturn() {
        System.out.println("총 수익률은 " + calculateRateOfReturn() +"%입니다.");
    }

    private double calculateRateOfReturn() {
        return ((double) result.getWinningPrice() / buying.getBuyingPrice()) * 100;
    }
}
