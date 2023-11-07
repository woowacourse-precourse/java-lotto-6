package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    static final int START_NUMBER = 1;
    static final int END_NUMBER = 45;
    static final int COUNT_NUMBER = 6;
    enum WINNING {
        THREE(0),
        FOUR(0),
        FIVE(0),
        FIVE_BONUS(0),
        SIX(0);

        private int value;

        WINNING(int value) {
            this.value = value;
        }

        void addValue() {

        }
        int getValue() {
            return value;
        }
    }

    int getInput() {
        int parsedInput;

        String input = Console.readLine();

        while (true) {
            try {
                parsedInput = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
        }

        return parsedInput;
    }

    List<Integer> getInputForNumbers() {
        List<Integer> parsedInput = new ArrayList<>();

        String input = Console.readLine();

        List<String> splitedInput = Arrays.asList(input.split(","));

        for (int i = 0; i < splitedInput.size(); i++) {
            parsedInput.add(Integer.parseInt(splitedInput.get(i)));
        }

        return parsedInput;
    }

    int getTicket(int cash) {
        int ticket;

        if (cash % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        ticket = cash / 1000;

//        while (true) {
//            try {
//                ticket = validator.validateCash(parsedInput);
//                break;
//            } catch (IllegalArgumentException e) {
//                System.out.println("[ERROR] 구입금액은 1000원 단위이여야 합니다.");
//            }
//        }

        return ticket;
    }

    List<Integer> getRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_NUMBER);

        return randomNumbers;
    }

    Lotto getLotto() {
        List<Integer> randomNumbers = getRandomNumbers();

        Lotto lotto = new Lotto(randomNumbers);

        return lotto;
    }

    List<Lotto> getLottoBundle(int ticket) {
        List<Lotto> lottoBundle = new ArrayList<>();

        for (int i = 0 ; i < ticket; i++) {
            Lotto lotto = getLotto();
            lottoBundle.add(lotto);
        }

        return lottoBundle;
    }

    List<Integer> getWinningStatistics(List<Integer> winningNumbers, List<Lotto> lottoBundle) {
        List<Integer> winningStatistics = new ArrayList<>();

        for (int i = 0; i < lottoBundle.size(); i++) {
            Lotto lotto = lottoBundle.get(i);
            List<Integer> lottoNumbers = lotto.getNumbers();
            winningStatistics.add(compareWinningAndLotto(winningNumbers, lottoNumbers));
        }

        return winningStatistics;
    }

    int compareWinningAndLotto(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int containsCount = 0;
        int bonusNumberIndex = winningNumbers.size() - 1;

        // 마지막 번호인 보너스 번호를 제외하고 비교
        for (int i = 0; i < bonusNumberIndex; i++) {
            if (lottoNumbers.contains(winningNumbers.get(i))) {
                containsCount++;
            }
        }

        // 보너스 번호가 포함되어 있는지 확인
        if (lottoNumbers.contains(winningNumbers.get(bonusNumberIndex))) {
            containsCount++;
        }

        return containsCount;
    }

}
