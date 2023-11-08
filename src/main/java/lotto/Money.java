package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Money {
	Errors errors;
	
    public final int ticketPrice = 1000;
    public final int minInRange = 1;
    public final int maxInRange = 45;
    public final int size = 6;

    public int userInputCostOfLotto;
    public int playRound;

    public List<List<Integer>> collectTotalWinningLottoNumbers;

    Money() {
    	this.userInputCostOfLotto = priceToBuyLotto();
        this.playRound = ticketQuantity();
        this.collectTotalWinningLottoNumbers = makeWinningNumbers();
    }

    private int priceToBuyLotto() {
        System.out.println("로또 구입 금액을 입력해주세요.(1,000원 단위의 숫자 입력)");
        validateOfCost();
        return userInputCostOfLotto;
    }

    // 로또 구입 금액 입력에 대한 예외 처리
    private void validateOfCost() {
        boolean validInputPriceToBuyLotto = false;
        while (!validInputPriceToBuyLotto) {
            try {
                errors.checkErrorsOfInputMoney();
                validInputPriceToBuyLotto = true;
            } catch (NumberFormatException e) {
                System.out.println("[Error] 숫자만 입력 가능합니다.");
                System.out.println("다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
            }
        }
    }

    private int ticketQuantity() {
        playRound = userInputCostOfLotto / ticketPrice;
        return this.playRound;
    }

    /* 로또 번호 생성 및 당첨 번호 갯수 확인 */
    public List<List<Integer>> makeWinningNumbers() {
        System.out.println();
        System.out.println(ticketQuantity() + "개를 구매했습니다.");

        List<List<Integer>> collectTotalWinningLottoNumbers = new ArrayList<>();
        for (int i = 0; i < playRound; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(minInRange, maxInRange, size);
            Collections.sort(randomNumbers);
            collectTotalWinningLottoNumbers.add(randomNumbers);
        }
        for (int i = 0; i < playRound; i++) {
            System.out.println(collectTotalWinningLottoNumbers.get(i));
        }
        return this.collectTotalWinningLottoNumbers;
    }

}
