package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Application {

    public static final int LOTTO_PRICE_UNIT = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static void main(String[] args) {
        PurchasePrice purchasePrice = InputView.inputPurchasePrice();
        int purchaseCount = purchasePrice.getPurchaseCount();
        System.out.println(purchaseCount + " 개를 구매했습니다.");

        List<PurchaseNumber> purchaseNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            PurchaseNumber purchaseNumber = new PurchaseNumber(randomNumbers);
            purchaseNumbers.add(purchaseNumber);
        }

        printPurchaseNumber(purchaseNumbers);

        System.out.println("당첨 번호를 입력해주세요.");
        String userInput = Console.readLine();
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String userInputSeperated : userInput.split(",")) {
            int userInputNumber;
            try {
                userInputNumber = Integer.parseInt(userInputSeperated);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자를 입력해야 합니다.");
            }
            LottoNumber lottoNumber = new LottoNumber(userInputNumber);
            lottoNumbers.add(lottoNumber);
        }
    }

    private static void printPurchaseNumber(List<PurchaseNumber> purchaseNumbers) {
        for(PurchaseNumber purchaseNumber : purchaseNumbers) {
            List<Integer> numbers = purchaseNumber.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }
}
