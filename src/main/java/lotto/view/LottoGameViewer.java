package lotto.view;

import static lotto.engine.LottoSystemConstant.TextMessage.ERROR_PREFIX;
import static lotto.engine.LottoSystemConstant.TextMessage.INPUT_BONUS_NUMBER;
import static lotto.engine.LottoSystemConstant.TextMessage.INPUT_MONEY_FOR_BUYING_LOTTO;
import static lotto.engine.LottoSystemConstant.TextMessage.INPUT_WINNING_NUMBERS_LOTTO;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.common.Message;
import lotto.common.Validator;

public class LottoGameViewer {

    private final LottoGameViewerMapper lottoGameViewerMapper;

    public LottoGameViewer(LottoGameViewerMapper lottoGameViewerMapper) {
        this.lottoGameViewerMapper = lottoGameViewerMapper;
    }

    public int interactForBuyLotto() {
        boolean isRetry = true;
        String money = input(INPUT_MONEY_FOR_BUYING_LOTTO);

        while (isRetry) {
            try {
                //todo: 유효성 검증
                isRetry = false;
            } catch (IllegalArgumentException exception) {
                println(() -> ERROR_PREFIX.getMessage() + exception.getMessage());
                money = input();
            }
        }

        return lottoGameViewerMapper.toInt(money);
    }


    public List<Integer> interactForWinningNumber() {
        boolean isRetry = true;
        String winningNumbers = input(INPUT_WINNING_NUMBERS_LOTTO);

        while (isRetry) {
            try {
                //todo: 유효성 검증
                isRetry = false;
            } catch (IllegalArgumentException exception) {
                println(() -> ERROR_PREFIX.getMessage() + exception.getMessage());
                winningNumbers = input();
            }
        }

        return lottoGameViewerMapper.toLottoNumbers(winningNumbers);
    }

    public int interactForBonusNumber() {
        boolean isRetry = true;
        String bonusNumber = input(INPUT_BONUS_NUMBER);

        while (isRetry) {
            try {
                //todo: 유효성 검증
                isRetry = false;
            } catch (IllegalArgumentException exception) {
                println(() -> ERROR_PREFIX.getMessage() + exception.getMessage());
                bonusNumber = input();
            }
        }

        return lottoGameViewerMapper.toInt(bonusNumber);
    }

    public void println(Message message) {
        System.out.println(message.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }

    protected String input(Message message) {
        println(message);
        return Console.readLine();
    }

    protected String input() {
        return Console.readLine();
    }
}
