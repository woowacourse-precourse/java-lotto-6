package lotto;

import lotto.io.UserInput;
import lotto.io.UserOutput;

public class LottoGame {

    private final UserInput userInput;
    private final UserOutput userOutput;

    public LottoGame(UserInput userInput, UserOutput userOutput) {
        this.userInput = userInput;
        this.userOutput = userOutput;
    }

    public void play() {
        LottoPurchaseAmount lottoPurchaseAmount = createLottoPurchaseAmount();
    }

    private LottoPurchaseAmount createLottoPurchaseAmount() {
        userOutput.print("구입금액을 입력해 주세요.\n");

        String purchaseAmount = userInput.input();

        return new LottoPurchaseAmount(purchaseAmount);
    }
}
