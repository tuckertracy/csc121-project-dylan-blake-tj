import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WorldAppTest {

    BasketBall b1 = new BasketBall(new Posn(100, 100), new Posn(4, 3), 15);
    
    @Test
    void testBallMethods() {
        
        assertEquals(new BasketBall(new Posn(104, 103), new Posn(4, 2.5f), 15),
                    b1.move());
        
    }

}
