package lotto.console.game.lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.console.game.Game;
import lotto.console.game.lotto.constants.GameMessages;
import lotto.console.game.lotto.core.Lotto;
import lotto.console.game.lotto.core.Player;
import lotto.console.game.lotto.core.PrizeDetail;
import lotto.console.game.lotto.core.PrizeHandler;

import java.util.List;

public class LottoGame implements Game {
    private Player player;
    private PrizeHandler prizeHandler;

    public LottoGame() {

    }

    public void createPlayer(Player player) {
        this.player = player;
    }

    public void createPrizeHandler(PrizeHandler prizeHandler) {
        this.prizeHandler = prizeHandler;
    }

    @Override
    public void start(){
        createPlayer(new Player(enterPurchaseMoney()));
        player.issueLottoTickets();
        printPurchasedCount(player.getIssuedQuantity());
        printIssuedLottos(player.getIssuedLottos());

        createPrizeHandler(new PrizeHandler());
        prizeHandler.registerWinningNumbers(enterWinningNumbers());
        prizeHandler.registerBonusNumber(enterBonusNumber());

        PrizeDetail prizeDetail = prizeHandler.generatePrizeDetailByLottos(player.getIssuedLottos());
        printPrizeDetail(prizeDetail);
        player.receivePrizeDetail(prizeDetail);
        printProfitRate(player.getProfitRate());
    }



    private int enterPurchaseMoney() {
        printGameMessage(GameMessages.ENTER_YOUR_PURCHASE_AMOUNT);

        String moneyInput = null;
        boolean isVaild = false;
        while (!isVaild) {
            moneyInput = Console.readLine();
            isVaild = validateMoneyInput(moneyInput);
        }
        return LottoGameInputConverter.convertMoney(moneyInput);
    }

    private boolean validateMoneyInput(String moneyInput) {
        try{
            LottoGameInputValidater.validateMoney(moneyInput);
            return true;
        } catch (IllegalArgumentException e) {
            printGameMessage(e.getMessage());
            return false;
        }
    }

    private List<Integer> enterWinningNumbers() {
        printGameMessage(GameMessages.ENTER_YOUR_WINNING_NUMBER);

        String numbersInput = null;
        boolean isVaild = false;
        while (!isVaild) {
            numbersInput = Console.readLine();
            isVaild = validateNumbersInput(numbersInput);
        }
        return LottoGameInputConverter.convertNumbers(numbersInput);
    }

    private boolean validateNumbersInput(String numbersInput) {
        try {
            LottoGameInputValidater.validateNumbers(numbersInput);
            return true;
        } catch (IllegalArgumentException e) {
            printGameMessage(e.getMessage());
            return false;
        }
    }

    private int enterBonusNumber() {
        printGameMessage(GameMessages.ENTER_YOUR_BONUS_NUMBER);

        String numberInput = null;
        boolean isVaild = false;
        while (!isVaild) {
            numberInput = Console.readLine();
            isVaild = validateNumberInput(numberInput);
        }
        return LottoGameInputConverter.convertNumber(numberInput);
    }

    private boolean validateNumberInput(String numberInput) {
        try {
            LottoGameInputValidater.validateNumber(numberInput);
            return true;
        } catch (IllegalArgumentException e) {
            printGameMessage(e.getMessage());
            return false;
        }
    }

    private void printPurchasedCount(int issuedQuantity) {
        printGameMessage(issuedQuantity + GameMessages.YOUR_PURCHASED_COUNT);
    }

    private void printIssuedLottos(List<Lotto> issuedLottos) {
        issuedLottos.stream()
                .map(Lotto::indicateNumbers)
                .forEach(System.out::println);
    }

    private void printPrizeDetail(PrizeDetail prizeDetail) {
        printGameMessage(prizeDetail.exportMessage());
    }

    private void printProfitRate(String profitRate) {
        printGameMessage(GameMessages.YOUR_PROFIT_RATE_PREFIX + profitRate + GameMessages.YOUR_PROFIT_RATE_POSTFIX);
    }

    private void printGameMessage(String message){
        System.out.println(message);
    }

}
