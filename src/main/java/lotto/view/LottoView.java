package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.controller.dto.LottoDto;
import lotto.controller.dto.LottoInfoDto;
import lotto.controller.dto.LottosDto;
import lotto.controller.dto.WinningResultDto;
import lotto.io.Input;
import lotto.io.Output;

public class LottoView {

    private final Input input;
    private final Output output;

    public LottoView(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public int askPurchaseMoney() {
        output.println("구입금액을 입력해 주세요.");
        return input.getInteger();
    }

    public List<Integer> askLottoNumbers() {
        output.println("\n당첨 번호를 입력해 주세요.");
        return input.getIntegers();
    }

    public int askBonusNumber() {
        output.println("\n보너스 번호를 입력해 주세요.");
        return input.getInteger();
    }

    public void printLottos(LottosDto lottosDto) {
        List<LottoDto> findLottos = lottosDto.getLottos();
        System.out.printf("\n%d개를 구매했습니다.\n", findLottos.size());
        for (LottoDto lottoDto : findLottos) {
            output.println(lottoDto.getNumbers().toString());
        }
    }

    //메모 : List로 받으면될듯
    public void printWinningResult(WinningResultDto winningResultDto) {
        output.println("\n당첨 통계 \n---");
        Map<String, LottoInfoDto> winningResult = winningResultDto.getWinningResult();
        for (String key : winningResult.keySet()) {
            LottoInfoDto lottoInfoDto = winningResult.get(key);
            int matchCount = lottoInfoDto.getMatchCount();
            int money = lottoInfoDto.getMoney();
            boolean hasBonusNumber = lottoInfoDto.hasBonusNumber();
            int winningCount = lottoInfoDto.getWinningCount();
            String form = getForm(hasBonusNumber);
            output.printf(form, matchCount, money, winningCount);
        }
    }

    private static String getForm(boolean hasBonusNumber) {
        String form = "%d개 일치 (%,d원) - %d개 \n";
        if (hasBonusNumber) {
            form = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개 \n";
        }
        return form;
    }

    public void printWinningProfit(float rateOfReturn) {
        double result = Math.round(rateOfReturn * 100) / 100.0;
        output.printf("총 수익률은 %.1f%%입니다.", result);
    }

    public void printErrorMessage(String errorMessage) {
        output.println(errorMessage);
    }
}
