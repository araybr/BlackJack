package es.ieslavereda;

import java.util.Arrays;

public enum Num {
    AS("A", new int []{1,11}),
    DOS("2",new int[]{2}),
    TRES("3",new int[]{3}),
    CUATRO("4",new int[]{4}),
    CINCO("5",new int[]{5}),
    SEIS("6",new int[]{6}),
    SIETE("7",new int[]{7}),
    OCHO("8",new int[]{8}),
    NUEVE("9",new int[]{9}),
    JOTA("J", new int[]{10}),
    QUEEN("Q", new int[]{10}),
    KING("K", new int[]{10});
    private String num;
    private int[] value;
    Num(String num, int[] value){
        this.num = num;
        this.value = value;
    }

    public int[] getValue() {
        return value;
    }
    public String getNum() {
        return num;
    }

    @Override
    public String toString() {
        return num;
    }
}
