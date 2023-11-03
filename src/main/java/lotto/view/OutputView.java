package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.dto.LottosDto;
import lotto.dto.RanksDto;
import lotto.dto.RateOfReturnDto;

import java.util.List;


public class OutputView {

    private static final String errorMessage = "[ERROR]";
    private static final String purchaseMessage = "%d개를 구매했습니다.";
    private static final String oneLottoMessage = "[%d, %d, %d, %d, %d, %d]";
    private static final String resultTitleMessage = "당첨 통계\n" + "---";
    private static final Prize[] prizes = Prize.values();
    private static final String[] countsMessage = {
            "6개 일치 ",
            "5개 일치, 보너스 볼 일치 ",
            "5개 일치 ",
            "4개 일치 ",
            "3개 일치 "};
    private static final String rateOfReturnMessage = "총 수익률은 %.1f%%입니다.";


    public void outputErrorMessage(Exception e) {
        System.out.print(errorMessage);
        System.out.println(" "+e.getMessage());
    }

    public void outputLottosMessage(LottosDto dto) {
        Lotto[] lottos = dto.lottos();
        System.out.println();
        System.out.println(purchaseMessage.formatted(lottos.length));
        for (Lotto lotto : lottos) {
            outputLottoMessage(lotto);
        }
    }

    public void outputResultMessage(RanksDto dto) {
        System.out.println();
        System.out.println(resultTitleMessage);
        int[] ranks = dto.ranks();
        for (int i = ranks.length - 1; i >= 0; i--) {
            System.out.println(countsMessage[i] + "(" + prizes[i].getStrMoney() +"원)" + " - %d개".formatted(ranks[i]));
        }
    }

    public void outputRateOfReturnMessage(RateOfReturnDto dto) {
        System.out.println(rateOfReturnMessage.formatted(dto.rate()));
    }

    private void outputLottoMessage(Lotto lotto) {
        List<Integer> list = lotto.getNumbers();
        int[] numbers = list.stream().sorted().mapToInt(Integer::intValue).toArray();
        System.out.println(oneLottoMessage.formatted(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5]));
    }

}
