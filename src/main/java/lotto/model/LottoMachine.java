package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.model.LottoStatistics.PrizeInformation;

import static lotto.util.ErrorMessage.*;
import static lotto.util.NumbersValidator.*;

public class LottoMachine {

    private final int THREE_MATCHES = 3;
    private final int FOUR_MATCHES = 4;
    private final int FIVE_MATCHES = 5;
    private final int SIX_MATCHES = 6;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public LottoMachine() {
        winningNumbers = new ArrayList<>();
        bonusNumber = null;
    }

    public ArrayList<Lotto> runLottoMachine(Integer lottoCount) {
        ArrayList<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(createLotto());
        }
        return lottoTickets;
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public void setWinningNumbers(List<Integer> numbers) {
        checkWinningNumbers(numbers);
        this.winningNumbers = numbers;
    }

    private void checkWinningNumbers(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        checkElementsInRange(numbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }


    public void setBonusNumber(Integer number) {
        checkIntegerInRange(number);
        checkIntegerInList(winningNumbers, number);
        this.bonusNumber = number;
    }

    private void checkIntegerInRange(Integer number) {
        if (number < RANDOM_NUMBER_MIN_VALUE || number > RANDOM_NUMBER_MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private void checkIntegerInList(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.stream().anyMatch(number -> number.equals(bonusNumber))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_CANT_BE_DUPLICATED);
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public ArrayList<PrizeInformation> determineLottoWinning(ArrayList<Lotto> lottoTickets) {
        ArrayList<PrizeInformation> lottoResult = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            long matchCount = lottoNumbers.stream().filter(winningNumbers::contains).count();
            PrizeInformation rank = selectRank(lottoNumbers, matchCount);
            lottoResult.add(rank);
        }
        lottoResult.removeAll(Collections.singletonList(null));
        return lottoResult;
    }

    private PrizeInformation selectRank(List<Integer> lottoNumbers, long matchCount) {
        if (matchCount == THREE_MATCHES) {
            return PrizeInformation.FIFTH_PRIZE;
        }
        if (matchCount == FOUR_MATCHES) {
            return PrizeInformation.FOURTH_PRIZE;
        }
        if (matchCount == FIVE_MATCHES) {
            return determineBonusWinning(lottoNumbers);
        }
        if (matchCount == SIX_MATCHES) {
            return PrizeInformation.FIRST_PRIZE;
        }
        return null;
    }

    private PrizeInformation determineBonusWinning(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            return PrizeInformation.SECOND_PRIZE;
        }
        return PrizeInformation.THIRD_PRIZE;
    }

}