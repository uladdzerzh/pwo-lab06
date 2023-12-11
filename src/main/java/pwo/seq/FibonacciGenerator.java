package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa generująca wyrazy ciągu Fibonacciego. Rozszerza klasę abstrakcyjną {@link Generator}.
 *
 * @author vderz
 * @version 1.0.0
 */
public class FibonacciGenerator extends Generator {

    /**
     * Konstruktor inicjalizujący początkowe wartości ciągu Fibonacciego.
     */
    public FibonacciGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Resetuje generator ciągu Fibonacciego do stanu początkowego.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Zwraca kolejny wyraz ciągu Fibonacciego.
     *
     * @return Następny wyraz ciągu Fibonacciego.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 1) {
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }

        lastIndex++;
        return current;
    }
}
