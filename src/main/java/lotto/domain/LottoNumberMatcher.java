package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumberMatcher {

    private final List<Rank> matchedLottoRank = Arrays.asList();

    private List<Lotto> randomLottos = new ArrayList<>();
    private Lotto mainLotto;
    private BonusLotto bonus;

    public LottoNumberMatcher(RandomLotto randomLotto, UserLotto userLotto) {
        randomLottos = randomLotto.getRandomLottoNumbers();
        mainLotto = userLotto.getMainLottoNumber();
        bonus = userLotto.getBonusNumber();
    }

    public List<Rank> getMatchedLottoRank() { ///이름 마음에 안듬
        List<Integer> userMainNumber = mainLotto.getNumbers();

        for (Lotto lotto : randomLottos) {
            List<Integer> randomNumber = lotto.getNumbers();

            int matchingCount = countMatchingNumbers(randomNumber, userMainNumber);
            boolean hasBonus = hasBonusNumber(randomNumber);

            System.out.println(randomNumber);
            System.out.println(matchingCount);
            System.out.println(hasBonus);

        }
        return matchedLottoRank;
    }

    private int countMatchingNumbers(List<Integer> randomNum, List<Integer> userNum) {
        List<Integer> conbinedNumbers = toConbinedList(randomNum, userNum);
        
        int numbersWithDuplicates = conbinedNumbers.size();
        int numbersWithoutDuplicates = (int) conbinedNumbers.stream().distinct().count();

        return calculateMatchingNumbers(numbersWithDuplicates, numbersWithoutDuplicates);
    }

    private List<Integer> toConbinedList(List<Integer> randomNum, List<Integer> userNum) {
        return Stream.concat(randomNum.stream(), userNum.stream())
                .collect(Collectors.toList());
    }

    private int calculateMatchingNumbers(int allNumbers, int distinctNumbers) {
        return (allNumbers - distinctNumbers);
    }

    private boolean hasBonusNumber(List<Integer> randomLotto) {
        return randomLotto.contains(bonus.getBonusNumber());
    }


}
