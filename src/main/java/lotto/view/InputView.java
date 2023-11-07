package lotto.view;

import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private int lottoPurchase;
    private List<Integer> Lotto;
    private int bonusNumber;

    public InputView() {
        this.lottoPurchase = Integer.parseInt(readLine());

    }



}
