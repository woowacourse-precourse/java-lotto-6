package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.AmountValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 게임을 진행하는 클래스
 */
public class LottoGame {

    private List<Lotto> lottos = new ArrayList<>(); // 구입한 로또

    private AmountValidator purchaseAmountValidator;

    public LottoGame(AmountValidator purchaseAmountValidator) {
        this.purchaseAmountValidator = purchaseAmountValidator;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void start() {
        int purchaseAmount = getPurchaseAmount();
        generateLottos(purchaseAmount);
        printPurchasedLottos();
    }

    /**
     * 구입 금액을 입력받는다.(유효한 금액을 입력할 때까지 반복)
     * @return 유효성이 검증된 구입 금액
     */
    private int getPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmountInput = Console.readLine();
            try {
                if (purchaseAmountValidator.isValid(purchaseAmountInput)) {
                    return Integer.parseInt(purchaseAmountInput);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(String.format("[ERROR] %s", e.getMessage()));
            }
        }
    }

    /**
     * 로또 번호를 생성한다.
     * @param purchaseAmount
     */
    public void generateLottos(int purchaseAmount) {
        for (int i = 0; i < purchaseAmount / GameDetail.AMOUNT_UNIT; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
    }

    /**
     * 구입한 로또를 출력한다.
     */
    private void printPurchasedLottos() {
        int size = 0;
        if (lottos != null) {
            size = lottos.size();
        }
        System.out.println(String.format("%d개를 구매했습니다.", size));
        if (lottos != null) {
            lottos.stream().forEach(lotto -> System.out.println(lotto.toString()));
        }
    }

}
