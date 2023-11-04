package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int buyMoney = Lotto.inputBuyMoney();
            List<Lotto> lottoList = new ArrayList<>();

            createLottos(buyMoney, lottoList);
            printLottos(lottoList);

            List<Integer> correctNumbers = Lotto.inputCorrectNumbers();
            Integer bonusNumber = Lotto.inputBonusNumber(correctNumbers);

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


    private static void createLottos(int buyMoney, List<Lotto> lottoList) {
        for(int i = 0; i < buyMoney / 1000; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            Lotto lotto = new Lotto(numbers);

            lottoList.add(lotto);
        }
    }


    private static void printLottos(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
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
        int totalPrice = 0;

        System.out.println("당첨 통계\n---------");

        for (Position position : winCheckMap.keySet()) {
            totalPrice += winCheckMap.get(position) * position.getPositionMoney();

            System.out.print(position.getPositonPrint() + " (" + position.getPositionMoney() +"원)");
            System.out.println(" - " + winCheckMap.get(position) + "개");
        }

        double totalPercent = (double) totalPrice / buyMoney * 100.0;
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println("총 수익률은 " + df.format(totalPercent) + "%입니다.");
    }

}
