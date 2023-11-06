package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.validator.PriceValidator;
import lotto.validator.Validator;

public class LotteryGame {
    private List<Lotto> lottoList;
    private InputHandler inputHandler = new InputHandler();
    private OutputHandler outputHandler = new OutputHandler();
    private final String ERROR = "[ERROR]";
    private final String REUQEST_PRICE = "구입금액을 입력해 주세요.";

    public void run() {

    }

    private void init() {
        outputHandler.print(REUQEST_PRICE);
        int price = getPrice();
        lottoList = getLottoList(price);
    }

    private int getPrice() {
        while (true) {
            try {
                String inputPrice = inputHandler.readLine();
                PriceValidator.isInteger(inputPrice);

                int price = Integer.parseInt(inputPrice);

                PriceValidator.validateCost(price);
                PriceValidator.validateThousand(price);

                return price;
            } catch (IllegalArgumentException e) {
                outputHandler.print(ERROR+e.getMessage());
            }
        }
    }

    private List<Lotto> getLottoList(int price) {
        int count = price / 1000;
        Lotto[] lottos = new Lotto[price / 1000];
        for (int i = 0; i < count; i++) {
            lottos[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return Arrays.asList(lottos);
    }
}