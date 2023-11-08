package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    enum LottoRank{
        NONE1,
        NONE2,
        NONE3,
        FIFTH,
        FOUR,
        THIRD,
        SECOND,
        FIRST
    }
    static final int WIN_AND_BONUS = 2;
    static final int START_NUMBER_FOR_WINNING_LOTTO = 3;
    static final int LOTTO_CNT = 6;
    static final int SIZE_OF_RESULT = 7;
    static final int LOTTO_PRICE = 1000;

    static int lottoAmount;
    static int[] lottoNums;
    static int bonusNum;
    static int numberOfLottoPurchased;
    static ArrayList<Lotto> allLottoNums = new ArrayList<>();

    private int inputIntegerNum(){
        String input = Console.readLine();

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);

            if('0' > c || c > '9') {
                System.out.println("[ERROR]");
                return inputIntegerNum();
            }
        }

        return Integer.parseInt(input);
    }

    private int[] inputLottoNums() throws IllegalArgumentException{
        return Arrays.stream(Console.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private int getNumberOfLottoPurchased(){
        return lottoAmount / LOTTO_PRICE;
    }
    private void buyLotto(){
        StringBuilder sb = new StringBuilder();
        numberOfLottoPurchased = getNumberOfLottoPurchased();

        sb.append("\n" + numberOfLottoPurchased + "개를 구매했습니다.\n");
        for(int i = 0; i < numberOfLottoPurchased; i++) {
            allLottoNums.add(getLottoNumbers());
            sb.append(toStringLottoNumber(allLottoNums.get(i)) + "\n");
        }

        System.out.print(sb);
    }

    private Lotto getLottoNumbers(){
        List<Integer> lottoNums = getLottoNumbersWithoutDuplication();

        return new Lotto(lottoNums);
    }

    private String toStringLottoNumber(Lotto lotto){
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        List<Integer> lottoNumbers = lotto.getNumbers();
        for(int i = 0; i < LOTTO_CNT - 1; i++){
            sb.append(lottoNumbers.get(i) + ", ");
        }

        sb.append(lottoNumbers.get(LOTTO_CNT - 1) + "]");

        return sb.toString();
    }

    private List<Integer> getLottoNumbersWithoutDuplication(){
        List<Integer> nums = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return nums;
    }

    private void printLottoResult(){
        numberOfLottoPurchased = getNumberOfLottoPurchased();

        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n");
        sb.append("---\n");

        int[] resultOfLotto = new int[SIZE_OF_RESULT + 1];
        int[] cntOfWinWithBonus = new int[WIN_AND_BONUS];

        getresultOfLotto(resultOfLotto, cntOfWinWithBonus);

        sb.append(getAmountOfRevenue(resultOfLotto, sb));
        System.out.print(sb);

        getRateOfBenefit(resultOfLotto);
    }

    private void getresultOfLotto(int[] resultOfLotto, int[] cntOfWinWithBonus){
        LottoRank[] ranks = LottoRank.values();

        for(int i = 0; i < numberOfLottoPurchased; i++) {
            cntOfWinWithBonus = getLottoResult(i);

            int numberOfWin = cntOfWinWithBonus[0];
            int isBonus = cntOfWinWithBonus[1];

            if(isBonus == 0){
                resultOfLotto[numberOfWin]++;
            }else if(isBonus == 1 && ranks[numberOfWin] == LottoRank.THIRD){
                resultOfLotto[numberOfWin + isBonus]++;
            }
        }
    }

    private int[] getLottoResult(int idx){
        int[] cntOfWinWithBonus = new int[2];

        for(int i = 0; i < LOTTO_CNT; i++){
            if(allLottoNums.get(idx).getNumbers().contains(lottoNums[i]))
                cntOfWinWithBonus[0]++;
        }

        if(allLottoNums.get(idx).getNumbers().contains(bonusNum))
            cntOfWinWithBonus[1]++;

        return cntOfWinWithBonus;
    }

    private String getAmountOfRevenue(int[] resultOfLotto, StringBuilder sb){
        LottoRank[] ranks = LottoRank.values();
        for(int i = START_NUMBER_FOR_WINNING_LOTTO; i <= SIZE_OF_RESULT; i++) {
            LottoRank curRank = LottoRank.valueOf(ranks[i].toString());

            if (curRank == LottoRank.FIFTH)
                sb.append(i + "개 일치 (5,000원) " + "- " + resultOfLotto[i] + "개\n");
            else if (curRank == LottoRank.FOUR)
                sb.append(i + "개 일치 (50,000원) " + "- " + resultOfLotto[i] + "개\n");
            else if (curRank == LottoRank.THIRD)
                sb.append(i + "개 일치 (1,500,000원) " + "- " + resultOfLotto[i] + "개\n");
            else if (curRank == LottoRank.SECOND)
                sb.append(i - 1 + "개 일치, 보너스 볼 일치 (30,000,000원) " + "- " + resultOfLotto[i] + "개\n");
            else if (curRank == LottoRank.FIRST)
                sb.append(i - 1 + "개 일치 (2,000,000,000원) " + "- " + resultOfLotto[i] + "개\n");
        }

        return sb.toString();
    }

    private void getRateOfBenefit(int[] resultOfLotto){
        BigInteger rate = new BigInteger("0");

        LottoRank[] ranks = LottoRank.values();
        for(int i = START_NUMBER_FOR_WINNING_LOTTO; i <=SIZE_OF_RESULT; i++){
            if(resultOfLotto[i] == 0) continue;

            LottoRank curRank = LottoRank.valueOf(ranks[i].toString());
            rate = checkResultValue(rate, curRank);
        }

        BigInteger base = BigInteger.valueOf(numberOfLottoPurchased * LOTTO_PRICE);
        double profitRate = (rate.doubleValue() / base.doubleValue()) * 100;
        profitRate = Math.round(profitRate * 10) / 10.0;

        System.out.printf("%s %.1f%%%s", "총 수익률은", profitRate, "입니다.\n");
    }

    private BigInteger checkResultValue(BigInteger rate, LottoRank curRank){
        if(curRank == LottoRank.FIFTH)
            rate = rate.add(new BigInteger("5000"));
        else if(curRank == LottoRank.FOUR)
            rate = rate.add(new BigInteger("50000"));
        else if(curRank == LottoRank.THIRD)
            rate = rate.add(new BigInteger("1500000"));
        else if(curRank == LottoRank.SECOND)
            rate = rate.add(new BigInteger("30000000"));
        else if(curRank == LottoRank.FIRST)
            rate = rate.add(new BigInteger("2000000000"));

        return rate;
    }

    public void doLotto(){
        System.out.println("구입금액을 입력해주세요.");
        lottoAmount = inputIntegerNum();

        buyLotto();

        System.out.println("\n당첨 번호를 입력해 주세요.");
        lottoNums = inputLottoNums();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusNum = inputIntegerNum();

        printLottoResult();
    }
}
