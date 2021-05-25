package workshop.oo.roulette;

import java.util.List;
import java.util.stream.IntStream;

public class RouletteAsserts {

  public static void assertWins(Roulette roulette, int iter, List<Bet> bets, int expectedWins) {
    TestResult result = TestResult.create();
    iterate(iter, () -> roulette.spin(bets, result));
    result.assertWins(expectedWins);
  }

  public static void assertAmount(Roulette roulette, int iter, List<Bet> bets, double expectedAmount) {
    TestResult result = TestResult.create();
    iterate(iter, () -> roulette.spin(bets, result));
    result.assertAmount(expectedAmount);
  }

  interface VoidF {
    void exec();
  }

  public static void iterate(int n, VoidF action) {
    IntStream.range(0, n).forEach(__ -> action.exec());
  }

  interface WinAssert {
    void assertWins(int expectedWins);
  }

  interface AmountAssert {
    void assertAmount(double expectedAmount);
  }
}
