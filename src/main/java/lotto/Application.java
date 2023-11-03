package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = LottoUtil.parseInt(Console.readLine());

        List<Lotto> lottoList = LottoUtil.createLottoList(amount);
        LottoUtil.printLottoList(lottoList);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> integerList = LottoUtil.parseNumberToListInteger(Console.readLine());

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        LottoTarget lottoTarget = new LottoTarget(new Lotto(integerList), bonusNumber);
        List<ResultStatus> resultStatusList = LottoUtil.gradingLottoListWithLottoTarget(lottoTarget, lottoList);
        LottoUtil.printResult(resultStatusList, amount);
    }
}
