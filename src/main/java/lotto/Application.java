package lotto;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int buyMoney = inputBuyMoney();
            List<Lotto> lottoList = new ArrayList<>();

            createLottos(buyMoney, lottoList);
            printLottos(lottoList);

            List<Integer> correctNumbers = inputCorrectNumbers();
            Integer bonusNumber = inputBonusNumber(correctNumbers);

            Map<Position, Integer> winCheckMap = new LinkedHashMap<>();
            initWinCheckMap(winCheckMap);
            winCheck(lottoList, correctNumbers, bonusNumber, winCheckMap);

            printLottoResult(buyMoney, winCheckMap);
        } catch (NumberFormatException ex) {
            System.out.println("[ERROR] 입력은 숫자로 입력되어야 합니다.");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static int inputBuyMoney() {
        System.out.println("구입 금액을 입력해주세요.");

        String input = Console.readLine();
        int money = validateBuyMoney(input);
        return money;
    }

    private static int validateBuyMoney(String input) {
        int money;

        money = Integer.parseInt(input);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000으로 나누어 떨어져야 합니다.");
        }

        return money;
    }


    public static List<Integer> inputCorrectNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> numbers = new ArrayList<>();

        String input = Console.readLine();

        for(String str : input.split(",")){
            numbers.add(Integer.parseInt(str));
        }

        validateCorrectNumbers(numbers);

        return numbers;
    }

    private static void validateCorrectNumbers(List<Integer> numbers) {
        if(numbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개 입력해야 합니다.");
        }

        for (Integer number : numbers) {
            if(number > 45 || number < 1){
                throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1 ~ 45 사이여야 합니다.");
            }
        }

        Set<Integer> validSet = new HashSet<>(numbers);
        if(validSet.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 중복 없이 6개 입력해야 합니다.");
        }
    }


    private static void createLottos(int buyMoney, List<Lotto> lottoList) {
        for(int i = 0; i < buyMoney / 1000; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
    }


    private static void printLottos(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
    }


    public static Integer inputBonusNumber(List<Integer> correctNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");

        String input = Console.readLine();

        Integer bonusNumber = Integer.parseInt(input);

        validateBonusNumber(correctNumbers, bonusNumber);

        return bonusNumber;
    }

    private static void validateBonusNumber(List<Integer> correctNumbers, Integer bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 숫자를 입력해야 합니다.");
        }

        if(correctNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }


    private static void initWinCheckMap(Map<Position, Integer> winCheckMap) {
        for (Position position : Position.values()) {
            winCheckMap.put(position, 0);
        }
    }


    private static void winCheck(List<Lotto> lottoList, List<Integer> correctNumbers, Integer bonusNumber, Map<Position, Integer> winCheckMap) {
        for (Lotto lotto : lottoList) {
            Position position = lotto.checkLotto(correctNumbers, bonusNumber);

            if(position != null){
                winCheckMap.put(position, winCheckMap.get(position) + 1);
            }
        }
    }


    private static void printLottoResult(int buyMoney, Map<Position, Integer> winCheckMap) {
        System.out.println("당첨 통계\n---------");

        int totalPrice = 0;
        for (Position position : winCheckMap.keySet()) {
            totalPrice += winCheckMap.get(position) * position.getPositionMoney();

            DecimalFormat df = new DecimalFormat("###,###");
            System.out.print(position.getPositonPrint() + " (" + df.format(position.getPositionMoney()) +"원)");
            System.out.println(" - " + winCheckMap.get(position) + "개");
        }

        double totalPercent = (double) totalPrice / buyMoney * 100.0;
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println("총 수익률은 " + df.format(totalPercent) + "%입니다.");
    }

}
