package lotto.Controller;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.*;
import lotto.Parser;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {
    private static final int LOW_NUMBER = 1;
    private static final int HIGH_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private PurchasePrice purchasePrice;
    private User user;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public void run() {
        this.purchasePrice = makeLottoQuantity();
        this.user = makeUser(purchasePrice.findLottoQuantity());
        this.winningNumbers = makeWinningNumbers();
        this.bonusNumber = makeBonusNumber(winningNumbers.getWinningNumbers());
        List<Integer> resultCount = makeResultCount();
        // resultCount : 각 rank별로 몇 개가 나왔는지 기록한 정수 리스트 (미당첨, 5등, 4등, 3등, 2등, 1등)
        OutputView.printResultHead();
        transmitOutput(resultCount);
        double profitRate = user.calculateProfitRate(resultCount);
        OutputView.printProfitRate(Parser.parseProfitRateFormat(profitRate));
    }

    private PurchasePrice makeLottoQuantity() {
        while (true) {
            try {
                String userInput = InputView.requestLottoPurchaseAmount();
                PurchasePrice purchasePrice = new PurchasePrice(Parser.parsePurchaseAmount(userInput));
                OutputView.printPurchaseLottoAmount(purchasePrice.findLottoQuantity());
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private User makeUser(int lottoQuantity) {
        User user;
        while (true) {		
            try {
                List<Lotto> lottos = makeLottos(lottoQuantity);
                user = new User(lottos, lottoQuantity);
                break;
            } catch (IllegalArgumentException e) {
            	OutputView.printErrorMessage(e.getMessage());
            }
        }
        return user;
    }

    private List<Lotto> makeLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            try {
                List<Integer> numbers = makeRandomNums();
                lottos.add(makeLotto(numbers));
                OutputView.printLottoNums(Parser.parseIntToString(numbers));
            } catch (IllegalArgumentException e) {
                i--;
            }
        }
        return lottos;
    }

    private List<Integer> makeRandomNums() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOW_NUMBER, HIGH_NUMBER, LOTTO_SIZE);
        return numbers;
    }

    private Lotto makeLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    private WinningNumbers makeWinningNumbers() {
        while (true) {
            try {
                String input = InputView.requestWinningNumbers();
                List<Integer> lottoWinningNumbers = Parser.parseWinningNumbers(input);
                WinningNumbers winningNumbers = new WinningNumbers(lottoWinningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
            	OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber makeBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusInput = InputView.requestBonusNumber();
                int number = Parser.parseBonusNumber(bonusInput);
                BonusNumber bonusNumber = new BonusNumber(number, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
            	OutputView.printErrorMessage(e.getMessage());
            }
        }
    }



    private List<Integer> makeResultCount() {
        return user.countTotalResult(winningNumbers.getWinningNumbers(), bonusNumber.getBonusNumber());
    }

    private void transmitOutput(List<Integer> resultCount) {
        Rank[] ranks = Rank.values();
        for (int i = 1; i < resultCount.size(); i++) {
            OutputView.printResult(ranks[i].getPrintString(), resultCount.get(i));
        }
    }
}
