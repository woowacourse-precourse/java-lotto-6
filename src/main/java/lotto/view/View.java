package lotto.view;

import lotto.model.AnalysisResult;
import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.Arrays;
import java.util.List;

public class View {
    public static void requestMoney() {
        System.out.println(InputMessage.BUY_MONEY.getMessage());
    }

    public static void requestSixNumbers() {
        System.out.println(InputMessage.WINNING_LOTTO_NUMBER.getMessage());
    }

    public static void requestBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER.getMessage());
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(String.format(OutputMessage.BUY.getMessage(), lottos.size()));
        lottos.forEach((lotto) -> System.out.println(Arrays.toString(lotto.getNumbers().toArray())));
    }

    public static void printAnalysis(AnalysisResult analysisResult) {
        System.out.println(OutputMessage.Analysis.getMessage());
        analysisResult.getRankingcounter().forEach((lottoType, count) -> {
            System.out.print(String.format(OutputMessage.SAME.getMessage(), lottoType.getMatchCount()));
            if(lottoType == LottoResult.SECOND) {
                System.out.print(OutputMessage.SAME_BONUS.getMessage());
            }
            System.out.print(String.format(OutputMessage.COST.getMessage(), lottoType.getWinningMoney()));
            System.out.println(String.format(OutputMessage.COUNT.getMessage(), count));
        });
        System.out.println(String.format(OutputMessage.PROFIT.getMessage(),(float) analysisResult.getProfit()/ analysisResult.getCost()*100));
    }

    public static void printError(String message) {
        System.out.println(message);
    }
} enum InputMessage {
    BUY_MONEY("구입금액을 입력해 주세요."),
    WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 볼을 입력해 주세요.");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
enum OutputMessage {
    Analysis("당첨 통계\n---"),
    SAME("%s개 일치"),
    COST(" (%,d원) "),
    COUNT("- %s개"),
    PROFIT("총 수익률은 %.1f%%입니다."),
    BUY("%s개를 구매했습니다."),
    SAME_BONUS(", 보너스 볼 일치");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
