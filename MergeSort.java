public class MergeSort {
    public static void main(String[] args) {
        int[] anArray = {3, 2, 5, 1, 1, 6};

        printArray(anArray);

        mergeSort(anArray);
        printArray(anArray);
    }
    static void mergeSort(int[] anArray){
        int inputLength = anArray.length;

        //to return when the array has one or zero element.
        if(inputLength < 2){
            return;
        }

        //declaring new arrays that divides the input array into two.
        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength-midIndex];

        //to complete the leftHalf array.
        for(int i = 0; i<midIndex; i++){
            leftHalf[i] = anArray[i];
        }

        //to complete the rightHalf array.
        for(int i = midIndex; i<inputLength; i++){
            rightHalf[i-midIndex] = anArray[i];
        }

        //calling recursively to create smaller arrays.
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        //merging arrays together.
        merge(anArray, leftHalf, rightHalf);

    }

    public static void merge(int[] anArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        //declaring eterator for the arrays. 
        //k for anArray, i for leftHalf and j for rightHalf.
        int i = 0, j = 0, k = 0;

        //adding the elements in the main array.
        while(i < leftSize && j < rightSize){
            if(leftHalf[i] <= rightHalf[j]){
                anArray[k] = leftHalf[i];
                i++;
            }
            else{
                anArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        //to add the leftovers.
        while(i<leftSize){
            anArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while(j<rightSize){
            anArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    static void printArray(int[] anArray){
        for(int e : anArray){
            System.out.print(e + ", ");
        }
        System.out.println();
    }
}
