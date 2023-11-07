package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    static ArrayList<Lotto> lottoTickets = new ArrayList<>();
    static List<Integer> winningNumbers = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해주세요:");
        generateLottoTickets(Console.readLine());
        showLottoTickets();
        System.out.println("당첨번호를 입력해 주세요.");
        getWinningNumbers(Console.readLine());
        System.out.println("보너스 번호를 입력해주세요.");
        getBonusNumber(Console.readLine());
        compareLottoWithWinning();
    }

    public static Integer convertMoneyFormat(String inputMoney) {
        Integer money = Integer.valueOf(inputMoney);
        return money;
    }
    public static Integer getQuantityOfLotto(Integer money) {
        Integer quantityOfLotto = money/1000;
        return quantityOfLotto;
    }
    public static void generateLottoTickets(String inputMoney) {
        Integer money= convertMoneyFormat(inputMoney);
        Integer quantityOfLotto = getQuantityOfLotto(money);
        for (int i = 0; i<quantityOfLotto; i++) {
            lottoTickets.add(generateLotto());
        }
    }
    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(null);
        return new Lotto(numbers);
    }
    public static void showLottoTickets() {
        Integer numberOfLottoTickets = lottoTickets.size();
        System.out.println(String.format("%d개를 구매했습니다.",numberOfLottoTickets));
        for(Lotto lottoTicket : lottoTickets) {
            List<Integer> numbers = lottoTicket.getNumbers();
            System.out.println(numbers);
        }
    }
    public static void getWinningNumbers(String inputWinningNumbers) {
        for (String winningNumber : inputWinningNumbers.split(",")) {
            winningNumbers.add(Integer.valueOf(winningNumber));
        }
    }
    public static void getBonusNumber(String inputBonusNumber) {
        Integer bonusNumber = Integer.valueOf(inputBonusNumber);
    }
    public static void compareLottoWithWinning() {
        for(Lotto lottoTicket : lottoTickets) {
            Integer sameNumber = (int) lottoTicket.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            //5개면 보너스가 맞는지
            //enum 어떻게 쓰지?
        }
    }
}
