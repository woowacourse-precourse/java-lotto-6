package lotto.domain;

import java.util.List;

import static lotto.domain.NumberConverter.convertNumberToLottoNumber;

public class WinningNumbers {
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int BONUS_NUMBER_SIZE = 1;

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        validateWinningNumbersSize(winningNumbers);
        validateDuplicateWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = convertNumberToLottoNumber(winningNumbers);
        this.bonusNumber = convertNumberToLottoNumber(bonusNumber);
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicateWinningNumbers(List<Integer> numbers, Integer bonusNumber) {
        numbers.add(bonusNumber);
        long count = numbers.stream()
                .distinct()
                .count();
        if (count != WINNING_NUMBERS_SIZE + BONUS_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스 번호 중 중복되는 숫자가 존재합니다.");
        }
        numbers.remove(Integer.valueOf(bonusNumber));
    }

    public boolean isBonus(LottoTicket lottoTicket) {
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        return lottoNumbers.contains(bonusNumber);
    }

    public Rank getRank(LottoTicket lottoTicket) {
        long matchCount = lottoTicket.getLottoNumbers().stream()
                .filter(lottoNumber -> winningNumbers.contains(lottoNumber))
                .count();
        return Rank.of((int) matchCount, isBonus(lottoTicket));
    }

}
