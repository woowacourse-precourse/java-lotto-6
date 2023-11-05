package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class LotterySystem {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NEED_NUMBER = 6;
    public static int turn = 0;
    private InputSystem InputSystem = new InputSystem();
    private ErrorMessages ErrorMessages = new ErrorMessages();
//    private Draw Draw = new Draw();

    private List<Integer> drawed =  new ArrayList<>();


    public void input() {
        InputSystem.purchase(drawed);

    }

    private void draw(List<Integer> numbers) {
        for (int i = 0; i < turn; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
    }
}
