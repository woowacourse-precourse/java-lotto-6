package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Converter;
import lotto.constant.ExceptionMessage;
import lotto.constant.Number;
import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.domain.Rank;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoController {

    long paymentPrice;
    long ticketCount;
    List<Lotto> lottos;

    List<Integer> winningNumbers;
    int bonusNumber;

    public void start() throws IllegalArgumentException {
        callPaymentPriceLoop();
        winningNumbers = getWinningNumbersLoop();
        bonusNumber = getBonusNumberLoop();
        Rank rank = getStatic(lottos);
        OutputHandler.showWinningDetails(rank.getRank(1), rank.getRank(2), rank.getRank(3), rank.getRank(4),
                rank.getRank(5));
        showRateOfReturn(rank, paymentPrice);
    }

    // 구입 금액 받기 -> 구입 개수 계산 -> 로또 발행, 출력
    void callPaymentPriceLoop() {
        try {
            paymentPrice = getPaymentPrice();
            ticketCount = getTicketCount(paymentPrice);
            OutputHandler.sayTicketCount(ticketCount);
            lottos = issueLottos(ticketCount);
        } catch (IllegalArgumentException e) {
            callPaymentPriceLoop();
        }
    }

    long getPaymentPrice() throws IllegalArgumentException {
        OutputHandler.requirePaymentPrice();
        String paymentPriceInput = InputHandler.getInput();
        long paymentPrice = Converter.pay(paymentPriceInput);
        OutputHandler.printEmptyLine();
        return paymentPrice;
    }

    long getTicketCount(long paymentPrice) throws IllegalArgumentException {
        if (paymentPrice < 0) {
            OutputHandler.requirePositiveInteger();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_POSITIVE_INTEGER);
        }
        if (paymentPrice % Number.LOTTO_PRICE != 0) {
            OutputHandler.requireMultipleOfLottoPrice();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_MULTIPLE_OF_LOTTO_PRICE);
        }
        return paymentPrice / Number.LOTTO_PRICE;
    }

    List<Lotto> issueLottos(long ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            OutputHandler.printLottoNumbers(lotto.getNumbers());
        }
        OutputHandler.printEmptyLine();
        return lottos;
    }

    // 당첨 번호 받기
    List<Integer> getWinningNumbersLoop() {
        try {
            return getWinningNumbers();
        } catch (IllegalArgumentException e) {
            return getWinningNumbersLoop();
        }
    }

    // TODO : 오름차순으로 받기 or 받은 것 오름차순으로 바꿔주기
    List<Integer> getWinningNumbers() throws IllegalArgumentException {
        OutputHandler.requireWinningNumbers();
        String winningNumbersInput = InputHandler.getInput();
        if (winningNumbersInput.isEmpty()) {
            OutputHandler.requireNonemptyInput();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT);
        }
        List<Integer> winningNumbers = Converter.winningNumbers(winningNumbersInput);
        if (winningNumbers.size() != Number.LOTTO_NUM_COUNT) {
            OutputHandler.requireSixNumbers();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_SIX_NUMBERS);
        }
        OutputHandler.printEmptyLine();
        return winningNumbers;
    }

    int getBonusNumberLoop() {
        try {
            return getBonusNumber();
        } catch (IllegalArgumentException e) {
            return getBonusNumberLoop();
        }
    }

    int getBonusNumber() throws IllegalArgumentException {
        OutputHandler.requireBonusNumber();
        String bonusNumberInput = InputHandler.getInput();
        if (bonusNumberInput.isEmpty()) {
            OutputHandler.requireNonemptyInput();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT);
        }
        int bonusNumber = Converter.bonusNumbers(bonusNumberInput);
        OutputHandler.printEmptyLine();
        return bonusNumber;
    }

    // TODO : 15글자 넘어가지 않게 하기
    // 당첨 통계 계산 & 당첨 통계, 수익률 출력
    Rank getStatic(List<Lotto> lottos) {
        Rank rank = new Rank();
        for (Lotto lotto : lottos) {
            LottoMatch lottoMatch = getLottoMatch(lotto, winningNumbers, bonusNumber);
            int matchCount = lottoMatch.getMatchCount();
            if (matchCount < 3) {
                continue;
            }
            if (matchCount == 3) {
                rank.addRank(5);
            }
            if (matchCount == 4) {
                rank.addRank(4);
            }
            if (matchCount == 5 && !lottoMatch.getBonusMatch()) {
                rank.addRank(3);
            }
            if (matchCount == 5 && lottoMatch.getBonusMatch()) {
                rank.addRank(2);
            }
            if (matchCount == 6) {
                rank.addRank(1);
            }
        }
        return rank;
    }

    void showRateOfReturn(Rank rank, Long paymentPrice) {
        int winningPrice = rank.getRank(1) * Number.RANK1_PRICE + rank.getRank(2) * Number.RANK2_PRICE
                + rank.getRank(3) * Number.RANK3_PRICE + rank.getRank(4) * Number.RANK4_PRICE
                + rank.getRank(5) * Number.RANK5_PRICE;
        double rateOfReturn = (double) winningPrice / paymentPrice;
        OutputHandler.printRateOfReturn(rateOfReturn);
    }

    LottoMatch getLottoMatch(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        int matchCount = 0;
        boolean bonusMatch = false;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
            if (number == bonusNumber) {
                bonusMatch = true;
            }
        }
        return new LottoMatch(matchCount, bonusMatch);
    }
}

