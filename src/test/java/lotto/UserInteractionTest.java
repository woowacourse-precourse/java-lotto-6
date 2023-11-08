package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserInteractionTest {

    @Test
    void promptBudget() {
    }

    @Test
    void printTickets() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(5,10,15,42,44,45)),
                new Lotto(List.of(5,10,15,43,4,45)),
                new Lotto(List.of(5,10,15,20,44,45)),
                new Lotto(List.of(5,10,15,20,43,45)),
                new Lotto(List.of(5,10,15,20,42,45)),
                new Lotto(List.of(5,10,15,20,25,40)),
                new Lotto(List.of(5,10,15,20,25,41)),
                new Lotto(List.of(5,10,15,20,25,35)),
                new Lotto(List.of(5,10,15,20,25,30))
        );
        UserInteraction.printTickets(tickets);
    }
}