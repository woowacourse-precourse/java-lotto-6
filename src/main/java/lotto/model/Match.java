package lotto.model;

public class Match {

    private final InputLottoNumber inputLottoNumber;
    private final InputBonusNumber inputBonusNumber;
    private final Lotto lotto;


    public Match(InputLottoNumber inputLottoNumber, InputBonusNumber inputBonusNumber,
        Lotto lotto) {
        this.inputLottoNumber = inputLottoNumber;
        this.inputBonusNumber = inputBonusNumber;
        this.lotto = lotto;
    }

    public MatchResult calculate() {

        int matchCount = countLotto();
        boolean bonusMatch = isBonusNumberContained();
        MatchResult matchResult = new MatchResult(matchCount, bonusMatch);
        return matchResult;
    }

    private int countLotto() {
        return (int) lotto.getNumbers().stream()
            .filter(inputLottoNumber.getInputNumber()::contains)
            .count();
    }

    private boolean isBonusNumberContained() {
        return lotto.getNumbers().contains(inputBonusNumber.getNumber());
    }
}