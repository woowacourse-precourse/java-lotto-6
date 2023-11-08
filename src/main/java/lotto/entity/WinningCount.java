//package lotto.entity;
//
//import lotto.generator.ClientLottoNumber;
//import lotto.service.NumCountInList;
//import lotto.view.PrintView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class WinningCount{
//    public int totalProfit; // totalProfit를 필드로 이동
//    ClientLottoNumber clientLottoNumber = new ClientLottoNumber();
//
//    public void winCountList() {
//        List<Integer> lottoWinNumber = PrintView.lottoWinNumber;
//        int bonusNumber = PrintView.bonusNumber;
//        List<Integer> winCounts = new ArrayList<>(); // winCounts 초기화
//
//        for (int i = 0; i < clientLottoNumber.LottoNumberList.size(); i++) {
//            List<Integer> compare_list = clientLottoNumber.LottoNumberList.get(i);
//            System.out.println();
//            int winCount = WinCount.calculateWinCount(compare_list, lottoWinNumber, bonusNumber);
//            winCounts.add(winCount); // 각 요소 추가
//        }
//
//        int o = 3;
//        for (WinMessage.WinType winType : WinMessage.WinType.values()) {
//            int count = NumCountInList.countOccurrences(winCounts, o);
//            int prize = PrizePrint.CalculatorPrize.calculatePrize(o);
//            totalProfit += prize * count;
//            o++;
//            System.out.println(winType.getLabel() + " - " + count + "개");
//        }
//
//    }
//}
//
//
//
