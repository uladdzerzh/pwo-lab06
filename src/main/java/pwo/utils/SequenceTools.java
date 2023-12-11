package pwo.utils;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Klasa narzędziowa służąca do obsługi obiektów implementujących interfejs {@link SequenceGenerator}.
 * Umożliwia formatowanie i zapisywanie ciągów liczbowych.
 *
 * @author vderz
 * @version 1.0.0
 */
public class SequenceTools {

    private static String getTerms(SequenceGenerator sg, int from, int to, String sep) {
        int i = from, stop = to, step = from > to ? -1 : 1;
        StringBuilder terms = new StringBuilder();

        while (true) {
            terms.append(sg.getTerm(i)).append(sep);
            if (i == stop) {
                return terms.toString().trim();
            }
            i += step;
        }
    }

    /**
     * Zamienia wyrazy ciągu na tekst, tworząc kolumnę.
     *
     * @param sg Dowolny obiekt implementujący {@link SequenceGenerator}
     * @param from Początkowy wyraz ciągu
     * @param to Końcowy wyraz ciągu
     * @return Wyrazy ciągu w postaci tekstu tworzącego kolumnę
     */
    public static String getTermsAsColumn(SequenceGenerator sg, int from, int to) {
        return getTerms(sg, from, to, "\n");
    }

    /**
     * Zamienia wyrazy ciągu na tekst, tworząc wiersz.
     *
     * @param sg Dowolny obiekt implementujący {@link SequenceGenerator}
     * @param from Początkowy wyraz ciągu
     * @param to Końcowy wyraz ciągu
     * @return Wyrazy ciągu w postaci tekstu tworzącego wiersz
     */
    public static String getTermsAsLine(SequenceGenerator sg, int from, int to) {
        return getTerms(sg, from, to, " ");
    }

    /**
     * Zapisuje wyrazy ciągu do pliku w postaci kolumny.
     * W przypadku niepowodzenia zapisu (np. z powodu błędu wejścia/wyjścia), metoda zwraca false.
     *
     * @param sg Dowolny obiekt implementujący {@link SequenceGenerator}
     * @param from Początkowy wyraz ciągu
     * @param to Końcowy wyraz ciągu
     * @param fileName Nazwa pliku
     * @return true jeżeli udało się zapisać plik, false w przypadku wystąpienia błędu
     */
    public static boolean writeToFile(SequenceGenerator sg, int from, int to, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(getTermsAsColumn(sg, from, to));
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
