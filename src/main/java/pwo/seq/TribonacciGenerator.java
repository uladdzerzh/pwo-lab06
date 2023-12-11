package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa generująca wyrazy ciągu Tribonacciego. Rozszerza klasę {@link FibonacciGenerator}.
 *
 * @author vderz
 * @version 1.0.0
 */
public class TribonacciGenerator extends FibonacciGenerator {

    private BigDecimal f_3; 

    /**
     * Konstruktor inicjalizujący początkowe wartości ciągu Tribonacciego.
     */
    public TribonacciGenerator() {
        f_3 = new BigDecimal(0);
    }

    /**
     * Resetuje generator ciągu Tribonacciego do stanu początkowego.
     */
    @Override
    public void reset() {
        super.reset();
        f_3 = new BigDecimal(0);
    }

    /**
     * Zwraca kolejny wyraz ciągu Tribonacciego.
     *
     * @return Następny wyraz ciągu Tribonacciego.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 2) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
}
