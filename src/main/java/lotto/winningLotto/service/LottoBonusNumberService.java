package lotto.winningLotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.Positive;
import lotto.winningLotto.domain.LottoBonusNumber;

public class LottoBonusNumberService {

    public LottoBonusNumber createLottoBonusNumber() {
        while (true) {
            try {
                return new LottoBonusNumber(new Positive(readLine()));
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨 번호를 다시 입력해 주세요.\n");
            } catch (NullPointerException e) {
                System.out.println("[ERROR] 당첨 번호를 다시 입력해 주세요.\n");
            }
        }


    }


}
