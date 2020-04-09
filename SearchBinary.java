import java.util.*;

class SearchBinary {

    static int SearchBinary(int[] tab, int borneG, int borneD, int tosearch) {
    
        if (borneD >= borneG) {
            int mid = borneG + (borneD - borneG) / 2; 
            if (tab[mid] == tosearch) 
                return mid; 
            if (tab[mid] > tosearch) 
                return SearchBinary(tab, borneG, mid - 1, tosearch); 
            return SearchBinary(tab, mid + 1, borneD, tosearch); 
            }
        return -1;
        }

        static int[] genRandArray() {
            Random rand = new Random();
            int[] randArray =  new int[rand.nextInt(101)];
            int size = randArray.length;
            for (int i = 0; i < size; i++)
                randArray[i] = rand.nextInt(10001);
            mergeSort(randArray);
            return randArray;
        }

        static void printArray(int[] array) {
            int taille = array.length;
            System.out.println("Affichage du tableau : ");
            if (taille == 0) {
                System.out.println("Tableau vide...");
                return;
            }
            System.out.print("[");
            for (int i = 0; i < taille-1; i++) {
                    System.out.print(array[i] + ", ");
            }
            System.out.println(array[taille-1] + "]");
        }
    

        static void mergeSort(int[] array) {

            int size = array.length; 
            int  i, k, lengthleft, lengthright = 0;
            if (size < 2)
                return;
        // Si le tableau possède un nombre de cases impair.
            if (size%2 != 0) {
                int midsize = (size-1)/2;
                lengthleft = midsize;
                lengthright = midsize +1;
            }
            else {
                lengthleft = size/2;
                lengthright = size/2;
            }
    
            int[] arrayA = new int[lengthleft];
            int[] arrayB = new int[lengthright];
        // Découpage en 2 tableaux du tableau à trier.
            k = 0;
            for (i = 0; i < lengthleft; i++)
                arrayA[i] = array[i];
            for (i = lengthleft ; i < size; i++) {
                arrayB[k] = array[i];
                k++;
            }
            mergeSort(arrayA);
            mergeSort(arrayB);
            merge (array, arrayA, arrayB);
        }
    
        static void merge(int array[], int[] arrayA, int[] arrayB) {
            int i = 0;
            int j = 0;
            int k = 0; 
            int lengthleft = arrayA.length;
            int lengthright = arrayB.length;
            while (i < lengthleft && j < lengthright) {
                if (arrayA[i] <= arrayB[j]) {
                    array[k] = arrayA[i];
                    i++;
                    }
                else {   // means (arrayA[i] > arrayB[j])
                    array[k] = arrayB[j];
                    j++;
                }
                k++;
            }
            while (i < lengthleft) {
                array[k] = arrayA[i];
                i++;
                k++;
            }
            while (j < lengthright) {
                array[k] = arrayB[j];
                j++;
                k++;
            }
        }
    
        static void test() {
            int[] tab = genRandArray();
            printArray(tab);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number to search");
            int search  = sc.nextInt();
            sc.close();
            int longueur = tab.length;
            int retour = SearchBinary(tab, 0, longueur -1, search) +1;
            if ( retour != 0) 
                System.out.println(search + " a été trouvé position = " + retour);
            else 
                System.out.println(search + " n'a pas été trouvé" );            
        }

    public static void main(String[] args) {
        test();
    }
}
