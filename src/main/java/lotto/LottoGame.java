package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaser;
import lotto.domain.Lottos;
import lotto.domain.Statistics;
import lotto.errors.ErrorMessage;

public class LottoGame {

    LottoPurchaser lottoPurchaser = LottoPurchaser.getInstance();
    BonusNumber bonusNumber = new BonusNumber();
    Lotto luckyNumbers = null;
    Lottos lottos = null;
    Statistics statistics = new Statistics();

    public void getRightCost() {
        do {
            getCost();
        } while (!lottoPurchaser.checkNumberOfLottos());
    }

    private void getCost() {
        try {
            lottoPurchaser.setNumberOfLottos(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public Lottos createLottos() {
        lottos = new Lottos(addLottos());
        return lottos;
    }

    // TODO 3항연산자 사용 X
    public List<Lotto> addLottos() {
        List<Lotto> allLottos = new ArrayList<>();
        for (int i = 0; i < lottoPurchaser.getNumberOfLottos(); i++) {
            List<Integer> randomNumber = getRandomNumber();
            randomNumber.sort(Comparator.naturalOrder());
            allLottos.add(new Lotto(randomNumber));
        }
        return allLottos;
    }

    // TODO 숫자 상수로 빼기
    private List<Integer> getRandomNumber() {
        List<Integer> beforeSorted = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new ArrayList<>(beforeSorted);
    }

    public void getRightLuckyNumbers() {
        boolean success = false;
        do {
            success = getLuckyNumbers();
        } while (success == false);
    }

    private boolean getLuckyNumbers() {
        try {
            luckyNumbers = new Lotto(Console.readLine());
            return true;
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            return false;
        }
    }

    public void getRightBonusNumber() {
        boolean success;
        do {
            success = getBonusNumber();
        } while(success == false);
    }

    private boolean getBonusNumber() {
        try {
            bonusNumber.setBonusNumber(Console.readLine());
            checkDuplicatedBonusNumber(bonusNumber, luckyNumbers.getNumbers());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void checkDuplicatedBonusNumber(BonusNumber bonusNumber, List<Integer> luckyNumbers) {
        if (luckyNumbers.stream()
                .anyMatch(number -> Objects.equals(number, bonusNumber.getBonusNumber()))) {
            bonusNumber.setBonusNumber(null);
            throw new IllegalArgumentException(ErrorMessage.WRONG_BONUS_NUMBER.getMessage());
        }
    }

    public void calculateStatistics() {
        statistics.temp(lottos, luckyNumbers, bonusNumber);
    }

    public void print() {
        System.out.println(statistics);
    }

    public void calculateProfitRatio () {
        int profit = statistics.calculateprofits();
        System.out.println("profit = " + profit);
        double profitRatio = ((double) profit / (lottoPurchaser.getNumberOfLottos()*1000)) * 100;
        BigDecimal bd = new BigDecimal(profitRatio);
        bd = bd.setScale(1, RoundingMode.HALF_UP);

        System.out.printf("총 수익률은 %.1f%%입니다.%n", bd);
    }

}
