package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = LottoUtil.parseInt(Console.readLine());

        List<Lotto> lottoList = LottoUtil.createLottoList(amount);
        printLottoList(lottoList);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> integerList = LottoUtil.parseNumberToListInteger(Console.readLine());

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        LottoTarget lottoTarget = new LottoTarget(new Lotto(integerList), bonusNumber);
        List<ResultStatus> resultStatusList = gradingLottoListWithLottoTarget(lottoTarget, lottoList);
        printResult(resultStatusList, amount);
    }

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.println("\n" + lottoList.size() + "개를 구매했습니다.");

        lottoList.forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    public static List<ResultStatus> gradingLottoListWithLottoTarget(LottoTarget lottoTarget, List<Lotto> lottoList) {
        List<ResultStatus> resultStatusList = new ArrayList<>();

        for (int i = 0; i < lottoList.size(); i++) {
            resultStatusList.add(lottoTarget.grading(lottoList.get(i)));
        }

        return resultStatusList;
    }

    public static void printResult(List<ResultStatus> resultStatusList, int amount) {
        long three = resultStatusList.stream().filter(status -> status == ResultStatus.THREE).count();
        long four = resultStatusList.stream().filter(status -> status == ResultStatus.FOUR).count();
        long five = resultStatusList.stream().filter(status -> status == ResultStatus.FIVE).count();
        long bonus = resultStatusList.stream().filter(status -> status == ResultStatus.BONUS).count();
        long six = resultStatusList.stream().filter(status -> status == ResultStatus.SIX).count();
        float rate = LottoUtil.calculateRate(
                three * 5000 + four * 50000 + five * 1500000 + bonus * 30000000 + six * 2000000000,
                amount);

        DecimalFormat df = new DecimalFormat("0.0%");
        String formatted = df.format(rate);

        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + bonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");
        System.out.println("총 수익률은 " + formatted + "입니다.");
    }
}
