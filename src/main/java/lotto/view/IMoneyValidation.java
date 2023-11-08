package lotto.view;

public interface IMoneyValidation {
    void moneyUnitError(String str);

    void moneyNullError(String str);

    void moneyStringError(String str);

    static void moneyValidation(IMoneyValidation instance
            , String string) throws IllegalArgumentException {
        instance.moneyNullError(string);
        instance.moneyStringError(string);
        instance.moneyUnitError(string);
    }
}
