package FebrianaJmartKD;


/**
 * class Transactor
 *
 * @author Febriana Pasonang Sidauruk
 * @version 27 September 2021
 */
public interface Transactor
{
    public boolean validate();
    public Invoice perform();
}