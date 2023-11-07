package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {
    private static final LottoInputView instance = new LottoInputView();

    private LottoInputView(){
    }

    public static LottoInputView getInstance(){
        return instance;
    }

    public String purchasePriceInput(){
        System.out.println(LottoMessage.PURCHASE_PRICE_INPUT_MESSAGE.getMessage());
        String purchasePrice = Console.readLine();
        return purchasePrice;
    }

    public String lottoWinningNumbersInput(){
        System.out.println(LottoMessage.WINNING_NUMBER_INPUT_MESSAGE.getMessage());
        String winningNumbers = Console.readLine();

        return winningNumbers;
    }

    public String bonusNumberInput(){
        System.out.println(LottoMessage.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

}
