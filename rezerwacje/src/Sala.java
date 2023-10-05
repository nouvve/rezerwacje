import java.util.HashMap;
import java.util.Map;

public class Sala {
    public int numerSali;
    public int pojemnoscKlasy;
    private Map<String, Boolean> rezerwacje;
    Sala(int numerSali, int pojemnoscKlasy){
        this.numerSali = numerSali;
        this.pojemnoscKlasy = pojemnoscKlasy;
        this.rezerwacje = new HashMap<>();
    }

    public boolean sprawdzCzyWolna(String kodRezerwacji){
        return !rezerwacje.containsKey(kodRezerwacji) || !rezerwacje.get(kodRezerwacji);
    }

    public void stworzRezerwacje(String kodRezerwacji){
        if (sprawdzCzyWolna(kodRezerwacji)) {
            rezerwacje.put(kodRezerwacji,true);
            System.out.println("Sala "+numerSali+" pomyslnie zarezerwowana na: "+kodRezerwacji);
        } else {
            System.out.println("Sala "+numerSali+" Jest juz zarezerowana na: "+kodRezerwacji);
        }
    }

    public void odwolajRezerwacje(String kodRezerwacji){
        if(!sprawdzCzyWolna(kodRezerwacji)){
            rezerwacje.put(kodRezerwacji,false);
            System.out.println("Odwolano rezerwacje sali "+numerSali+" na: "+kodRezerwacji);
        } else {
            System.out.println("Sala "+numerSali+" nie jest zarezerwowana na: "+kodRezerwacji);
        }
    }

}
	