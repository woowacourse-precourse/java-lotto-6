package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaser;
import lotto.errors.ErrorMessage;

public class LottoGame {

    LottoPurchaser lottoPurchaser = LottoPurchaser.getInstance();
    BonusNumber bonusNumber = new BonusNumber();
    Lotto luckyNumbers = null;

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
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void getRightLuckyNumbers() {
        do {
            getLuckyNumbers();
        } while (luckyNumbers==null);
    }

    private void getLuckyNumbers() {
        try {
            luckyNumbers = luckyNumbers.createNewLotto(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
                .anyMatch(number -> number == bonusNumber.getBonusNumber())) {
            bonusNumber.setBonusNumber(null);
            throw new IllegalArgumentException(ErrorMessage.WRONG_BONUS_NUMBER.getMessage());
        }
    }

    public void calculateStatistics() {

    }
}
