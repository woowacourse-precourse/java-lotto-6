package lotto.constants;

public enum WinningAmountOfLottoString {
    fifth("5,000"),
    fourth("50,000"),
    third("1,500,000"),
    second("30,000,000"),
    first("2,000,000,000");

    private final String value;

    WinningAmountOfLottoString(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static String returnDataByIndexString(int index){
        if(index < 0 || index >= WinningAmountOfLottoString.values().length){
            return null;
        }
        return WinningAmountOfLottoString.values()[index].getValue();
    }
}