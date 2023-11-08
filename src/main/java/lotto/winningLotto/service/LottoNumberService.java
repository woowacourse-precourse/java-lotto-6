package lotto.winningLotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.StringCalculator;
import lotto.winningLotto.domain.LottoNumber;

public class LottoNumberService {
    private static final String ERROR_TAG = "[ERROR]";
    private static final String REENTER_WINNING_NUM_MSG = "당첨 번호를 다시 입력해 주세요.";
    private static final String SPACE_BAR = " ";

    public LottoNumber createLottoNumber() {
        while (true) {
            try {
                return new LottoNumber(StringCalculator.withOutSpaceBarAndSplitAndPositives(readLine()));
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TAG + SPACE_BAR + REENTER_WINNING_NUM_MSG);
            } catch (NullPointerException e) {
                System.out.println(ERROR_TAG + SPACE_BAR + REENTER_WINNING_NUM_MSG);
            }
        }
    }
}
