package lotto.system.shop.domain;

import static lotto.system.shop.domain.GuideMessage.INPUT_MONEY;
import static lotto.system.shop.domain.GuideMessage.WINNING_STATISTICS;
import static lotto.system.shop.domain.GuideMessage.WINNING_STATISTICS_HEADER;
import static lotto.system.shop.domain.MessageFormat.PURCHASE_AMOUNT_FORMAT;
import static lotto.system.shop.domain.MessageFormat.RATE_OF_RETURN_FORMAT;
import static lotto.system.shop.domain.MessageFormat.WINNING_BONUS_PRINT_FORMAT;
import static lotto.system.shop.domain.MessageFormat.WINNING_PRINT_FORMAT;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lotto.system.shop.domain.manager.lotto.LottoMachineManager;
import lotto.system.shop.domain.ticket.lotto.LottoTicket;
import lotto.system.shop.exception.reader.InvalidNumberTypeException;

public class LottoShop {

    private static final String CRLF = "";
    private static final String DECIMAL_FORMAT = "###,###";
    private static final DecimalFormat DF = new DecimalFormat(DECIMAL_FORMAT);
    private static final Integer RANK_MAP_INITIAL_VALUE = 0;
    private static final Integer RANK_ADD_COUNT = 1;
    private static final int INITIAL_TOTAL_WINNING_MONEY = 0;

    private final Machine<LottoTicket, LottoRank> machine;
    private final Viewer viewer;
    private final Reader reader;

    public LottoShop(Machine<LottoTicket, LottoRank> machine, Viewer viewer, Reader reader) {
        this.machine = machine;
        this.viewer = viewer;
        this.reader = reader;
    }

    private LottoShop(ShopOwner<LottoTicket, LottoRank> owner) {
        this(owner.getMachine(), owner.getViewer(), owner.getReader());
    }

    public static LottoShop open(ShopOwner<LottoTicket, LottoRank> owner) {
        return new LottoShop(owner);
    }

    public void operate() {
        Integer inputMoney = getMoneyProcess();
        List<LottoTicket> tickets = buyTicketsProcess(inputMoney);
        LottoMachineManager manager = LottoMachineManager.bring();
        manager.initialize(machine, reader, viewer);
        Map<LottoRank, Integer> results = matchTicketsProcess(tickets);
        calculateResultsProcess(results, inputMoney);
    }

    private Integer getMoneyProcess() {
        viewer.print(INPUT_MONEY);
        Integer money = getMoney();
        viewer.print(CRLF);
        return money;
    }

    private Integer getMoney() {
        Integer money = null;
        try {
            money = reader.readNumber();
        } catch (InvalidNumberTypeException exception) {
            viewer.print(exception.getMessage());
            getMoney();
        }
        return money;
    }

    private List<LottoTicket> buyTicketsProcess(Integer money) {
        List<LottoTicket> tickets = machine.buy(money);
        viewer.print(PURCHASE_AMOUNT_FORMAT, tickets.size());
        for (LottoTicket ticket : tickets) {
            viewer.print(ticket.getSource().toString());
        }
        viewer.print(CRLF);
        return tickets;
    }

    private Map<LottoRank, Integer> matchTicketsProcess(List<LottoTicket> tickets) {
        List<LottoRank> ranks = machine.match(tickets);
        Map<LottoRank, Integer> results = Arrays.stream(LottoRank.values())
            .collect(getMapCollector());
        for (LottoRank rank : ranks) {
            results.merge(rank, RANK_ADD_COUNT, Integer::sum);
        }
        return results;
    }

    private Collector<LottoRank, ?, Map<LottoRank, Integer>> getMapCollector() {
        return Collectors.toMap(rank -> rank, rank -> RANK_MAP_INITIAL_VALUE,
            zeroInitializeOperator(), reverseOrderByRankSupplier());
    }

    private BinaryOperator<Integer> zeroInitializeOperator() {
        return (Integer o, Integer n) -> RANK_MAP_INITIAL_VALUE;
    }

    private Supplier<Map<LottoRank, Integer>> reverseOrderByRankSupplier() {
        return () -> new TreeMap<>(LottoRank::reverseComparator);
    }

    private void calculateResultsProcess(Map<LottoRank, Integer> results, Integer money) {
        viewer.print(WINNING_STATISTICS);
        viewer.print(WINNING_STATISTICS_HEADER);
        int totalWinningMoney = calculateTotalWinningMoney(results);
        viewer.print(RATE_OF_RETURN_FORMAT, getRoR(totalWinningMoney, money));
    }

    private int calculateTotalWinningMoney(Map<LottoRank, Integer> results) {
        int totalWinningMoney = INITIAL_TOTAL_WINNING_MONEY;
        for (Map.Entry<LottoRank, Integer> result : results.entrySet()) {
            LottoRank lottoRank = result.getKey();
            Integer matchTicketCount = result.getValue();
            totalWinningMoney += calculateWinningMoney(lottoRank, matchTicketCount);
        }
        return totalWinningMoney;
    }

    private int calculateWinningMoney(LottoRank rank, Integer matchTicketCount) {
        boolean isMatchBonus = rank.getMatchBonus();
        Integer matchCount = rank.getMatchCount();
        Integer winningMoney = rank.getWinningMoney();
        if (!rank.isMiss()) {
            printResult(isMatchBonus, matchCount, winningMoney, matchTicketCount);
        }
        return winningMoney * matchTicketCount;
    }

    private void printResult(boolean isMatchBonus, Integer matchCount, Integer winningMoney,
        Integer matchTicketCount) {
        String winningAmount = DF.format(winningMoney);
        if (isMatchBonus) {
            viewer.print(WINNING_BONUS_PRINT_FORMAT, matchCount, winningAmount, matchTicketCount);
            return;
        }
        viewer.print(WINNING_PRINT_FORMAT, matchCount, winningAmount, matchTicketCount);
    }

    private double getRoR(double totalWinningMoney, Integer money) {
        assert money != null;
        return (totalWinningMoney / money) * 100;
    }
}