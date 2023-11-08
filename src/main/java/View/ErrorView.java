package View;

public interface ErrorView {
    public void emptyStringAtInputMoney();
    public void notConvertedToInt(String errorStr);
    public void notMultipleOfThousand(Integer errorInt);
    public void zeroInserted();
}
