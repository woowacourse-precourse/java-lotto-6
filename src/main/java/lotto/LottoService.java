package lotto;

import util.InputHandler;
import view.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private final static int lottoPrice = 1000;
    private final static String totalPriceMessage = "구입금액을 입력해 주세요.";
    private final static String winningNumberMessage = "당첨 번호를 입력해 주세요.";
    private final static String bonusNumberMessage = "보너스 번호를 입력해 주세요.";

    protected List<Lotto> createLotto() {
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

   protected List<Integer> allWinningLottoNumber() {
        List<Integer> winningNumbers = winningLottoNumber();
        int bonusNumber = bonusLottoNumber();
        winningNumbers.add(bonusNumber);
        return winningNumbers;
   }

   private List<Integer> winningLottoNumber() {
        String winningNumber = InputHandler.printMessageAndReceiveInput(winningNumberMessage);
        List<Integer> winningNumbers = Arrays.stream(winningNumber.split(","))
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toList());
        return winningNumbers;
   }

   private int bonusLottoNumber() {
        int bonusNumber = Integer.parseInt(InputHandler.printMessageAndReceiveInput(bonusNumberMessage));
        return bonusNumber;
   }

}
