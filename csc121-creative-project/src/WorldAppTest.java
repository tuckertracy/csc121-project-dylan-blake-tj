import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WorldAppTest {

    BasketBall b1 = new BasketBall(new Posn(260, 210), new Posn(4, 3), 15);
    Hoop h1 = new Hoop(new Posn(250,230),new Pole(60,10),new Board(40,48),20,false);
    
    @Test
    void testBallMethods() {
        
        /*assertEquals(new BasketBall(new Posn(104, 103), new Posn(4, 2.5f), 15),
                    b1.move());*/
        
        assertEquals(true, b1.loc.distanceTo(h1.loc) <= 25);
        
    }

}
