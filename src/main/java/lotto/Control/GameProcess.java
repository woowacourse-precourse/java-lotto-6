package lotto.Control;

import java.util.ArrayList;
import java.util.List;

import lotto.DTO.AutoTicketDTO;
import lotto.DTO.DrawWinNumberDTO;
import lotto.DTO.StatResultDTO;
import lotto.DTO.SystemMessageDTO;
import lotto.Model.CheckPurchaseAmount;
import lotto.Model.CheckWinNumber;
import lotto.Model.MakeAutoTicket;
import lotto.Model.MakeTotalProceeds;
import lotto.Model.SortList;
import lotto.Model.StringToInt;
import lotto.Model.StringToList;
import lotto.View.CallSystemMessage;

public class GameProcess {
    CallSystemMessage callMessage = new CallSystemMessage();
    PressEnter lottoInputSystem = new PressEnter();
    CheckPurchaseAmount validatecheck = new CheckPurchaseAmount();

    public GameProcess() {
        // 시작 메세지, 입력 받기, 형 변환
        callMessage.printMessage(SystemMessageDTO.INPUT_PURCHASE_AMOUNT, true);
        lottoInputSystem.plzPressEnter();
        String inputPurchaseAmount = lottoInputSystem.getInput();
        int makeNumber = 0;

        try {
            StringToInt sToIParser = new StringToInt(inputPurchaseAmount);
            makeNumber = sToIParser.getInteger();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다시 입력하세요.");
        }

        System.out.println();

        // DTO에 저장, 유효 검사 및 티켓 수 획득
        AutoTicketDTO autoTicketDTO = new AutoTicketDTO(makeNumber);
        int purchaseAmount = autoTicketDTO.getPurcahseAmount();
        int checkPurchaseAmount = validatecheck.getNumberOfTicket(purchaseAmount);
        autoTicketDTO.setNumberOfTicket(checkPurchaseAmount);
        int numberOfTicket = autoTicketDTO.getNumberOfTicket();
        System.out.print(numberOfTicket);
        callMessage.printMessage(SystemMessageDTO.OUTPUT_NUMBER_OF_TICKET, true);
        SortList sort = new SortList();
        for (int i = 0; i < numberOfTicket; i++) {
            MakeAutoTicket makeAutoTicket = new MakeAutoTicket();
            autoTicketDTO.setAutoTicket(i, sort.sortAsc(makeAutoTicket.getnumbers()));
            System.out.println(autoTicketDTO.getAutoTicket(i));
        }

        // 당첨번호 지정
        System.out.println();
        callMessage.printMessage(SystemMessageDTO.INPUT_WINNING_NUMBERS, true);

        lottoInputSystem.plzPressEnter();
        String inputWinNumbers = lottoInputSystem.getInput();
        StringToList sToLParser = new StringToList(inputWinNumbers);
        List<Integer> winNumbers = sToLParser.getListInteger();

        DrawWinNumberDTO drawWinNumberDTO = new DrawWinNumberDTO(winNumbers);
        System.out.println();
        callMessage.printMessage(SystemMessageDTO.INPUT_BONUS_NUMBER, true);

        lottoInputSystem.plzPressEnter();
        String inputBonusNumber = lottoInputSystem.getInput();
        StringToInt sToIParser = new StringToInt(inputBonusNumber);
        int bonusNumber = sToIParser.getInteger();

        drawWinNumberDTO.setBonusNumber(bonusNumber);

        StatResultDTO statResultDTO = new StatResultDTO();
        CheckWinNumber checkWinNumber = new CheckWinNumber();

        for (int i = 0; i < numberOfTicket; i++) {
            int cnt = checkWinNumber.checkWinNumber(autoTicketDTO.getAutoTicket(i), drawWinNumberDTO.getWinNumber(),
                    drawWinNumberDTO.getBonusNumber());

            if (cnt == 3)
                statResultDTO.setWinCount(0, statResultDTO.getWinCount(0) + 1);
            if (cnt == 4)
                statResultDTO.setWinCount(1, statResultDTO.getWinCount(1) + 1);
            if (cnt == 5)
                statResultDTO.setWinCount(2, statResultDTO.getWinCount(2) + 1);
            if (cnt == 7)
                statResultDTO.setWinCount(3, statResultDTO.getWinCount(3) + 1);
            if (cnt == 6)
                statResultDTO.setWinCount(4, statResultDTO.getWinCount(4) + 1);
        }
        System.out.println();

        callMessage.printMessage(SystemMessageDTO.COMMENT_WINNING_STAT, true);
        callMessage.printMessage(SystemMessageDTO.HORIZONTAL_RULE, true);
        callMessage.printMessage(SystemMessageDTO.FIFTH_STAT, false);
        System.out.println(statResultDTO.getWinCount(0) + "개");
        callMessage.printMessage(SystemMessageDTO.FOURTH_STAT, false);
        System.out.println(statResultDTO.getWinCount(1) + "개");
        callMessage.printMessage(SystemMessageDTO.THIRD_STAT, false);
        System.out.println(statResultDTO.getWinCount(2) + "개");
        callMessage.printMessage(SystemMessageDTO.SECOND_STAT, false);
        System.out.println(statResultDTO.getWinCount(3) + "개");
        callMessage.printMessage(SystemMessageDTO.FIRST_STAT, false);
        System.out.println(statResultDTO.getWinCount(4) + "개");

        MakeTotalProceeds makeTotalProceeds = new MakeTotalProceeds();

        makeTotalProceeds.makeTotalProceeds(statResultDTO);
        statResultDTO.setRateOfReturn(statResultDTO.getTotalProceeds(), autoTicketDTO.getPurcahseAmount());
        callMessage.printMessage(SystemMessageDTO.TOTAL_STAT, false);
        System.out.print(statResultDTO.getRateOfReturn() + "%");
        callMessage.printMessage(SystemMessageDTO.POSTPOSITION, false);
    }

}
