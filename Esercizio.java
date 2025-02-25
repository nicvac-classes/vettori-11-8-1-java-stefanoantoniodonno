//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, i, ora, j, iMax, nPesci, peso;

        System.out.println("Inserire il numero di pesci che saranno pescati: ");
        do {
            n = input.nextInt();
        } while (n < 1);
        int[] pesi = new int[n];
        int[] ore = new int[n];

        nPesci = 0;
        for (i = 0; i <= n - 1; i++) {
            peso = random.nextInt(9) * 50 + 100;
            do {
                System.out.println("Inserisci l'ora di cattura: ");
                ora = input.nextInt();
            } while (ora < 0 && ora > 23);
            System.out.println("Pesce di peso: " + peso + "g");
            System.out.println("Pescato all'ora: " + ora);
            nPesci = inseriscivettore(pesi, ore, nPesci, peso, ora, nPesci);
            j = 0;
            while (j < nPesci) {
                if (pesi[j] < pesi[nPesci - 1]) {
                    System.out.println("Il pesce che pesa " + pesi[j] + " grammi, che è stato catturato all'ora " + ore[j] + ", verrà eliminato");
                    nPesci = eliminavettore(pesi, ore, nPesci, j);
                } else {
                    j = j + 1;
                }
            }
            visualizzavettore(pesi, ore, nPesci);
        }
        iMax = ricercaMassimo(pesi, nPesci);
        System.out.println("Il pesce più pesante è quello che pesa " + pesi[iMax] + " grammi e che è stato catturato all'ora " + ore[iMax]);
        nPesci = rimuoviduplicato(pesi, ore, nPesci);
        visualizzavettore(pesi, ore, nPesci);
    }
    
    public static int eliminavettore(int[] v, int n, int ie) {
        int i, n2;

        n2 = n - 1;
        i = ie;
        while (i <= n - 2) {
            v[i] = v[i + 1];
            i = i + 1;
        }
        
        return n2;
    }
    
    public static int inseriscivettore(int[] v, int n, int e, int ie) {
        int i, n2;

        n2 = n + 1;
        i = n2 - 1;
        while (i >= ie + 1) {
            v[i] = v[i - 1];
            i = i - 1;
        }
        v[ie] = e;
        
        return n2;
    }
    
    public static int ricercaMassimo(int[] pesi, int n) {
        int iMax, i;

        iMax = 0;
        i = 0;
        while (i < n && iMax == 0) {
            if (pesi[i] > pesi[iMax]) {
                iMax = i;
            }
            i = i + 1;
        }
        
        return iMax;
    }
    
    public static int rimuoviduplicato(int[] v, int n) {
        int i, j;

        i = 0;
        while (i <= n - 2) {
            j = i + 1;
            while (j <= n - 1) {
                if (v[i] == v[j]) {
                    System.out.println("Elimino " + v[j] + " da cella " + j);
                    n = eliminaDaVettore(v, n, j);
                } else {
                    j = j + 1;
                }
            }
            i = i + 1;
        }
        
        return n;
    }
    
    public static void visualizzavettore(int[] v, int n) {
        int i;

        i = 0;
        while (i < n) {
            System.out.println(Integer.toString(i) + ": " + v[i]);
            i = i + 1;
        }
    }
}