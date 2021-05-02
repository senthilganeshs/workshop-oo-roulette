package workshop.oo.roulette;

import org.junit.Assert;

public class RouletteAsserts {

  public static void assertWins(Roulette roulette, int iter, Bet[] bets, int expectedWins) {
    int actualWins = 0;
    while (iter > 0) {
      boolean[] results = roulette.spin(bets);
      for (boolean result : results) {
        if (result) {
          actualWins++;
        }
      }
      iter--;
    }
    Assert.assertEquals("Got: " + actualWins, expectedWins, actualWins);
  }

  public static void assertAmount(Roulette roulette, int iter, Bet[] bets, double expectedAmount) {
    double actualAmount = 0.0;
    while (iter > 0) {
      boolean[] results = roulette.spin(bets);
      int index = 0;
      for (boolean result : results) {
        if (result) {
          actualAmount += bets[index].getWinAmount();
        } else {
          actualAmount -= bets[index].getLoseAmount();
        }
      }
      iter--;
      index++;
    }
    Assert.assertEquals("Got: " + actualAmount, expectedAmount, actualAmount, .99);
  }
}
