package workshop.oo.roulette;

import java.util.stream.IntStream;
import org.junit.Assert;

public class RouletteAsserts {

  public static void assertWins(Roulette roulette, int iter, Bet[] bets, int expectedWins) {
    TestResult result = TestResult.create();
    IntStream.range(0, iter).forEach(__ -> roulette.spin(bets, result));
    result.assertWins(expectedWins);
  }

  public static void assertAmount(Roulette roulette, int iter, Bet[] bets, double expectedAmount) {
    TestResult result = TestResult.create();
    IntStream.range(0, iter).forEach(__ -> roulette.spin(bets, result));
    result.assertAmount(expectedAmount);
  }

  interface WinAssert {
    void assertWins(int expectedWins);
  }

  interface AmountAssert {
    void assertAmount(double expectedAmount);
  }

  interface TestResult extends Result, WinAssert, AmountAssert {

    static TestResult create() {
      return new SimpleTestResult();
    }

    final class SimpleTestResult implements TestResult {

      private int actualWins;
      private double actualAmount;

      @Override
      public void onWin(double amt) {
        actualWins ++;
        actualAmount += amt;
      }

      @Override
      public void onLose(double amt) {
        actualWins --;
        actualAmount -= amt;
      }

      @Override
      public void assertWins(int expectedWins) {
        Assert.assertEquals("Got: " + actualWins, expectedWins, actualWins);
      }

      @Override
      public void assertAmount(double expectedAmount) {
        Assert.assertEquals("Got: " + actualAmount, expectedAmount, actualAmount, .99);
      }
    }
  }
}
