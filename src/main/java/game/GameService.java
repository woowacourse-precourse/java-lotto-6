package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.WinningNumber;

public class GameService {

    public void play() {

        System.out.println("구입금액을 입력해 주세요.");
        int price = getPrice();

        List<Lotto> lottos = createLottoByPrice(price);
        getLottoByPrice(lottos);

        WinningNumber winningNumber = getWinningNumber();


    }

    public int getPrice() {
        int price = 0;
        while (price == 0) {
            try {
                String priceInput = Console.readLine();
                if (Integer.parseInt(priceInput) % 1000 == 0) {
                    price = Integer.parseInt(priceInput);
                    return price;
                }
                throw new IllegalArgumentException("Price must be a multiple of 1000");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e);
            }
        }
        return price;
    }

    public List<Lotto> createLottoByPrice(int price) {
        List<Lotto> lottos = new ArrayList<>();
        int createLottoNumber = price / 1000;
        System.out.println(createLottoNumber + "개를 구매했습니다.");

        for (int i = 0; i < createLottoNumber; i++) {
            List<Integer> newLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(newLotto));
        }

        return lottos;
    }

    public void getLottoByPrice(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
    }

    public WinningNumber getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumberInput = Console.readLine().split(",");
        validateWinningNumber(winningNumberInput);

        WinningNumber winningNumber;

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumberInput) {
            winningNumbers.add(Integer.parseInt(number));
        }

        int bonus = getBonusNumber(winningNumbers);

        winningNumber = new WinningNumber(winningNumbers, bonus);
        return winningNumber;
    }

    public void validateWinningNumber(String[] winningNumber) {
        if (winningNumber.length != 6) {
            throw new IllegalArgumentException();
        }
        for (String number : winningNumber) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException();
            }
            if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        String bonusInput = Console.readLine();
        validateBonus(bonusInput, winningNumbers);
        return Integer.parseInt(bonusInput);
    }

    public void validateBonus(String bonus, List<Integer> winningNumbers) {
        if (!bonus.matches("\\d+")) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(bonus) < 1 || Integer.parseInt(bonus) > 45) {
            throw new IllegalArgumentException();
        }

        if (winningNumbers.contains(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException();
        }
    }

}
