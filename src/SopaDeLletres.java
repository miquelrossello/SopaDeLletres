public class SopaDeLletres {

    public static boolean cercaPraula(char[][] taulaLletres, String paraulaCerca, int filaI, int columnaI) {
        if (paraulaCerca.length() > taulaLletres.length - 1 || paraulaCerca.length() > taulaLletres[0].length) {
            return false;
        }
        int ocurrenciesParaula = 0;
        taulaLletres = setLowerCaseTableChar(taulaLletres);
        paraulaCerca = paraulaCerca.toLowerCase();
        int contador;
        int[][] sentits = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int s = 0; s < sentits.length; s++) {
            contador = 0;
            for (int l = 0; l < paraulaCerca.length(); l++) {
                int newX = filaI + sentits[s][0] * l;
                int newY = columnaI + sentits[s][1] * l;
                if (!dinsMarges(taulaLletres, newX, newY)) {
                    break;
                }
                if (taulaLletres[newX][newY] != paraulaCerca.charAt(l)) {
                    break;
                }
                contador++;
                if (contador == paraulaCerca.length()) {
                    ocurrenciesParaula++;
                    break;
                }
            }
        }
        if (ocurrenciesParaula > 0) {
            return true;
        }
        return false;
    }

    private static boolean dinsMarges(char[][] taula, int x, int y) {
        return (x >= 0 && x < taula.length && y >= 0 && y < taula[0].length);
    }

    private static char[][] setLowerCaseTableChar(char[][] tableChar) {
        for (int x = 0; x < tableChar.length; x++) {
            for (int y = 0; y < tableChar[0].length; y++) {
                tableChar[x][y] = Character.toLowerCase(tableChar[x][y]);
            }
        }
        return tableChar;
    }

    private static void printTable(char[][] table) {
        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < table[0].length; y++) {
                System.out.print(table[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] t = new char[5][5];
        t[0][0] = 'H';
        t[0][1] = 'O';
        t[0][2] = 'L';
        t[0][3] = 'A';
        t[1][0] = 'O';
        t[2][0] = 'L';
        t[3][0] = 'A';
        System.out.println(cercaPraula(t, "hola", 0, 0));
    }
}
