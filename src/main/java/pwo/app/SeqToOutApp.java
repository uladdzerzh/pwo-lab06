package pwo.app;

import pwo.utils.SequenceTools;

/**
 * Klasa aplikacji generującej i wypisującej ciąg liczbowy na ekran konsoli.
 * Obsługuje argumenty przekazane z linii poleceń. Rozszerza klasę {@link SeqToFileApp}.
 *
 * @author vderz
 * @version 1.0.0
 */
public class SeqToOutApp extends SeqToFileApp {

    /**
     * Przetwarza argumenty przekazane z linii poleceń.
     *
     * @param args Argumenty z linii poleceń.
     * @return true, jeśli argumenty są prawidłowe; w przeciwnym razie false.
     */
    @Override
    protected boolean getArgs(String[] args) {
        if (super.getArgs(args)) {
            return true;
        }
        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Wypisuje wygenerowany ciąg liczbowy na ekran konsoli.
     *
     * @return zawsze true, wskazując na sukces operacji.
     */
    @Override
    protected boolean writeSeq() {
        System.out.println(SequenceTools.getTermsAsColumn(
                seqType.getGenerator(), from, to));
        return true;
    }

    /**
     * Uruchamia aplikację. Przetwarza argumenty i wypisuje ciąg liczbowy.
     *
     * @param args Argumenty przekazane z linii poleceń.
     */
    @Override
    public void run(String[] args) {
        System.out.println("Sequence to terminal CLI app");

        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to");
            return;
        }

        writeSeq();
    }
}
