package workshop.oo.roulette;

import org.junit.Assert;
import workshop.oo.roulette.RouletteAsserts.AmountAssert;
import workshop.oo.roulette.RouletteAsserts.WinAssert;

public interface TestResult extends Result, WinAssert, AmountAssert {

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