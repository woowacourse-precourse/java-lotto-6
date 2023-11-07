package lotto.view;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private int lottoPurchase;
    private List<Integer> lotto;
    private int bonusNumber;

    public InputView() {
        this.lottoPurchase = Integer.parseInt(readLine());
        this.lotto = inputLotto();

    }

    private List<Integer> inputLotto() {

        List<Integer> lotto = new ArrayList<>();

        String[] strLotto = readLine().split(",");

        for(String str : strLotto) {
            lotto.add(Integer.valueOf(str));
        }

        return lotto;
    }


}
