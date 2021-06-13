package com.home_wrokout.Alarm_RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

class ArrayCollectionError extends RuntimeException {
    ArrayCollectionError(String msg) { super(msg); }
}

public class TableCollectionInteger {
    /**
     * Klasa 'KolecjaTablicyKalendarza' jest to klasa służąca do stworzenia kolekcji typu tablicowego dla obiektów klasy 'Integer'
     * @see 'Integer'
     *
     * @implements
     *
     *          Comparator - jest to interfejs zawierający metode umożliwająca porównywanie dwóch obiektów w tym przyapdku klasy
     *          'Integer'
     *
     * @param ładunek - jest to zmienna służąca nam za liczbę typu Integer okreslającą nam podstawowy rozmiar tablicy
     *                i jest też wykorszystywany do powiekszania i zmiejszania naszej kolekcji w razie potrzeby o
     *                zawsze tą samą wartość.
     * @param tabSize - przechowuje aktualna wielkośc tablicy w formie Intger.
     * @param Tablica - jest to Tablica obiektów typu 'Kalendarz' w których są przechowywane element naszej kolekcji.
     * @param indeks - służy do przechowywania informacji o pierwszym wolnym dostępnym do zapisu w tej kolekcji.
     */

    private final int ładunek;
    private int tabSize;
    private Integer Tablica[];
    private int indeks;

    /**
     * Konstruktor podstawowy tej klasy nie przyjmujący żadnego parametru tworzy kolekcje o podstawowym ładunku
     * o wartości '10'.
     */

    TableCollectionInteger(){
        this.ładunek = 10;
        Tablica = new Integer[10];
        this.indeks = 0;
        this.tabSize = 10;
    }

    TableCollectionInteger(int ładunek, int tabSize, Integer[] Tablica, int indeks){
        this.ładunek = ładunek;
        this.tabSize = tabSize;
        this.Tablica = Tablica;
        this.indeks = indeks;
    }

    public int getŁadunek() {
        return ładunek;
    }

    public int getTabSize() {
        return tabSize;
    }

    /**
     * Konstruktor tej klasy przyjmujący podany przez użytkownika rozmiar ładunku.
     * @param ładunek - liczba typu Integer określąca ładunek.
     *
     * @exception 'ArrayCollectionError' - zwraca błąd gdy ładnuke określony w parametrze kostruktora jest mniejszy niż 1.
     */

    TableCollectionInteger(int ładunek) {

        if( ładunek < 1 ) throw new ArrayCollectionError("Ładunek nie może byc mniejszy niż 1, podałeś: "+ładunek);
        this.ładunek = ładunek;
        Tablica = new Integer[ładunek];
        this.indeks = 0;
        this.tabSize = ładunek;
    }

    public Integer[] getTablica() {
        return Tablica;
    }

    /**
     * Metoda 'add' - służy do dodania na pierwsze wolne miesjce w kolekcji elementu typu 'Integer'.
     * @see 'NextFree'
     *
     * @param Integer - element który będzie umieszczany w kolekcji typu 'Integer'.
     */

    public void add(Integer Integer){

        Tablica[indeks] = Integer;
        System.out.println("Element został dodany pod indeks'em: "+(this.indeks+1)+".");
        NextFree();

    }


    /**
     * Metoda 'add' - z dwoma parametrami służy do dodawania elementów na podany w parametrze 'indeks' miesjce w tablicy.
     * @see 'NextFree'
     *
     * @param Integer - element który będzie umieszczany w kolekcji typu 'Integer'.
     * @param indeks - index talicy naszej kolekcji na którym zapisany będzie element.
     */

    //Czy dodać do kolkecji poszerzanie się gdy ktoś dodaje coś na dowlony indeks.

    public void add(Integer Integer, int indeks ){

        if( Tablica[indeks] != null ){
            System.out.println("### Indeks: "+indeks+", jest zajęty element został dodany w pierwsze wolne miesjce:"+this.indeks+".");
            Tablica[this.indeks] = Integer;
        } else {
            Tablica[indeks] = Integer;
            System.out.println("Element został dodany pod indeks'em: "+(indeks+1)+".");
        }
        NextFree();

    }

    /**
     * Metoda 'delete' - jes to metodą słuząca do usuwania elementów z podanego index'u kolekcji.
     *
     * @param indeks - indeks z którego użytkownik żadą aby usunać element.
     *
     * @exception 'ArrayCollectionError' - rzuacany jest gdy index z którego chcemy usnąć elment jest z poza naszej kolekcji.
     */

    public void delete(int indeks){

        try {
            if ( Tablica[indeks] != null ){
                Tablica[indeks] = null;
                this.indeks = indeks;

            } else {
                System.out.println("### Pod indeksem: "+indeks+", nie znajduje się żaden element");
            }

        } catch (ArrayIndexOutOfBoundsException w){
            throw new ArrayCollectionError("Indeks z którego próbowano usnąć element jest nieprawidłowy: "+indeks+".");
        }

    }

    /**
     * Usuwa wszystkie elementy kolkecji i przywraca ją do stanu po stworzeniu, oraz zwraca id Obiketu kolekcji.
     */

    public void deleteAll(){

        tabSize = ładunek;
        Tablica = null;
        Tablica = new Integer[tabSize];
        indeks = 0;
        System.out.println("### Wszystkie elementy Kolekcji: "+this.hashCode()+", zostały usunięte!");

    }

    /**
     * Służy do wyświetlania elementu w postaci typu String z określonego w parametrze index'u
     *
     * @param indeks - index wyświetlanego elementu w tej kolekcji
     * @return obiekt z kolkecji pod podanym index'em w postaci typu String
     *
     * @exception 'ArrayCollectionError' - jest rzucany gdy próbujemy wyświetlić elemnt z poza kolekcji.
     */

    public String show(int indeks){

        try{
            return Tablica[indeks].toString();
        } catch (ArrayIndexOutOfBoundsException w){
            throw new ArrayCollectionError("Próbowałeś uzyskać element o indeksie z poza tablicy");
        }

    }

    /**
     * Metoda służąca do wyświetlania całości naszej kolekcji w postacji:
     *
     *      Kolekcja Tablicowa numer: -Id Obiektu-
     *      1. -Element-
     *      2. -Element-
     *      ...
     *      n. -Element-
     *
     *
     * @return - Zwraca kolekcje w postaci zmiennej typu String
     */

    public String showAll(){

        int i;
        String result = "Kolekcja Tablicowa numer: '"+this.hashCode()+"':\n";
        for( i = 0; i < Tablica.length; i++ ){
            if( Tablica[i] == null ){
                result += i+1+". Null element,\n";
            } else {
                result += i+1+". "+Tablica[i].toString()+", \n";
            }
        }
        return result;
    }

    /**
     * Sprawdza aktualny rozmiar tablicy i na podstawie najdalszego elementu kolekcji zmniejsza jej rozmiar tak
     * bardzo jak to możliwe używając zmiennej klasy 'ładunek' jako progu.
     */

    private void CheckSize(){

        int i;
        for( i = 0; i < Tablica.length; i++ ){
            if(Tablica[i] == null){ indeks = i; break; }
        }
        while( (tabSize - indeks) > ładunek ){
            tabSize -= ładunek;
            Integer placeholder[] = Tablica;
            Tablica = null;
            Tablica = new Integer[tabSize];
            for ( i = 0; i < tabSize; i++){
                Tablica[i] =  placeholder[i];
            }
        }

    }

    /**
     * Metoda 'NextFree' - wykorszystuje mechanizm rekurencji do znaleźenie pierwszego wolnego index'u w
     * tej kolekcji począwszy od aktulanego index'u.
     * @see 'ExpandArray'
     */

    private void NextFree(){
        if( Tablica[indeks] != null ) {
            if (indeks + 1 == tabSize) {
                ExpandArray();
            }
            indeks++;
            NextFree();
        }
        return;
    }

    public int getIndeks() {
        return indeks;
    }

    /**
     * Zwiększa kolekcje o rozmiar określony w zmiennej 'ładunek'.
     */

    public Integer getFromIndex(int index){
        return Tablica[index];
    }

    private void ExpandArray(){
        tabSize += ładunek;
        Integer placeholder[] = Tablica;
        Tablica = null;
        Tablica = new Integer[tabSize];
        for (int i = 0; i < placeholder.length; i++){
            Tablica[i] =  placeholder[i];
        }
    }

    public void setTablica(Integer[] tablica) {
        Tablica = tablica;
    }
}

