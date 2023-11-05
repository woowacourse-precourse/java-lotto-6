package view;

public class LottoCount {

    private int lottoCount;

    public LottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void printLottoCount() {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }
}
