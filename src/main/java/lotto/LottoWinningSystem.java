package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Lotto.MAX_LOTTONUMBER;
import static lotto.Lotto.MIN_LOTTONUMBER;

public class LottoWinningSystem {
    int matchesThreeNumber;
    int matchesFourNumber;
    int matchesFiveNumber;
    int matchesFiveAndBonusNumber;
    int matchesSixNumber;
    private Lotto lotto;

    void winningNumber(String numbers) {
        List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        lotto = new Lotto(winningNumbers);
    }

    void bonusNumber(int number) {
        validateBonusNumber(number);
        lotto.setBonusNumber(number);
    }

    private void validateBonusNumber(int number) {
        if(MIN_LOTTONUMBER >= number && number <= MAX_LOTTONUMBER) {
            throw new IllegalArgumentException("[ERROR] 당첨번호의 숫자는 1~45사이입니다");
        }
    }

    public List<Integer> winningCheck(List<List<Integer>> randomNumbers) {
        List<List<Integer>> randoms = randomNumbers;
        System.out.println(randoms);
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        List<Integer> winningAmounts = new ArrayList<>();
        int bonusNumber = lotto.getBonusNumber();

        for (List<Integer> randomNumberList : randomNumbers) {
            int count = (int) randomNumberList.stream().filter(lottoNumbers::contains).count();

            if (count == 5 && randomNumberList.contains(bonusNumber)) {
                count += 2; // 일치하는 숫자가 5개이고 보너스 번호도 일치하는 경우
            }

            winningAmounts.add(count);
        }

        return winningAmounts;
    }


    public void winningStatics(List<Integer> winningAmounts) {
        for (int winningamount : winningAmounts) {
            if (winningamount == 3) {
                matchesThreeNumber++;
            }
            if (winningamount == 4) {
                matchesFourNumber++;
            }
            if (winningamount == 5) {
                matchesFiveNumber++;
            }
            if (winningamount == 7) {
                matchesFiveAndBonusNumber++;
            }
            if (winningamount == 6) {
                matchesSixNumber++;
            }
        }
    }

}
