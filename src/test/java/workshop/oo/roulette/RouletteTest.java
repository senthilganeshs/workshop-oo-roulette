package workshop.oo.roulette;

import org.junit.Assert;
import org.junit.Test;

public class RouletteTest {

  @Test
  public void testStraightBetOnRolette() {
    Roulette roulette = Roulette.american();
    assertWins(roulette, 380, 5, 10);
  }

  private void assertWins(Roulette roulette, int iter, int bet, int expectedWins) {
    int actualWins = 0;
    while (iter > 0) {
      if (roulette.spin(bet)){
        actualWins++;
      }
      iter--;
    }

    Assert.assertEquals("Got: " + actualWins, expectedWins, actualWins);
  }
}
