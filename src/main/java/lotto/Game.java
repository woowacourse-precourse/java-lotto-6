package lotto;

import static lotto.ResultCase.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private BuyingPrice buyingPrice;
    private List<Lotto> lottos;
    private Winning winning;
    private Bonus bonus;
    private Result result;

    public Game() {
        this.buyingPrice = new BuyingPrice();
        this.lottos = new ArrayList<>();
        this.winning = new Winning();
        this.bonus = new Bonus();
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
        saveValue("구입금액을 입력해 주세요.", buyingPrice);
    }

    private void giveLotto() {
        int buyingCount = buyingPrice.getBuyingCount();
        System.out.println(buyingCount + "개를 구매했습니다.");
        for (int i = 0; i < buyingCount; i++) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            showLotto(uniqueNumbers);
            lottos.add(new Lotto(uniqueNumbers));
        }
    }

    private void showLotto(List<Integer> uniqueNumbers) {
        ArrayList<Integer> copyNumbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(copyNumbers);
        String result = copyNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }

    private void saveWinningNumber() {
        saveValue("당첨 번호를 입력해 주세요.", winning);
    }

    private void saveBonusNumber() {
        saveValue("보너스 번호를 입력해 주세요.", bonus);
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
        System.out.println(resultCase.getInform() + matchLotto + "개");
    }

    private int countMatchLotto(ResultCase resultCase) {
        int matchLotto = 0;
        for (Lotto lotto : lottos) {
            int equalNumber = lotto.countEqualNumber(winning.getNumbers());
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
        if (lotto.contain(bonus.getNumber())) {
            equalNumber++;
        }
        return equalNumber;
    }

    private void informRateOfReturn() {
        System.out.println("총 수익률은 " + calculateRateOfReturn() +"%입니다.");
    }

    private double calculateRateOfReturn() {
        double rateOfReturn = ((double) result.getWinningPrice() / buyingPrice.getPrice()) * 100;
        double refinedRateOfReturn = (double) Math.round(rateOfReturn * Math.pow(10, 2)) / Math.pow(10, 2);
        return refinedRateOfReturn;
    }

    private void saveValue(String informComment, Input input) {
        Boolean isNotEnded = true;
        while (isNotEnded) {
            try {
                System.out.println(informComment);
                String readLine = Console.readLine();
                input.save(readLine);
                isNotEnded = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
