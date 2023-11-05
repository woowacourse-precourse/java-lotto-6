package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.ui.InputHandler;
import lotto.ui.OutputHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private final OutputHandler outputHandler;
    private final InputHandler inputHandler;

    public Application(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
        this.inputHandler = new InputHandler(this.outputHandler);
    }

    public static void main(String[] args) {
        OutputHandler outputHandler = new OutputHandler();
        Application application = new Application(outputHandler);
        application.run();

    }

    public void run () {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoBundle = new ArrayList<>();
        while (purchaseAmount != 0) {
            purchaseAmount -= 1000;
            List<Integer> numbers = generateNumbers();
            Collections.sort(numbers);
            lottoBundle.add(new Lotto(numbers));
        }
        System.out.println(lottoBundle.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.toString());
        }
        String userInput = inputHandler.getWinnerNumbers();
        List<Integer> winnerNumbers = Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .toList();
        int bonusNumber = inputHandler.getBonusNumber();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private int getPurchaseAmount() {
        try {
            return inputHandler.getValidPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }
}
