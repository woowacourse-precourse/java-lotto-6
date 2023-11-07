package lotto.view;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private int lottoPurchase;
    private List<Integer> lotto;
    private int bonusNumber;

    public InputView() {
        this.lottoPurchase = inputLottoPurchase();
        this.lotto = inputLotto();
        this.bonusNumber = inputBonusNumber();

    }

    private int inputLottoPurchase() {
        int lottoPurchase;
        System.out.println("구입금액을 입력해 주세요.");

        lottoPurchase = Integer.parseInt(readLine());

        return lottoPurchase;

    }

    private List<Integer> inputLotto() {

        List<Integer> lotto = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");


        String[] strLotto = readLine().split(",");

        for(String str : strLotto) {
            lotto.add(Integer.valueOf(str));
        }

        return lotto;
    }

    private int inputBonusNumber() {
        int bonusNumber;
        System.out.println("보너스 번호를 입력해 주세요.");

        bonusNumber = Integer.parseInt(readLine());

        return bonusNumber;

    }


}
