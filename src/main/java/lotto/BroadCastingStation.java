package lotto;

public class BroadCastingStation {
    public static LottoDrawResult drawLotto(Lotto lotto, Integer bonus) {
        LottoDrawResult lottoDrawResult = new LottoDrawResult(lotto, bonus);
        validateDuplicate(lotto, bonus);
        return lottoDrawResult;
    }

    private static void validateDuplicate(Lotto lotto, Integer bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호가 중복됩니다.");
        }
    }
}
