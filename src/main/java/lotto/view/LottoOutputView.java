package lotto.view;

public class LottoOutputView implements View {
    LottoOutputView() {
    }

    public void printPublishedLottos(Integer count, String lottoList) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
        System.out.println(lottoList);
    }
}
