package lotto.domain;

public class Result {
    private Lotto lottoNumber;
    private int bonusNumber;

    public Result(Lotto lottoNumber, int bonusNumber) {
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }
}
