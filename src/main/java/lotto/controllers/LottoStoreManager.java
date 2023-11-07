package lotto.controllers;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;

import java.util.ArrayList;

import static lotto.model.InputValidator.validateDivisibleByThousand;
import static lotto.model.InputValidator.validateNonInteger;
import static lotto.model.Utilities.divide;
import static lotto.model.Utilities.inputIntegerParsing;
import static lotto.views.MessageManager.*;

public class LottoStoreManager {
    private String inputAmount;
    private final double LOTTO_PRICE = 1000;
    private int lottoTicketCount;

    public LottoStoreManager() {
        initialize();
    }

    public void setInput(String inputAmount) {
        this.inputAmount = inputAmount;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public void initialize() {
        setInput(InputProcessor.readLine());

        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            try {
                validateNonInteger(inputAmount);
                validateDivisibleByThousand(inputIntegerParsing(inputAmount));
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                inputAmount = InputProcessor.readLine();
                attempts++;
            }
        }

        if (attempts == maxAttempts) {
            getProgramClosePromoptMessage();
        }
        lottoTicketCount = (int) divide(Double.parseDouble(inputAmount), LOTTO_PRICE);
    }

    public LottoGenerator lottoMachine() {
        return new LottoGenerator(lottoTicketCount);
    }

    public void displayLottoTicketsNumber() {
        LottoGenerator tickets = lottoMachine();
        ArrayList<Lotto> lottoTickets = tickets.getLottoTickets();
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
