package lotto.view;


public interface ILottoInputValidation {
    void lottoLengthError(String str);

    void lottoDuplictionError(String str);

    void lottoNumberError(String str);

    static void lottoInputValidation(ILottoInputValidation instance
            , String string) throws IllegalArgumentException {
        instance.lottoLengthError(string);
        instance.lottoDuplictionError(string);
        instance.lottoNumberError(string);
    }
}
