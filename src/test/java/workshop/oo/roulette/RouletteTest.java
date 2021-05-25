package workshop.oo.roulette;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class RouletteTest {

  @Test
  public void testPlacingMultipleBetsOnRoulette() {
    Roulette roulette = Roulette.american();
    List<Bet> bets = Arrays.asList(
        Bet.straight(1, 5),
        Bet.split(1, 7, 24)
    );

    RouletteAsserts.assertWins(roulette, 380, bets, -700);
    RouletteAsserts.assertAmount(roulette, 380, bets, -40);
  }

}
