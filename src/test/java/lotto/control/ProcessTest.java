//package lotto.control;
//
//import camp.nextstep.edu.missionutils.Console;
//import lotto.domain.seller.LottoSeller;
//import lotto.domain.user.User;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.MockedStatic;
//
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.mockStatic;
//
//class ProcessTest {
//    private static MockedStatic<Console> console;
//    private User user;
//    private Process process;
//    private LottoSeller lottoSeller;
//
//    @AfterAll
//    public static void tearDown() {
//        console.close();
//    }
//
//    @BeforeEach
//    void setUp() {
//        this.user = new User();
//        this.lottoSeller = new LottoSeller();
//        this.process = new Process();
//        console = mockStatic(Console.class);
//    }
//
//    @DisplayName("사용자가 로또를 로또판매자한테 산다.")
//    @Test
//    void buyLotto() {
//        // given
//        String input = "8000";
//        given(Console.readLine()).willReturn(input);
//
//        // when
//        process.buyLotto();
//
//        // than
//    }
//
//    @DisplayName("사용자가 로또를 로또판매자한테 산다.")
//    @Test
//    void showLotto() {
//        // given
//        String input = "8000";
//        given(Console.readLine()).willReturn(input);
//
//        // when
//        process.buyLotto();
//        StringBuilder result = process.showLottosInformation();
//
//        System.out.println("result = " + result);
//        // than
//    }
//
//    @DisplayName("게임 진행자가 당첨 번호를 뽑는다.")
//    @Test
//    void pickWinNum() {
//        // given
//        String input = "1,2,3,4,5,6";
//        given(Console.readLine()).willReturn(input);
//
//        // when
//        String result = process.pickWinNumber();
//
//        System.out.println("result = " + result);
//        // than
//    }
//
//    @DisplayName("게임 진행자가 보너스 번호를 뽑는다.")
//    @Test
//    void pickBonusNumber() {
//        // given
//        String input = "7";
//        given(Console.readLine()).willReturn(input);
//
//        // when
//        String result = process.pickBonusNumber();
//
//        System.out.println("result = " + result);
//        // than
//    }
//
//    @DisplayName("유저가 결과를 통계한다.")
//    @Test
//    void showStatisticResult() {
//        // given
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i + "번째");
//            String inputMoney = "8000";
//            given(Console.readLine()).willReturn(inputMoney);
//            process.buyLotto();
//
//            String inputWinNums = "1,2,3,4,5,6";
//            given(Console.readLine()).willReturn(inputWinNums);
//            String resultWinNum = process.pickWinNumber();
//
//            String inputBonusNum = "7";
//            given(Console.readLine()).willReturn(inputBonusNum);
//            String resultBonusNum = process.pickBonusNumber();
//
//            // when
//
//            StringBuilder result = process.showStatisticResult();
//
//            System.out.println("result = " + result);
//            System.out.println();
//        }
//        // than
//    }
//
//    @DisplayName("유저가 수익률을 알려준다.")
//    @Test
//    void showRateResult() {
//        // given
//        String inputMoney = "8000";
//        given(Console.readLine()).willReturn(inputMoney);
//        process.buyLotto();
//
//        String inputWinNums = "1,2,3,4,5,6";
//        given(Console.readLine()).willReturn(inputWinNums);
//        String resultWinNum = process.pickWinNumber();
//
//        String inputBonusNum = "7";
//        given(Console.readLine()).willReturn(inputBonusNum);
//        String resultBonusNum = process.pickBonusNumber();
//
//        // when
//
//        process.showStatisticResult();
//        StringBuilder result = process.showRateResult();
//
//        System.out.println("result = " + result);
//        System.out.println();
//        // than
//    }
//
//}