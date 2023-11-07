package lotto.View;

public class OutputView {

    public static int getLottoCount(int amount) {
        int LottoCount = amount / 1000;
        System.out.println(LottoCount + "개를 구매했습니다.");
        return LottoCount;
    }
}
