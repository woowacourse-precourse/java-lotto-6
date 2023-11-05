package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import lotto.Service.LottoMachine;
import java.util.List;
import lotto.Model.Lotto;
import lotto.View.UIView;

public class UIController {

    public static Integer makePurchasePrice() {
        int price = 0;
        while (true) {
            try {
                UIView.printPurchasePriceInstruction();
                price = getPurchasePrice();
                validatePurchasePrice(price);

                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1이상의 천단위 숫자만 가능합니다.");
            }
        }
        return price;
    }


    private static int getPurchasePrice() {
        return Integer.parseInt(Console.readLine());
    }


    private static void validatePurchasePrice(Integer price) {
        if (price <= 0) {
            throw new IllegalArgumentException("1이상의 숫자만 가능합니다.");
        }

        if (price % 1000 == 0) {
            return;
        }
        throw new IllegalArgumentException("천 단위의 숫자만 가능 합니다");
    }

    public static List<Lotto> makeLotto(Integer price) {
        int lottoCount = LottoMachine.lottoCount(price);
        ArrayList<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = LottoMachine.makeRandomNumbers();
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }


    public static void makeLottoStatus(List<Lotto> lottos) {
        UIView.printLottoCount(lottos);
        UIView.printLottoNumbers(lottos);
    }


    public static List<Integer> makeWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                UIView.printWinningNumberInstruction();
                winningNumbers = getWinningNumber();
                // TODO : 당첨번호 검증
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨번호는 숫자 여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨번호는 1~45의 중복되지 않는 6개의 숫자 여야 합니다.");
            }
        }
        return winningNumbers;
    }


    private static List<Integer> getWinningNumber() {
        String[] line = Console.readLine().split(",");

        return null;
    }
}
