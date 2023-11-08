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

    List<Prize> getWinningStatistics(List<Integer> winningNumbers, List<Lotto> lottoBundle) {
        List<Prize> winningStatistics = new ArrayList<>();

        for (int i = 0; i < lottoBundle.size(); i++) {
            Lotto lotto = lottoBundle.get(i);
            List<Integer> lottoNumbers = lotto.getNumbers();
            Prize prize = compareWinningAndLotto(winningNumbers, lottoNumbers);
            winningStatistics.add(prize);
        }

        return winningStatistics;
    }

    Prize compareWinningAndLotto(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int generalCount = 0;
        int bonusCount = 0;
        int bonusNumberIndex = winningNumbers.size() - 1;
        int bouusNumber = winningNumbers.get(bonusNumberIndex);

        generalCount += countGeneralNumber(winningNumbers, lottoNumbers);
        bonusCount += countBonusNumber(bouusNumber, lottoNumbers);

        if (bonusCount < 1) {
            if (generalCount == 3) {
                return Prize.FIFTH;
            }
            if (generalCount == 4) {
                return Prize.FOURTH;
            }
            if (generalCount == 5) {
                return Prize.THIRD;
            }
            if (generalCount == 6) {
                return Prize.FIRST;
            }
        }

        if (bonusCount > 1 && generalCount == 5) {
            return Prize.SECOND;
        }

        return Prize.NONE;
    }

    int countGeneralNumber(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int generalCount = 0;
        int bonusNumberIndex = winningNumbers.size() - 1;

        for (int i = 0; i < bonusNumberIndex; i++) {
            if (lottoNumbers.contains(winningNumbers.get(i))) {
                generalCount++;
            }
        }

        return generalCount;
    }

    int countBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        int bonusCount = 0;

        if (lottoNumbers.contains(bonusNumber)) {
            bonusCount++;
        }

        return bonusCount;
    }

    float getRateOfReturn(int cash, List<Prize> winningStatistics) {
        float rateOfReturn;
        int prize = 0;

        for (int i = 0; i < winningStatistics.size(); i++) {
            prize += winningStatistics.get(i).getPrize();
        }

        rateOfReturn = (float) prize / cash * 100;

        return rateOfReturn;
    }
}