package lotto.constants;

public enum WinningLottoCount {
    fifth("3개 일치"),
    fourth("4개 일치"),
    third("5개 일치"),
    second("5개 일치, 보너스 볼 일치"),
    first("6개 일치");

    private final String value;

    WinningLottoCount(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static String returnWinningByString(int index){
        if(index < 0 || index >= WinningLottoCount.values().length){
            return null;
        }
        return WinningLottoCount.values()[index].getValue();
    }
}
