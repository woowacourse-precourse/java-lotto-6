package lotto;

import lotto.domain.UserLotto;
import lotto.service.UserLottoGenerator;
import lotto.validation.LottoValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        LottoValidation lottoValidation = new LottoValidation();
        UserLottoGenerator userLottoGenerator = new UserLottoGenerator();

        int purchaseAmount = ioPurchaseAmount(outputView, inputView, lottoValidation);
        List<UserLotto> userLottos = outputPurchasedUserLotto(purchaseAmount, outputView, userLottoGenerator);
    }

    private static List<UserLotto> outputPurchasedUserLotto(int purchaseAmount, OutputView outputView, UserLottoGenerator userLottoGenerator) {
        int lottoTicket = purchaseAmount / 1000;
        outputView.printInformPurchaseMessage(lottoTicket);
        List<UserLotto> userLottos = userLottoGenerator.generateUserLotto(lottoTicket);
        for (UserLotto userLotto : userLottos) {
            System.out.println(userLotto.getNumbers());
        }
        return userLottos;
    }

    private static int ioPurchaseAmount(OutputView outputView, InputView inputView, LottoValidation lottoValidation) {
        int purchaseAmount = 0;
        outputView.printInputPurchaseAmountMessage();
        while (true) {
            try {
                purchaseAmount = inputView.readPurchaseAmount(lottoValidation);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }
}
