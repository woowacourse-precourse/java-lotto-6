package lotto.enums;

public enum LottoEnum {

    W1(2000000000),
    W2(30000000),
    W3(1500000),
    W4(50000),
    W5(5000);


    private int reward;


    LottoEnum(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public static boolean contains(String name) {
        LottoEnum[] values = LottoEnum.values();
        for (LottoEnum value : values) {
            if (value.name().equals(name)){
                return true;
            }
        }
        return false;
    }
}
