package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Amount;

import java.text.NumberFormat;
import java.util.*;
import java.util.Vector;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static Vector<Integer> lottoNumberVector = new Vector<>(LOTTO_NUMBERS_SIZE);
    private static int bonusNumber;

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        Amount amount = new Amount(); //가격을 입력으로 받고 validation함

        List<Lotto> myLottos = new ArrayList<>();

        for(int iter = 1;iter <= amount.getAmount()/1000;iter++){ //입력금액 / 1000 만큼 iter 실행
            Lotto curLotto = makeRandomLotto();
            curLotto.printLotto();
            myLottos.add(curLotto);
        }

        Lotto WinLotto = getWinNumbers(); // 로또 당첨 번호를 입력받음

        bonusNumber = getBonusNumber(WinLotto); //보너스 번호 입력 받음

        int winPrice = 0;
        HashMap<Rank, Integer> hm = initHashMap(); // 새 HashMap을 생성하고 초기화

        for(Lotto curLotto : myLottos){
            Rank curRank = Rank.calculateRank(WinLotto, bonusNumber, curLotto);
            //System.out.println(curRank);
            winPrice += curRank.getPrize();
            hm.put(curRank, hm.get(curRank) + 1);
        }

        printStatistics(hm);

        double profitRate = (double) winPrice / amount.getAmount() * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);

    }

    private static List<Integer> parseLottoNumbers(String lottoNums) { //입력 -> List<Integer>
        String[] tokens = lottoNums.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token.trim()); // 쉼표 다음에 공백이 올 수 있으므로 trim()을 사용
            numbers.add(number);
        }
        return numbers;
    }

    private static Lotto getWinNumbers(){
        while(true){
            try {
                System.out.print("당첨 번호를 입력하세요: ");
                String LottoNums = Console.readLine();
                List<Integer> LottoNumsIntList = parseLottoNumbers(LottoNums);
                Lotto winLotto = new Lotto(LottoNumsIntList);
                return winLotto;
            }catch (NumberFormatException e) { //ParseInt에서 던지는 exception
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다.");
            } catch (IllegalArgumentException e) { //Lotto class에서 던지는 exception
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getBonusNumber(Lotto winLotto) {
        while (true) {
            try {
                System.out.print("보너스 번호를 입력해 주세요: ");
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                winLotto.checkBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lotto makeRandomLotto(){
        List<Integer> numberList = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(numberList);
    }

    private static HashMap<Rank, Integer> initHashMap(){
        HashMap<Rank, Integer> hm = new HashMap<>();
        for (Rank rank : Rank.values()) {
            hm.put(rank, 0);
        }
        return hm;
    }

    public static void printStatistics(Map<Rank, Integer> statistics) {
        int totalWinPrice = 0;
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }
            int count = statistics.getOrDefault(rank, 0);
            totalWinPrice += rank.getPrize() * count;

            String bonusText = "";
            if (rank.isBonusMatch()) {
                bonusText = ", 보너스 볼 일치";
            }

            System.out.println(rank.getMatchCount() + "개 일치" + bonusText + " (" + formatter.format(rank.getPrize()) + "원) - " + count + "개");
        }
    }
}
