package lotto.view;

public interface IBonusValidation {

    void bonusNumberError(String str);
    void bonusStringError(String str);

    static void bonusValidation(IBonusValidation instance
            , String string) throws IllegalArgumentException {
        instance.bonusStringError(string);
        instance.bonusNumberError(string);
    }
}
