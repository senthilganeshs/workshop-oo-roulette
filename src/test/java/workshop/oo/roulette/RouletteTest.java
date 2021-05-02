package workshop.oo.roulette;

import org.junit.Test;

public class RouletteTest {

  @Test
  public void testPlacingMultipleBetsOnRoulette() {
    Roulette roulette = Roulette.american();
    Bet[] bets = new Bet [] {
        Bet.straight(1, 5),
        Bet.split(1, 7, 24)
    };

    RouletteAsserts.assertWins(roulette, 380, bets, 30);
    RouletteAsserts.assertAmount(roulette, 380, bets, 320);
  }

}
