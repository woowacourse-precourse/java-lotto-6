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

    public List<Integer> makeLotto(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getMyWinning(int winningNumber) {
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
}
