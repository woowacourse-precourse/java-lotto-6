package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;

public class LottoGame {

    LottoManager lottoManager = LottoManager.getInstance();
    Lotto luckyNumbers = null;

    public void getRightCost() {
        do {
            getCost();
        } while (!lottoManager.checkNumberOfLottos());
    }

    private void getCost() {
        try {
            lottoManager.setNumberOfLottos(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // TODO 3항연산자 사용 X
    public List<Lotto> addLottos() {
        List<Lotto> allLottos = new ArrayList<>();
        for (int i = 0; i < lottoManager.getNumberOfLottos(); i++) {
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
            System.out.println("wrong" + luckyNumbers);
        } while (luckyNumbers==null);
        System.out.println("right" + luckyNumbers);
    }

    private void getLuckyNumbers() {
        try {
            luckyNumbers = new Lotto(lottoManager.setLuckyNumbers(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
