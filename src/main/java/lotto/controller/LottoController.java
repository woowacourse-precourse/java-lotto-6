package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final int lottoPrice = 1000;
    private int purchaseQuantity;
    private boolean checkInitPurchaseQuantity = true;


    public void start() {
        while (checkInitPurchaseQuantity) {
            initPurchaseQuantity(); // 구매 수량 초기화
        }
        outputPurchaseQuantity(); // 구매 수량 출력
        makeLottos(); // 로또 생성
    }

    public void initPurchaseQuantity() {
        try {
            String input = InputView.inputAmountOfMoney();
            validateInputMoney(input);
            calculateQuantity(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void calculateQuantity(String input) { // 로또 구매 수량 계산.
        try {
            int money = Integer.parseInt(input);
            validatePurchaseQuantity(money);
            purchaseQuantity = money / lottoPrice;
            checkInitPurchaseQuantity = false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void outputPurchaseQuantity() {
        OutputView.printPurchaseQuantity(purchaseQuantity);
    }

    public void makeLottos(){
        Lotto lotto;
        for(int i=0; i<purchaseQuantity; i++){
            List<Integer> randomNumbers = generateRandomNumber();
            lotto=new Lotto(randomNumbers);
            lotto.printLottoNumbers();
        }
    }
    public List<Integer> generateRandomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 24, 6);
        return numbers;
    }

    public void validateInputMoney(String input) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            checkInitPurchaseQuantity = true;
            throw new IllegalArgumentException("[ERROR]숫자를 입력해 주세요.");
        }
    }

    public void validatePurchaseQuantity(int money) {
        if (money == 0 || money % 1000 != 0) {
            checkInitPurchaseQuantity = true;
            throw new IllegalArgumentException("[ERROR]금액은 1,000원 단위로 입력해 주세요.");
        }
    }

}
