package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ConsoleUI {
    private static final int LOTTO_PRICE = 1000;

    public static int amountInput(){
        int purchaseAmount;
        while (true){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = parseInt(Console.readLine());

                if(purchaseAmount % LOTTO_PRICE != 0){
                    throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
                }

                purchaseAmount /= LOTTO_PRICE;
                break;
            } catch (NumberFormatException e){
                System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
        return purchaseAmount;
    }

    public static List<List<Integer>> showLotto(int tickets){
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < tickets; i++) {
            List<Integer> lottoNumbers = LottoService.generateRandomLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            result.add(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }
        return result;
    }
}
