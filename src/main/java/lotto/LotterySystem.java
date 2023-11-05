package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input.Price;

import java.util.List;
import java.util.ArrayList;

public class LotterySystem {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NEED_NUMBER = 6;
    private static int lottoCnt = 0;
    private lotto.input.Price Price = new Price();
    private lotto.ErrorMessages ErrorMessages = new ErrorMessages();
//    private Draw Draw = new Draw();

    private List<Integer> drawed =  new ArrayList<>();



    public void input() {
        lottoCnt = Price.purchase();
    }

    private void draw(List<Integer> numbers) {
        for (int i = 0; i < lottoCnt; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
    }
}
