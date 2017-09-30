public class Fraction {

    private int n;
    private int d;

    public Fraction(int num, int den) {

        if (den == 0) {
            throw new IllegalArgumentException("Error: Denominator can't be zero.");
        } else if (den < 0) {
            this.n = -num;
            this.d = -den;
        } else {
            this.n = num;
            this.d = den;
        }
    }

    public Fraction(int num) {
        this(num, 1);
    }

    public int getNumerator() {
        return this.n;
    }

    public int getDenominator() {
        return this.d;
    }

    public String toString() {
        if (this.d == 1) {
            return this.n + "";
        } else {
            return this.n + "/" + this.d;
        }
    }

    public double toDouble() {
        return this.n / this.d;
    }

    public Fraction add(Fraction other) {
        if (this.d != other.d) {
            int denNew = this.d * other.d;
            int num1 = this.n * other.d;
            int num2 = other.n * this.d;
            return new Fraction(num1 + num2, denNew);
        } else {
            return new Fraction(this.n + other.n, this.d);
        }

    }

    public Fraction subtract(Fraction other) {
        if (this.d != other.d) {
            int denNew = this.d * other.d;
            int num1 = this.n * other.d;
            int num2 = other.n * this.d;
            return new Fraction(num1 - num2, denNew);
        } else {
            return new Fraction(this.n - other.n, this.d);
        }
    }

    public Fraction multiply(Fraction other) {
        int numNew = this.n * other.n;
        int denNew = this.d * other.d;
        return new Fraction(numNew, denNew);
    }

    public Fraction divide(Fraction other) {
        if ((int) other.toDouble() == 0) {
            throw new IllegalArgumentException("Error: Can't divide by zero.");
        } else {
            int numNew = this.n * other.d;
            int denNew = this.d * other.n;
            return new Fraction(numNew, denNew);
        }
    }

    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            Fraction objectNew = Fraction.class.cast(other);
            if (objectNew.toDouble() == this.toDouble()) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    public static int gcd(int num, int den) {
        while (num != 0 && den != 0) {
            int remain = num % den;
            num = den;
            den = remain;
        }
        return num;
    }

    public void toLowestTerms() {
        int divisor = gcd(this.n, this.d);
        this.n = this.n/divisor;
        this.d = this.d/divisor;
    }
}