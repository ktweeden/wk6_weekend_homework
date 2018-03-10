import Guests.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public void before() {
        this.guest = new Guest("Kate");
    }

    @Test
    public void getName() {
        assertEquals("Kate", guest.getName());
    }
}
