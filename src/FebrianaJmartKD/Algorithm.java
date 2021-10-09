package FebrianaJmartKD;
import java.util.Iterator;

/**
 * class Algorithm
 *
 * @author Febriana Pasonang Sidauruk
 * @version 9 October 2021
 */

public class Algorithm {
    private Algorithm() {

    }

    public static <T> int count(T[] array, T value){
        int cnt = 0;
        for(T arrayValue : array){
            if (arrayValue.equals(value)){
                cnt++;
            }
        }
        return cnt;
    }

    public static <T> int count(Iterable<T> iterable, T value){
        int cnt= 0;
        for(T t : iterable){
            if(t.equals(value)){
                cnt++;
            }
        }
        return cnt;
    }

    public static <T> int count(Iterator<T> iterator, T value){
        int cnt = 0;
        while(iterator.hasNext()){
            if(iterator.next().equals(value)){
                cnt++;
            }
        }
        return cnt;
    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        int cnt = 0;
        for(T arrayValue : array){
            if (arrayValue.equals(pred)){
                cnt++;
            }
        }
        return cnt;
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        int cnt = 0;
        for(T t : iterable){
            if(t.equals(pred)){
                cnt++;
            }
        }
        return cnt;
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int cnt = 0;
        while(iterator.hasNext()){
            if(iterator.next().equals(pred)){
                cnt++;
            }
        }
        return cnt;
    }
    public static <T> boolean exists(T[] array, T value) {
        for(T arrayValue : array){
            if (arrayValue.equals(value)){
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        for(T t : iterable){
            if(t.equals(value)){
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        while(iterator.hasNext()){
            if(iterator.next().equals(value)){
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        for(T arrayValue : array){
            if (arrayValue.equals(pred)){
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        for(T t : iterable){
            if(t.equals(pred)){
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext()){
            if(iterator.next().equals(pred)){
                return true;
            }
        }
        return false;
    }

    public static <T> T find(T[] array, T value) {
        return null;
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        return null;
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        return null;
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        return null;
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        return null;
    }

    public static<T extends Comparable<? super T>> T max(T first, T second) {
        if(first.compareTo(second) > 0) return first;
        return second;
    }

    public static<T extends Comparable<? super T>> T min(T first, T second) {
        if(first.compareTo(second) < 0) return first;
        return second;
    }
}