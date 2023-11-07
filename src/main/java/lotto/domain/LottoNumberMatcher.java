package lotto.domain;

import lotto.domain.lottos.BonusLotto;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.RandomLotto;
import lotto.domain.lottos.UserLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumberMatcher {
    private List<Lotto> randomLottos;
    private Lotto mainLotto;
    private BonusLotto bonus;
    private final List<Rank> matchedLottoRank = new ArrayList<>();

    public LottoNumberMatcher(RandomLotto randomLotto, UserLotto userLotto) {
        randomLottos = randomLotto.getRandomLottoNumbers();
        mainLotto = userLotto.getMainLottoNumber();
        bonus = userLotto.getBonusNumber();
    }

    public List<Rank> getMatchedLottoRank() {
        List<Integer> userMainNumber = mainLotto.getNumbers();

        for (Lotto lotto : randomLottos) {
            List<Integer> randomNumber = lotto.getNumbers();
            int matchingCount = countMatchingNumbers(randomNumber, userMainNumber);
            boolean hasBonus = hasBonusNumber(randomNumber);

            matchedLottoRank.add(Rank.findRank(matchingCount, hasBonus));
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
        //합친 리스크의 크기 - 중복을 삭제한 리스트의 크기 = 중복된 숫자의 개수
        return (allNumbers - distinctNumbers);
    }

    private boolean hasBonusNumber(List<Integer> randomLotto) {
        return randomLotto.contains(bonus.getBonusNumber());
    }

}
