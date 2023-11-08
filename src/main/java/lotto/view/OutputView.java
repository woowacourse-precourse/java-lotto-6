package lotto.view;


import java.util.List;
import lotto.domain.Lottos;
import lotto.dto.ResultResponse;

public class OutputView {

    public void printPurchaseGuideMessage() {
        System.out.println(GuideMessage.PURCHASE_GUIDE_MESSAGE.getText());
    }

    public void printWinningNumbersGuideMessage() {
        System.out.println(GuideMessage.WINNING_NUMBERS_GUIDE_MESSAGE.getText());
    }

    public void printBonusNumberGuideMessage() {
        System.out.println(GuideMessage.BONUS_NUMBER_GUIDE_MESSAGE.getText());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public void printLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public void printBenefitRate(double benefitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", benefitRate);
    }

    public void printLottoResult(List<ResultResponse> resultResponses) {
        for (ResultResponse resultResponse : resultResponses) {
            System.out.print(resultResponse.toString());
        }
    }
}
