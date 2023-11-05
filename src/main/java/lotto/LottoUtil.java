package lotto;


import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {

    public static List<Lotto> createLottoList(int amount) {
        validateAmount(amount);

        int size = amount / 1000;
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
        }

        return lottoList;
    }

    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            ErrorMessage.divisibleException();
            throw new IllegalArgumentException();
        }
    }

    public static int parseInt(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            ErrorMessage.typeException();
//            throw new IllegalArgumentException(); 예외_테스트 시 에러발생하면 fail이 난다..
        }

        return 0;
    }

    public static List<Integer> parseNumberToListInteger(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String calculateRate(long winningAmount, int amount) {
        float rate = (float) winningAmount / amount;

        DecimalFormat df = new DecimalFormat("0.0%");

        return df.format(rate);
    }

    public static void printResult(List<ResultStatus> resultStatusList, int amount) {
        long three = resultStatusList.stream().filter(status -> status == ResultStatus.THREE).count();
        long four = resultStatusList.stream().filter(status -> status == ResultStatus.FOUR).count();
        long five = resultStatusList.stream().filter(status -> status == ResultStatus.FIVE).count();
        long bonus = resultStatusList.stream().filter(status -> status == ResultStatus.BONUS).count();
        long six = resultStatusList.stream().filter(status -> status == ResultStatus.SIX).count();

        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + bonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");
        System.out.println("총 수익률은 " + LottoUtil.calculateRate(
                three * 5000 + four * 50000 + five * 1500000 + bonus * 30000000 + six * 2000000000,
                amount) + "입니다.");
    }

    public static List<ResultStatus> gradingLottoListWithLottoTarget(LottoTarget lottoTarget, List<Lotto> lottoList) {
        List<ResultStatus> resultStatusList = new ArrayList<>();

        for (int i = 0; i < lottoList.size(); i++) {
            resultStatusList.add(lottoTarget.grading(lottoList.get(i)));
        }

        return resultStatusList;
    }

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.println("\n" + lottoList.size() + "개를 구매했습니다.");

        lottoList.forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }
}
