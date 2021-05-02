package workshop.oo.roulette;

import java.util.stream.IntStream;

public interface Bet {

  boolean check(int index, int winner);

  static Bet straight(int num) {
    return new StraightBet(num);
  }

  static Bet split(int first, int second) {
    return new SplitBet(first, second);
  }

  static Bet street(int first, int second, int third) {
    return new StreetBet(first, second, third);
  }

  static Bet square(int first, int second, int third, int fourth) {
    return new SquareBet(first, second, third, fourth);
  }

  static Bet basket(int first, int second, int third, int fourth, int fifth) {
    return new BasketBet(first, second, third, fourth, fifth);
  }

  static Bet doubleStreet(int first, int second, int third, int fourth, int fifth, int sixth) {
    return new DoubleStreet(first, second, third, fourth, fifth, sixth);
  }

  static Bet dozen(int index) {
    return new DozenBet(index);
  }

  static Bet column(int index) {
    return new ColumnBet(index);
  }

  static Bet low() {
    return new LowBet();
  }

  static Bet high() {
    return new HighBet();
  }
  
  static Bet even() {
    return new EvenBet();
  }
  
  static Bet odd() {
    return new OddBet();
  }

  static Bet red() {
    return new RedBet();
  }

  static Bet black() {
    return new BlackBet();
  }

  class NBet implements Bet {

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

  final class BlackBet implements Bet {

    @Override
    public boolean check(int index, int winner) {
      return (index != 0 && index != 19) && index % 2 == 0;
    }
  }

  final class RedBet implements Bet {

    @Override
    public boolean check(int index, int winner) {
      return (index != 0 && index != 19) && index % 2 != 0;
    }
  }

  final class EvenBet implements Bet {

    @Override
    public boolean check(int index, int winner) {
      return winner != 0 && winner % 2 == 0;
    }
  }

  final class OddBet implements Bet {

    @Override
    public boolean check(int index, int winner) {
      return winner != 0 && winner % 2 != 0;
    }
  }

  final class DozenBet extends NBet {

    DozenBet(int col) {
      super(12, values(col));
    }

    private static int[] values(int col) {
      switch(col) {
        case 1: return new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        case 2: return new int[]{13,14,15,16,17,18,19,20,21,22,23,24};
        default: return new int[]{25,26,27,28,29,30,31,32,33,34,35,36};
      }
    }
  }


  final class SplitBet extends NBet {

    public SplitBet(int first, int second) {
      super(2, first, second);
    }
  }

  final class StraightBet extends NBet {

    public StraightBet(int num) {
      super(1, num);
    }
  }

  final class StreetBet extends NBet {
    public StreetBet(int first, int second, int third) {
      super(3, first, second, third);
    }
  }

  final class SquareBet extends NBet {

    public SquareBet(int first, int second, int third, int fourth) {
      super(4, first, second, third, fourth);
    }
  }

  final class BasketBet extends NBet {

    public BasketBet(int first, int second, int third, int fourth,
        int fifth) {
      super(5, first, second, third, fourth, fifth);
    }
  }

  final class DoubleStreet extends NBet {

    public DoubleStreet(int first, int second, int third,
        int fourth, int fifth, int sixth) {
      super(6, first, second, third, fourth, fifth, sixth);
    }
  }

  final class ColumnBet extends NBet {

    public ColumnBet(int index) {
      super(12, values(index));

    }

    private static int[] values(int index) {
      switch(index) {
        case 1:  return new int[]{1,4,7,10,13,16,19,22,25,28,31,34};
        case 2:  return new int[]{2,5,8,11,14,17,20,23,26,29,32,35};
        default: return new int[]{3,6,9,12,15,18,21,24,27,30,33,36};
      }
    }
  }

  final class LowBet extends NBet {

    LowBet() {
      super(18, IntStream.range(1, 19).toArray());
    }
  }

  final class HighBet extends NBet {
    HighBet() {
      super(18, IntStream.range(19, 37).toArray());
    }
  }
}
