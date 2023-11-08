package lotto.core.domain;

import lotto.common.console.Input;
import lotto.common.console.Output;
import lotto.common.exception.ErrorType;
import lotto.common.exception.LottoGameException;

import java.util.*;

import static lotto.core.domain.Lotto.LOTTO_SIZE;

public class DrawLottoMachine {
    private final Lotto winningLotto;
    private final int bonusNumber;
    private int[] drawLottoResult = {0, 0, 0, 0, 0};

    public DrawLottoMachine() {
        this.winningLotto = new Lotto(readWinningLottoNumbers());
        this.bonusNumber = readBonusNumber();
    }

    private List<Integer> readWinningLottoNumbers() {
        String winningLottoNumbers;

        do {
            winningLottoNumbers = Input.readLottoNumbers();
        } while (!isValidWinningLottoNumbers(winningLottoNumbers));

        return Arrays.stream(winningLottoNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private boolean isValidWinningLottoNumbers(String winningLottoNumbersInput) {
        try {
            List<Integer> winningLottoNumbers = convertWinningLottoNumbers(winningLottoNumbersInput);
            validateWinningLottoNumbers(winningLottoNumbers);
            return true;
        } catch (IllegalArgumentException e) {
            Output.writeMessage(e.getMessage());
            return false;
        }
    }

    private List<Integer> convertWinningLottoNumbers(String winningLottoNumbersInput) {
        List<Integer> winningLottoNumbers = Arrays.stream(winningLottoNumbersInput.split(","))
                .map(Integer::parseInt)
                .toList();

        if(winningLottoNumbers.size() != LOTTO_SIZE) {
            throw LottoGameException.withType(ErrorType.INVALID_LOTTO_SIZE);
        }

        return winningLottoNumbers;
    }
    private void validateWinningLottoNumbers(List<Integer> winningLottoNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningLottoNumbers);

        if (uniqueNumbers.size() != winningLottoNumbers.size()) {
            throw LottoGameException.withType(ErrorType.DUPLICATE_NUMBERS);
        }
    }

    private int readBonusNumber() {
        String bonusNumber;

        do {
            bonusNumber = Input.readBonusNumber();
        } while (!isValidBonusNumber(bonusNumber));

        return Integer.parseInt(bonusNumber);
    }

    private boolean isValidBonusNumber(String bonusNumberInput) {
        try {
            int bonusNumber = convertNumber(bonusNumberInput);
            validateNumberRange(bonusNumber);
            validateBonusNumber(bonusNumber);
            return true;
        } catch (IllegalArgumentException e) {
            Output.writeMessage(e.getMessage());
            return false;
        }
    }

    private int convertNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw LottoGameException.withType(ErrorType.INVALID_NUMBERS);
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
           throw LottoGameException.withType(ErrorType.INVALID_NUMBERS);
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        List<Integer> lottoNumbers = this.winningLotto.getNumbers();

        if (lottoNumbers.contains(bonusNumber)) {
            throw LottoGameException.withType(ErrorType.DUPLICATE_NUMBERS);
        }
    }

    public void draw(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            switch (getWinningResult(lotto)) {
                case FIFTH_Place -> drawLottoResult[0]++;
                case FORTH_PLACE -> drawLottoResult[1]++;
                case THRID_PLACE -> drawLottoResult[2]++;
                case SECOND_PLACE -> drawLottoResult[3]++;
                case FIRST_PLACE -> drawLottoResult[4]++;
            }
        }

       writeEntireDrawResult();
    }

    public void writeEntireDrawResult() {
        Output.writeEntireLottoDrawResult();

        Output.writeEachLottoDrawResult(WinningCondition.FIFTH_Place, drawLottoResult[0]);
        Output.writeEachLottoDrawResult(WinningCondition.FORTH_PLACE, drawLottoResult[1]);
        Output.writeEachLottoDrawResult(WinningCondition.THRID_PLACE, drawLottoResult[2]);
        Output.writeEachLottoDrawResult(WinningCondition.SECOND_PLACE, drawLottoResult[3]);
        Output.writeEachLottoDrawResult(WinningCondition.FIRST_PLACE, drawLottoResult[4]);
    }

    public void writeReturnRate(int purchaseAmount) {
        int sum = WinningCondition.FIFTH_Place.getReward() * drawLottoResult[0] +
        WinningCondition.FORTH_PLACE.getReward() * drawLottoResult[1] +
        WinningCondition.THRID_PLACE.getReward() * drawLottoResult[2] +
        WinningCondition.SECOND_PLACE.getReward() * drawLottoResult[3] +
        WinningCondition.FIRST_PLACE.getReward() * drawLottoResult[4];

        Output.writeReturnRate(sum/purchaseAmount);
    }

    private WinningCondition getWinningResult(Lotto lotto) {
        int count = (int) lotto.getNumbers().stream().filter(this.winningLotto::isMatchingLottoNumber).count();
        boolean isMatchBonusNumber = lotto.getNumbers().contains(bonusNumber);

        if(isMatchBonusNumber) {
            count++;
        }

        if(count < LOTTO_SIZE) {
            isMatchBonusNumber = false;
        }

        return WinningCondition.getByMatchResult(count, isMatchBonusNumber);
    }
}
