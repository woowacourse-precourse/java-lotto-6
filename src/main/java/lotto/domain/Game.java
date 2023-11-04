package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import static lotto.domain.exception.LottoExceptionList.NUMBERS_NOT_DIVIDED_ERROR;

public class Game {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;
    private final NumberGenerator numberGenerator;
    private final Validator validator;
    public Game(){
        numberGenerator = new NumberGenerator();
        lottos = new ArrayList<>();
        validator = new Validator();
    }

    public void startGame(){
        int purchaseAmount = inputPurchaseAmount();
        try {
            buyLotto(purchaseAmount);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            startGame();
        }
    }

    public void buyLotto(int money){
        if (money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(NUMBERS_NOT_DIVIDED_ERROR.getMessage());
        }
        int lottoCount = money / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++){
            List<Integer> numbers = numberGenerator.createNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        System.out.println(lottoCount+"개를 구매했습니다.");
        for (Lotto lotto : lottos){
            System.out.println(lotto.getSortedNumbers());
        }
    }

    public int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        try {
            validator.validateNumbersPure(userInput);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            startGame();
        }

        return Integer.parseInt(userInput);
    }
}
