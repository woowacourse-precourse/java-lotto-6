package lotto.winningLotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.Positive;
import lotto.winningLotto.domain.LottoBonusNumber;

public class LottoBonusNumberService {
    private static final String ERROR_TAG = "[ERROR]";
    private static final String REENTER_WINNING_NUM_MSG = "보너스 번호를 다시 입력해 주세요.";
    private static final String SPACE_BAR = " ";


    public LottoBonusNumber createLottoBonusNumber() {
        while (true) {
            try {
                return new LottoBonusNumber(new Positive(readLine()));
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TAG + SPACE_BAR + REENTER_WINNING_NUM_MSG);
            } catch (NullPointerException e) {
                System.out.println(ERROR_TAG + SPACE_BAR + REENTER_WINNING_NUM_MSG);
            }
        }


    }


}
