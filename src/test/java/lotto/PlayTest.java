package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayTest {

    @Test
    void giveNumberOfTicket() {
        Play play = new Play();
        assertEquals(2, play.giveNumberOfTicket("2000"));
    }

}