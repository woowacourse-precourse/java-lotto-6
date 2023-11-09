package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;
import lotto.constant.LottoRanking;
import lotto.model.Lotto;
import lotto.model.LottoPocket;
import lotto.util.IntegerParser;

public class View {
    private InputView inputView;
    private OutputView outputView;

    public View() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public int getMoney() {
        while (true) {
            try {
                String inputMoney = inputView.getInputMoney();
                outputView.printLine();
                int money = IntegerParser.parse(inputMoney);
                validateMoney(money);
                return money;
            } catch (NumberFormatException e) {
                outputView.printErrorMessage(ErrorMessage.NOT_INTEGER_ERROR);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public List<Integer> getLottoNumbers() {
        while (true) {
            try {
                String inputLottoNumbers = inputView.getInputLottoNumbers();
                outputView.printLine();
                return IntegerParser.parse(Arrays.asList(inputLottoNumbers.split(",")));
            } catch (NumberFormatException e) {
                outputView.printErrorMessage(ErrorMessage.NOT_INTEGER_ERROR);
            }
        }
    }

    public int getBonusNumber() {
        while (true) {
            try {
                String inputBonusNumber = inputView.getInputBonusNumber();
                outputView.printLine();
                return IntegerParser.parse(inputBonusNumber);
            } catch (NumberFormatException e) {
                outputView.printErrorMessage(ErrorMessage.NOT_INTEGER_ERROR);
            }
        }
    }

    public void printLottosInfo(List<Lotto> lottos) {
        outputView.printLottoCountMessage(lottos.size());
        lottos.forEach(lotto -> outputView.printLottoNumber(lotto));
        outputView.printLine();
    }

    public void printLottoRanking(LottoPocket lottoPocket) {
        outputView.printRankingMessage();
        for (LottoRanking ranking : LottoRanking.values()) {
            if (!ranking.equals(LottoRanking.NONE)) {
                outputView.printRankingInfo(ranking, lottoPocket.getRankingCount(ranking));
            }
        }
    }

    public void printRateOfReturn(double rate) {
        outputView.printRateOfReturn(rate);
    }

    public void printErrorMessage(String message) {
        outputView.printErrorMessage(message);
    }

    private void validateMoney(int money) {
        if (money < LottoConstant.LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_MONEY_ERROR);
        }
        if (money % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INAPPROPRIATE_MONEY_ERROR);
        }
    }
}
