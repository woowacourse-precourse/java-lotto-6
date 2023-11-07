package lotto;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Buyer {
    private LottoMachine lottoMachine;
    private List<Lotto> lottos;

    public void buyLotto() {
        while (true) {
            try {
                System.out.println("구매금액을 입력해 주세요.");
                String input = Console.readLine();

                int price = InputProcessor.parsePrice(input);
                InputProcessor.checkPriceValidation(price);
                this.lottos = lottoMachine.inputPurchasePrice();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void drawWinningNumbers() {
    }

    public Object getLotto() {
        return null;
    }

    public Object getDrawnNumbers() {
        return null;
    }
}
