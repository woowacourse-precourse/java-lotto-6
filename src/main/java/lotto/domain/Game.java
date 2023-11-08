package lotto.domain;

import lotto.constants.DomainMessages;
import lotto.constants.LottoValues;
import lotto.constants.WinningType;
import lotto.util.ConsolePrinter;
import lotto.util.NumberGenerator;
import lotto.util.UserInputHandler;

public class Game {
    private Lottos lottos;
    private Winning winning;
    private Integer lottosSize;
    private WinningCalculator calculator;

    public Game(WinningCalculator calculator) {
        this.calculator = calculator;
    }

    public void start() {
        purchaseLotto();
        checkLottoNumbers();
        selectWinningNumbers();
        checkWinningStatics();
    }

    private void purchaseLotto() {
        ConsolePrinter.showMessage(DomainMessages.PROMPT_LOTTO_PURCHASE_AMOUNT);
        Integer amount = UserInputHandler.getLottoPurchaseAmount();
        lottosSize = amount / LottoValues.AMOUNT_UNIT.getValue();
        lottos = NumberGenerator.createLottos(lottosSize);
        ConsolePrinter.showNewLine();
    }

    private void checkLottoNumbers() {
        ConsolePrinter.showMessageWithNumber(DomainMessages.LOTTO_PURCHASE_COUNT, lottosSize);
        ConsolePrinter.showLottos(lottos);
        ConsolePrinter.showNewLine();
    }

    private void selectWinningNumbers() {
        ConsolePrinter.showMessage(DomainMessages.PROMPT_WINNING_NUMBERS);
        winning = new Winning(UserInputHandler.getWinningNumbers());
        ConsolePrinter.showNewLine();

        ConsolePrinter.showMessage(DomainMessages.PROMPT_WINNING_BONUS_NUMBER);
        winning.setBonusNumber(UserInputHandler.getBonusNumber(winning.getNumbers()));
        ConsolePrinter.showNewLine();
    }

    private void checkWinningStatics() {
        calculator.caculate(lottos, winning);
        ConsolePrinter.showMessage(DomainMessages.WINNING_STATICS_TOP_BANNER);
        ConsolePrinter.showMessageWithNumber(DomainMessages.FIFTH_PLACE_MESSAGE,
                calculator.getCount(WinningType.FIFTH));
        ConsolePrinter.showMessageWithNumber(DomainMessages.FOURTH_PLACE_MESSAGE,
                calculator.getCount(WinningType.FOURTH));
        ConsolePrinter.showMessageWithNumber(DomainMessages.THIRD_PLACE_MESSAGE,
                calculator.getCount(WinningType.THIRD));
        ConsolePrinter.showMessageWithNumber(DomainMessages.SECOND_PLACE_MESSAGE,
                calculator.getCount(WinningType.SECOND));
        ConsolePrinter.showMessageWithNumber(DomainMessages.FIRST_PLACE_MESSAGE,
                calculator.getCount(WinningType.FIRST));

        checkProfitMargin();
    }

    private void checkProfitMargin() {
        Integer lottoPurchaseAmount = lottosSize * LottoValues.AMOUNT_UNIT.getValue();
        Double profitRate = calculator.calculateProfitMargin(lottoPurchaseAmount);
        ConsolePrinter.showTotalReturn(profitRate);
    }
}
