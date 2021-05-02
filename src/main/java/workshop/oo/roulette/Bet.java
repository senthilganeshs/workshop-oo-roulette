package workshop.oo.roulette;

import java.util.stream.IntStream;

public interface Bet {

  boolean check(int index, int winner);

  double getWinAmount();

  double getLoseAmount();

  static Bet straight(double amt, int num) {
    return new StraightBet(amt, num);
  }

  static Bet split(double amt, int first, int second) {
    return new SplitBet(amt, first, second);
  }

  static Bet street(double amt, int first, int second, int third) {
    return new StreetBet(amt, first, second, third);
  }

  static Bet square(double amt, int first, int second, int third, int fourth) {
    return new SquareBet(amt, first, second, third, fourth);
  }

  static Bet basket(double amt, int first, int second, int third, int fourth, int fifth) {
    return new BasketBet(amt, first, second, third, fourth, fifth);
  }

  static Bet doubleStreet(double amt, int first, int second, int third, int fourth, int fifth, int sixth) {
    return new DoubleStreet(amt, first, second, third, fourth, fifth, sixth);
  }

  static Bet dozen(double amt, int index) {
    return new DozenBet(amt, index);
  }

  static Bet column(double amt, int index) {
    return new ColumnBet(amt, index);
  }

  static Bet low(double amt) {
    return new LowBet(amt);
  }

  static Bet high(double amt) {
    return new HighBet(amt);
  }
  
  static Bet even(double amt) {
    return new EvenBet(amt);
  }
  
  static Bet odd(double amt) {
    return new OddBet(amt);
  }

  static Bet red(double amt) {
    return new RedBet(amt);
  }

  static Bet black(double amt) {
    return new BlackBet(amt);
  }

  abstract class NBet implements Bet {

    private final int[] values;
    private final int n;

    NBet(int n, int...values) {
      this.n = n;
      this.values = values;
      assert(n == values.length);
    }

    @Override
    public final boolean check(int index, int winner) {
      boolean[] win = new boolean[1];
      IntStream.range(0, n).forEach(i -> win[0] |= winner == values[i]);
      return win[0];
    }
  }

  final class StraightBet extends NBet {

    private final double amt;

    public StraightBet(double amt, int num) {
      super(1, num);
      this.amt = amt;
    }

    @Override
    public double getWinAmount() {
      return 35 * amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }


  final class SplitBet extends NBet {

    private final double amt;

    public SplitBet(double amt, int first, int second) {
      super(2, first, second);
      this.amt = amt;
    }

    @Override
    public double getWinAmount() {
      return 17 * amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }

  final class StreetBet extends NBet {

    private final double amt;

    public StreetBet(double amt, int first, int second, int third) {
      super(3, first, second, third);
      this.amt = amt;
    }

    @Override
    public double getWinAmount() {
      return 11 * amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }

  final class SquareBet extends NBet {

    private final double amt;

    public SquareBet(double amt, int first, int second, int third, int fourth) {
      super(4, first, second, third, fourth);
      this.amt = amt;
    }

    @Override
    public double getWinAmount() {
      return 8 * amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }

  final class BasketBet extends NBet {

    private final double amt;

    public BasketBet(double amt, int first, int second, int third, int fourth,
        int fifth) {
      super(5, first, second, third, fourth, fifth);
      this.amt = amt;
    }

    @Override
    public double getWinAmount() {
      return 6 * amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }

  final class DoubleStreet extends NBet {

    private final double amt;

    public DoubleStreet(double amt, int first, int second, int third,
        int fourth, int fifth, int sixth) {
      super(6, first, second, third, fourth, fifth, sixth);
      this.amt = amt;
    }

    @Override
    public double getWinAmount() {
      return 5 * amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }

  final class ColumnBet extends NBet {

    private final double amt;

    public ColumnBet(double amt, int index) {
      super(12, values(index));
      this.amt = amt;

    }

    private static int[] values(int index) {
      switch(index) {
        case 1:  return new int[]{1,4,7,10,13,16,19,22,25,28,31,34};
        case 2:  return new int[]{2,5,8,11,14,17,20,23,26,29,32,35};
        default: return new int[]{3,6,9,12,15,18,21,24,27,30,33,36};
      }
    }

    @Override
    public double getWinAmount() {
      return 2 * amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }

  final class DozenBet extends NBet {

    private final double amt;

    DozenBet(double amt, int col) {
      super(12, values(col));
      this.amt = amt;
    }

    private static int[] values(int col) {
      switch(col) {
        case 1: return new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        case 2: return new int[]{13,14,15,16,17,18,19,20,21,22,23,24};
        default: return new int[]{25,26,27,28,29,30,31,32,33,34,35,36};
      }
    }

    @Override
    public double getWinAmount() {
      return 2 * amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }

  final class LowBet extends NBet {

    private final double amt;

    LowBet(double amt) {
      super(18, IntStream.range(1, 19).toArray());
      this.amt = amt;
    }

    @Override
    public double getWinAmount() {
      return amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }

  final class HighBet extends NBet {

    private final double amt;

    HighBet(double amt) {
      super(18, IntStream.range(19, 37).toArray());
      this.amt = amt;
    }

    @Override
    public double getWinAmount() {
      return amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }

  final class BlackBet implements Bet {

    private final double amt;

    public BlackBet(double amt) {
      this.amt = amt;
    }

    @Override
    public boolean check(int index, int winner) {
      return (index != 0 && index != 19) && index % 2 == 0;
    }

    @Override
    public double getWinAmount() {
      return amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }

  final class RedBet implements Bet {

    private final double amt;

    public RedBet(double amt) {
      this.amt = amt;
    }

    @Override
    public boolean check(int index, int winner) {
      return (index != 0 && index != 19) && index % 2 != 0;
    }

    @Override
    public double getWinAmount() {
      return amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }

  final class EvenBet implements Bet {

    private final double amt;

    public EvenBet(double amt) {
      this.amt = amt;
    }

    @Override
    public boolean check(int index, int winner) {
      return winner != 0 && winner % 2 == 0;
    }

    @Override
    public double getWinAmount() {
      return amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }

  final class OddBet implements Bet {

    private final double amt;

    public OddBet(double amt) {
      this.amt = amt;
    }

    @Override
    public boolean check(int index, int winner) {
      return winner != 0 && winner % 2 != 0;
    }

    @Override
    public double getWinAmount() {
      return amt;
    }

    @Override
    public double getLoseAmount() {
      return this.amt;
    }
  }
}
