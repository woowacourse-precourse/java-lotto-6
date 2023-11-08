package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 사용자로부터 값을 입력받고,
 * Validator 클래스의 메소드를 이용하여 검증한 후
 * 자료형변환을 거쳐
 * LottoController에 값을 반환하는 클래스
 */

public class GetLottoNumber {
    public static int purchasePrice() {
        int purchasePrice = 0;
        try {
            String input = InputView.inputPurchasePrice();

            Validator.isNumericInput(input);
            purchasePrice = Integer.parseInt(input);
            Validator.purchasePrice(purchasePrice);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchasePrice();
        }
        return purchasePrice;
    }

    public static List<Integer> userTicketNumbers() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> modifiableList = new ArrayList<>(lottoNumber);
        Collections.sort(modifiableList);

        return modifiableList;
    }

    public static Lotto winningTicketNumbers() {
        Lotto winningLotto = null;
        try {
            String input = InputView.inputWinNumber();

            String [] numbers = input.split(",");
            List<Integer> winningNumbers = new ArrayList<>();

            for (String num : numbers) {
                validateInput(num);
                int number = Integer.parseInt(num);
                winningNumbers.add(number);
            }

            winningLotto = new Lotto(winningNumbers);

            return winningLotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningTicketNumbers();
        }
        return winningLotto;
    }

    public static int bonusNumber() {
        int bonusNumber = 0;
        try {
            String input = InputView.inputBonusNumber();
            validateInput(input);
            bonusNumber = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber();
        }
        return bonusNumber;
    }

    public static void validateInput(String num) {
        Validator.isEmpty(num);
        Validator.isNumericInput(num);
        Validator.isNumberInRange(num);
    }
}
