//package lotto.v3.manager;
//
//import lotto.v3.controller.*;
//import lotto.v3.model.Lotto;
//import lotto.v3.model.LottoBonusNumber;
//import lotto.v3.model.LottoMachine;
//import lotto.v3.model.LottoWinningNumber;
//import lotto.v3.view.*;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class LottoGameManager {
//
//    private final LottoPurchaseController purchaseController;
//    private final LottoGenerationController lottoGenerationController;
//    private final LottoWinningNumberController lottoWinningNumberController;
//    private final LottoBonusNumberController lottoBonusNumberController;
//    private final LottoResultController lottoResultController;
//
//    public LottoGameManager(
//            LottoPurchaseView purchaseView,
//            LottoGenerateView generateView,
//            LottoWinningNumbersView winningNumbersView,
//            LottoBonusNumberView bonusNumberView,
//            LottoResultView resultView,
//            LottoMachine lottoMachine,
//            LottoWinningNumber winningNumber) {
//
//        this.purchaseController = new LottoPurchaseController(purchaseView);
//        this.lottoGenerationController = new LottoGenerationController(generateView, lottoMachine);
//        this.lottoWinningNumberController = new LottoWinningNumberController(winningNumbersView);
//        this.lottoBonusNumberController = new LottoBonusNumberController(bonusNumberView, winningNumber);
//        this.lottoResultController = new LottoResultController(resultView);
//    }
//
//    public void start() {
//        int numberOfLottoTickets = purchaseController.startPurchaseProcess();
//
//        List<Lotto> lottoTickets = lottoGenerationController.generateLottoTickets(numberOfLottoTickets);
//
//        LottoWinningNumber winningNumber = lottoWinningNumberController.createWinningNumber();
//
//        LottoBonusNumber bonusNumber = lottoBonusNumberController.createBonusNumber();
//
//        // 구매한 티켓의 번호 List들을 Set으로 변환하여 List<Set<Integer>>로 변환
//        List<Set<Integer>> purchasedNumberSets = lottoTickets.stream()
//                .map(ticket -> new HashSet<>(ticket.getNumbers())) // List<Integer>를 Set<Integer>로 변환
//                .collect(Collectors.toList());
//
//        lottoResultController.showResults(
//                purchasedNumberSets,
//                winningNumber.getNumbers(),
//                bonusNumber.getBonusNumber()
//        );
//    }
//}
