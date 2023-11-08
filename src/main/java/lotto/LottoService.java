package lotto;

import util.InputHandler;
import view.View;

import java.util.List;

public class LottoService {
    private final static int lottoPrice = 1000;
    private final static String totalPriceMessage = "구입금액을 입력해 주세요.";
    public List<Lotto> createLotto() {
        int totalPrice = Integer.parseInt(InputHandler.printMessageAndReceiveInput(totalPriceMessage));
        int lottoCount = calculateLottoCount(totalPrice);
        return LottoFactory.createLotto(lottoCount);
    }

    private int calculateLottoCount(int totalPrice) {
        return totalPrice / lottoPrice;
    }

    protected void printLottoInfo(List<Lotto> lottoList) {
        createLottoInfoView(lottoList).print();
    }

    private View createLottoInfoView(List<Lotto> lottoList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%d개를 구매했습니다.\n", lottoList.size()));
        lottoList.stream()
                .forEach(lotto -> {
                    List<Integer> lottoNumbers = lotto.getLottoNumbers();
                    lottoNumbers.sort(Integer::compareTo);
                    stringBuilder.append(lottoNumbers).append("\n");
                });
        return new View(stringBuilder.toString());
   }
}
