package lotto.model;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.ErrorMessage;
import lotto.view.OutputView;

public class LottoUtil {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;

    public static List<Lotto> createLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
            System.out.println(numbers);
            lottoList.add(new Lotto(numbers));
        }

        return lottoList;
    }

    public static void validateAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            ErrorMessage.divisibleException();
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> parseNumberToListInteger(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static double calculateRate(long winningAmount, int amount) {
        return ((float) winningAmount / amount) * 100;
    }

    public static void printResult(List<ResultStatus> resultStatusList, int amount) {
        List<Long> countList = matchList(resultStatusList);
        OutputView.printSuccessMessage(countList, amount);
    }

    public static List<Long> matchList(List<ResultStatus> resultStatusList) {
        long three = resultStatusList.stream().filter(status -> status == ResultStatus.THREE).count();
        long four = resultStatusList.stream().filter(status -> status == ResultStatus.FOUR).count();
        long five = resultStatusList.stream().filter(status -> status == ResultStatus.FIVE).count();
        long bonus = resultStatusList.stream().filter(status -> status == ResultStatus.BONUS).count();
        long six = resultStatusList.stream().filter(status -> status == ResultStatus.SIX).count();

        return Arrays.asList(three, four, five, bonus, six);
    }

    public static List<ResultStatus> gradingLottoListWithLottoTarget(LottoTarget lottoTarget, List<Lotto> lottoList) {
        List<ResultStatus> resultStatusList = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            resultStatusList.add(lottoTarget.grading(lotto));
        }

        return resultStatusList;
    }
}
