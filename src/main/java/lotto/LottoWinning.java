package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoWinning {

    private static int LOTTO_WINNING_NUM_MIN = 1;
    private static int LOTTO_WINNING_NUM_MAX = 45;
    private static int LOTTO_WINNING_NUMS = 6;

    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public LottoWinning(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 " + LOTTO_WINNING_NUMS + " 자리입니다.");
        }
        if (new HashSet<Integer>(winningNumbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호에 중복되는 숫자가 사용되었습니다.");
        }
        if (!winningNumbers.stream().allMatch(n -> n <= LOTTO_WINNING_NUM_MAX && n >= LOTTO_WINNING_NUM_MIN)) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호에 유효하지 않은 숫자가 사용되었습니다.");
        }
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber > LOTTO_WINNING_NUM_MAX || bonusNumber < LOTTO_WINNING_NUM_MIN) {
            throw new IllegalArgumentException("[ERROR] 로또 보너스 당첨 번호에 유효하지 않은 숫자가 사용되었습니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 보너스 당첨 번호와 로또 당첨 번호가 중복됩니다.");
        }
    }

    public void setBonusNumber(Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    // TODO: refactor names of variables
    public List<LottoRank> assignRanks(List<Lotto> tickets) {
        List<LottoRank> winnings = new ArrayList<>();
        // TODO: refactor
        tickets.forEach(t -> {
            LottoRank wonRank = assignRank(t);
            winnings.add(wonRank);
        });
        // TODO: refactor ignore NoWinning
        return winnings;
    }

    public LottoRank assignRank(Lotto ticket) {
        int match = ticket.countMatchingNumbers(winningNumbers);
        boolean bonusMatch = checkIfTicketContainsBonusNumber(ticket);
        LottoRank wonRank = LottoRank.getWinningRank(match, bonusMatch);
        if (wonRank == LottoRank.NO_WINNING) {
            return null;
        }
        return wonRank;
    }

    private boolean checkIfTicketContainsBonusNumber(Lotto ticket) {
        if (bonusNumber == null) {
            return false;
        }
        return ticket.numbersContain(bonusNumber);
    }
}
