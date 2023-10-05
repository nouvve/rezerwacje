import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemRezerwacji{
    private static List<Sala> sale = new ArrayList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true){
            System.out.println("\nWybierz opcje:");
            System.out.println("\nRezerwacji mozna dokonac tylko na pelne godziny i trwaja cala godzine :)\n");
            System.out.println("1. Zarezerwuj sale.");
            System.out.println("2. Sprawdz Dostepnosc.");
            System.out.println("3. Dodaj sale.");
            System.out.println("4. Edytuj sale.");
            System.out.println("5. odwolaj rezerwacje.");
            System.out.println("6. Wyjdz z programu.");
            int wybranaOpcja = s.nextInt();

            switch (wybranaOpcja){
                case 1:
                    zarezerwujSale(s);
                    break;
                case 2:
                    sprawdzDostepnosc(s);
                    break;
                case 3:
                    dodajKlase(s);
                    break;
                case 4:
                    edytujSale(s);
                    break;
                case 5:
                    odwolajRezerwacje(s);
                    break;
                case 6:
                    System.out.println("Wylaczanie...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Niepoprawna opcja, wybierz ponownie.");
                    break;
            }
        }
    }
    private static void dodajKlase(Scanner s) {
        System.out.println("Podaj numer klasy");
        int numer = s.nextInt();
        System.out.println("Podaj pojemnosc klasy");
        int pojemnosc = s.nextInt();
        Sala sala = new Sala(numer,pojemnosc);
        sale.add(sala);
        System.out.println("Pomyslnie dodano sale "+numer);
    }
    private static void zarezerwujSale(Scanner s) {
        System.out.println("Podaj numer klasy");
        int numer = s.nextInt();
        s.nextLine();  // zeby dzialalo :)
        System.out.println("Podaj date i godzine wedlug wzoru: YYYY-MM-DD-HH");
        String data = s.nextLine();
        Sala sala = znajdzSale(numer);
        if (sala != null){
            sala.stworzRezerwacje(data);
        } else {
            System.out.println("Sala "+numer+" nie istnieje.");
        }
    }

    private static void odwolajRezerwacje(Scanner s) {
        System.out.println("Podaj numer klasy");
        int numer = s.nextInt();
        s.nextLine();  // zeby dzialalo :)
        System.out.println("Podaj date i godzine wedlug wzoru: YYYY-MM-DD-HH");
        String data = s.nextLine();
        Sala sala = znajdzSale(numer);
        if (sala != null){
            sala.odwolajRezerwacje(data);
        } else {
            System.out.println("Sala "+numer+" nie istnieje.");
        }
    }

    private static void edytujSale(Scanner s) {
        System.out.println("Podaj numer klasy");
        int numer = s.nextInt();
        System.out.println("Podaj nowa pojemnosc klasy");
        Sala sala = znajdzSale(numer);
        if (sala != null){
            sala.pojemnoscKlasy = s.nextInt();
        } else {
            System.out.println("Sala "+numer+" nie istnieje.");
        }
    }



    private static void sprawdzDostepnosc(Scanner s) {
        System.out.println("Podaj numer klasy");
        int numer = s.nextInt();
        System.out.println("Podaj date i godzine wedlug wzoru: YYYY-MM-DD-HH");
        s.nextLine();  // zeby dzialalo :)
        String data = s.nextLine();


        Sala sala = znajdzSale(numer);
        if (sala != null) {
            if (sala.sprawdzCzyWolna(data)) {
                System.out.println("Sala " + numer + " jest dostępna na " + data);
            } else {
                System.out.println("Sala " + numer + " jest już zajęta na " + data);
            }
        } else {
            System.out.println("Nie znaleziono sali o numerze " + numer);
        }
    }

    private static Sala znajdzSale(int numer) {
        for (Sala s : sale) {
            if (s.numerSali == numer) {
                return s;
            }
        }
        return null;
    }

}
