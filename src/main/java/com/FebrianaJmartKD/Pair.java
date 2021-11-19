package com.FebrianaJmartKD;

/**
 * class Pair
 *
 * @author Febriana Pasonang Sidauruk
 * @version 9 October 2021
 */

public class Pair<T,U> {
    public T first;
    public U second;

    public Pair() {}

    public Pair(T first, U second)
    {
        this.first = first;
        this.second = second;
    }
}
