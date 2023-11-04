package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setUp() {

        customer = new Customer("5000");
    }

    @Test
    void buyLottosTest() {

        assertEquals(5, customer.getLottos().size());
    }
}
