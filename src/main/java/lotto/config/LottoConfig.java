package lotto.config;

public enum LottoConfig {
    START_LOTTO_NUM(1),
    END_LOTTO_NUM(45);
    private int num;
    private LottoConfig(int num) {
        this.num = num;
    }
    int getNum() {return this.num;}
}
