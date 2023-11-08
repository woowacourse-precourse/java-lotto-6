package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Numbers {

    public List<Integer> createLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        int[] lottoNumbers = new int[randomNumbers.size()];

        for (int i = 0; i < randomNumbers.size(); i++) {
            lottoNumbers[i] = randomNumbers.get(i);
        }
        Arrays.sort(lottoNumbers);
        System.out.println(Arrays.toString(lottoNumbers));

        return randomNumbers;
    }

    public List<Integer> addLottoNumbers(int round) {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < round; i++) {
            List<Integer> roundNumbers = createLottoNumbers();
            lottoNumbers.addAll(roundNumbers);
        }

        return lottoNumbers;
    }

    public List<Integer> inputLuckyNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNumbers = Console.readLine();
        String[] numbers = inputNumbers.split(",");
        Integer[] luckyNumbers = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            luckyNumbers[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println();

        return Arrays.asList(luckyNumbers);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();

        return bonusNumber;
    }
}
