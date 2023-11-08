package lotto.LottoFactory;

public interface LottoChecker {
    boolean isDuplicateBonus(int bonus);
    int countMatchingNum(Lotto lotto);
}
