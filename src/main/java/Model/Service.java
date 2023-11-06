package Model;

import static java.util.Arrays.asList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Service {
    private final Domain DOMAIN = Domain.getInstance();

    private Service() {
    }

    private class Singleton {
        private static final Service INSTANCE = new Service();
    }

    public static Service getInstance() {
        return Singleton.INSTANCE;
    }

    public List<Integer> lottoGenerator() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public int numberGenerator() {
        return Randoms.pickNumberInRange(1, 45);
    }

    private int numberFrequencyCount(List<Integer> list) {
        Set<Integer> set = new HashSet<>(DOMAIN.lottoWinningNumber);
        return (int) list.stream()
                .filter(set::contains)
                .count();
    }

    public void compareNumbers() {
        for (var e : Domain.getInstance().getMyLotto()) {
            DOMAIN.getCorrectNumberCount()
                    .add(numberFrequencyCount(e.getNumbers()));
        }
    }

    public void setPrice(int price) {
        DOMAIN.price = price;
    }

    public void setLottoWinningNumber(List<Integer> lottoWinningNumber) {
        DOMAIN.lottoWinningNumber = lottoWinningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        DOMAIN.bonusNumber = bonusNumber;
    }

    public List<Integer> makeLotto(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int getMyWinning(int winningNumber) {
        if(winningNumber == 1) {
            return Winnings.FIRST_PLACE.getValue();
        } else if(winningNumber == 2) {
            return Winnings.SECOND_PLACE.getValue();
        } else if(winningNumber == 3) {
            return Winnings.THIRD_PLACE.getValue();
        } else if(winningNumber == 4) {
            return Winnings.FOURTH_PLACE.getValue();
        } else if(winningNumber == 5) {
            return Winnings.FIFTH_PLACE.getValue();
        }
        throw new IllegalArgumentException("잘못된 값이 들어감");
    }

    public void setRevenueRate(int winningNumber) {
        DOMAIN.revenueRate = getMyWinning(winningNumber) / DOMAIN.price;
    }
}
