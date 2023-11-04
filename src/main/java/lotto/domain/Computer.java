package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.Validator;

public class Computer {
    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> sortedLotto = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedLotto);
            System.out.println(sortedLotto);
        }
    }

    public static Double calculateEarningRate(List<Integer> lottoResult, List<Integer> prizeMoney, Integer lottoCount) {
        int sum = 0;

        for (int i = 0; i < lottoResult.size(); i++) {
            sum += lottoResult.get(i) * prizeMoney.get(i);
        }

        return ((double) sum / (lottoCount * 1000)) * 100;

    }

    public static String getInput() {
        return Console.readLine();
    }

    // domain - createBonusNumber()같은곳으로
    public static List<Integer> checkWinning(List<Lotto> lottos, Lotto winningLotto, Integer bonusNumber) {
        int count;
        List<Integer> lottoResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        for (Lotto lotto : lottos) {
            count = 0;
            for (int i = 0; i < 6; i++) {
                if (lotto.getNumbers().contains(winningLotto.getNumbers().get(i))) {
                    count++;
                }
            }
            if (count == 6) {
                lottoResult.set(0, lottoResult.get(0) + 1);
                continue;
            }
            if (count == 5) {
                if (lotto.getNumbers().contains(bonusNumber)) {
                    lottoResult.set(1, lottoResult.get(1) + 1);
                    continue;
                }
                lottoResult.set(2, lottoResult.get(2) + 1);
                continue;
            }
            if (count == 4) {
                lottoResult.set(3, lottoResult.get(3) + 1);
                continue;
            }
            if (count == 3) {
                lottoResult.set(4, lottoResult.get(4) + 1);
            }
        }
        return lottoResult;
    }

    // domain? - Seller
    public static List<Lotto> createLottos(Integer lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private static Lotto generateLotto() {

        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));

    }

    public static Lotto createWinningLotto() {
        boolean isRunning = true;
        Lotto winningLotto = null;
        while (isRunning) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<String> userInputs = Arrays.asList(Computer.getInput().split(","));

                List<Integer> inputNumber = new ArrayList<>();

                for (String userInput : userInputs) {
                    Validator.checkNumber(userInput);
                    Validator.checkZero(userInput);

                    Integer lottoNumber = Integer.parseInt(userInput);
                    Validator.checkRange(lottoNumber);

                    inputNumber.add(Integer.parseInt(userInput));
                }
                System.out.println(inputNumber);
                winningLotto = new Lotto(inputNumber);

                isRunning = false;

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return winningLotto;
    }

    // domain - createWinningLotto()와 같은 곳으로
    public static Integer createBonusNumber(Lotto winningLotto) {
        boolean isRunning = true;
        Integer bonusNumber = null;
        while (isRunning) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String userInput = Computer.getInput();

                Validator.checkNumber(userInput);
                Validator.checkZero(userInput);

                bonusNumber = Integer.parseInt(userInput);
                Validator.checkRange(bonusNumber);
                winningLotto.checkInclusion(bonusNumber);

                isRunning = false;

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return bonusNumber;
    }

}
