/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
 package pwo.utils;

 import java.math.BigDecimal;

 /**
 * Interfejs dowolnego generatora liczbowego
 * o wyrazach zdefiniowanych w zakresie od 0.
 *
 * @author vderz
 * @version 1.0.0
 */
 public interface SequenceGenerator {

 /**
 * Powoduje, ze metoda {@link #nextTerm()}
 * rozpoczyna od 0.<br>
 * Nie wpywan na działanie metody {@link #getTerm(int)}.
 */
 void reset();

 /**
 * Zwraca koleny wyraz ciagu.
 *
 * @return Wartość wyrazu ciagu
 * @see #getTerm(int)
 */
 BigDecimal nextTerm();

 /**
 * Zwraca wyraz ciagu o podanym indeksie.
 *
 * @param i Nr wyrazu ciagu dla którego
 * jest uzyskiwana wartość
 * @return Wartość wyrazu ciagu o indeksie i
 * @throws IllegalArgumentException if the index is less than 0
 * @see #nextTerm()
 */
 BigDecimal getTerm(int i);
 }