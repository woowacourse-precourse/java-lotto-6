package lotto.view;

import lotto.dto.response.LottoNumbersResponse;
import lotto.dto.response.LottoWinningStatsResponse;
import lotto.dto.response.PurchaseResponse;

public class OutView {

    public void displayPurchase(PurchaseResponse purchaseResponse) {
        System.out.println();
        System.out.println(purchaseResponse.getPurchaseCount() + "개를 구매했습니다.");
        for (LottoNumbersResponse result : purchaseResponse.getLottoTicket()) {
            System.out.println(result.getLottoNumber().toString());
        }
        System.out.println();
    }

    public void displayWinningStatus(LottoWinningStatsResponse lottoWinningStatsResponse) {
        System.out.println();
        for (ViewMessage view : ViewMessage.values()) {
            System.out.println(
                view.resultMessage(
                    view.getIndex(),
                    lottoWinningStatsResponse.getWinningStats().get(view.getIndex()).getCount())
            );
        }
        System.out.println();
        System.out.print(resultMessage(lottoWinningStatsResponse.getTotalProfit()));
    }

    public String resultMessage(double totalProfit) {
        return "총 수익률은 " + String.format("%.1f", totalProfit) + "%입니다.";
    }
}