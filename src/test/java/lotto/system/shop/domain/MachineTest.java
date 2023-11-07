package lotto.system.shop.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.system.shop.domain.ticket.lotto.Lotto;
import lotto.system.shop.domain.ticket.lotto.LottoTicket;
import lotto.system.shop.exception.machine.AlreadyInitializeException;
import lotto.system.shop.exception.machine.DuplicatedBonusNumberException;
import lotto.system.shop.exception.machine.DuplicatedLottoNumberException;
import lotto.system.shop.exception.machine.InvalidLottoPurchaseAmountException;
import lotto.system.shop.exception.machine.NotInitializeException;
import lotto.system.shop.machine.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MachineTest {

    @Test
    @DisplayName("로또 기계를 생성 하기 위해서는 공을 넣고 초기화를 해주어야 한다.")
    void create() {
        // given
        Machine<LottoTicket, LottoRank> machine = new LottoMachine();
        machine.set(List.of(1, 2, 3, 4, 5, 6));
        machine.set(7);
        machine.initialize();

        // when && then
        assertInstanceOf(LottoMachine.class, machine);
    }

    @Test
    @DisplayName("로또 기계에 초기화를 하지 않으면 로또를 비교할 수 없다.")
    void needInitialize() {
        // given
        Machine<LottoTicket, LottoRank> machine = new LottoMachine();

        // when && then
        assertAll(
            () -> assertThrows(NotInitializeException.class, () -> {
                machine.match(new LottoTicket(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
            }),
            () -> assertThrows(NotInitializeException.class, () -> {
                machine.match(List.of(new LottoTicket(new Lotto(List.of(1, 2, 3, 4, 5, 6)))));
            })
        );
    }

    @Test
    @DisplayName("로또 기계에 초기화를 여러번 할 수 없다.")
    void initializeTwice() {

        // given
        Machine<LottoTicket, LottoRank> machine = new LottoMachine();

        // when
        machine.set(List.of(1, 2, 3, 4, 5, 6));
        machine.set(7);

        // then
        assertAll(
            () -> assertThrows(AlreadyInitializeException.class, () -> {
                machine.set(List.of(1, 2, 3, 4, 5, 6));
            }),
            () -> assertThrows(AlreadyInitializeException.class, () -> {
                machine.set(7);
            })
        );
    }

    @Test
    @DisplayName("로또 기계에 중복된 번호를 넣을 수 없다.")
    void duplicateNumber() {
        // given
        Machine<LottoTicket, LottoRank> machine = new LottoMachine();

        // when && then
        assertAll(
            () -> assertThrows(DuplicatedLottoNumberException.class, () -> {
                machine.set(List.of(1, 2, 3, 4, 5, 5));
            }),
            () -> assertThrows(DuplicatedBonusNumberException.class, () -> {
                machine.set(List.of(1, 2, 3, 4, 5, 6));
                machine.set(6);
            })
        );
    }

    @Test
    @DisplayName("로또 기계에 1000월을 주면 로또 1개를 살 수 있다.")
    void buy() {
        // given
        Machine<LottoTicket, LottoRank> machine = new LottoMachine();
        machine.set(List.of(1, 2, 3, 4, 5, 6));
        machine.set(7);
        machine.initialize();

        // when
        List<LottoTicket> tickets = machine.buy(1000);

        // then
        assertEquals(1, tickets.size());
    }

    @Test
    @DisplayName("로또 기계에 1000원 단위로만 로또를 살 수 있다.")
    void buyOnlyThousandWonStandard() {
        // given
        Machine<LottoTicket, LottoRank> machine = new LottoMachine();
        machine.set(List.of(1, 2, 3, 4, 5, 6));
        machine.set(7);
        machine.initialize();

        // when && then
        assertThrows(InvalidLottoPurchaseAmountException.class, () -> {
            machine.buy(999);
        });
    }

    @Test
    @DisplayName("로또 기계를 로또 티켓과 자신의 로또 번호를 비교할 수 있다.")
    void match() {
        // given
        Machine<LottoTicket, LottoRank> machine = new LottoMachine();
        machine.set(List.of(1, 2, 3, 4, 5, 6));
        machine.set(7);
        machine.initialize();
        LottoTicket ticket = new LottoTicket(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        // when
        LottoRank rank = machine.match(ticket);

        // then
        assertEquals(LottoRank.FIRST, rank);
    }

    @Test
    @DisplayName("로또 기계를 로또 티켓들과 자신의 로또 번호를 비교할 수 있다.")
    void matches() {
        // given
        Machine<LottoTicket, LottoRank> machine = new LottoMachine();
        machine.set(List.of(1, 2, 3, 4, 5, 6));
        machine.set(7);
        machine.initialize();
        LottoTicket ticket1 = new LottoTicket(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LottoTicket ticket2 = new LottoTicket(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<LottoTicket> tickets = List.of(ticket1, ticket2);

        // when
        List<LottoRank> results = machine.match(tickets);

        // then
        assertEquals(2, results.size());
        for (LottoRank result : results) {
            assertEquals(LottoRank.FIRST, result);
        }
    }
}