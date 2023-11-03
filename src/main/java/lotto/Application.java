package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.User;
import lotto.ui.Computer;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Lotto> lottos = new ArrayList<>();

        User user = new User();
        Computer computer = new Computer();
        user.purchaseLotto();

        // 로또 개수 만큼 번호 계산
        for (int i = 0; i < user.lottoCount; i++) {
            lottos.add(computer.calculateLottoNumber());
        }

        // 4. 로또 번호 출력
        for (Lotto lotto : lottos) {
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }

        // 5. 당첨 번호 입력
        List<Integer> lottoNumbers;
        boolean isRunning = true;
        while (isRunning) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<String> userInputs = Arrays.asList(computer.getInput().split(","));
                lottoNumbers = new ArrayList<>();

                for (String userInput : userInputs) {
                    computer.checkNumber(userInput);
                    computer.checkZero(userInput);

                    Integer lottoNumber = Integer.parseInt(userInput);
                    computer.checkRange(lottoNumber);

                    lottoNumbers.add(Integer.parseInt(userInput));
                }
                System.out.println(lottoNumbers);
                computer.checkDuplication(lottoNumbers);

                isRunning = false;

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
