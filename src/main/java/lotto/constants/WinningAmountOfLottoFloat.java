package lotto.constants;

public enum WinningAmountOfLottoFloat {
    fifth(5000),
    fourth(50000),
    third(1500000),
    second(30000000),
    first(2000000000);

    private final float value;

    WinningAmountOfLottoFloat(float value){
        this.value = value;
    }

    public float getValue(){
        return value;
    }

    public static float returnDataByIndexFloat(int index){
        if(index < 0 || index >= WinningAmountOfLottoFloat.values().length){
            return 0;
        }
        return WinningAmountOfLottoFloat.values()[index].getValue();
    }
}
