package lotto.view;

public interface IBonusValidation {

    void lottoNumberError(String str);

    static void bonusValidation(IBonusValidation instance
            , String string) throws IllegalArgumentException {
        instance.lottoNumberError(string);
    }
}
