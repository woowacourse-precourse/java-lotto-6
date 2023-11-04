package lotto.view;

import static lotto.common.InputOutputMessages.INPUT_BONUS_NUMBER;
import static lotto.common.InputOutputMessages.INPUT_MONEY;
import static lotto.common.InputOutputMessages.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import java.util.function.Function;
import lotto.common.InputOutputMessages;
import lotto.common.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.dto.LottoGameResponse;

public class InputOutputView {

    public Money inputMoney() {
        return getUserInput(INPUT_MONEY, Money::new);
    }

    public Lotto inputWinningNumbers() {
        return getUserInput(INPUT_WINNING_NUMBER, Lotto::createLotto);
    }

    public int inputBonusNumber() {
        return getUserInput(INPUT_BONUS_NUMBER, Integer::parseInt);
    }

    public <T> T getUserInput(InputOutputMessages inputMessage, Function<String, T> parser) {
        System.out.println(inputMessage.getMessage());
        while (true) {
            try {
                String input = Console.readLine();
                return parser.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public void printBuyLottos(LottoGameResponse lottoGameResponse) {
        System.out.printf("%s개를 구매했습니다.\n", lottoGameResponse.getCount());
        for (int i = 0; i < lottoGameResponse.getCount(); i++) {
            System.out.println(lottoGameResponse.getBuyLottoNumbers().get(i));
        }
    }

    public void printResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %s개\n", result.getOrDefault(LottoRank.FIFTH_RANK, 0));
        System.out.printf("4개 일치 (50,000원) - %s개\n", result.getOrDefault(LottoRank.FOURTH_RANK, 0));
        System.out.printf("5개 일치 (1,500,000원) - %s개\n", result.getOrDefault(LottoRank.THIRD_RANK, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n", result.getOrDefault(LottoRank.SECOND_RANK, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %s개\n", result.getOrDefault(LottoRank.FIRST_RANK, 0));
        System.out.println("총 수익률은 62.5%입니다.");
    }
}
