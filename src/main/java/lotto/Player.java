package lotto;

public class Player {
    private static LottoCount lottoCount;
    private static Lotto[] lottos;

    public void setLottoCount(int amount) {
        lottoCount = new LottoCount(amount);
    }
}
