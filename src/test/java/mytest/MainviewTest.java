//package mytest;
//
//import java.io.ByteArrayOutputStream;
//import java.io.OutputStream;
//import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.EnumMap;
//import java.util.List;
//import model.Rank;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import view.MainView;
//;
//import static org.assertj.core.api.Assertions.*;
//
//public class MainviewTest {
//
//    private PrintStream oldOut;
//    private OutputStream whereToSave;
//
//    @BeforeEach
//    private final void init() {
//        oldOut = System.out;
//        whereToSave = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(whereToSave));
//    }
//
//    @AfterEach
//    private final void printOutput() {
//        System.setOut(oldOut);
//        System.out.println(output());
//    }
//
//    private final String output() {
//        return whereToSave.toString().trim();
//    }
//
//    MainView testVeiw = new MainView();
//
//    @Test
//    void requestHowManyTest() {
//        testVeiw.requestHowMany();
//        assertThat(output()).isEqualTo("구입금액을 입력해 주세요.");
//    }
//
//    @Test
//    void requestNumbersTest() {
//        testVeiw.requestNumbers();
//        assertThat(output()).isEqualTo("당첨 번호를 입력해 주세요.");
//    }
//
//    @Test
//    void requestBonusNumberTest() {
//        testVeiw.requestBonusNumber();
//        assertThat(output()).isEqualTo("보너스 번호를 입력해 주세요.");
//    }
//
//    @Test
//    void printResultTest() {
//        EnumMap<Rank, Integer> testMap = new EnumMap<>(Rank.class);
//        testMap.put(Rank.FOURTH, 1);
//        testMap.put(Rank.FIFTH, 1);
//        testVeiw.printresult(testMap);
//        assertThat(output()).isEqualTo("당첨 통계\n"
//                + "---\n"
//                + "3개 일치 (5,000원) - 1개\n"
//                + "4개 일치 (50,000원) - 1개\n"
//                + "5개 일치 (1,500,000원) - 0개\n"
//                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
//                + "6개 일치 (2,000,000,000원) - 0개");
//    }
//
//    @Test
//    void printRateOfProfitTest() {
//        testVeiw.printRateOfProfit("62.5");
//        assertThat(output()).isEqualTo("총 수익률은 62.5%입니다.");
//    }
//
//    @Test
//    void printHowManyAndLottosTest() {
//        Integer[] testInt = new Integer[]{1, 2, 3, 4, 5, 6};
//        List<Integer[]> testList = new ArrayList<>();
//        testList.add(testInt);
//        testVeiw.printHowManyAndLottos(testList);
//        assertThat(output()).isEqualTo("1개를 구매했습니다.\n"
//                + "[1, 2, 3, 4, 5, 6]");
//    }
//
//}
