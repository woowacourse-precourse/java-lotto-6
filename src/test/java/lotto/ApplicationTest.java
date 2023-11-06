package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


    @Test
    @DisplayName("구매자에게 구매금액을 입력받는다.")
    void inputPurchaseAmount() {
        String inputPurchaseAmount = inputPurchaseAmount("10000");
        assertThat(inputPurchaseAmount).isEqualTo("10000");
    }

    @DisplayName("구매자에게 구매금액을 입력받는 메서드.")
    private String inputPurchaseAmount(String input){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner in = new Scanner(input);
        input = in.next();
        return input;
    }

    @Test
    @DisplayName("입력한 값이 숫자인지 검증한다.")
    void inputPurchaseAmountValidation_정상케이스() {
        assertThatCode(() -> inputPurchaseAmountValidation("12000"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력한 값이 숫자가 아닌지 검증한다.")
    void inputPurchaseAmountValidation_예외케이스() {
        assertThatThrownBy(() -> inputPurchaseAmountValidation("테스트"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액을 숫자로 입력해 주세요. 예) 10000");
    }

    @DisplayName("입력 받은 값이 숫자인지 검증하는 메서드")
    private  int inputPurchaseAmountValidation(String inputPurchaseAmount){
        try {
            int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
            return purchaseAmount;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입금액을 숫자로 입력해 주세요. 예) 10000");
        }
    }

    @Test
    @DisplayName("입력한 값이 1,000원 단위인지 검증한다.")
    void lottoQuantity_정상케이스() {
        assertThatCode(() -> lottoQuantity(12000))
                .doesNotThrowAnyException();

        int lottoQuantity = lottoQuantity(10000);
        assertThat(lottoQuantity).isEqualTo(10);
    }

    @Test
    @DisplayName("입력한 값이 1,000원 단위가 아닌지 검증한다.")
    void lottoQuantity_예외케이스() {
        assertThatThrownBy(() -> lottoQuantity(12300))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액을 1,000원 단위로 입력하세요.");
    }

    @DisplayName("입력 받은 값이 1,000원 단위인지 검증하는 메서드")
    private int lottoQuantity(int lottoPurchaseAmount){
        int lottoPurchaseAmountRemain = lottoPurchaseAmount % 1000;
        if(lottoPurchaseAmountRemain != 0){
            throw new IllegalArgumentException("[ERROR] 구입금액을 1,000원 단위로 입력하세요.");
        }
        int lottoQuantity = lottoPurchaseAmount / 1000;
        return lottoQuantity;
    }

    @Test
    @DisplayName("입력받은 n개의 로또를 생성한다.")
    void createLottos() {
        List<Lotto> lottos = createLottos(5);
        assertThat(lottos.size()).isEqualTo(5);
    }

    @DisplayName("입력받은 n개의 로또를 생성하는 메서드")
    private List<Lotto> createLottos(int lottoQuantity){
        List<Lotto> lottos= new ArrayList<>();
        for(int quantity = 1; quantity <= lottoQuantity ; quantity++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    @Test
    @DisplayName("생성된 로또의 번호를 구매자에게 뵤여준다.")
    void purchaseLottoNumbersDisplay() {
        List<Lotto> lottos = createLottos(5);
        purchaseLottoNumbersDisplay(lottos);
    }

    @DisplayName("생성된 로또의 번호를 구매자에게 보여주는 메서드")
    private void purchaseLottoNumbersDisplay(List<Lotto> lottos){
        int lottoQuantity = lottos.size();
        System.out.println(lottoQuantity+"개를 구매했습니다.");
        for (int quantity = 1 ; quantity <= lottoQuantity ; quantity++){
            lottos.get(quantity-1).lottoNumberDisplay();
        }
    }

    @Test
    @DisplayName("당첨번호를 입력받는다.")
    void inputWinningNumber() {
        String inputPurchaseAmount = inputPurchaseAmount("1,2,3,4,5,6");
        assertThat(inputPurchaseAmount).isEqualTo("1,2,3,4,5,6");
    }
    @DisplayName("당첨번호를 입력받는 메서드")
    private String inputWinningNumber(String inputWinningNumber){
        System.out.println("당첨 번호를 입력해 주세요.");
        Scanner in = new Scanner(inputWinningNumber);
        inputWinningNumber = in.next();
        return inputWinningNumber;
    }

    @Test
    @DisplayName("입력받은 당첨번호를 쉼표(,) 기준으로 나눈다.")
    void inputWinningNumberSplit_정상케이스() {
        String inputWinningNumber = "1,2,3,4,5,6";
        String[] strings = inputWinningNumberSplit(inputWinningNumber);
        assertThat(strings).contains("1","2","3","4","5","6");
    }

    @Test
    @DisplayName("입력받은 당첨번호를 쉼표(,) 긴준으로 나눈다.")
    void inputWinningNumberSplit_예외케이스() {
        assertThatThrownBy(() -> inputWinningNumberSplit("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호를 쉼표(,)를 기준으로 6자리를 입력해주세요.");
    }
    @DisplayName("입력받은 당첨번호를 쉼표(,) 기준으로 나누는 메서드")
    private String[] inputWinningNumberSplit(String inputWinningNumber){
        String[] inputWinningNumberSplit = inputWinningNumber.split(",");
        if(inputWinningNumberSplit.length != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 쉼표(,)를 기준으로 6자리를 입력해주세요.");
        }
        return inputWinningNumberSplit;
    }

    @Test
    @DisplayName("쉼표(,) 긴준으로 나누어진 당첨번호가 숫자인지 검증한다.")
    void inputWinningNumberValidation_정상케이스() {
        String[] winningNumberSplit = {"1","2","3","4","5","6"};
        assertThatCode(() -> inputWinningNumberValidation(winningNumberSplit))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("쉼표(,) 긴준으로 나누어진 당첨번호가 숫자가 아닌지 검증한다")
    void inputWinningNumberValidation_예외케이스() {
        String[] winningNumberSplit = {"1","a","b","4","c","6"};
        assertThatThrownBy(() ->  inputWinningNumberValidation(winningNumberSplit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호를 숫자만 입력해주세요.");
    }

    @Test
    @DisplayName("숫자인지 검증이 완료되면 오름차순 정렬하여 List에 저장한다.")
    void inputWinningNumberValidation_정상케이스_오름차순정렬() {
        String[] winningNumberSplit = {"5","1","6","2","4","3"};
        List<Integer> winningNumber = inputWinningNumberValidation(winningNumberSplit);

        assertThat(winningNumber).containsExactly(1,2,3,4,5,6);
    }

    @DisplayName("쉼표(,) 기준으로 나누어진 당첨번호가 숫자인지 검증하는 메서드")
    public List<Integer> inputWinningNumberValidation(String[] inputWinningNumberSplit){
        try {
            List<Integer> winningNumber = new ArrayList<>();
            for (int i = 0 ; i < inputWinningNumberSplit.length ; i++){
                int number = Integer.parseInt(inputWinningNumberSplit[i]);
                winningNumber.add(number);
            }
            Collections.sort(winningNumber);
            return winningNumber;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 숫자만 입력해주세요.");
        }
    }

    @Test
    @DisplayName("보너스 번호를 입력받는다.")
    void inputBonusNumber() {
        String inputBonusNumber = inputBonusNumber("7");
        assertThat(inputBonusNumber).isEqualTo("7");
    }

    @DisplayName("보너스 번호를 입력받는 메서드")
    private String inputBonusNumber(String inputWinningNumber){
        System.out.println("보너스 번호를 입력해 주세요.");
        Scanner in = new Scanner(inputWinningNumber);
        inputWinningNumber = in.next();
        return inputWinningNumber;
    }

    @Test
    @DisplayName("보너스 번호가 숫자인지 검증한다.")
    void inputBonusNumberValidation_정상케이스() {
        assertThatCode(() -> inputBonusNumberValidation("7"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닌지 검증한다.")
    void inputBonusNumberValidation_예외케이스() {
        assertThatThrownBy(() -> inputBonusNumberValidation("칠"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호를 숫자로 입력해주세요.");
    }

    @DisplayName("보너스 번호가 숫자인지 검증하는 메서드")
    private int inputBonusNumberValidation(String inputBonusNumber){
        try {
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            return bonusNumber;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 숫자로 입력해주세요.");
        }
    }

    @Test
    @DisplayName("보너스 번호가 1~45 사이의 숫자인지 검증한다.")
    void inputBonusNumberRangeValidation_정상케이스() {
        assertThatCode(() -> inputBonusNumberRangeValidation(1))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아닌지 검증한다.")
    void inputBonusNumberRangeValidation_예외케이스() {
        assertThatThrownBy(() -> inputBonusNumberRangeValidation(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1~45 사이의 숫자를 입력해 주세요.");
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자인지 검증하는 메서드")
    private int inputBonusNumberRangeValidation(int inputBonusNumberValidation){

        if(inputBonusNumberValidation < 1 || inputBonusNumberValidation > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자를 입력해 주세요.");
        }
        return inputBonusNumberValidation;
    }

    @Test
    @DisplayName("로또의 당첨 금액을 계산한다.")
    void lottoWinningAmount() {
        List<Integer> lotto = new ArrayList<>(Arrays.asList(4,5,6,7,8,10));
        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(4,5,6,7,8,9));
        int bonusNumber = 10;

        int result = lottoWinningAmount(lotto, winningNumber, bonusNumber);

        assertThat(result).isEqualTo(30000000);
    }

    @DisplayName("로또 번호와 당첨번호를 매칭하여 당첨금액을 구하는 메서드")
    public int lottoWinningAmount(List<Integer> lotto ,List<Integer> winningNumber, int bonusNumber){
        int matchCount = 0;
        for(int i = 0 ; i < winningNumber.size() ; i++){
            if(lotto.contains(winningNumber.get(i))){
                matchCount++;
            }
        }

        if(matchCount == 3){
            return 5000;
        }
        if(matchCount == 4){
            return 50000;
        }
        if(matchCount == 5){
            if(lotto.contains(bonusNumber)){
                return 30000000;
            }
            return 1500000;
        }
        if(matchCount == 6){
            return 200000000;
        }
        return 0;
    }

    @Test
    @DisplayName("총 수익률을 계산하고 당첨 내역을 보여준다.")
    void lottoWinningResult() {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        int bonusNumber = 7;

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,7,19,15));
        Lotto lotto = new Lotto(numbers);

        lottos.add(lotto);

        lottoWinningResult(lottos,winningNumber,bonusNumber);

    }

    @DisplayName("총 수익률을 계산하고 당첨 내역을 보여주는 메서드")
    public void lottoWinningResult (List<Lotto> lottos ,List<Integer> winningNumber, int bonusNumber){
        int totalWinningAmount = 0;
        double totalReturnRate = 0.0;
        int lottoQuantity = lottos.size();
        double totalLottoPurchase = 1000 * lottoQuantity;

        int threeMatches = 0;
        int fourMatches = 0;
        int fiveMatches = 0;
        int fiveBonusMatches = 0;
        int sixMatches = 0;

        for (int quantity = 0 ; quantity < lottoQuantity ; quantity ++){

            int winningAmount = lottoWinningAmount(lottos.get(quantity).getNumbers(), winningNumber, bonusNumber);
            totalWinningAmount += winningAmount;

            if(winningAmount == 5000){
                threeMatches++;
            }

            if(winningAmount == 50000){
                fourMatches++;
            }

            if(winningAmount == 1500000){
                fiveMatches++;
            }

            if(winningAmount == 30000000){
                fiveBonusMatches++;
            }

            if(winningAmount == 200000000){
                sixMatches++;
            }

        }

        totalReturnRate = (totalWinningAmount/totalLottoPurchase)*100;
        String totalRate = String.format("%.1f",totalReturnRate);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + threeMatches+"개");
        System.out.println("4개 일치 (50,000원) - " + fourMatches+"개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveMatches+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveBonusMatches+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixMatches+"개");
        System.out.println("총 수익률은 "+ totalRate +"%입니다.");
    }

}
