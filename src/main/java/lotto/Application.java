package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.User;
import lotto.ui.Computer;

public class Application {


    // domain? - Seller
    public static List<Lotto> createLottos(Integer lottoCount){
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Computer.calculateLottoNumber());
        }
        return lottos;
    }

    // ui - 출력
    public static void printLottos(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            List<Integer> sortedLotto = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedLotto);
            System.out.println(sortedLotto);
        }
    }

    public static Lotto createWinningLotto(){
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

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Lotto> lottos = new ArrayList<>();

        User user = new User();
        Computer computer = new Computer();
        user.purchaseLotto();

        // 로또 개수 만큼 번호 계산
        Application.createLottos(user.lottoCount);

        // 4. 로또 번호 출력
        Application.printLottos(lottos);

        // 5. 당첨 번호 입력
        Lotto winningLotto = createWinningLotto();

        // 6. 보너스 번호 입력
        isRunning = true;
        Integer bonusNumber = null;
        while (isRunning) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String userInput = computer.getInput();

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

        // 7. 당첨 내역 계산 로직
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
        List<Integer> prizeMoney = new ArrayList<>(Arrays.asList(2000000000, 30000000, 1500000, 50000, 5000));
        int sum = 0;
        Double rateInvestment;

        // 8. 수익률 계산 로직
        for (int i = 0; i < lottoResult.size(); i++) {
            sum += lottoResult.get(i) * prizeMoney.get(i);
        }

        rateInvestment = ((double) sum / (user.lottoCount * 1000)) * 100;

        // 9. 당첨 결과 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.get(0) + "개");

        // 10. 수익률 출력

        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateInvestment);

    }
}
